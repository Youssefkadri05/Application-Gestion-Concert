package dao_gestion_concert;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpa_gestion_concert.TGroupeGrp;

public class DAO_Groupe {
    
    

    private EntityManagerFactory emf;
    private EntityManager em;

    public DAO_Groupe() {
        emf = Persistence.createEntityManagerFactory("ConcertPU"); 
        em = emf.createEntityManager();
    }


    public TGroupeGrp find(int id) {
        return em.find(TGroupeGrp.class, id);
    }

    public List<TGroupeGrp> findAll() {
        Query query = em.createQuery("SELECT g FROM TGroupeGrp g");
        return query.getResultList();
    }

    public void create(TGroupeGrp groupe) {
    	em.getTransaction().begin();
    	em.persist(groupe);
    	em.getTransaction().commit();
    }

    public void update(TGroupeGrp groupe) {
    	em.getTransaction().begin();
        em.merge(groupe);
        em.getTransaction().commit();
    }

    public void delete(TGroupeGrp groupe) {
    	em.getTransaction().begin();
    	em.remove(groupe);
    	em.getTransaction().commit();
    }
}