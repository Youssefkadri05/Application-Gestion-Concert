package dao;


import gestion_concert.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import concertDAO.DAO;
import concertDAO.DAOException;
import concertDAO.SQLConnection;

/**
 * DAO pour la classe/table Ticket avec implémentation en JDBC.
 * @author Eric
 */
class DAO_Salle extends DAO<TSalleSal> {

    private Connection connection = null;
    
    @Override
    public TSalleSal find(int id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(TSalleSal salle) throws DAOException {
        try {
            Statement req = connection.createStatement();
            req = connection.createStatement();
            int nb = req.executeUpdate("insert into t_salle_sal values "
                            + "(" + salle.getSalId() + " , '" + salle.getSalNom() + "' , '" + salle.getSalAdresse() +"' , " + salle.getSalCapacite() + "' , '" + salle.getSalNomGestionnaire() +"' , " + "' , '" + salle.getSalAssociationGestionnaire() +")");
        } catch (Exception e) {
            throw new DAOException("Problème technique (" + e.getMessage() + ")");
        }
    }

    @Override
    public void update(TSalleSal salle) throws DAOException {
        try {
            PreparedStatement reqParam = connection.prepareStatement("update t_salle_sal set sal_nom = "+salle.getSalNom()+" where sal_id = ?");
            reqParam.setInt(1, salle.getSalId());
            reqParam.executeUpdate();
        } catch (Exception e) {
            throw new DAOException("Problème technique (" + e.getMessage() + ")");
        }
    }

    @Override
    public void delete(TSalleSal salle) throws DAOException {
        try {
            PreparedStatement reqParam = connection.prepareStatement("delete from t_salle_sal where sal_id = ?");
            reqParam.setInt(1, salle.getSalId());
            reqParam.executeUpdate();

        
        } catch (Exception e) {
            throw new DAOException("Problème technique (" + e.getMessage() + ")");
        }
    }

    public DAO_Salle() throws DAOException {
            super();
        this.connection = SQLConnection.getConnection();
    }
}