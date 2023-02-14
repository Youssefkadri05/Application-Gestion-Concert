/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa_gestion_concert;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author amrii
 */
@Entity
@Table(name = "t_artiste_art", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"art_id"})})
@NamedQueries({
    @NamedQuery(name = "TArtisteArt.findAll", query = "SELECT t FROM TArtisteArt t"),
    @NamedQuery(name = "TArtisteArt.findByArtId", query = "SELECT t FROM TArtisteArt t WHERE t.artId = :artId"),
    @NamedQuery(name = "TArtisteArt.findByArtNom", query = "SELECT t FROM TArtisteArt t WHERE t.artNom = :artNom"),
    @NamedQuery(name = "TArtisteArt.findByArtPrenom", query = "SELECT t FROM TArtisteArt t WHERE t.artPrenom = :artPrenom"),
    @NamedQuery(name = "TArtisteArt.findByArtVilleOrigine", query = "SELECT t FROM TArtisteArt t WHERE t.artVilleOrigine = :artVilleOrigine"),
    @NamedQuery(name = "TArtisteArt.findByArtAge", query = "SELECT t FROM TArtisteArt t WHERE t.artAge = :artAge")})
public class TArtisteArt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "art_id", nullable = false)
    private Integer artId;
    @Basic(optional = false)
    @Column(name = "art_nom", nullable = false, length = 15)
    private String artNom;
    @Basic(optional = false)
    @Column(name = "art_prenom", nullable = false, length = 15)
    private String artPrenom;
    @Basic(optional = false)
    @Column(name = "art_ville_origine", nullable = false, length = 45)
    private String artVilleOrigine;
    @Basic(optional = false)
    @Column(name = "art_age", nullable = false)
    private int artAge;
    @JoinColumn(name = "grp_id", referencedColumnName = "grp_id", nullable = false)
    @ManyToOne(optional = false)
    private TGroupeGrp grpId;

    public TArtisteArt() {
    }

    public TArtisteArt(Integer artId) {
        this.artId = artId;
    }

    public TArtisteArt(Integer artId, String artNom, String artPrenom, String artVilleOrigine, int artAge) {
        this.artId = artId;
        this.artNom = artNom;
        this.artPrenom = artPrenom;
        this.artVilleOrigine = artVilleOrigine;
        this.artAge = artAge;
    }

    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public String getArtNom() {
        return artNom;
    }

    public void setArtNom(String artNom) {
        this.artNom = artNom;
    }

    public String getArtPrenom() {
        return artPrenom;
    }

    public void setArtPrenom(String artPrenom) {
        this.artPrenom = artPrenom;
    }

    public String getArtVilleOrigine() {
        return artVilleOrigine;
    }

    public void setArtVilleOrigine(String artVilleOrigine) {
        this.artVilleOrigine = artVilleOrigine;
    }

    public int getArtAge() {
        return artAge;
    }

    public void setArtAge(int artAge) {
        this.artAge = artAge;
    }

    public TGroupeGrp getGrpId() {
        return grpId;
    }

    public void setGrpId(TGroupeGrp grpId) {
        this.grpId = grpId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artId != null ? artId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TArtisteArt)) {
            return false;
        }
        TArtisteArt other = (TArtisteArt) object;
        if ((this.artId == null && other.artId != null) || (this.artId != null && !this.artId.equals(other.artId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestion_concert.TArtisteArt[ artId=" + artId + " ]";
    }
    
}
