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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author d00mus
 */
@Entity
@Table(name = "PSG_ATTR_CPAP_BALANCE_PRM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsgAttrCpapBalancePrm.findAll", query = "SELECT p FROM PsgAttrCpapBalancePrm p"),
    @NamedQuery(name = "PsgAttrCpapBalancePrm.findById", query = "SELECT p FROM PsgAttrCpapBalancePrm p WHERE p.id = :id"),
    @NamedQuery(name = "PsgAttrCpapBalancePrm.findByMeasuringTime", query = "SELECT p FROM PsgAttrCpapBalancePrm p WHERE p.measuringTime = :measuringTime"),
    @NamedQuery(name = "PsgAttrCpapBalancePrm.findByPrUpperTreshold", query = "SELECT p FROM PsgAttrCpapBalancePrm p WHERE p.prUpperTreshold = :prUpperTreshold"),
    @NamedQuery(name = "PsgAttrCpapBalancePrm.findByPrLowerTreshold", query = "SELECT p FROM PsgAttrCpapBalancePrm p WHERE p.prLowerTreshold = :prLowerTreshold"),
    @NamedQuery(name = "PsgAttrCpapBalancePrm.findBySoftPapFunction", query = "SELECT p FROM PsgAttrCpapBalancePrm p WHERE p.softPapFunction = :softPapFunction"),
    @NamedQuery(name = "PsgAttrCpapBalancePrm.findByPsg", query = "SELECT p FROM PsgAttrCpapBalancePrm p WHERE p.psg = :psg")})
public class PsgAttrCpapBalancePrm implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @SequenceGenerator(name="PSG_ATTR_CPAP_BALANCE_PRM_ID_GENERATOR", sequenceName="PSG_ATTR_CPAP_BALANCE_PRM_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PSG_ATTR_CPAP_BALANCE_PRM_ID_GENERATOR")
    
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEASURING_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date measuringTime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PR_UPPER_TRESHOLD")
    private BigDecimal prUpperTreshold;
    
    @Column(name = "PR_LOWER_TRESHOLD")
    private BigDecimal prLowerTreshold;
    
    @Size(max = 16)
    @Column(name = "SOFT_PAP_FUNCTION")
    
    private String softPapFunction;
    
    @JoinColumn(name = "PSG_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    @NotNull
    private Psg psg;

    public PsgAttrCpapBalancePrm() {
    }

    public PsgAttrCpapBalancePrm(Long id) {
        this.id = id;
    }

    public PsgAttrCpapBalancePrm(Long id, Date measuringTime) {
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

    public BigDecimal getPrUpperTreshold() {
        return prUpperTreshold;
    }

    public void setPrUpperTreshold(BigDecimal prUpperTreshold) {
        this.prUpperTreshold = prUpperTreshold;
    }

    public BigDecimal getPrLowerTreshold() {
        return prLowerTreshold;
    }

    public void setPrLowerTreshold(BigDecimal prLowerTreshold) {
        this.prLowerTreshold = prLowerTreshold;
    }

    public String getSoftPapFunction() {
        return softPapFunction;
    }

    public void setSoftPapFunction(String softPapFunction) {
        this.softPapFunction = softPapFunction;
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
        if (!(object instanceof PsgAttrCpapBalancePrm)) {
            return false;
        }
        PsgAttrCpapBalancePrm other = (PsgAttrCpapBalancePrm) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdl.PsgAttrCpapBalancePrm[ id=" + id + " ]";
    }
    
}
