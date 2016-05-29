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
import javax.persistence.FetchType;
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
@Table(name = "PSG_ATTR_DETECTOR_TUNE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsgAttrDetectorTune.findAll", query = "SELECT p FROM PsgAttrDetectorTune p"),
    @NamedQuery(name = "PsgAttrDetectorTune.findById", query = "SELECT p FROM PsgAttrDetectorTune p WHERE p.id = :id"),
    @NamedQuery(name = "PsgAttrDetectorTune.findByMeasuringTime", query = "SELECT p FROM PsgAttrDetectorTune p WHERE p.measuringTime = :measuringTime"),
    @NamedQuery(name = "PsgAttrDetectorTune.findByPsgId", query = "SELECT p FROM PsgAttrDetectorTune p WHERE p.psgId = :psgId")})
public class PsgAttrDetectorTune implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="PSG_ATTR_DETECTOR_TUNE_ID_GENERATOR", sequenceName="PSG_ATTR_DETECTOR_TUNE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PSG_ATTR_DETECTOR_TUNE_ID_GENERATOR")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEASURING_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date measuringTime;
    
    @JoinColumn(name = "PSG_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Psg psgId;
    
    @JoinColumn(name = "DETECTOR_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PsgAttrDetector detectorId;

    public PsgAttrDetectorTune() {
    }

    public PsgAttrDetectorTune(Long id) {
        this.id = id;
    }

    public PsgAttrDetectorTune(Long id, Date measuringTime, Psg psgId) {
        this.id = id;
        this.measuringTime = measuringTime;
        this.psgId = psgId;
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

    public PsgAttrDetector getDetectorId() {
        return detectorId;
    }

    public void setDetectorId(PsgAttrDetector detectorId) {
        this.detectorId = detectorId;
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
        if (!(object instanceof PsgAttrDetectorTune)) {
            return false;
        }
        PsgAttrDetectorTune other = (PsgAttrDetectorTune) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdl.PsgAttrDetectorTune[ id=" + id + " ]";
    }
    
}
