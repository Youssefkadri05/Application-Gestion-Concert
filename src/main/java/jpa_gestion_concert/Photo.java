package jpa_gestion_concert;
import java.util.Date;

public class Photo {
    private String pho_auteur;
    private Date pho_date;
    private String pho_lien;

    public Photo(String pho_auteur, Date pho_date, String pho_lien) {
        this.pho_auteur = pho_auteur;
        this.pho_date = pho_date;
        this.pho_lien = pho_lien;
    }

    public String getPho_auteur() {
        return pho_auteur;
    }

    public void setPho_auteur(String pho_auteur) {
        this.pho_auteur = pho_auteur;
    }

    public Date getPho_date() {
        return pho_date;
    }

    public void setPho_date(Date pho_date) {
        this.pho_date = pho_date;
    }

    public String getPho_lien() {
        return pho_lien;
    }

    public void setPho_lien(String pho_lien) {
        this.pho_lien = pho_lien;
    }
}
