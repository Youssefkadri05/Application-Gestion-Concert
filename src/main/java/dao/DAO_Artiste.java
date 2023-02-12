package dao;

import gestion_concert.TArtisteArt;
import gestion_concert.TTicketTic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_Artiste extends DAO<TArtisteArt> {
private Connection connection = null;
    
    @Override
    public TArtisteArt find(int id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void create(TArtisteArt artiste) throws DAOException {
        try {
            Statement req = connection.createStatement();
            req = connection.createStatement();
            int nb = req.executeUpdate("insert into t_artiste_art values "
            		+ "('" + artiste.getArtNom() + "' , '" + artiste.getArtPrenom() +"' , '" + artiste.getArtVilleOrigine()+"' ,"
            		+artiste.getArtAge()+","+ artiste.getGrpId().getGrpId() +")");
        } catch (Exception e) {
            throw new DAOException("Problème technique (" + e.getMessage() + ")");
        }
    }

    @Override
    public void update(TArtisteArt artiste) throws DAOException {
        try {
            PreparedStatement reqParam = connection.prepareStatement("update t_artiste_art set art_nom = "+artiste.getArtNom()+" where art_id = ?");
            reqParam.setInt(1, artiste.getArtId());
            reqParam.executeUpdate();
        } catch (Exception e) {
            throw new DAOException("Problème technique (" + e.getMessage() + ")");
        }
    }

    @Override
    public void delete(TArtisteArt artiste) throws DAOException {
        try {
            PreparedStatement reqParam = connection.prepareStatement("delete from t_artiste_art where art_id = ?");
            reqParam.setInt(1, artiste.getArtId());
            reqParam.executeUpdate();

        
        } catch (Exception e) {
            throw new DAOException("Problème technique (" + e.getMessage() + ")");
        }
    }

    public DAO_Artiste() throws DAOException {
    	super();
        this.connection = SQLConnection.getConnection();
    }
}