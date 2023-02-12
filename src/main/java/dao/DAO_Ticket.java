package dao;

import gestion_concert.TTicketTic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * DAO pour la classe/table Ticket avec implémentation en JDBC.
 * @author Eric
 */
class DAO_Ticket extends DAO<TTicketTic> {

    private Connection connection = null;
    
    @Override
    public TTicketTic find(int id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void create(TTicketTic ticket) throws DAOException {
        try {
            Statement req = connection.createStatement();
            req = connection.createStatement();
            int nb = req.executeUpdate("insert into t_ticket_tic values "
            		+ "(" + ticket.getTicPrix() + " , '" + ticket.getTicNom() + "' , '" + ticket.getTicPrenom() +"' , " + ticket.getSoiId().getSoiId() +")");
        } catch (Exception e) {
            throw new DAOException("Problème technique (" + e.getMessage() + ")");
        }
    }

    @Override
    public void update(TTicketTic ticket) throws DAOException {
        try {
            PreparedStatement reqParam = connection.prepareStatement("update t_ticket_tic set tic_prix = "+ticket.getTicPrix()+" where tic_id = ?");
            reqParam.setInt(1, ticket.getTicId());
            reqParam.executeUpdate();
        } catch (Exception e) {
            throw new DAOException("Problème technique (" + e.getMessage() + ")");
        }
    }

    @Override
    public void delete(TTicketTic ticket) throws DAOException {
        try {
            PreparedStatement reqParam = connection.prepareStatement("delete from t_ticket_tic where tic_id = ?");
            reqParam.setInt(1, ticket.getTicId());
            reqParam.executeUpdate();

        
        } catch (Exception e) {
            throw new DAOException("Problème technique (" + e.getMessage() + ")");
        }
    }

    public DAO_Ticket() throws DAOException {
    	super();
        this.connection = SQLConnection.getConnection();
    }
}