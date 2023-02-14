package test;

import dao_gestion_concert.AbstractDAOFactory;
import dao_gestion_concert.DAOFactory;
import dao_gestion_concert.DAO_Admin;
import dao_gestion_concert.DAO_Artiste;
import dao_gestion_concert.DAO_Concert;
import dao_gestion_concert.DAO_Groupe;
import dao_gestion_concert.DAO_Salle;
import dao_gestion_concert.DAO_Soiree;
import dao_gestion_concert.DAO_Ticket;
import dao_gestion_concert.PersistenceKind;
import jpa_gestion_concert.TAdminstrateurAdm;
import jpa_gestion_concert.TArtisteArt;
import jpa_gestion_concert.TConcertCon;
import jpa_gestion_concert.TGroupeGrp;
import jpa_gestion_concert.TSalleSal;
import jpa_gestion_concert.TSoireeSoi;
import jpa_gestion_concert.TTicketTic;


public class TestDAO {

    public static void main(String argv[]) {
        try {
	    
	    // cr�ation des DAO via les fabriques
            DAOFactory factory = AbstractDAOFactory.getDAOFactory(PersistenceKind.JDBC);
            DAO_Artiste daoartiste = factory.getDAOArtiste(); 
            DAO_Admin daoadmin = factory.getDAOAdmin(); 
            DAO_Concert daoConcert = factory.getDAOConcert();
            DAO_Groupe daoGroupe = factory.getDAOGroupe();
            DAO_Soiree daoSoiree = factory.getDAOSoiree();
            DAO_Salle daoSal = factory.getDAOSalle();
            DAO_Ticket daoTic = factory.getDAOTicket();




            TAdminstrateurAdm admin = daoadmin.find(2);
            System.out.println("Admin d'id 1 est "+admin.getAdmNom());
   
            TArtisteArt artiste = daoartiste.find(1);
            System.out.println("L'artiste d'id 1 est "+artiste.getArtNom());
            
            TConcertCon concert = daoConcert.find(1);
            System.out.println("Le concert d'id 1 est "+concert.getConNom());
            
            TGroupeGrp groupe = daoGroupe.find(1);
            System.out.println("Le groupe d'id 1 est "+groupe.getGrpNom());
            
            TSoireeSoi soiree = daoSoiree.find(1);
            System.out.println("La soiree d'id 1 est "+soiree.getSoiNom());
            
            TSalleSal salle = daoSal.find(1);
            System.out.println("La salle d'id 1 est "+salle.getSalNom());
            
            
            TTicketTic tic = daoTic.find(1);
            System.out.println("Le ticket d'id 1 est "+tic.getTicNom());
            

           /* TAdminstrateurAdm s = new TAdminstrateurAdm();
            s.setAdmNom("test");
            s.setAdmId(3);
            s.setAdmPrenom("tets");
            s.setAdmMotDePasse("hey");
            s.setAdmEmail("test@gmail.com");*/

            //daoadmin.create(s); 
            
            //Teste de UPdate
            TAdminstrateurAdm a = new TAdminstrateurAdm();
            a.setAdmId(3);
            //a.setAdmMotDePasse("hhhhhhhhhhh");
          

                    
         
             
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}

