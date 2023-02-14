package jpa_gestion_concert;
import java.util.Date;

public class Article {
    private String titre;
    private String description;
    private String auteur;
    private Date date;
    
    public Article(String titre, String description, String auteur, Date date) {
        this.titre = titre;
        this.description = description;
        this.auteur = auteur;
        this.date = date;
    }
    
    public String getTitre() {
        return titre;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getAuteur() {
        return auteur;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
}


