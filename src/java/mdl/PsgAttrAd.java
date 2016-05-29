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
@Table(name = "PSG_ATTR_AD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsgAttrAd.findAll", query = "SELECT p FROM PsgAttrAd p"),
    @NamedQuery(name = "PsgAttrAd.findById", query = "SELECT p FROM PsgAttrAd p WHERE p.id = :id"),
    @NamedQuery(name = "PsgAttrAd.findByMeasuringTime", query = "SELECT p FROM PsgAttrAd p WHERE p.measuringTime = :measuringTime"),
    @NamedQuery(name = "PsgAttrAd.findBySystolPressue", query = "SELECT p FROM PsgAttrAd p WHERE p.systolPressue = :systolPressue"),
    @NamedQuery(name = "PsgAttrAd.findByDiastolPressue", query = "SELECT p FROM PsgAttrAd p WHERE p.diastolPressue = :diastolPressue"),
    @NamedQuery(name = "PsgAttrAd.findByHand", query = "SELECT p FROM PsgAttrAd p WHERE p.hand = :hand")})
public class PsgAttrAd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @SequenceGenerator(name="PSG_ATTR_AD_ID_GENERATOR", sequenceName="PSG_ATTR_AD_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PSG_ATTR_AD_ID_GENERATOR")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEASURING_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date measuringTime;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "SYSTOL_PRESSUE")
    private short systolPressue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIASTOL_PRESSUE")
    private short diastolPressue;
    @Column(name = "HAND")
    private Character hand;
    
    @JoinColumn(name = "PSG_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Psg psgId;

    public PsgAttrAd() {
        systolPressue = 120;
        diastolPressue = 70;
        measuringTime = new Date();
    }

    public PsgAttrAd(Long id) {
        this.id = id;
    }

    public PsgAttrAd(Long id, Date measuringTime, short systolPressue, short diastolPressue) {
        this.id = id;
        this.measuringTime = measuringTime;
        this.systolPressue = systolPressue;
        this.diastolPressue = diastolPressue;
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


    public short getSystolPressue() {
        return systolPressue;
    }

    public void setSystolPressue(short systolPressue) {
        this.systolPressue = systolPressue;
    }

    public short getDiastolPressue() {
        return diastolPressue;
    }

    public void setDiastolPressue(short diastolPressue) {
        this.diastolPressue = diastolPressue;
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
        if (!(object instanceof PsgAttrAd)) {
            return false;
        }
        PsgAttrAd other = (PsgAttrAd) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdl.PsgAttrAd[ id=" + id + " ]";
    }
    
}
