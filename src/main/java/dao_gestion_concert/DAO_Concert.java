package dao_gestion_concert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import jpa_gestion_concert.TConcertCon;

import java.sql.Date;
import java.util.List;

public class DAO_Concert {

    private EntityManager em;

    public DAO_Concert() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConcertPU");
        em = emf.createEntityManager();
    }

    public TConcertCon find(int id) {
        return em.find(TConcertCon.class, id);
    }

    public List<TConcertCon> findAll() {
        return em.createNamedQuery("TConcertCon.findAll", TConcertCon.class).getResultList();
    }

    public void create(TConcertCon tConcertCon) {
        em.getTransaction().begin();
        em.persist(tConcertCon);
        em.getTransaction().commit();
    }

    public void update(TConcertCon tConcertCon) {
        em.getTransaction().begin();
        em.merge(tConcertCon);
        em.getTransaction().commit();
    }

    public void delete(int id) {
        TConcertCon tConcertCon = find(id);
        em.getTransaction().begin();
        em.remove(tConcertCon);
        em.getTransaction().commit();
    }
    
    // Touver toutes les concerts organisées dans la meme date
    public List<TConcertCon> trouverConcertsParDate(Date date) {
        TypedQuery<TConcertCon> query = em.createQuery(
            "SELECT c FROM Concert c WHERE c.date = :date", TConcertCon.class);
        query.setParameter("date", date);
        List<TConcertCon> resultats = query.getResultList();
        em.close();
        return resultats;
    }

}
