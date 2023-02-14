package dao_gestion_concert;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import jpa_gestion_concert.TArtisteArt;
import jpa_gestion_concert.TConcertCon;
import jpa_gestion_concert.TGroupeGrp;

public class DAO_Artiste {
	 private EntityManager em;

	    public DAO_Artiste() {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConcertPU");
	        em = emf.createEntityManager();
	    }


    public void create(TArtisteArt TArtisteArt) {
        EntityManager em = null;
        try {
     
            em.getTransaction().begin();
            em.persist(TArtisteArt);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void update(TArtisteArt TArtisteArt) {
        EntityManager em = null;
        try {
          
            em.getTransaction().begin();
            TArtisteArt = em.merge(TArtisteArt);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void delete(Integer id) {
       
        try {
            
            em.getTransaction().begin();
            TArtisteArt TArtisteArt;
            try {
                TArtisteArt = em.getReference(TArtisteArt.class, id);
                TArtisteArt.getArtId();
            } catch (EntityNotFoundException enfe) {
                throw new RuntimeException("The TArtisteArt with id " + id + " no longer exists.", enfe);
            }
            em.remove(TArtisteArt);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public TArtisteArt find(Integer id) {
       
        try {
            return em.find(TArtisteArt.class, id);
        } finally {
            em.close();
        }
    }
    
    // Afficher toutes les artistes d'un groupe
    public List<TArtisteArt> GetAllArtisteInGroupe(TGroupeGrp groupe) {
       ;
		try {
			TypedQuery<TArtisteArt> query = em.createQuery(
               "SELECT a FROM TArtisteArt a JOIN a.grpId g WHERE g.grpId = :groupId", TArtisteArt.class);
                query.setParameter("groupId", groupe.getGrpId());
            return (List<TArtisteArt>) query.getResultList();
        } finally {
            em.close();
        }
    }
    
    // si le groupe contient un seul artiste alors le groupe representre un artiste 
    public boolean isGroupe(TGroupeGrp groupe) {
    	return this.GetAllArtisteInGroupe(groupe).size() != 1 &&  ! this.GetAllArtisteInGroupe(groupe).isEmpty() ;
    }


}
