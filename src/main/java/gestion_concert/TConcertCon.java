/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.concert;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author amrii
 */
@Entity
@Table(name = "t_concert_con", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"con_id"})})
@NamedQueries({
    @NamedQuery(name = "TConcertCon.findAll", query = "SELECT t FROM TConcertCon t"),
    @NamedQuery(name = "TConcertCon.findByConId", query = "SELECT t FROM TConcertCon t WHERE t.conId = :conId"),
    @NamedQuery(name = "TConcertCon.findByConNom", query = "SELECT t FROM TConcertCon t WHERE t.conNom = :conNom"),
    @NamedQuery(name = "TConcertCon.findByConDateHeureDebut", query = "SELECT t FROM TConcertCon t WHERE t.conDateHeureDebut = :conDateHeureDebut"),
    @NamedQuery(name = "TConcertCon.findByConDateHeureFin", query = "SELECT t FROM TConcertCon t WHERE t.conDateHeureFin = :conDateHeureFin")})
public class TConcertCon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "con_id", nullable = false)
    private Integer conId;
    @Basic(optional = false)
    @Column(name = "con_nom", nullable = false, length = 40)
    private String conNom;
    @Basic(optional = false)
    @Lob
    @Column(name = "con_description", nullable = false, length = 65535)
    private String conDescription;
    @Basic(optional = false)
    @Column(name = "con_date_heure_debut", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date conDateHeureDebut;
    @Basic(optional = false)
    @Column(name = "con_date_heure_fin", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date conDateHeureFin;
    @JoinColumn(name = "grp_id", referencedColumnName = "grp_id", nullable = false)
    @ManyToOne(optional = false)
    private TGroupeGrp grpId;
    @JoinColumn(name = "soi_id", referencedColumnName = "soi_id", nullable = false)
    @ManyToOne(optional = false)
    private TSoireeSoi soiId;

    public TConcertCon() {
    }

    public TConcertCon(Integer conId) {
        this.conId = conId;
    }

    public TConcertCon(Integer conId, String conNom, String conDescription, Date conDateHeureDebut, Date conDateHeureFin) {
        this.conId = conId;
        this.conNom = conNom;
        this.conDescription = conDescription;
        this.conDateHeureDebut = conDateHeureDebut;
        this.conDateHeureFin = conDateHeureFin;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public String getConNom() {
        return conNom;
    }

    public void setConNom(String conNom) {
        this.conNom = conNom;
    }

    public String getConDescription() {
        return conDescription;
    }

    public void setConDescription(String conDescription) {
        this.conDescription = conDescription;
    }

    public Date getConDateHeureDebut() {
        return conDateHeureDebut;
    }

    public void setConDateHeureDebut(Date conDateHeureDebut) {
        this.conDateHeureDebut = conDateHeureDebut;
    }

    public Date getConDateHeureFin() {
        return conDateHeureFin;
    }

    public void setConDateHeureFin(Date conDateHeureFin) {
        this.conDateHeureFin = conDateHeureFin;
    }

    public TGroupeGrp getGrpId() {
        return grpId;
    }

    public void setGrpId(TGroupeGrp grpId) {
        this.grpId = grpId;
    }

    public TSoireeSoi getSoiId() {
        return soiId;
    }

    public void setSoiId(TSoireeSoi soiId) {
        this.soiId = soiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conId != null ? conId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TConcertCon)) {
            return false;
        }
        TConcertCon other = (TConcertCon) object;
        if ((this.conId == null && other.conId != null) || (this.conId != null && !this.conId.equals(other.conId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.concert.TConcertCon[ conId=" + conId + " ]";
    }
    
}
