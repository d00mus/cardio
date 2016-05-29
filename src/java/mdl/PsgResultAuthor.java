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
import javax.persistence.Column;
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
@Table(name = "PSG_RESULT_AUTHOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsgResultAuthor.findAll", query = "SELECT p FROM PsgResultAuthor p"),
    @NamedQuery(name = "PsgResultAuthor.findById", query = "SELECT p FROM PsgResultAuthor p WHERE p.id = :id"),
    @NamedQuery(name = "PsgResultAuthor.findByName", query = "SELECT p FROM PsgResultAuthor p WHERE p.name = :name"),
    @NamedQuery(name = "PsgResultAuthor.findByShortName", query = "SELECT p FROM PsgResultAuthor p WHERE p.shortName = :shortName")})
public class PsgResultAuthor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @SequenceGenerator(name="PSG_RESULT_AUTHOR_ID_GENERATOR", sequenceName="PSG_RESULT_AUTHOR_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PSG_RESULT_AUTHOR_ID_GENERATOR")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "SHORT_NAME")
    private String shortName;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", fetch = FetchType.EAGER)
    private List<PsgResult> psgResultList;

    public PsgResultAuthor() {
    }

    public PsgResultAuthor(Integer id) {
        this.id = id;
    }

    public PsgResultAuthor(Integer id, String name, String shortName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @XmlTransient
    @JsonIgnore
    public List<PsgResult> getPsgResultList() {
        return psgResultList;
    }

    public void setPsgResultList(List<PsgResult> psgResultList) {
        this.psgResultList = psgResultList;
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
        if (!(object instanceof PsgResultAuthor)) {
            return false;
        }
        PsgResultAuthor other = (PsgResultAuthor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return shortName;
    }
    
}
