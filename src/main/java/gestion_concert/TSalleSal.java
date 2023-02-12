/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.concert;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "t_salle_sal", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"sal_id"})})
@NamedQueries({
    @NamedQuery(name = "TSalleSal.findAll", query = "SELECT t FROM TSalleSal t"),
    @NamedQuery(name = "TSalleSal.findBySalId", query = "SELECT t FROM TSalleSal t WHERE t.salId = :salId"),
    @NamedQuery(name = "TSalleSal.findBySalNom", query = "SELECT t FROM TSalleSal t WHERE t.salNom = :salNom"),
    @NamedQuery(name = "TSalleSal.findBySalAdresse", query = "SELECT t FROM TSalleSal t WHERE t.salAdresse = :salAdresse"),
    @NamedQuery(name = "TSalleSal.findBySalCapacite", query = "SELECT t FROM TSalleSal t WHERE t.salCapacite = :salCapacite"),
    @NamedQuery(name = "TSalleSal.findBySalNomGestionnaire", query = "SELECT t FROM TSalleSal t WHERE t.salNomGestionnaire = :salNomGestionnaire"),
    @NamedQuery(name = "TSalleSal.findBySalPrenomGetionnaire", query = "SELECT t FROM TSalleSal t WHERE t.salPrenomGetionnaire = :salPrenomGetionnaire"),
    @NamedQuery(name = "TSalleSal.findBySalAssociationGestionnaire", query = "SELECT t FROM TSalleSal t WHERE t.salAssociationGestionnaire = :salAssociationGestionnaire")})
public class TSalleSal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sal_id", nullable = false)
    private Integer salId;
    @Basic(optional = false)
    @Column(name = "sal_nom", nullable = false, length = 15)
    private String salNom;
    @Basic(optional = false)
    @Column(name = "sal_adresse", nullable = false, length = 45)
    private String salAdresse;
    @Basic(optional = false)
    @Column(name = "sal_capacite", nullable = false)
    private int salCapacite;
    @Basic(optional = false)
    @Column(name = "sal_nom_gestionnaire", nullable = false, length = 15)
    private String salNomGestionnaire;
    @Basic(optional = false)
    @Column(name = "sal_prenom_getionnaire", nullable = false, length = 15)
    private String salPrenomGetionnaire;
    @Column(name = "sal_association_gestionnaire", length = 15)
    private String salAssociationGestionnaire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salId")
    private Collection<TSoireeSoi> tSoireeSoiCollection;

    public TSalleSal() {
    }

    public TSalleSal(Integer salId) {
        this.salId = salId;
    }

    public TSalleSal(Integer salId, String salNom, String salAdresse, int salCapacite, String salNomGestionnaire, String salPrenomGetionnaire) {
        this.salId = salId;
        this.salNom = salNom;
        this.salAdresse = salAdresse;
        this.salCapacite = salCapacite;
        this.salNomGestionnaire = salNomGestionnaire;
        this.salPrenomGetionnaire = salPrenomGetionnaire;
    }

    public Integer getSalId() {
        return salId;
    }

    public void setSalId(Integer salId) {
        this.salId = salId;
    }

    public String getSalNom() {
        return salNom;
    }

    public void setSalNom(String salNom) {
        this.salNom = salNom;
    }

    public String getSalAdresse() {
        return salAdresse;
    }

    public void setSalAdresse(String salAdresse) {
        this.salAdresse = salAdresse;
    }

    public int getSalCapacite() {
        return salCapacite;
    }

    public void setSalCapacite(int salCapacite) {
        this.salCapacite = salCapacite;
    }

    public String getSalNomGestionnaire() {
        return salNomGestionnaire;
    }

    public void setSalNomGestionnaire(String salNomGestionnaire) {
        this.salNomGestionnaire = salNomGestionnaire;
    }

    public String getSalPrenomGetionnaire() {
        return salPrenomGetionnaire;
    }

    public void setSalPrenomGetionnaire(String salPrenomGetionnaire) {
        this.salPrenomGetionnaire = salPrenomGetionnaire;
    }

    public String getSalAssociationGestionnaire() {
        return salAssociationGestionnaire;
    }

    public void setSalAssociationGestionnaire(String salAssociationGestionnaire) {
        this.salAssociationGestionnaire = salAssociationGestionnaire;
    }

    public Collection<TSoireeSoi> getTSoireeSoiCollection() {
        return tSoireeSoiCollection;
    }

    public void setTSoireeSoiCollection(Collection<TSoireeSoi> tSoireeSoiCollection) {
        this.tSoireeSoiCollection = tSoireeSoiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salId != null ? salId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TSalleSal)) {
            return false;
        }
        TSalleSal other = (TSalleSal) object;
        if ((this.salId == null && other.salId != null) || (this.salId != null && !this.salId.equals(other.salId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.concert.TSalleSal[ salId=" + salId + " ]";
    }
    
}
