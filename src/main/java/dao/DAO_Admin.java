package dao;

import gestion_concert.TGroupeGrp;
import concertDAO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * DAO pour la classe/table Administrateur
 */
class DAO_Admin extends DAO<TAdminstrateurAdm> {

    private Connection connection = null;
    
    @Override
    public TAdminstrateurAdm find(int id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void create(TAdminstrateurAdm admin) throws DAOException {
        try {
            Statement req = connection.createStatement();
            req = connection.createStatement();
            int nb = req.executeUpdate("insert into t_adminstrateur_adm values "
            		+ "(" + admin() + " , '" + groupe.getGrpNom() +")");
        } catch (Exception e) {
            throw new DAOException("Problème technique (" + e.getMessage() + ")");
        }
    }

    @Override
    public void update(TAdminstrateurAdm admin) throws DAOException {
        try {
            PreparedStatement reqParam = connection.prepareStatement("update t_groupe_grp set grp_nom = "+groupe.getGrpNom()+" where grp_id = ?");
            reqParam.setInt(1, groupe.getGrpId());
            reqParam.executeUpdate();
        } catch (Exception e) {
            throw new DAOException("Problème technique (" + e.getMessage() + ")");
        }
    }

    @Override
    public void delete(TAdminstrateur admin) throws DAOException {
        try {
            PreparedStatement reqParam = connection.prepareStatement("delete from t_groupe_grp where grp_id = ?");
            reqParam.setInt(1, groupe.getGrpId());
            reqParam.executeUpdate();

        
        } catch (Exception e) {
            throw new DAOException("Problème technique (" + e.getMessage() + ")");
        }
    }

    public DAO_Groupe() throws DAOException {
    	super();
        this.connection = SQLConnection.getConnection();
    }

	@Override
	public void create(TAdminstrateur data) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TAdminstrateur data) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TAdminstrateur data) throws DAOException {
		// TODO Auto-generated method stub
		
	}


}