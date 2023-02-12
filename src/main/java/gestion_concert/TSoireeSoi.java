/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_concert;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "t_soiree_soi", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"soi_id"})})
@NamedQueries({
    @NamedQuery(name = "TSoireeSoi.findAll", query = "SELECT t FROM TSoireeSoi t"),
    @NamedQuery(name = "TSoireeSoi.findBySoiId", query = "SELECT t FROM TSoireeSoi t WHERE t.soiId = :soiId"),
    @NamedQuery(name = "TSoireeSoi.findBySoiNom", query = "SELECT t FROM TSoireeSoi t WHERE t.soiNom = :soiNom")})
public class TSoireeSoi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "soi_id", nullable = false)
    private Integer soiId;
    @Basic(optional = false)
    @Column(name = "soi_nom", nullable = false, length = 15)
    private String soiNom;
    @JoinColumn(name = "sal_id", referencedColumnName = "sal_id", nullable = false)
    @ManyToOne(optional = false)
    private TSalleSal salId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "soiId")
    private Collection<TConcertCon> tConcertConCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "soiId")
    private Collection<TTicketTic> tTicketTicCollection;

    public TSoireeSoi() {
    }

    public TSoireeSoi(Integer soiId) {
        this.soiId = soiId;
    }

    public TSoireeSoi(Integer soiId, String soiNom) {
        this.soiId = soiId;
        this.soiNom = soiNom;
    }

    public Integer getSoiId() {
        return soiId;
    }

    public void setSoiId(Integer soiId) {
        this.soiId = soiId;
    }

    public String getSoiNom() {
        return soiNom;
    }

    public void setSoiNom(String soiNom) {
        this.soiNom = soiNom;
    }

    public TSalleSal getSalId() {
        return salId;
    }

    public void setSalId(TSalleSal salId) {
        this.salId = salId;
    }

    public Collection<TConcertCon> getTConcertConCollection() {
        return tConcertConCollection;
    }

    public void setTConcertConCollection(Collection<TConcertCon> tConcertConCollection) {
        this.tConcertConCollection = tConcertConCollection;
    }

    public Collection<TTicketTic> getTTicketTicCollection() {
        return tTicketTicCollection;
    }

    public void setTTicketTicCollection(Collection<TTicketTic> tTicketTicCollection) {
        this.tTicketTicCollection = tTicketTicCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (soiId != null ? soiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TSoireeSoi)) {
            return false;
        }
        TSoireeSoi other = (TSoireeSoi) object;
        if ((this.soiId == null && other.soiId != null) || (this.soiId != null && !this.soiId.equals(other.soiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.concert.TSoireeSoi[ soiId=" + soiId + " ]";
    }
    
}
