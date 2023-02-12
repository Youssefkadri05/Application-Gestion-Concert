/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_concert;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author amrii
 */
@Entity
@Table(name = "t_adminstrateur_adm", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"adm_id"})})
@NamedQueries({
    @NamedQuery(name = "TAdminstrateurAdm.findAll", query = "SELECT t FROM TAdminstrateurAdm t"),
    @NamedQuery(name = "TAdminstrateurAdm.findByAdmId", query = "SELECT t FROM TAdminstrateurAdm t WHERE t.admId = :admId"),
    @NamedQuery(name = "TAdminstrateurAdm.findByAdmNom", query = "SELECT t FROM TAdminstrateurAdm t WHERE t.admNom = :admNom"),
    @NamedQuery(name = "TAdminstrateurAdm.findByAdmPrenom", query = "SELECT t FROM TAdminstrateurAdm t WHERE t.admPrenom = :admPrenom"),
    @NamedQuery(name = "TAdminstrateurAdm.findByAdmMotDePasse", query = "SELECT t FROM TAdminstrateurAdm t WHERE t.admMotDePasse = :admMotDePasse"),
    @NamedQuery(name = "TAdminstrateurAdm.findByAdmEmail", query = "SELECT t FROM TAdminstrateurAdm t WHERE t.admEmail = :admEmail")})
public class TAdminstrateurAdm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "adm_id", nullable = false)
    private Integer admId;
    @Basic(optional = false)
    @Column(name = "adm_nom", nullable = false, length = 15)
    private String admNom;
    @Basic(optional = false)
    @Column(name = "adm_prenom", nullable = false, length = 15)
    private String admPrenom;
    @Basic(optional = false)
    @Column(name = "adm_mot_de_passe", nullable = false, length = 64)
    private String admMotDePasse;
    @Basic(optional = false)
    @Column(name = "adm_email", nullable = false, length = 20)
    private String admEmail;

    public TAdminstrateurAdm() {
    }

    public TAdminstrateurAdm(Integer admId) {
        this.admId = admId;
    }

    public TAdminstrateurAdm(Integer admId, String admNom, String admPrenom, String admMotDePasse, String admEmail) {
        this.admId = admId;
        this.admNom = admNom;
        this.admPrenom = admPrenom;
        this.admMotDePasse = admMotDePasse;
        this.admEmail = admEmail;
    }

    public Integer getAdmId() {
        return admId;
    }

    public void setAdmId(Integer admId) {
        this.admId = admId;
    }

    public String getAdmNom() {
        return admNom;
    }

    public void setAdmNom(String admNom) {
        this.admNom = admNom;
    }

    public String getAdmPrenom() {
        return admPrenom;
    }

    public void setAdmPrenom(String admPrenom) {
        this.admPrenom = admPrenom;
    }

    public String getAdmMotDePasse() {
        return admMotDePasse;
    }

    public void setAdmMotDePasse(String admMotDePasse) {
        this.admMotDePasse = admMotDePasse;
    }

    public String getAdmEmail() {
        return admEmail;
    }

    public void setAdmEmail(String admEmail) {
        this.admEmail = admEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (admId != null ? admId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TAdminstrateurAdm)) {
            return false;
        }
        TAdminstrateurAdm other = (TAdminstrateurAdm) object;
        if ((this.admId == null && other.admId != null) || (this.admId != null && !this.admId.equals(other.admId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.concert.TAdminstrateurAdm[ admId=" + admId + " ]";
    }
    
}
