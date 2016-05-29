/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author d00mus
 */
@Entity
@Table(name = "PSG_ATTR_CPAP_VENT_PRESS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsgAttrCpapVentPressue.findAll", query = "SELECT p FROM PsgAttrCpapVentPressue p"),
    @NamedQuery(name = "PsgAttrCpapVentPressue.findById", query = "SELECT p FROM PsgAttrCpapVentPressue p WHERE p.id = :id"),
    @NamedQuery(name = "PsgAttrCpapVentPressue.findByMeasuringTime", query = "SELECT p FROM PsgAttrCpapVentPressue p WHERE p.measuringTime = :measuringTime"),
    @NamedQuery(name = "PsgAttrCpapVentPressue.findByEepap", query = "SELECT p FROM PsgAttrCpapVentPressue p WHERE p.eepap = :eepap"),
    @NamedQuery(name = "PsgAttrCpapVentPressue.findByJpap", query = "SELECT p FROM PsgAttrCpapVentPressue p WHERE p.ipap = :jpap"),
    @NamedQuery(name = "PsgAttrCpapVentPressue.findByEpap", query = "SELECT p FROM PsgAttrCpapVentPressue p WHERE p.epap = :epap"),
    @NamedQuery(name = "PsgAttrCpapVentPressue.findByPdjff", query = "SELECT p FROM PsgAttrCpapVentPressue p WHERE p.pdiff = :pdjff")
})
public class PsgAttrCpapVentPressue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="PSG_ATTR_CPAP_PRESSUE_ID_GENERATOR", sequenceName="PSG_ATTR_CPAP_PRESSUE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PSG_ATTR_CPAP_PRESSUE_ID_GENERATOR")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEASURING_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date measuringTime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Column(name = "EEPAP")
    private BigDecimal eepap;
    
    @Column(name = "IPAP")
    private BigDecimal ipap;
    
    @Column(name = "EPAP")
    private BigDecimal epap;
    
    @Column(name = "PDIFF")
    private BigDecimal pdiff;
    
    
    @JoinColumn(name = "PSG_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    @NotNull
    private Psg psg;

    public PsgAttrCpapVentPressue() {
    }

    public PsgAttrCpapVentPressue(Long id) {
        this.id = id;
    }

    public PsgAttrCpapVentPressue(Long id, Date measuringTime) {
        this.id = id;
        this.measuringTime = measuringTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getMeasuringTime() {
        return measuringTime;
    }

    public void setMeasuringTime(Date measuringTime) {
        this.measuringTime = measuringTime;
    }

    public BigDecimal getEepap() {
        return eepap;
    }

    public void setEepap(BigDecimal eepap) {
        this.eepap = eepap;
    }

    public BigDecimal getIpap() {
        return ipap;
    }

    public void setIpap(BigDecimal ipap) {
        this.ipap = ipap;
    }

    public BigDecimal getEpap() {
        return epap;
    }

    public void setEpap(BigDecimal epap) {
        this.epap = epap;
    }

    public BigDecimal getPdiff() {
        return pdiff;
    }

    public void setPdiff(BigDecimal pdiff) {
        this.pdiff = pdiff;
    }

    public Psg getPsg() {
        return psg;
    }

    public void setPsg(Psg psg) {
        this.psg = psg;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsgAttrCpapVentPressue)) {
            return false;
        }
        PsgAttrCpapVentPressue other = (PsgAttrCpapVentPressue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        
        return "mdl.PsgAttrCpapPressue[ id=" + id + " ]";
    }
    
}
