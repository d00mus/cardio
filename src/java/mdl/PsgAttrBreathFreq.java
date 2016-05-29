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
@Table(name = "PSG_ATTR_BREATH_FREQ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsgAttrBreathFreq.findAll", query = "SELECT p FROM PsgAttrBreathFreq p"),
    @NamedQuery(name = "PsgAttrBreathFreq.findById", query = "SELECT p FROM PsgAttrBreathFreq p WHERE p.id = :id"),
    @NamedQuery(name = "PsgAttrBreathFreq.findByMeasuringTime", query = "SELECT p FROM PsgAttrBreathFreq p WHERE p.measuringTime = :measuringTime"),
    @NamedQuery(name = "PsgAttrBreathFreq.findByBreathFreq", query = "SELECT p FROM PsgAttrBreathFreq p WHERE p.breathFreq = :breathFreq")
})
public class PsgAttrBreathFreq implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="PSG_ATTR_BREATH_FREQ_ID_GENERATOR", sequenceName="PSG_ATTR_BREATH_FREQ_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PSG_ATTR_BREATH_FREQ_ID_GENERATOR")
    private Long id;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEASURING_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    
    private Date measuringTime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "BREATH_FREQ")
    private BigDecimal breathFreq;
    
    
    @JoinColumn(name = "PSG_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    @NotNull
    private Psg psg;

    public PsgAttrBreathFreq() {
    }

    public PsgAttrBreathFreq(Long id) {
        this.id = id;
    }

    public PsgAttrBreathFreq(Long id, Date measuringTime, BigDecimal breathFreq) {
        this.id = id;
        this.measuringTime = measuringTime;
        this.breathFreq = breathFreq;
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

    public BigDecimal getBreathFreq() {
        return breathFreq;
    }

    public void setBreathFreq(BigDecimal breathFreq) {
        this.breathFreq = breathFreq;
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
        if (!(object instanceof PsgAttrBreathFreq)) {
            return false;
        }
        PsgAttrBreathFreq other = (PsgAttrBreathFreq) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdl.PsgAttrBreathFreq[ id=" + id + " ]";
    }
    
}
