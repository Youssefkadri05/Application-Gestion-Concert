package dao_gestion_concert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa_gestion_concert.TSoireeSoi;

import java.util.List;

public class DAO_Soiree {
    private EntityManagerFactory emf;
    private EntityManager em;

    public DAO_Soiree() {
        emf = Persistence.createEntityManagerFactory("ConcertPU"); 
        em = emf.createEntityManager();
    }

    public TSoireeSoi create(TSoireeSoi soiree) {
        em.getTransaction().begin();
        em.persist(soiree);
        em.getTransaction().commit();
        return soiree;
    }

    public TSoireeSoi find(Integer id) {
        return em.find(TSoireeSoi.class, id);
    }

    public List<TSoireeSoi> findAll() {
        return em.createQuery("SELECT s FROM TSoireeSoi s", TSoireeSoi.class).getResultList();
    }

    public TSoireeSoi update(TSoireeSoi soiree) {
        em.getTransaction().begin();
        em.merge(soiree);
        em.getTransaction().commit();
        return soiree;
    }

    public void delete(TSoireeSoi soiree) {
        em.getTransaction().begin();
        em.remove(soiree);
        em.getTransaction().commit();
    }

    public void closeEntityManager() {
        em.close();
        emf.close();
    }
}
