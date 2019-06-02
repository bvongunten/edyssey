package ch.nostromo.edyssey.journal;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import ch.nostromo.edyssey.database.Database;
import ch.nostromo.edyssey.database.entities.Commander;
import ch.nostromo.edyssey.database.entities.StarSystem;
import ch.nostromo.edyssey.database.entities.Station;

public class JournalDatabaseLoaderIT {

	Database database;

	@Before
	public void before() {
		Map<String, String> properties = new HashMap<>();
		properties.put("javax.persistence.transactionType", "RESOURCE_LOCAL");
		properties.put("hibernate.connection.username", "sa");
		properties.put("hibernate.connection.password", "");
		properties.put("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver");
		properties.put("hibernate.connection.url", "jdbc:hsqldb:mem:.");
		properties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "false");
		properties.put("hibernate.format_sql", "false");
		properties.put("hibernate.use_sql_comments", "false");

		database = new Database(properties);
		database.connect();
	}

	@Test
	public void testFullLoad() throws IllegalArgumentException, IllegalAccessException, IOException {

		JournalDatabaseLoader testee = new JournalDatabaseLoader(database);
		testee.loadFullDirectory("Crosta", Paths.get("C:\\Users\\Bernhard von Gunten\\Documents\\Flightlog\\"));

		@SuppressWarnings("unchecked")
		List<StarSystem> starSystems = database.getEntityManager().createQuery("Select s from StarSystem s")
				.getResultList();
		assertEquals(939, starSystems.size());

		@SuppressWarnings("unchecked")
		List<Station> stations = database.getEntityManager().createQuery("Select s from Station s").getResultList();
		assertEquals(134, stations.size());

		Commander commander = (Commander) database.getEntityManager().createQuery("Select c from Commander c")
				.getSingleResult();
		assertEquals(1561, commander.getJournalEvents().size());

	}

}
