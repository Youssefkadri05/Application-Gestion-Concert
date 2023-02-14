package dao_gestion_concert;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import jpa_gestion_concert.TTicketTic;

public class DAO_Ticket {

	private EntityManager em;

    public DAO_Ticket() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConcertPU");
        em = emf.createEntityManager();
    }

    public void create(TTicketTic tTicketTic) {
       
        try {
            
            em.getTransaction().begin();
            em.persist(tTicketTic);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void update(TTicketTic tTicketTic) {
        try {
         
            em.getTransaction().begin();
            em.merge(tTicketTic);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void delete(TTicketTic tTicketTic) {
        try {
          
            em.getTransaction().begin();
            em.remove(em.merge(tTicketTic));
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public TTicketTic find(int id) {
        
        try {
            return em.find(TTicketTic.class, id);
        } finally {
            em.close();
        }
    }

    public List<TTicketTic> findAll() {
       
        try {
            Query q = em.createNamedQuery("TTicketTic.findAll");
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    // Retouner le nombre de tickes vendus
    public int nombreTicketsVendus() {
        TypedQuery<Integer> query = em.createQuery("SELECT COUNT(t) FROM TTicketTic t", Integer.class);
        Integer count = query.getSingleResult();
        return count.intValue();
    }
    
    // Retourner la listes des tickets pour une soireé
    public List<TTicketTic> findTicketsBySoireeId(int soireeId) {
        try {
            TypedQuery<TTicketTic> query = em.createQuery(
                "SELECT t FROM TTicketTic t WHERE t.soiId.soiId = :soireeId", TTicketTic.class);
            query.setParameter("soireeId", soireeId);
            return query.getResultList();
        } finally {
            em.close();
        }
    }


    
}