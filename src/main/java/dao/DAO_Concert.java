package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import gestion_concert.TConcertCon;

public class DAO_Concert extends DAO<TConcertCon> {
private Connection connection = null;
    
    @Override
    public TConcertCon find(int id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void create(TConcertCon concert) throws DAOException {
        try {
            Statement req = connection.createStatement();
            req = connection.createStatement();
            int nb = req.executeUpdate("insert into t_concert_con values "
            		+ "('" + concert.getConNom() + "' , '" + concert.getConDescription() +"' , '" + concert.getConDateHeureDebut()+"' ,"
            		+ concert.getConDateHeureFin()+"' ,"
            		+concert.getSoiId().getSoiId()+","+ concert.getGrpId().getGrpId() +")");
        } catch (Exception e) {
            throw new DAOException("Problème technique (" + e.getMessage() + ")");
        }
    }

    @Override
    public void update(TConcertCon concert) throws DAOException {
        try {
            PreparedStatement reqParam = connection.prepareStatement("update t_concert_con set com_nom = "+concert.getConNom()+" where com_id = ?");
            reqParam.setInt(1, concert.getConId());
            reqParam.executeUpdate();
        } catch (Exception e) {
            throw new DAOException("Problème technique (" + e.getMessage() + ")");
        }
    }

    @Override
    public void delete(TConcertCon concert) throws DAOException {
        try {
            PreparedStatement reqParam = connection.prepareStatement("delete from t_concert_con where con_id = ?");
            reqParam.setInt(1, concert.getConId());
            reqParam.executeUpdate();

        
        } catch (Exception e) {
            throw new DAOException("Problème technique (" + e.getMessage() + ")");
        }
    }

    public DAO_Concert() throws DAOException {
    	super();
        this.connection = SQLConnection.getConnection();
    }
}