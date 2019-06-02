package ch.nostromo.edyssey.cli;

import ch.nostromo.edyssey.database.Database;
import ch.nostromo.edyssey.eddn.EddnDatabaseLoader;
import ch.nostromo.edyssey.eddn.EddnDatabaseLoaderListener;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

public class Cli implements EddnDatabaseLoaderListener {

    Database db;
    EddnDatabaseLoaderListener listener = this;
    EddnDatabaseLoader loader;

    int counter = 0;

    public Cli() {

    }

    public void start() {

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


    public static void main(String...args) {
        Cli cli = new Cli();
        cli.start();

    }

    @Override
    public void eddnMessageProcessed(String message) {

        if ((counter % 1000) == 0) {
            String result = "Counter: " + counter;
            EntityManager em = db.getEntityManager();

            Query starSystemQuery = em.createQuery("SELECT count(*) FROM StarSystem");
            long starSystemCount = (long) starSystemQuery.getSingleResult();
            result += ", StarSystems: " + String.valueOf(starSystemCount);

            Query bodyQuery = em.createQuery("SELECT count(*) FROM Body");
            long bodyCount = (long) bodyQuery.getSingleResult();
            result += ", Bodies: " + String.valueOf(bodyCount);



            Query stationQuery = em.createQuery("SELECT count(*) FROM Station");
            long stationCount = (long) stationQuery.getSingleResult();

            Query stationCommodityQuery = em
                    .createQuery("SELECT count(*) FROM Station s where s.stationCommodities is not empty");
            long stationCommoditCount = (long) stationCommodityQuery.getSingleResult();


            result += ", Stations: " + String.valueOf(stationCount) + ", Markets: " + String.valueOf(stationCommoditCount);

            System.out.println(result);

        } else if ((counter % 100) == 0) {
            System.out.println("counter: " + counter);
        }
        counter ++;

    }

    @Override
    public void eddnMessageFailed(String message) {

    }
}
