package dao_gestion_concert;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import jpa_gestion_concert.TSalleSal;

public class DAO_Salle {
	private EntityManagerFactory emf;
	private EntityManager em;

	public DAO_Salle() {
		emf = Persistence.createEntityManagerFactory("ConcertPU");
		em = emf.createEntityManager();
	}

	public TSalleSal find(int id) {
		return em.find(TSalleSal.class, id);
	}

	public void create(TSalleSal salle) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(salle);
		transaction.commit();
	}

	public void update(TSalleSal salle) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.merge(salle);
		transaction.commit();
	}

	public void delete(TSalleSal salle) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(salle);
		transaction.commit();
	}
	
	// Trouver toutes les salles libres
	public List<TSalleSal> GetAllSalleLibre() {
	    try {
	        TypedQuery<TSalleSal> query = em.createQuery("SELECT s FROM TSalleSal s WHERE s.salId NOT IN (SELECT so.salleId.salId FROM TSoireeSoi so WHERE so.soiDateDebut <= :now AND so.soiDateFin >= :now)", TSalleSal.class);
	        query.setParameter("now", new Date(0));
	        return query.getResultList();
	    } finally {
	        em.close();
	    }
	}

}
