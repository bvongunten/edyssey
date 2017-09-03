package ch.nostromo.edyssey.database;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import ch.nostromo.edyssey.database.entities.StarSystem;
import ch.nostromo.edyssey.database.entities.references.Allegiance;

public class DatabaseTest {

	Database testee;
	
	@Before
	public void before() {
    	Map<String, String> properties = new HashMap<>();
        properties.put("javax.persistence.transactionType", "RESOURCE_LOCAL");
        properties.put("hibernate.connection.username", "sa");
        properties.put("hibernate.connection.password" ,"");
        properties.put("hibernate.connection.driver_class","org.hsqldb.jdbcDriver");            
        properties.put("hibernate.connection.url", "jdbc:hsqldb:mem:." );
        properties.put("hibernate.dialect" ,"org.hibernate.dialect.HSQLDialect");
        properties.put("hibernate.hbm2ddl.auto","update");
        properties.put("hibernate.show_sql","false");
        properties.put("hibernate.format_sql" ,"false"); 
        testee = new Database(properties);
        testee.connect();
	}
	
	
	@Test
	public void testMainEntityCreation() {
		testee.transactionStart();
		testee.getMainEntityHelper().getOrCreateStarSystem("Sol");
		testee.transactionCommit();
		
        @SuppressWarnings("unchecked")
		List<StarSystem> starSystems = testee.getEntityManager().createQuery("Select s from StarSystem s").getResultList();
		
        assertEquals(1, starSystems.size());
        assertEquals("Sol", starSystems.get(0).getId());
        assertNotNull(starSystems.get(0).getCreated());
	}
	
	@Test
	public void testRefernceCreation() {
		testee.transactionStart();
		testee.getReferenceEntityHelper().getOrCreateAllegiance("My Allegiance");
		testee.transactionCommit();
		
        @SuppressWarnings("unchecked")
		List<Allegiance> allegiance = testee.getEntityManager().createQuery("Select a from Allegiance a").getResultList();
		
        assertEquals(1, allegiance.size());
        assertEquals("My Allegiance", allegiance.get(0).getId());
        assertNotNull(allegiance.get(0).getCreated());
	}

}
