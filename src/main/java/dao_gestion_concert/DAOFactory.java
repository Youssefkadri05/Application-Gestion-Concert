package dao_gestion_concert;

import jpa_gestion_concert.TAdminstrateurAdm;
import jpa_gestion_concert.TArtisteArt;
import jpa_gestion_concert.TConcertCon;
import jpa_gestion_concert.TGroupeGrp;
import jpa_gestion_concert.TSalleSal;
import jpa_gestion_concert.TSoireeSoi;
import jpa_gestion_concert.TTicketTic;

/**
 * Fabrique abstraite de DAO pour le sch�ma sports
 * @author Eric
 */
public abstract class DAOFactory {
    
    /**
     * @return le DAO pour la classe/table Sport.
     * @throws DAOException en cas de probl�me
     */
    public abstract DAO_Artiste getDAOArtiste() throws DAOException;

	public abstract DAO_Admin getDAOAdmin() throws DAOException;
	
	public abstract DAO_Salle getDAOSalle() throws DAOException;
	
	public abstract DAO_Soiree getDAOSoiree() throws DAOException;
	
	public abstract DAO_Ticket getDAOTicket() throws DAOException;
	
	public abstract DAO_Groupe getDAOGroupe() throws DAOException;
	
	public abstract DAO_Concert getDAOConcert() throws DAOException;
    
    /**
     * @return le DAO pour la classe/table Discipline.
     * @throws DAOException en cas de probl�me
     */
    //public abstract DAO<Discipline> getDAODiscipline() throws DAOException;
}
