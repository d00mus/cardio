/*
 * To change this template, choose Tools | Templates
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
@Table(name = "PSG_ATTR_SNORING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsgAttrSnoring.findAll", query = "SELECT p FROM PsgAttrSnoring p"),
    @NamedQuery(name = "PsgAttrSnoring.findById", query = "SELECT p FROM PsgAttrSnoring p WHERE p.id = :id"),
    @NamedQuery(name = "PsgAttrSnoring.findByPsgLevel", query = "SELECT p FROM PsgAttrSnoring p WHERE p.psgLevel = :psgLevel"),
    @NamedQuery(name = "PsgAttrSnoring.findByBeginTime", query = "SELECT p FROM PsgAttrSnoring p WHERE p.beginTime = :beginTime"),
    @NamedQuery(name = "PsgAttrSnoring.findByEndTime", query = "SELECT p FROM PsgAttrSnoring p WHERE p.endTime = :endTime")})
public class PsgAttrSnoring implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @SequenceGenerator(name="PSG_ATTR_SNORING_ID_GENERATOR", sequenceName="PSG_ATTR_SNORING_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PSG_ATTR_SNORING_ID_GENERATOR")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PSG_LEVEL")
    private short psgLevel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BEGIN_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date beginTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "END_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @JoinColumn(name = "PSG_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Psg psgId;

    public PsgAttrSnoring() {
    }

    public PsgAttrSnoring(Long id) {
        this.id = id;
    }

    public PsgAttrSnoring(Long id, short psgLevel, Date beginTime, Date endTime) {
        this.id = id;
        this.psgLevel = psgLevel;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public short getPsgLevel() {
        return psgLevel;
    }

    public void setPsgLevel(short psgLevel) {
        this.psgLevel = psgLevel;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
        if (!(object instanceof PsgAttrSnoring)) {
            return false;
        }
        PsgAttrSnoring other = (PsgAttrSnoring) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdl.PsgAttrSnoring[ id=" + id + " ]";
    }
    
}
