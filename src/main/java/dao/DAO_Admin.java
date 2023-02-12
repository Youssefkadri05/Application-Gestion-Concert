package dao;


import gestion_concert.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;



/**
 * DAO pour la classe/table Ticket avec implémentation en JDBC.
 * @author Eric
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
            int nb = req.executeUpdate("insert into t_administrateur_adm values "
            		+ "(" + admin.getAdmId() + " , '" + admin.getAdmNom() + "' , '" + admin.getAdmPrenom() +"' , " + admin.getAdmEmail() +"' , " + admin.getAdmMotDePasse() +")");
        } catch (Exception e) {
            throw new DAOException("Problème technique (" + e.getMessage() + ")");
        }
    }

    @Override
    public void update(TAdminstrateurAdm admin) throws DAOException {
        try {
            PreparedStatement reqParam = connection.prepareStatement("update t_administrateur_adm set adm_mot_de_passe = "+admin.getAdmMotDePasse()+" where adm_id = ?");
            reqParam.setInt(1, admin.getAdmId());
            reqParam.executeUpdate();
        } catch (Exception e) {
            throw new DAOException("Problème technique (" + e.getMessage() + ")");
        }
    }

    @Override
    public void delete(TAdminstrateurAdm admin) throws DAOException {
        try {
            PreparedStatement reqParam = connection.prepareStatement("delete from t_administrateur_adm where adm_id = ?");
            reqParam.setInt(1, admin.getAdmId());
            reqParam.executeUpdate();

        
        } catch (Exception e) {
            throw new DAOException("Problème technique (" + e.getMessage() + ")");
        }
    }

    public DAO_Admin() throws DAOException {
    	super();
        this.connection = SQLConnection.getConnection();
    }
}