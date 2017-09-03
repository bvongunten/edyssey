package ch.nostromo.edyssey.fxclient;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ch.nostromo.edyssey.database.Database;
import ch.nostromo.edyssey.eddn.EddnDatabaseLoader;
import ch.nostromo.edyssey.eddn.EddnDatabaseLoaderListener;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * JavaFX Controller for the main window
 * 
 * @author Bernhard von Gunten <bvg@nostromo.ch>
 *
 */
public class FxClientMainController implements Initializable, EddnDatabaseLoaderListener {

	@FXML
	private TextArea txtLog;

	@FXML
	private Label lblInfo;

	@FXML
	private Label lblStarSystemCount;

	@FXML
	private Label lblBodiesCount;

	@FXML
	private Label lblStationsCount;

	private Database db;

	private EddnDatabaseLoader loader;

	private long success = 0;
	private long failures = 0;

	/**
	 * Load preferences, create cell factories and attach listeners
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	void onQuitAction(ActionEvent event) {
		if (loader != null) {
			try {
				onEddnStop(null);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		if (db != null) {
			db.disconnect();
		}

		Platform.exit();
		System.exit(0);

	}

	@FXML
	void onEddStart(ActionEvent event) throws Exception {
		if (db == null) {

			Map<String, String> properties = new HashMap<>();
			properties.put("javax.persistence.transactionType", "RESOURCE_LOCAL");
			properties.put("hibernate.connection.username", "edyssey");
			properties.put("hibernate.connection.password", "edyssey");
			properties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
			properties.put("hibernate.connection.url", "jdbc:postgresql://localhost/edyssey");
			properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
			properties.put("hibernate.hbm2ddl.auto", "update");
			properties.put("hibernate.show_sql", "false");
			properties.put("hibernate.format_sql", "false");

			db = new Database(properties);
			db.connect();
		}

		if (loader == null) {
			EddnDatabaseLoaderListener listener = this;

			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						loader = new EddnDatabaseLoader(db, listener);
						loader.startCollecting();
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}
			}).start();
		}
		updateDatabaseStats();
	}

	@FXML
	void onEddnStop(ActionEvent event) throws Exception {
		if (loader != null) {
			loader.stopCollecting();
			loader = null;
		}
	}

	@FXML
	void onDbRefresh(ActionEvent event) throws Exception {
		updateDatabaseStats();
	}

	@Override
	public void eddnMessageProcessed(String message) {
		success++;
		updateLog(true, message);
	}

	@Override
	public void eddnMessageFailed(String message) {
		failures++;
		updateLog(false, message);
	}

	private void updateLog(boolean processed, String line) {

		Platform.runLater(() -> {

			lblInfo.setText("Messages processed: " + success + " (Failed: " + failures + ")");

			if (!processed) {
				String currentlog = txtLog.getText();
				if (currentlog.length() > 10000) {
					currentlog = currentlog.substring(currentlog.length() - 5000);
				}

				txtLog.setText(currentlog + System.lineSeparator() + line);
				txtLog.selectPositionCaret(txtLog.getText().length());
			}
			
			
			if (success + failures % 500 == 0) {
				updateDatabaseStats();
			}
		});

	}

	private void updateDatabaseStats() {
		Platform.runLater(() -> {

			EntityManager em = db.getEntityManager();

			Query starSystemQuery = em.createQuery("SELECT count(*) FROM StarSystem");
			long starSystemCount = (long) starSystemQuery.getSingleResult();
			lblStarSystemCount.setText(String.valueOf(starSystemCount));

			Query bodyQuery = em.createQuery("SELECT count(*) FROM Body");
			long bodyCount = (long) bodyQuery.getSingleResult();
			lblBodiesCount.setText(String.valueOf(bodyCount));

			Query stationQuery = em.createQuery("SELECT count(*) FROM Station");
			long stationCount = (long) stationQuery.getSingleResult();

			Query stationCommodityQuery = em
					.createQuery("SELECT count(*) FROM Station s where s.stationCommodities is not empty");
			long stationCommoditCount = (long) stationCommodityQuery.getSingleResult();
			lblStationsCount.setText(String.valueOf(stationCount) + " / " + String.valueOf(stationCommoditCount));
		});
	}

}
