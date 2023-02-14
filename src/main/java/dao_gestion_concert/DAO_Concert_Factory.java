package dao_gestion_concert;

import jpa_gestion_concert.TAdminstrateurAdm;
import jpa_gestion_concert.TArtisteArt;
import jpa_gestion_concert.TConcertCon;
import jpa_gestion_concert.TGroupeGrp;
import jpa_gestion_concert.TSalleSal;
import jpa_gestion_concert.TSoireeSoi;
import jpa_gestion_concert.TTicketTic;

/**
 * Fabrique concr�te de DAO pour le sch�ma relationnel sports avec une impl�mentation en JDBC.
 * @author Eric
 */
public class DAO_Concert_Factory extends DAOFactory {
    
	/**
	 * Le DAO concret en JDBC pour la table Sport
	 */
    private DAO_Artiste daoArtiste = null;
    private DAO_Admin daoAdmin = null;
    private DAO_Concert daoConcert = null;
    private DAO_Groupe daoGroupe = null;
    private DAO_Salle daoSalle = null;
    private DAO_Soiree daoSoiree = null;
    private DAO_Ticket daoTicket = null;
    

	@Override
	public DAO_Artiste getDAOArtiste() throws DAOException {
		if (daoArtiste == null) daoArtiste = new DAO_Artiste();
        return daoArtiste;
	}
	
	@Override
	public DAO_Admin getDAOAdmin() throws DAOException {
		if (daoAdmin == null) daoAdmin = new DAO_Admin();
        return daoAdmin;
	}

	@Override
	public DAO_Salle getDAOSalle() throws DAOException {
		if (daoSalle == null) daoSalle = new DAO_Salle();
        return daoSalle;
	}

	@Override
	public DAO_Soiree getDAOSoiree() throws DAOException {
		if (daoSoiree == null) daoSoiree = new DAO_Soiree();
        return daoSoiree;
	}

	@Override
	public DAO_Ticket getDAOTicket() throws DAOException {
		if (daoTicket == null) daoTicket = new DAO_Ticket();
        return daoTicket;
	}

	@Override
	public DAO_Groupe getDAOGroupe() throws DAOException {
		if (daoGroupe == null) daoGroupe = new DAO_Groupe();
        return daoGroupe;
	}

	@Override
	public DAO_Concert getDAOConcert() throws DAOException {
		if (daoConcert == null) daoConcert = new DAO_Concert();
        return daoConcert;
	}
    
    
}
