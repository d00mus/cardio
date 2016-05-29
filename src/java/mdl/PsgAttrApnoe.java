/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdl;

import java.io.Serializable;
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
@Table(name = "PSG_ATTR_APNOE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsgAttrApnoe.findAll", query = "SELECT p FROM PsgAttrApnoe p"),
    @NamedQuery(name = "PsgAttrApnoe.findById", query = "SELECT p FROM PsgAttrApnoe p WHERE p.id = :id"),
    @NamedQuery(name = "PsgAttrApnoe.findByBeginTime", query = "SELECT p FROM PsgAttrApnoe p WHERE p.beginTime = :beginTime"),
    @NamedQuery(name = "PsgAttrApnoe.findByDurationSec", query = "SELECT p FROM PsgAttrApnoe p WHERE p.durationSec = :durationSec"),
    @NamedQuery(name = "PsgAttrApnoe.findByPsgId", query = "SELECT p FROM PsgAttrApnoe p WHERE p.psgId = :psgId")})
public class PsgAttrApnoe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="PSG_ATTR_APNOE_ID_GENERATOR", sequenceName="PSG_ATTR_APNOE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PSG_ATTR_APNOE_ID_GENERATOR")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "BEGIN_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date beginTime;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DURATION_SEC")
    private short durationSec;
    
    @JoinColumn(name = "PSG_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Psg psgId;
    
    @JoinColumn(name = "APNOE_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne
    private PsgAttrApnoeType apnoeTypeId;

    public PsgAttrApnoe() {
    }

    public PsgAttrApnoe(Long id) {
        this.id = id;
    }

    public PsgAttrApnoe(Long id, Date beginTime, short durationSec, Psg psgId) {
        this.id = id;
        this.beginTime = beginTime;
        this.durationSec = durationSec;
        this.psgId = psgId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public short getDurationSec() {
        return durationSec;
    }

    public void setDurationSec(short durationSec) {
        this.durationSec = durationSec;
    }

    public Psg getPsgId() {
        return psgId;
    }

    public void setPsgId(Psg psgId) {
        this.psgId = psgId;
    }

    public PsgAttrApnoeType getApnoeTypeId() {
        return apnoeTypeId;
    }

    public void setApnoeTypeId(PsgAttrApnoeType apnoeTypeId) {
        this.apnoeTypeId = apnoeTypeId;
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
        if (!(object instanceof PsgAttrApnoe)) {
            return false;
        }
        PsgAttrApnoe other = (PsgAttrApnoe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdl.PsgAttrApnoe[ id=" + id + " ]";
    }
    
}
