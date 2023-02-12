/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package gestion_concert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author amrii
 */
public class Concert {

    public static void main(String[] args) {
        System.out.println("Helloggggg Worldgrfnfg!");
     // charge le gestionnaire d'entités lié à l'unité de persistance "SportsPU"
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConcertPU");
        EntityManager em = emf.createEntityManager();
        System.out.println("PU chargée");
        // récupère le sport d'identifiant 1, affiche son intitulé et ses disciplines
        int cle = 1;
        TSalleSal salle = em.find(TSalleSal.class, cle);
        // System.out.println("Le sport " + cle + " est " + salle.getIntitule());
        for (TSoireeSoi disc : salle.getTSoireeSoiCollection())
        System.out.println(" -> " + disc.getSalId());
        }

    
}
