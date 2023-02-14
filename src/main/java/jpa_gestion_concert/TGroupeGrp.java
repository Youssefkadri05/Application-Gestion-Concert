/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa_gestion_concert;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author amrii
 */
@Entity
@Table(name = "t_groupe_grp", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"grp_id"})})
@NamedQueries({
    @NamedQuery(name = "TGroupeGrp.findAll", query = "SELECT t FROM TGroupeGrp t"),
    @NamedQuery(name = "TGroupeGrp.findByGrpId", query = "SELECT t FROM TGroupeGrp t WHERE t.grpId = :grpId")})
public class TGroupeGrp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "grp_id", nullable = false)
    private Integer grpId;
    @Basic(optional = false)
    @Lob
    @Column(name = "grp_nom", nullable = false, length = 65535)
    private String grpNom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grpId")
    private Collection<TConcertCon> tConcertConCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grpId")
    private Collection<TArtisteArt> tArtisteArtCollection;

    public TGroupeGrp() {
    }

    public TGroupeGrp(Integer grpId) {
        this.grpId = grpId;
    }

    public TGroupeGrp(Integer grpId, String grpNom) {
        this.grpId = grpId;
        this.grpNom = grpNom;
    }

    public Integer getGrpId() {
        return grpId;
    }

    public void setGrpId(Integer grpId) {
        this.grpId = grpId;
    }

    public String getGrpNom() {
        return grpNom;
    }

    public void setGrpNom(String grpNom) {
        this.grpNom = grpNom;
    }

    public Collection<TConcertCon> getTConcertConCollection() {
        return tConcertConCollection;
    }

    public void setTConcertConCollection(Collection<TConcertCon> tConcertConCollection) {
        this.tConcertConCollection = tConcertConCollection;
    }

    public Collection<TArtisteArt> getTArtisteArtCollection() {
        return tArtisteArtCollection;
    }

    public void setTArtisteArtCollection(Collection<TArtisteArt> tArtisteArtCollection) {
        this.tArtisteArtCollection = tArtisteArtCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grpId != null ? grpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TGroupeGrp)) {
            return false;
        }
        TGroupeGrp other = (TGroupeGrp) object;
        if ((this.grpId == null && other.grpId != null) || (this.grpId != null && !this.grpId.equals(other.grpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestion_concert.TGroupeGrp[ grpId=" + grpId + " ]";
    }
    
}
