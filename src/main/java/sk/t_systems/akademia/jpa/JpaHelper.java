package sk.t_systems.akademia.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaHelper {

	private static EntityManagerFactory factory;
	private static EntityManager em;

	/** Initialize conection if not initialized. */
	private static void init() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("hibernatePersistenceUnit");
		}
		if (em == null) {
			em = factory.createEntityManager();
		}
	}

	/**
	 * Return entitiy manager.
	 * 
	 * @return em entity manager
	 */
	public static EntityManager getEntityManager() {
		init();
		return em;
	}

	/** Begin transaction */
	public static void beginTransaction() {
		init();
		EntityTransaction eTrans = em.getTransaction();
		eTrans.begin();
	}

	/** Execute commands. */
	public static void committransaction() {
		try {
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	/** Close connection if open. */
	public static void close() {
		if (em != null) {
			em.close();
		}
		if (factory != null) {
			factory.close();
		}
	}
}
