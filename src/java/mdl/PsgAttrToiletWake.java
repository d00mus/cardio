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
@Table(name = "PSG_ATTR_TOILET_WAKE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsgAttrToiletWake.findAll", query = "SELECT p FROM PsgAttrToiletWake p"),
    @NamedQuery(name = "PsgAttrToiletWake.findById", query = "SELECT p FROM PsgAttrToiletWake p WHERE p.id = :id"),
    @NamedQuery(name = "PsgAttrToiletWake.findByMeasuringTime", query = "SELECT p FROM PsgAttrToiletWake p WHERE p.measuringTime = :measuringTime")})
public class PsgAttrToiletWake implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @SequenceGenerator(name="PSG_ATTR_TOILET_WAKE_ID_GENERATOR", sequenceName="PSG_ATTR_TOILET_WAKE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PSG_ATTR_TOILET_WAKE_ID_GENERATOR")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEASURING_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date measuringTime;
    @JoinColumn(name = "PSG_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Psg psgId;

    public PsgAttrToiletWake() {
    }

    public PsgAttrToiletWake(Long id) {
        this.id = id;
    }

    public PsgAttrToiletWake(Long id, Date measuringTime) {
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
        if (!(object instanceof PsgAttrToiletWake)) {
            return false;
        }
        PsgAttrToiletWake other = (PsgAttrToiletWake) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdl.PsgAttrToiletWake[ id=" + id + " ]";
    }
    
}
