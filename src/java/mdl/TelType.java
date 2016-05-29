/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "TEL_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TelType.findAll", query = "SELECT t FROM TelType t"),
    @NamedQuery(name = "TelType.findById", query = "SELECT t FROM TelType t WHERE t.id = :id"),
    @NamedQuery(name = "TelType.findByTypeCode", query = "SELECT t FROM TelType t WHERE t.typeCode = :typeCode"),
    @NamedQuery(name = "TelType.findByTypeName", query = "SELECT t FROM TelType t WHERE t.typeName = :typeName"),
    @NamedQuery(name = "TelType.findByIsMobile", query = "SELECT t FROM TelType t WHERE t.isMobile = :isMobile"),
    @NamedQuery(name = "TelType.findByIsPersonal", query = "SELECT t FROM TelType t WHERE t.isPersonal = :isPersonal"),
    @NamedQuery(name = "TelType.findByIsWork", query = "SELECT t FROM TelType t WHERE t.isWork = :isWork"),
    @NamedQuery(name = "TelType.findByIsFax", query = "SELECT t FROM TelType t WHERE t.isFax = :isFax"),
    @NamedQuery(name = "TelType.findByIsUa", query = "SELECT t FROM TelType t WHERE t.isUa = :isUa"),
    @NamedQuery(name = "TelType.findByRegexp", query = "SELECT t FROM TelType t WHERE t.regexp = :regexp"),
    @NamedQuery(name = "TelType.findByFormatNotes", query = "SELECT t FROM TelType t WHERE t.formatNotes = :formatNotes")})
public class TelType implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="TEL_TYPE_ID_GENERATOR", sequenceName="TEL_TYPE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEL_TYPE_ID_GENERATOR")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "TYPE_CODE")
    private String typeCode;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TYPE_NAME")
    private String typeName;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_MOBILE")
    private char isMobile;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_PERSONAL")
    private char isPersonal;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_WORK")
    private char isWork;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_FAX")
    private char isFax;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_UA")
    private char isUa;
    
    @Size(max = 2000)
    private String regexp;
    
    @Size(max = 2000)
    @Column(name = "FORMAT_NOTES")
    private String formatNotes;
    
    @OneToMany(mappedBy = "telTypeId", fetch = FetchType.EAGER)
    private List<PatientPhone> patientPhoneList;

    public TelType() {
    }

    public TelType(Long id) {
        this.id = id;
    }

    public TelType(Long id, String typeCode, String typeName, char isMobile, char isPersonal, char isWork, char isFax, char isUa) {
        this.id = id;
        this.typeCode = typeCode;
        this.typeName = typeName;
        this.isMobile = isMobile;
        this.isPersonal = isPersonal;
        this.isWork = isWork;
        this.isFax = isFax;
        this.isUa = isUa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public char getIsMobile() {
        return isMobile;
    }

    public void setIsMobile(char isMobile) {
        this.isMobile = isMobile;
    }

    public char getIsPersonal() {
        return isPersonal;
    }

    public void setIsPersonal(char isPersonal) {
        this.isPersonal = isPersonal;
    }

    public char getIsWork() {
        return isWork;
    }

    public void setIsWork(char isWork) {
        this.isWork = isWork;
    }

    public char getIsFax() {
        return isFax;
    }

    public void setIsFax(char isFax) {
        this.isFax = isFax;
    }

    public char getIsUa() {
        return isUa;
    }

    public void setIsUa(char isUa) {
        this.isUa = isUa;
    }

    public String getRegexp() {
        return regexp;
    }

    public void setRegexp(String regexp) {
        this.regexp = regexp;
    }

    public String getFormatNotes() {
        return formatNotes;
    }

    public void setFormatNotes(String formatNotes) {
        this.formatNotes = formatNotes;
    }

    @XmlTransient
    @JsonIgnore
    public List<PatientPhone> getPatientPhoneList() {
        return patientPhoneList;
    }

    public void setPatientPhoneList(List<PatientPhone> patientPhoneList) {
        this.patientPhoneList = patientPhoneList;
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
        if (!(object instanceof TelType)) {
            return false;
        }
        TelType other = (TelType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return typeName;
    }
    
}
