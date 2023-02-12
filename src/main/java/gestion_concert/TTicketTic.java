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
@Table(name = "t_ticket_tic", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"tic_id"})})
@NamedQueries({
    @NamedQuery(name = "TTicketTic.findAll", query = "SELECT t FROM TTicketTic t"),
    @NamedQuery(name = "TTicketTic.findByTicId", query = "SELECT t FROM TTicketTic t WHERE t.ticId = :ticId"),
    @NamedQuery(name = "TTicketTic.findByTicPrix", query = "SELECT t FROM TTicketTic t WHERE t.ticPrix = :ticPrix"),
    @NamedQuery(name = "TTicketTic.findByTicNom", query = "SELECT t FROM TTicketTic t WHERE t.ticNom = :ticNom"),
    @NamedQuery(name = "TTicketTic.findByTicPrenom", query = "SELECT t FROM TTicketTic t WHERE t.ticPrenom = :ticPrenom")})
public class TTicketTic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tic_id", nullable = false)
    private Integer ticId;
    @Basic(optional = false)
    @Column(name = "tic_prix", nullable = false)
    private double ticPrix;
    @Basic(optional = false)
    @Column(name = "tic_nom", nullable = false, length = 45)
    private String ticNom;
    @Basic(optional = false)
    @Column(name = "tic_prenom", nullable = false, length = 45)
    private String ticPrenom;
    @JoinColumn(name = "soi_id", referencedColumnName = "soi_id", nullable = false)
    @ManyToOne(optional = false)
    private TSoireeSoi soiId;

    public TTicketTic() {
    }

    public TTicketTic(Integer ticId) {
        this.ticId = ticId;
    }

    public TTicketTic(Integer ticId, double ticPrix, String ticNom, String ticPrenom) {
        this.ticId = ticId;
        this.ticPrix = ticPrix;
        this.ticNom = ticNom;
        this.ticPrenom = ticPrenom;
    }

    public Integer getTicId() {
        return ticId;
    }

    public void setTicId(Integer ticId) {
        this.ticId = ticId;
    }

    public double getTicPrix() {
        return ticPrix;
    }

    public void setTicPrix(double ticPrix) {
        this.ticPrix = ticPrix;
    }

    public String getTicNom() {
        return ticNom;
    }

    public void setTicNom(String ticNom) {
        this.ticNom = ticNom;
    }

    public String getTicPrenom() {
        return ticPrenom;
    }

    public void setTicPrenom(String ticPrenom) {
        this.ticPrenom = ticPrenom;
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
        hash += (ticId != null ? ticId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TTicketTic)) {
            return false;
        }
        TTicketTic other = (TTicketTic) object;
        if ((this.ticId == null && other.ticId != null) || (this.ticId != null && !this.ticId.equals(other.ticId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.concert.TTicketTic[ ticId=" + ticId + " ]";
    }
    
}
