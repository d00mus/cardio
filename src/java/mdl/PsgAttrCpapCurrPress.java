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
@Table(name = "PSG_ATTR_CPAP_CURR_PRESS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsgAttrCpapCurrPress.findAll", query = "SELECT p FROM PsgAttrCpapCurrPress p"),
    @NamedQuery(name = "PsgAttrCpapCurrPress.findById", query = "SELECT p FROM PsgAttrCpapCurrPress p WHERE p.id = :id"),
    @NamedQuery(name = "PsgAttrCpapCurrPress.findByMeasuringTime", query = "SELECT p FROM PsgAttrCpapCurrPress p WHERE p.measuringTime = :measuringTime"),
    @NamedQuery(name = "PsgAttrCpapCurrPress.findByVal1", query = "SELECT p FROM PsgAttrCpapCurrPress p WHERE p.val1 = :val1"),
    @NamedQuery(name = "PsgAttrCpapCurrPress.findByVal2", query = "SELECT p FROM PsgAttrCpapCurrPress p WHERE p.val2 = :val2"),
    @NamedQuery(name = "PsgAttrCpapCurrPress.findByVal3", query = "SELECT p FROM PsgAttrCpapCurrPress p WHERE p.val3 = :val3"),
    @NamedQuery(name = "PsgAttrCpapCurrPress.findByVal4", query = "SELECT p FROM PsgAttrCpapCurrPress p WHERE p.val4 = :val4"),
    @NamedQuery(name = "PsgAttrCpapCurrPress.findByPsg", query = "SELECT p FROM PsgAttrCpapCurrPress p WHERE p.psg = :psg")})
public class PsgAttrCpapCurrPress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @SequenceGenerator(name="PSG_ATTR_CPAP_CURR_PRESS_ID_GENERATOR", sequenceName="PSG_ATTR_CPAP_CURR_PRESS_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PSG_ATTR_CPAP_CURR_PRESS_ID_GENERATOR")
    
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEASURING_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date measuringTime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Column(name = "VAL1")
    private BigDecimal val1;
    
    @Column(name = "VAL2")
    private BigDecimal val2;
    
    @Column(name = "VAL3")
    private BigDecimal val3;
    
    @Column(name = "VAL4")
    private BigDecimal val4;
    
    @JoinColumn(name = "PSG_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    @NotNull
    private Psg psg;

    public PsgAttrCpapCurrPress() {
    }

    public PsgAttrCpapCurrPress(Long id) {
        this.id = id;
    }

    public PsgAttrCpapCurrPress(Long id, Date measuringTime) {
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

    public BigDecimal getVal1() {
        return val1;
    }

    public void setVal1(BigDecimal val1) {
        this.val1 = val1;
    }

    public BigDecimal getVal2() {
        return val2;
    }

    public void setVal2(BigDecimal val2) {
        this.val2 = val2;
    }

    public BigDecimal getVal3() {
        return val3;
    }

    public void setVal3(BigDecimal val3) {
        this.val3 = val3;
    }

    public BigDecimal getVal4() {
        return val4;
    }

    public void setVal4(BigDecimal val4) {
        this.val4 = val4;
    }

    public Psg getPsg() {
        return psg;
    }

    public void setPsg(Psg psgId) {
        this.psg = psgId;
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
        if (!(object instanceof PsgAttrCpapCurrPress)) {
            return false;
        }
        PsgAttrCpapCurrPress other = (PsgAttrCpapCurrPress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdl.PsgAttrCpapCurrPress[ id=" + id + " ]";
    }
    
}
