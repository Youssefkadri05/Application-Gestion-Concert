package dao_gestion_concert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpa_gestion_concert.*;

import java.util.List;

public class DAO_Admin {
    private EntityManager em;

    public DAO_Admin() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConcertPU");
        em = emf.createEntityManager();
    }

    public void ajouter(TAdminstrateurAdm adm) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(adm);
        transaction.commit();
    }

    public void modifier(TAdminstrateurAdm adm) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(adm);
        transaction.commit();
    }

    public void supprimer(TAdminstrateurAdm adm) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(adm);
        transaction.commit();
    }

    public TAdminstrateurAdm find(int id) {
        return em.find(TAdminstrateurAdm.class, id);
    }

    public List<TAdminstrateurAdm> chercherTous() {
        Query query = em.createQuery("SELECT t FROM TAdminstrateurAdm t");
        return query.getResultList();
    }
}
