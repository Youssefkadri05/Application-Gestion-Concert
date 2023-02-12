package dao;

import gestion_concert.TGroupeGrp;
import concertDAO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * DAO pour la classe/table Groupe
 */
class DAO_Groupe extends DAO<TGroupeGrp> {

    private Connection connection = null;
    
    @Override
    public TGroupeGrp find(int id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void create(TGroupeGrp groupe) throws DAOException {
        try {
            Statement req = connection.createStatement();
            req = connection.createStatement();
            int nb = req.executeUpdate("insert into t_groupe_grp values "
            		+ "(" + groupe.getGrpId() + " , '" + groupe.getGrpNom() +")");
        } catch (Exception e) {
            throw new DAOException("Problème technique (" + e.getMessage() + ")");
        }
    }

    @Override
    public void update(TGroupeGrp groupe) throws DAOException {
        try {
            PreparedStatement reqParam = connection.prepareStatement("update t_groupe_grp set grp_nom = "+groupe.getGrpNom()+" where grp_id = ?");
            reqParam.setInt(1, groupe.getGrpId());
            reqParam.executeUpdate();
        } catch (Exception e) {
            throw new DAOException("Problème technique (" + e.getMessage() + ")");
        }
    }

    @Override
    public void delete(TGroupeGrp groupe) throws DAOException {
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


}