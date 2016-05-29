/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author d00mus
 */
@Entity
@Table(name = "PSG_ATTR_DETECTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsgAttrDetector.findAll", query = "SELECT p FROM PsgAttrDetector p"),
    @NamedQuery(name = "PsgAttrDetector.findById", query = "SELECT p FROM PsgAttrDetector p WHERE p.id = :id"),
    @NamedQuery(name = "PsgAttrDetector.findByCode", query = "SELECT p FROM PsgAttrDetector p WHERE p.code = :code"),
    @NamedQuery(name = "PsgAttrDetector.findByName", query = "SELECT p FROM PsgAttrDetector p WHERE p.name = :name")})
public class PsgAttrDetector implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="PSG_ATTR_DETECTOR_ID_GENERATOR", sequenceName="PSG_ATTR_DETECTOR_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PSG_ATTR_DETECTOR_ID_GENERATOR")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    private String code;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    private String name;
    
    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detectorId", fetch = FetchType.EAGER)
    private List<PsgAttrDetectorTune> psgAttrDetectorTuneList;
*/
    public PsgAttrDetector() {
    }

    public PsgAttrDetector(Integer id) {
        this.id = id;
    }

    public PsgAttrDetector(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
    @XmlTransient
    @JsonIgnore
    public List<PsgAttrDetectorTune> getPsgAttrDetectorTuneList() {
        return psgAttrDetectorTuneList;
    }

    public void setPsgAttrDetectorTuneList(List<PsgAttrDetectorTune> psgAttrDetectorTuneList) {
        this.psgAttrDetectorTuneList = psgAttrDetectorTuneList;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsgAttrDetector)) {
            return false;
        }
        PsgAttrDetector other = (PsgAttrDetector) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
