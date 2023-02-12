package dao;


import gestion_concert.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * DAO pour la classe/table Ticket avec implémentation en JDBC.
 * @author Eric
 */
class DAO_Soiree extends DAO<TSoireeSoi> {

    private Connection connection = null;
    
    @Override
    public TSoireeSoi find(int id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void create(TSoireeSoi soiree) throws DAOException {
        try {
            Statement req = connection.createStatement();
            req = connection.createStatement();
            int nb = req.executeUpdate("insert into t_soiree_soi values "
            		+ "(" + soiree.getSoiId() + " , '" + soiree.getSoiNom() + "' , '" + soiree.getSalId() +")");
        } catch (Exception e) {
            throw new DAOException("Problème technique (" + e.getMessage() + ")");
        }
    }

    @Override
    public void update(TSoireeSoi soiree) throws DAOException {
        try {
            PreparedStatement reqParam = connection.prepareStatement("update t_soiree_soi set soi_nom = "+soiree.getSoiNom()+" where soi_id = ?");
            reqParam.setInt(1, soiree.getSoiId());
            reqParam.executeUpdate();
        } catch (Exception e) {
            throw new DAOException("Problème technique (" + e.getMessage() + ")");
        }
    }

    @Override
    public void delete(TSoireeSoi soiree) throws DAOException {
        try {
            PreparedStatement reqParam = connection.prepareStatement("delete from t_soiree_soi where soi_id = ?");
            reqParam.setInt(1, soiree.getSoiId());
            reqParam.executeUpdate();

        
        } catch (Exception e) {
            throw new DAOException("Problème technique (" + e.getMessage() + ")");
        }
    }

    public DAO_Soiree() throws DAOException {
    	super();
        this.connection = SQLConnection.getConnection();
    }
}