/*
 * To change this template, choose Tools | Templates
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
@Table(name = "PSG_ATTR_SP_O2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsgAttrSpO2.findAll", query = "SELECT p FROM PsgAttrSpO2 p"),
    @NamedQuery(name = "PsgAttrSpO2.findById", query = "SELECT p FROM PsgAttrSpO2 p WHERE p.id = :id"),
    @NamedQuery(name = "PsgAttrSpO2.findByMeasuringTime", query = "SELECT p FROM PsgAttrSpO2 p WHERE p.measuringTime = :measuringTime"),
    @NamedQuery(name = "PsgAttrSpO2.findByPsgLevel", query = "SELECT p FROM PsgAttrSpO2 p WHERE p.psgLevel = :psgLevel"),
    @NamedQuery(name = "PsgAttrSpO2.findBySpO2Min", query = "SELECT p FROM PsgAttrSpO2 p WHERE p.spO2Min = :spO2Min"),
    })
public class PsgAttrSpO2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @SequenceGenerator(name="PSG_ATTR_SP_O2_ID_GENERATOR", sequenceName="PSG_ATTR_SP_O2_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PSG_ATTR_SP_O2_ID_GENERATOR")
    private Long id;
    
    @Column(name = "MEASURING_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date measuringTime;
    
    @Column(name = "PSG_LEVEL")
    private Short psgLevel;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SP_O2_MIN")
    private BigDecimal spO2Min;
    
    @JoinColumn(name = "PSG_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Psg psgId;

    public PsgAttrSpO2() {
    }

    public PsgAttrSpO2(Long id) {
        this.id = id;
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

    public Short getPsgLevel() {
        return psgLevel;
    }

    public void setPsgLevel(Short psgLevel) {
        this.psgLevel = psgLevel;
    }

    public BigDecimal getSpO2Min() {
        return spO2Min;
    }

    public void setSpO2Min(BigDecimal spO2Min) {
        this.spO2Min = spO2Min;
    }

    public Psg getPsgId() {
        return psgId;
    }

    public void setPsgId(Psg psgId) {
        this.psgId = psgId;
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
        if (!(object instanceof PsgAttrSpO2)) {
            return false;
        }
        PsgAttrSpO2 other = (PsgAttrSpO2) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdl.PsgAttrSpO2[ id=" + id + " ]";
    }
    
}
