package mdl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
//import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author d00mus
 */
@Entity
@Table(name = "CARDIO_USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CardioUser.findAll", query = "SELECT c FROM CardioUser c"),
    @NamedQuery(name = "CardioUser.findById", query = "SELECT c FROM CardioUser c WHERE c.id = :id"),
    @NamedQuery(name = "CardioUser.findByUserName", query = "SELECT c FROM CardioUser c WHERE c.userName = :userName"),
    @NamedQuery(name = "CardioUser.findByPassword", query = "SELECT c FROM CardioUser c WHERE c.password = :password"),
    @NamedQuery(name = "CardioUser.findByShortName", query = "SELECT c FROM CardioUser c WHERE c.shortName = :shortName")})
public class CardioUser implements Serializable {
    //имя
    @Size(max = 255)
    @Column(name = "FIRST_NAME")
    private String firstName;
    
    //фамилия
    @Size(max = 255)
    @Column(name = "LAST_NAME")
    private String lastName;
    
    //отчество
    @Size(max = 255)
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    
    //дата рождения
    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.DATE)
    private Date birthDate = new Date();
    
    //адрес
    @Size(max = 255)
    @Column(name = "ADDRESS")
    private String address;
    
    @Size(max = 255)
    @Column(name = "WORK_EMAIL")
    private String workEmail;
    
    @Size(max = 255)
    @Column(name = "PERSONAL_EMAIL")
    private String personalEmail;
    
    @Column(name = "IS_OUTSIDE_EMPL")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isOutsideEmpl = DbBoolEnum.F;
    
    @Size(max = 255)
    @Column(name = "OUTSIDE_WORK_PLACE")
    private String outsideWorkPlace;
    
    @Size(max = 255)
    @Column(name = "OUTSIDE_WORK_SPEC")
    private String outsideWorkSpec;
    
    @Size(max = 8)
    @Column(name = "PASS_SER")
    private String passSer;
    
    @Size(max = 32)
    @Column(name = "PASS_NO")
    private String passNo;
    
    @Column(name = "PASS_GIVEOUT_DATE")
    @Temporal(TemporalType.DATE)
    private Date passGiveoutDate;
    
    @Size(max = 255)
    @Column(name = "PASS_GIVEOUT")
    private String passGiveout;
    
    @Size(max = 32)
    private String inn;
    
    @Column(name = "IS_DRIVER")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isDriver=DbBoolEnum.F;
    
    @Size(max = 32)
    @Column(name = "DRV_LIC_NO")
    private String drvLicNo;
    
    @Size(max = 255)
    private String notes;
    
    @Column(name = "IS_HAVE_AUTO")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isHaveAuto=DbBoolEnum.F;
    
    @Size(max = 255)
    @Column(name = "LIC_AUTO_MODEL")
    private String licAutoModel;
    
    @Size(max = 16)
    @Column(name = "LIC_AUTO_NO")
    private String licAutoNo;
    
    @Size(max = 255)
    @Column(name = "FAM_MBR_NAME")
    private String famMbrName;
    
    @JoinColumn(name = "FAM_MBR_PHONE_ID", referencedColumnName = "ID")
    @OneToOne(fetch = FetchType.EAGER)
    private UserPhone famMbrPhone;
    
    @JoinColumn(name = "ADR_TOWN_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private UaTown adrTown;

    
    @JoinColumn(name = "THEME_NAME", referencedColumnName = "THEME_NAME")
    @ManyToOne(fetch = FetchType.EAGER)
    private PfTheme theme;
    
    
    @JoinColumn(name = "ADR_STATE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private UaState adrState;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user",orphanRemoval = true)
    private List<UserEducation> userEducaionList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user",orphanRemoval = true)
    private List<UserPhone> userPhoneList;
    
    @JoinColumn(name = "AVATAR_FILE_ID", referencedColumnName = "ID")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private UserFiles avatarFile;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user",orphanRemoval = true)
    private List<UserOccupation> userOccupationList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user",orphanRemoval = true)
    private List<UserFiles> userFilesList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user",orphanRemoval = true)
    private List<CardioProject> userProjectList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user",orphanRemoval = true)
    private List<Task> userTaskList;
    
    //список сотрудников, с кем есть связь по полю 1
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manager")
    private List<PartnerEmploye> partnerEmployeList;
    

    //список сотрудников, с кем есть связь по полю 2
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manager2")
    private List<PartnerEmploye> partnerEmployeList2;
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic
//   @Basic(optional = false)
//    @NotNull
    @SequenceGenerator(name="CARDIO_USER_ID_GENERATOR", sequenceName="CARDIO_USER_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CARDIO_USER_ID_GENERATOR")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "USER_NAME")
    private String userName;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    private String password;
    
    @Size(max = 255)
    @Column(name = "SHORT_NAME")
    private String shortName;

    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<CardioUserRoles> cardioUserRolesList;
    */
    @OneToMany
    @JoinTable(name = "CARDIO_USER_ROLES"
              ,joinColumns = {@JoinColumn(name="USER_ID")}
              ,inverseJoinColumns = {@JoinColumn(name="ROLE_ID")})
    
    private List<CardioRole> roleList;
    /*
    @OneToMany(mappedBy = "nurseId")
    private List<PatientCall> patientCalls;
*/
    public CardioUser() {
    }

    public CardioUser(Long id) {
        this.id = id;
    }

    public CardioUser(Long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        StringBuilder sb = new StringBuilder();
        
        if(lastName!=null)sb.append(lastName.trim()).append(" ");
        if(firstName!=null)sb.append(firstName.trim()).append(" ");
        if(middleName!=null)sb.append(middleName.trim()).append(" ");
        
        return sb.toString().trim();
    }

    public PfTheme getTheme() {
        return theme;
    }
  
    public void setTheme(PfTheme theme) {
        this.theme = theme;
    }
    
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @XmlTransient
    public List<CardioRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<CardioRole> roleList) {
        this.roleList = roleList;
    }

    public List<CardioProject> getUserProjectList() {
        return userProjectList;
    }

    public void setUserProjectList(List<CardioProject> userProjectList) {
        this.userProjectList = userProjectList;
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
        if (!(object instanceof CardioUser)) {
            return false;
        }
        CardioUser other = (CardioUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        
        String result=lastName;
        //получить первую букву имени, если оно есть
        if(firstName!=null && !firstName.trim().isEmpty()){
         String name1=firstName.trim().substring(0, 1).toUpperCase();
            result=result+" "+name1+".";
            
            //получить первую букву отчества, если оно есть
            if(middleName!=null && !middleName.trim().isEmpty()){
             String patr1=middleName.trim().substring(0, 1).toUpperCase();
              result=result+patr1;
            }
        }
        return result;   
    }


    public CardioUser(Long id, String password) {
        this.id = id;
        this.password = password;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public boolean getIsOutsideEmpl() {
        return isOutsideEmpl.getAsBool();
    }

    public void setIsOutsideEmpl(boolean isOutsideEmpl) {
        this.isOutsideEmpl = DbBoolEnum.valueOf(isOutsideEmpl);
    }

    public String getOutsideWorkPlace() {
        return outsideWorkPlace;
    }

    public void setOutsideWorkPlace(String outsideWorkPlace) {
        this.outsideWorkPlace = outsideWorkPlace;
    }

    public String getOutsideWorkSpec() {
        return outsideWorkSpec;
    }

    public void setOutsideWorkSpec(String outsideWorkSpec) {
        this.outsideWorkSpec = outsideWorkSpec;
    }

    public String getPassSer() {
        return passSer;
    }

    public void setPassSer(String passSer) {
        this.passSer = passSer;
    }

    public String getPassNo() {
        return passNo;
    }

    public void setPassNo(String passNo) {
        this.passNo = passNo;
    }

    public Date getPassGiveoutDate() {
        return passGiveoutDate;
    }

    public void setPassGiveoutDate(Date passGiveoutDate) {
        this.passGiveoutDate = passGiveoutDate;
    }

    public String getPassGiveout() {
        return passGiveout;
    }

    public void setPassGiveout(String passGiveout) {
        this.passGiveout = passGiveout;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public boolean getIsDriver() {
        return isDriver.getAsBool();
    }

    public void setIsDriver(boolean isDriver) {
        this.isDriver = DbBoolEnum.valueOf(isDriver);
    }

    public String getDrvLicNo() {
        return drvLicNo;
    }

    public void setDrvLicNo(String drvLicNo) {
        this.drvLicNo = drvLicNo;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean  getIsHaveAuto() {
        return isHaveAuto.getAsBool();
    }

    public void setIsHaveAuto(boolean isHaveAuto) {
        this.isHaveAuto = DbBoolEnum.valueOf(isHaveAuto);
    }

    public String getLicAutoModel() {
        return licAutoModel;
    }

    public void setLicAutoModel(String licAutoModel) {
        this.licAutoModel = licAutoModel;
    }

    public String getLicAutoNo() {
        return licAutoNo;
    }

    public void setLicAutoNo(String licAutoNo) {
        this.licAutoNo = licAutoNo;
    }

    public String getFamMbrName() {
        return famMbrName;
    }

    public void setFamMbrName(String famMbrName) {
        this.famMbrName = famMbrName;
    }

    public UserPhone getFamMbrPhone() {
        return famMbrPhone;
    }

    public void setFamMbrPhone(UserPhone famMbrPhone) {
        this.famMbrPhone = famMbrPhone;
    }

    public UaTown getAdrTown() {
        return adrTown;
    }

    public void setAdrTown(UaTown adrTown) {
        this.adrTown = adrTown;
    }

    public UaState getAdrState() {
        return adrState;
    }

    public void setAdrState(UaState adrState) {
        this.adrState = adrState;
    }

    public List<Task> getUserTaskList() {
        return userTaskList;
    }

    public void setUserTaskList(List<Task> userTaskList) {
        this.userTaskList = userTaskList;
    }

    
    
    
    @XmlTransient
//    @JsonIgnore
    public List<UserEducation> getUserEducaionList() {
        return userEducaionList;
    }

    public void setUserEducaionList(List<UserEducation> userEducaionList) {
        this.userEducaionList = userEducaionList;
    }

    @XmlTransient
   // @JsonIgnore
    public List<UserPhone> getUserPhoneList() {
        return userPhoneList;
    }

    public List<PartnerEmploye> getPartnerEmployeList() {
        return partnerEmployeList;
    }

    public void setPartnerEmployeList(List<PartnerEmploye> partnerEmployeList) {
        this.partnerEmployeList = partnerEmployeList;
    }

    public List<PartnerEmploye> getPartnerEmployeList2() {
        return partnerEmployeList2;
    }

    public void setPartnerEmployeList2(List<PartnerEmploye> partnerEmployeList2) {
        this.partnerEmployeList2 = partnerEmployeList2;
    }

   
    
    public void setUserPhoneList(List<UserPhone> userPhoneList) {
        this.userPhoneList = userPhoneList;
    }

    public UserFiles getAvatarFile() {
        return avatarFile;
    }

    public void setAvatarFile(UserFiles avatarFile) {
        this.avatarFile = avatarFile;
    }

    @XmlTransient
    //@JsonIgnore
    public List<UserOccupation> getUserOccupationList() {
        return userOccupationList;
    }

    public void setUserOccupationList(List<UserOccupation> userOccupationList) {
        this.userOccupationList = userOccupationList;
    }

    @XmlTransient
    //@JsonIgnore
    public List<UserFiles> getUserFilesList() {
        return userFilesList;
    }

    public void setUserFilesList(List<UserFiles> userFilesList) {
        this.userFilesList = userFilesList;
    }
 
    
}
