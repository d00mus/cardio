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
@Table(name = "PSG_ATTR_PULLS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsgAttrPulls.findAll", query = "SELECT p FROM PsgAttrPulls p"),
    @NamedQuery(name = "PsgAttrPulls.findById", query = "SELECT p FROM PsgAttrPulls p WHERE p.id = :id"),
    @NamedQuery(name = "PsgAttrPulls.findByMeasuringTime", query = "SELECT p FROM PsgAttrPulls p WHERE p.measuringTime = :measuringTime"),
    @NamedQuery(name = "PsgAttrPulls.findByPsgLevel", query = "SELECT p FROM PsgAttrPulls p WHERE p.psgLevel = :psgLevel"),
    @NamedQuery(name = "PsgAttrPulls.findByHitsPerMin", query = "SELECT p FROM PsgAttrPulls p WHERE p.hitsPerMin = :hitsPerMin"),
    @NamedQuery(name = "PsgAttrPulls.findByHand", query = "SELECT p FROM PsgAttrPulls p WHERE p.hand = :hand")})
public class PsgAttrPulls implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @SequenceGenerator(name="PSG_ATTR_PULLS_ID_GENERATOR", sequenceName="PSG_ATTR_PULLS_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PSG_ATTR_PULLS_ID_GENERATOR")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEASURING_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date measuringTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PSG_LEVEL")
    private short psgLevel;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "HITS_PER_MIN")
    private int hitsPerMin;
    @Column(name = "HAND")
    private Character hand;
    @JoinColumn(name = "PSG_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Psg psgId;

    public PsgAttrPulls() {
     this.hitsPerMin = 60;
     this.measuringTime = new Date();
    }

    public PsgAttrPulls(Long id) {
        this.id = id;
    }

    public PsgAttrPulls(Long id, Date measuringTime, short psgLevel, int hitsPerMin) {
        this.id = id;
        this.measuringTime = measuringTime;
        this.psgLevel = psgLevel;
        this.hitsPerMin = hitsPerMin;
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

    public short getPsgLevel() {
        return psgLevel;
    }

    public void setPsgLevel(short psgLevel) {
        this.psgLevel = psgLevel;
    }

    public int getHitsPerMin() {
        return hitsPerMin;
    }

    public void setHitsPerMin(int hitsPerMin) {
        this.hitsPerMin = hitsPerMin;
    }

    public Character getHand() {
        return hand;
    }

    public void setHand(Character hand) {
        this.hand = hand;
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
        if (!(object instanceof PsgAttrPulls)) {
            return false;
        }
        PsgAttrPulls other = (PsgAttrPulls) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdl.PsgAttrPulls[ id=" + id + " ]";
    }
    
}
