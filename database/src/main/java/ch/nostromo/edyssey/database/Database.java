package ch.nostromo.edyssey.database;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.nostromo.edyssey.database.entities.BaseEntity;

public class Database {

	EntityManager em;
	Map<String, String> properties;

	MainEntityHelper mainEntityHelper;
	ReferenceEntityHelper referenceEntityHelper;
	JournalEntityHelper journalEntityHalper;

	public Database(Map<String, String> properties) {
		this.properties = properties;
		mainEntityHelper = new MainEntityHelper(this);
		referenceEntityHelper = new ReferenceEntityHelper(this);
		journalEntityHalper = new JournalEntityHelper(this);
	}

	public EntityManager getEntityManager() {
		return em;
	}

	public void connect() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("edyssey", properties);
		em = entityManagerFactory.createEntityManager();
	}

	public void persistEntity(BaseEntity entity) {
		em.persist(entity);
	}

	public void transactionStart() {
		em.getTransaction().begin();
	}

	public void transactionCommit() {
		em.getTransaction().commit();
	}

	public void transactionRollback() {
		em.getTransaction().rollback();
	}

	public void clearEntityManager() {
		em.clear();
	}

	public void disconnect() {
		em.close();
	}

	public MainEntityHelper getMainEntityHelper() {
		return mainEntityHelper;
	}

	public ReferenceEntityHelper getReferenceEntityHelper() {
		return referenceEntityHelper;
	}

	public JournalEntityHelper getJournalEntityHelper() {
		return journalEntityHalper;
	}

}
