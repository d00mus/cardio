/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
    @NamedQuery(name = "Patient.findById", query = "SELECT p FROM Patient p WHERE p.id = :id"),
    @NamedQuery(name = "Patient.findByName", query = "SELECT p FROM Patient p WHERE p.name = :name"),
    @NamedQuery(name = "Patient.findByFirstName", query = "SELECT p FROM Patient p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "Patient.findBySecondName", query = "SELECT p FROM Patient p WHERE p.secondName = :secondName"),
    @NamedQuery(name = "Patient.findByPseudoName", query = "SELECT p FROM Patient p WHERE p.pseudoName = :pseudoName"),
    @NamedQuery(name = "Patient.findBySex", query = "SELECT p FROM Patient p WHERE p.sex = :sex"),
    @NamedQuery(name = "Patient.findByBirthDate", query = "SELECT p FROM Patient p WHERE p.birthDate = :birthDate"),
    @NamedQuery(name = "Patient.findByAdrCountry", query = "SELECT p FROM Patient p WHERE p.adrCountry = :adrCountry"),
    @NamedQuery(name = "Patient.findByAdrCity", query = "SELECT p FROM Patient p WHERE p.adrCity = :adrCity"),
    @NamedQuery(name = "Patient.findByAdrStreet", query = "SELECT p FROM Patient p WHERE p.adrStreet = :adrStreet"),
    @NamedQuery(name = "Patient.findByAdrHouse", query = "SELECT p FROM Patient p WHERE p.adrHouse = :adrHouse"),
    @NamedQuery(name = "Patient.findByAdrFlat", query = "SELECT p FROM Patient p WHERE p.adrFlat = :adrFlat"),
    @NamedQuery(name = "Patient.findByCurHeight", query = "SELECT p FROM Patient p WHERE p.curHeight = :curHeight"),
    @NamedQuery(name = "Patient.findByCurWeight", query = "SELECT p FROM Patient p WHERE p.curWeight = :curWeight"),
    @NamedQuery(name = "Patient.findByPassSer", query = "SELECT p FROM Patient p WHERE p.passSer = :passSer"),
    @NamedQuery(name = "Patient.findByPassNo", query = "SELECT p FROM Patient p WHERE p.passNo = :passNo"),
    @NamedQuery(name = "Patient.findByPassDate", query = "SELECT p FROM Patient p WHERE p.passDate = :passDate"),
    @NamedQuery(name = "Patient.findByPassGivedBy", query = "SELECT p FROM Patient p WHERE p.passGivedBy = :passGivedBy"),
    @NamedQuery(name = "Patient.findByWorkTown", query = "SELECT p FROM Patient p WHERE p.workTown = :workTown"),
    @NamedQuery(name = "Patient.findByWorkPlace", query = "SELECT p FROM Patient p WHERE p.workPlace = :workPlace"),
    @NamedQuery(name = "Patient.findByIsFotoAdsAllowed", query = "SELECT p FROM Patient p WHERE p.isFotoAdsAllowed = :isFotoAdsAllowed"),
    @NamedQuery(name = "Patient.findByIsTvAdsAllowed", query = "SELECT p FROM Patient p WHERE p.isTvAdsAllowed = :isTvAdsAllowed"),
    @NamedQuery(name = "Patient.findByIsOtherAdsAllowed", query = "SELECT p FROM Patient p WHERE p.isOtherAdsAllowed = :isOtherAdsAllowed"),
    @NamedQuery(name = "Patient.findByIsChecked", query = "SELECT p FROM Patient p WHERE p.isChecked = :isChecked"),
    @NamedQuery(name = "Patient.findByIsActive", query = "SELECT p FROM Patient p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "Patient.findByIsInterest", query = "SELECT p FROM Patient p WHERE p.isInterest = :isInterest"),
    @NamedQuery(name = "Patient.findByCreateDate", query = "SELECT p FROM Patient p WHERE p.createDate = :createDate"),
    @NamedQuery(name = "Patient.findByLastPsgDate", query = "SELECT p FROM Patient p WHERE p.lastPsgDate = :lastPsgDate"),
    @NamedQuery(name = "Patient.findByAdrDistrict", query = "SELECT p FROM Patient p WHERE p.adrDistrict = :adrDistrict"),
    @NamedQuery(name = "Patient.findBySelfStory", query = "SELECT p FROM Patient p WHERE p.selfStory = :selfStory"),
    @NamedQuery(name = "Patient.findByNurseNotes", query = "SELECT p FROM Patient p WHERE p.nurseNotes = :nurseNotes"),
    @NamedQuery(name = "Patient.findBySpecialNotes", query = "SELECT p FROM Patient p WHERE p.specialNotes = :specialNotes"),
    @NamedQuery(name = "Patient.findByDocConlusion", query = "SELECT p FROM Patient p WHERE p.docConlusion = :docConlusion"),
    @NamedQuery(name = "Patient.findByRefInfoSrcDetail", query = "SELECT p FROM Patient p WHERE p.refInfoSrcDetail = :refInfoSrcDetail"),
    @NamedQuery(name = "Patient.findByCuredByDoc", query = "SELECT p FROM Patient p WHERE p.curedByDoc = :curedByDoc"),
    @NamedQuery(name = "Patient.findByIsLorInvasion", query = "SELECT p FROM Patient p WHERE p.isLorInvasion = :isLorInvasion"),
    @NamedQuery(name = "Patient.findByLorInvasionDetails", query = "SELECT p FROM Patient p WHERE p.lorInvasionDetails = :lorInvasionDetails"),
    @NamedQuery(name = "Patient.findByIsAllergic", query = "SELECT p FROM Patient p WHERE p.isAllergic = :isAllergic"),
    @NamedQuery(name = "Patient.findByAllergicDetail", query = "SELECT p FROM Patient p WHERE p.allergicDetail = :allergicDetail"),
    @NamedQuery(name = "Patient.findByIsGepatit", query = "SELECT p FROM Patient p WHERE p.isGepatit = :isGepatit"),
    @NamedQuery(name = "Patient.findByIsBotkin", query = "SELECT p FROM Patient p WHERE p.isBotkin = :isBotkin"),
    @NamedQuery(name = "Patient.findByIsCertGiven", query = "SELECT p FROM Patient p WHERE p.isCertGiven = :isCertGiven"),
    @NamedQuery(name = "Patient.findByNextPsgDate", query = "SELECT p FROM Patient p WHERE p.nextPsgDate = :nextPsgDate"),
    @NamedQuery(name = "Patient.findByPartnerName", query = "SELECT p FROM Patient p WHERE p.partnerName = :partnerName"),
    @NamedQuery(name = "Patient.findByFamMemberName", query = "SELECT p FROM Patient p WHERE p.famMemberName = :famMemberName"),
    @NamedQuery(name = "Patient.findByEmailAddrList", query = "SELECT p FROM Patient p WHERE p.emailAddrList = :emailAddrList"),
    @NamedQuery(name = "Patient.findByVipRankId", query = "SELECT p FROM Patient p WHERE p.vipRankId = :vipRankId"),
    @NamedQuery(name = "Patient.findByCreatedByUserId", query = "SELECT p FROM Patient p WHERE p.createdByUserId = :createdByUserId"),
    @NamedQuery(name = "Patient.findByContactsId", query = "SELECT p FROM Patient p WHERE p.contactsId = :contactsId"),
    @NamedQuery(name = "Patient.findByRefRankId", query = "SELECT p FROM Patient p WHERE p.refRankId = :refRankId")})
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="PATIENT_ID_GENERATOR", sequenceName="PATIENT_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PATIENT_ID_GENERATOR")
    private Long id;
    
    @Size(max = 64)
    private String name;
    
    @Size(max = 64)
    @Column(name = "FIRST_NAME")
    private String firstName;
    
    @Size(max = 64)
    @Column(name = "SECOND_NAME")
    private String secondName;
    
    @Size(max = 64)
    @Column(name = "PSEUDO_NAME")
    private String pseudoName;
    
    @Basic(optional = false)
    //@NotNull
    @Enumerated(EnumType.STRING)
    private DbGenderEnum sex=DbGenderEnum.M;
    
    @Basic(optional = true)
    //@NotNull
    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "ADR_COUNTRY")
    private String adrCountry="Украина";
    
    @Size(max = 64)
    @Column(name = "ADR_CITY")
    private String adrCity;
    
    @Size(max = 64)
    @Column(name = "ADR_STREET")
    private String adrStreet;
    
    @Size(max = 8)
    @Column(name = "ADR_HOUSE")
    private String adrHouse;
    
    @Size(max = 8)
    @Column(name = "ADR_FLAT")
    private String adrFlat;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CUR_HEIGHT")
    private BigDecimal curHeight;
    
    @Column(name = "CUR_WEIGHT")
    private BigDecimal curWeight;
    
    @Size(max = 8)
    @Column(name = "PASS_SER")
    private String passSer;
    
    @Size(max = 16)
    @Column(name = "PASS_NO")
    private String passNo;
    
    @Column(name = "PASS_DATE")
    @Temporal(TemporalType.DATE)
    private Date passDate;
    
    @Size(max = 255)
    @Column(name = "PASS_GIVED_BY")
    private String passGivedBy;
    
    @Size(max = 64)
    @Column(name = "WORK_TOWN")
    private String workTown;
    
    @Size(max = 64)
    @Column(name = "WORK_PLACE")
    private String workPlace;

    @Basic(optional = false)
    //@NotNull
    @Column(name = "IS_FOTO_ADS_ALLOWED")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isFotoAdsAllowed = DbBoolEnum.F;
    
    @Basic(optional = false)
   // @NotNull
    @Column(name = "IS_TV_ADS_ALLOWED")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isTvAdsAllowed = DbBoolEnum.F;
    
    @Basic(optional = false)
    //@NotNull
    @Column(name = "IS_OTHER_ADS_ALLOWED")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isOtherAdsAllowed = DbBoolEnum.F;
    
    @Basic(optional = false)
    //@NotNull
    @Column(name = "IS_CHECKED")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isChecked = DbBoolEnum.F;
    
    @Basic(optional = false)
    //@NotNull
    @Column(name = "IS_ACTIVE")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isActive = DbBoolEnum.T;
    
    @Basic(optional = false)
   // @NotNull
    @Column(name = "IS_INTEREST")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isInterest = DbBoolEnum.F;
    
    @Basic(optional = false)
    //@NotNull
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate=new Date();
    
    @Column(name = "LAST_PSG_DATE")
    @Temporal(TemporalType.DATE)
    private Date lastPsgDate;
    
    
    @Basic(optional = false)
   // @NotNull
    @Column(name = "IS_BIRTH_DAY_NOT_VALID")
    @Enumerated(EnumType.STRING)//день рождения пациента НЕ известен точно
    private DbBoolEnum isBirtDayNotValid = DbBoolEnum.T;
    
    
    @Size(max = 64)
    @Column(name = "ADR_DISTRICT")
    private String adrDistrict;
    
    @Size(max = 4000)
    @Column(name = "SELF_STORY")
    private String selfStory;
    
    @Size(max = 4000)
    @Column(name = "NURSE_NOTES")
    private String nurseNotes;
    
    @Size(max = 4000)
    @Column(name = "SPECIAL_NOTES")
    private String specialNotes;
    
    @Size(max = 4000)
    @Column(name = "DOC_CONLUSION")
    private String docConlusion;
    
    @Size(max = 1000)
    @Column(name = "REF_INFO_SRC_DETAIL")
    private String refInfoSrcDetail;
    
    @Size(max = 255)
    @Column(name = "CURED_BY_DOC")
    private String curedByDoc;
    
    @Basic(optional = false)
   // @NotNull
    @Column(name = "IS_LOR_INVASION")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isLorInvasion = DbBoolEnum.F;
    
    @Size(max = 1000)
    @Column(name = "LOR_INVASION_DETAILS")
    private String lorInvasionDetails;
    
    @Basic(optional = false)
   // @NotNull
    @Column(name = "IS_ALLERGIC")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isAllergic = DbBoolEnum.F;
    
    @Size(max = 2000)
    @Column(name = "ALLERGIC_DETAIL")
    private String allergicDetail;
    
    @Basic(optional = false)
    //@NotNull
    @Column(name = "IS_GEPATIT")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isGepatit = DbBoolEnum.F;
    
    @Basic(optional = false)
    //@NotNull
    @Column(name = "IS_BOTKIN")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isBotkin = DbBoolEnum.F;
    
    @Basic(optional = false)
    //@NotNull
    @Column(name = "IS_CERT_GIVEN")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isCertGiven = DbBoolEnum.F;
    
    @Column(name = "NEXT_PSG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nextPsgDate;
    
    @Size(max = 255)
    @Column(name = "PARTNER_NAME")
    private String partnerName;
    
    @Size(max = 255)
    @Column(name = "FAM_MEMBER_NAME")
    private String famMemberName;
    
    @Size(max = 2000)
    @Column(name = "EMAIL_ADDR_LIST")
    private String emailAddrList;
    
    @JoinColumn(name = "VIP_RANK_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private VipRank vipRankId;
    
    @JoinColumn(name = "CREATED_BY_USER_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private CardioUser createdByUserId;
    
    @JoinColumn(name = "TRACKED_BY_USER_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private CardioUser trackedByUserId;

    
    @JoinColumn(name = "CONTACTS_ID", referencedColumnName = "ID")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Contacts contactsId;
    
    @JoinColumn(name = "REF_RANK_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private SendRank refRankId;
    
    @JoinColumn(name = "REF_INFO_DOC_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private DoctorsExternal refInfoDocId;
    
    @OneToMany(mappedBy = "refInfoPatientId", fetch = FetchType.EAGER)
    private List<Patient> patientsSendedByThis;
    
    @JoinColumn(name = "REF_INFO_PATIENT_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Patient refInfoPatientId;
    
    @JoinColumn(name = "FAM_MEMBER_PHONE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    private PatientPhone famMemberPhoneId;
    
    @JoinColumn(name = "PARTNER_PHONE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    private PatientPhone partnerPhoneId;
    
    @JoinColumn(name = "AVATAR_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    private PatientPhoto avatarId;
    
    @JoinColumn(name = "REF_INFO_SRC_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private RefInfoSourceType refInfoSrcTypeId;
    
    @JoinColumn(name = "ADR_UA_STATE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private UaState adrUaStateId;
    
    @JoinColumn(name = "WORK_UA_TOWN_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private UaTown workUaTownId;
    
    @JoinColumn(name = "ADR_UA_TOWN_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private UaTown adrUaTownId;
    
    @Size(max = 64)
    @Column(name = "CPAP_STATUS")
    private String cpapStatus;
    
    
    @Basic(optional = true)
    @Column(name = "IS_CARD_PRG_PASSED")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isCardioProgPassed = DbBoolEnum.F;
    
    
    @Column(name = "PATALOGY_DETAIL")
    private String patalogyDetail;
    
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId", fetch = FetchType.EAGER)
    private List<PatientCall> patientCallList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<PatientPhone> patientPhoneList=new ArrayList<PatientPhone>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<PatientPhoto> patientPhotoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId",fetch = FetchType.EAGER)
    private List<Psg> psgList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient",fetch = FetchType.LAZY)
    private List<PatientDocument> documentList;

    public Patient() {
    }

    public Patient(Long id) {
        this.id = id;
    }

    public Patient(Long id, Date birthDate, String adrCountry) {
        this.id = id;
        this.birthDate = birthDate;
        this.adrCountry = adrCountry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPseudoName() {
        return pseudoName;
    }

    public void setPseudoName(String pseudoName) {
        this.pseudoName = pseudoName;
    }

    public DbGenderEnum getSex() {
        return sex;
    }

    public void setSex(DbGenderEnum sex) {
        this.sex = sex;
    }

    /**
     * Получить текущий возврат пациента
     * @return 
     */
    public int getAge() {
        Calendar cal = new GregorianCalendar();
         cal.setTime(birthDate);
         Calendar now = new GregorianCalendar();
        now.setTime(new Date());
      return now.get(Calendar.YEAR)-cal.get(Calendar.YEAR);
    }


    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAdrCountry() {
        return adrCountry;
    }

    public void setAdrCountry(String adrCountry) {
        this.adrCountry = adrCountry;
    }

    public String getAdrCity() {
        if(adrUaTownId !=null){
            return adrUaTownId.getRusName();
        }
        return adrCity;
    }

    public void setAdrCity(String adrCity) {
        this.adrCity = adrCity;
    }

    public String getAdrStreet() {
        return adrStreet;
    }

    public void setAdrStreet(String adrStreet) {
        this.adrStreet = adrStreet;
    }

    public String getAdrHouse() {
        return adrHouse;
    }

    public void setAdrHouse(String adrHouse) {
        this.adrHouse = adrHouse;
    }

    public String getAdrFlat() {
        return adrFlat;
    }

    public void setAdrFlat(String adrFlat) {
        this.adrFlat = adrFlat;
    }

    public BigDecimal getCurHeight() {
        return curHeight;
    }

    public void setCurHeight(BigDecimal curHeight) {
        this.curHeight = curHeight;
    }

    public BigDecimal getCurWeight() {
        return curWeight;
    }

    public void setCurWeight(BigDecimal curWeight) {
        this.curWeight = curWeight;
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

    public Date getPassDate() {
        return passDate;
    }

    public void setPassDate(Date passDate) {
        this.passDate = passDate;
    }

    public String getPassGivedBy() {
        return passGivedBy;
    }

    public void setPassGivedBy(String passGivedBy) {
        this.passGivedBy = passGivedBy;
    }

    public String getWorkTown() {
        return workTown;
    }

    public void setWorkTown(String workTown) {
        this.workTown = workTown;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public boolean getIsFotoAdsAllowed() {
        return isFotoAdsAllowed.getAsBool();
    }

    public void setIsFotoAdsAllowed(boolean isFotoAdsAllowed) {
        this.isFotoAdsAllowed = DbBoolEnum.valueOf(isFotoAdsAllowed);
    }

    public boolean getIsTvAdsAllowed() {
        return isTvAdsAllowed.getAsBool();
    }

    public void setIsTvAdsAllowed(boolean isTvAdsAllowed) {
        this.isTvAdsAllowed = DbBoolEnum.valueOf(isTvAdsAllowed);
    }

    public boolean getIsOtherAdsAllowed() {
        return isOtherAdsAllowed.getAsBool();
    }

    public void setIsOtherAdsAllowed(boolean isOtherAdsAllowed) {
        this.isOtherAdsAllowed = DbBoolEnum.valueOf(isOtherAdsAllowed);
    }

    public boolean getIsChecked() {
        return isChecked.getAsBool();
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = DbBoolEnum.valueOf(isChecked);
    }

    public boolean getIsActive() {
        return isActive.getAsBool();
    }

    public void setIsActive(boolean isActive) {
        this.isActive = DbBoolEnum.valueOf(isActive);
    }

    public boolean getIsInterest() {
        return isInterest.getAsBool();
    }

    public void setIsInterest(boolean isInterest) {
        this.isInterest = DbBoolEnum.valueOf(isInterest);
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastPsgDate() {
        return lastPsgDate;
    }

    public void setLastPsgDate(Date lastPsgDate) {
        this.lastPsgDate = lastPsgDate;
    }

    public String getAdrDistrict() {
        if(adrUaStateId !=null){
            return adrUaStateId.getRusName();
        }
        return adrDistrict;
    }

    public void setAdrDistrict(String adrDistrict) {
        this.adrDistrict = adrDistrict;
    }

    public String getSelfStory() {
        return selfStory;
    }

    public void setSelfStory(String selfStory) {
        this.selfStory = selfStory;
    }

    public String getNurseNotes() {
        return nurseNotes;
    }

    public void setNurseNotes(String nurseNotes) {
        this.nurseNotes = nurseNotes;
    }

    public String getSpecialNotes() {
        return specialNotes;
    }

    public void setSpecialNotes(String specialNotes) {
        this.specialNotes = specialNotes;
    }

    public String getDocConlusion() {
        return docConlusion;
    }

    public void setDocConlusion(String docConlusion) {
        this.docConlusion = docConlusion;
    }

    public String getRefInfoSrcDetail() {
        return refInfoSrcDetail;
    }

    public void setRefInfoSrcDetail(String refInfoSrcDetail) {
        this.refInfoSrcDetail = refInfoSrcDetail;
    }

    public String getCuredByDoc() {
        return curedByDoc;
    }

    public void setCuredByDoc(String curedByDoc) {
        this.curedByDoc = curedByDoc;
    }

    public boolean getIsLorInvasion() {
        return isLorInvasion.getAsBool();
    }

    public void setIsLorInvasion(boolean isLorInvasion) {
        this.isLorInvasion = DbBoolEnum.valueOf(isLorInvasion);
    }

    public String getLorInvasionDetails() {
        return lorInvasionDetails;
    }

    public void setLorInvasionDetails(String lorInvasionDetails) {
        this.lorInvasionDetails = lorInvasionDetails;
    }

    public boolean getIsAllergic() {
        return isAllergic.getAsBool();
    }

    public void setIsAllergic(boolean isAllergic) {
        this.isAllergic = DbBoolEnum.valueOf(isAllergic);
    }

    public String getAllergicDetail() {
        return allergicDetail;
    }

    public void setAllergicDetail(String allergicDetail) {
        this.allergicDetail = allergicDetail;
    }

    public boolean getIsGepatit() {
        return isGepatit.getAsBool();
    }

    public void setIsGepatit(boolean isGepatit) {
        this.isGepatit = DbBoolEnum.valueOf(isGepatit);
    }

    public boolean getIsBotkin() {
        return isBotkin.getAsBool();
    }

    public void setIsBotkin(boolean isBotkin) {
        this.isBotkin = DbBoolEnum.valueOf(isBotkin);
    }

    public boolean getIsCertGiven() {
        return isCertGiven.getAsBool();
    }

    public void setIsCertGiven(boolean isCertGiven) {
        this.isCertGiven = DbBoolEnum.valueOf(isCertGiven);
    }

    public Date getNextPsgDate() {
        return nextPsgDate;
    }

    public void setNextPsgDate(Date nextPsgDate) {
        this.nextPsgDate = nextPsgDate;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getFamMemberName() {
        return famMemberName;
    }

    public void setFamMemberName(String famMemberName) {
        this.famMemberName = famMemberName;
    }

    public String getEmailAddrList() {
        return emailAddrList;
    }

    public void setEmailAddrList(String emailAddrList) {
        this.emailAddrList = emailAddrList;
    }

    public VipRank getVipRankId() {
        return vipRankId;
    }

    public void setVipRankId(VipRank vipRankId) {
        this.vipRankId = vipRankId;
    }

    public CardioUser getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(CardioUser createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public CardioUser getTrackedByUserId() {
        return trackedByUserId;
    }

    public void setTrackedByUserId(CardioUser trackedByUserId) {
        this.trackedByUserId = trackedByUserId;
    }

    public boolean getIsCardioProgPassed() {
        if(isCardioProgPassed!=null){
        return isCardioProgPassed.getAsBool();
        }else return false;
    }

    
    public void setIsCardioProgPassed(boolean isCardioProgPassed) {
        this.isCardioProgPassed = DbBoolEnum.valueOf(isCardioProgPassed);
    }

    public String getPatalogyDetail() {
        return patalogyDetail;
    }

    public void setPatalogyDetail(String patalogyDetail) {
        this.patalogyDetail = patalogyDetail;
    }

   
    
    
    
    public Contacts getContactsId() {
        return contactsId;
    }

    public void setContactsId(Contacts contactsId) {
        this.contactsId = contactsId;
    }

    public SendRank getRefRankId() {
        return refRankId;
    }

    public void setRefRankId(SendRank refRankId) {
        this.refRankId = refRankId;
    }

    public DoctorsExternal getRefInfoDocId() {
        return refInfoDocId;
    }

    public void setRefInfoDocId(DoctorsExternal refInfoDocId) {
        this.refInfoDocId = refInfoDocId;
    }

    @XmlTransient
    @JsonIgnore
    public List<Patient> getPatientsSendedByThis() {
        return patientsSendedByThis;
    }

    public void setPatientsSendedByThis(List<Patient> patientsSendedByThis) {
        this.patientsSendedByThis = patientsSendedByThis;
    }

    public Patient getRefInfoPatientId() {
        return refInfoPatientId;
    }

    public void setRefInfoPatientId(Patient refInfoPatientId) {
        this.refInfoPatientId = refInfoPatientId;
    }

    public PatientPhone getFamMemberPhoneId() {
        return famMemberPhoneId;
    }

    public void setFamMemberPhoneId(PatientPhone famMemberPhoneId) {
        this.famMemberPhoneId = famMemberPhoneId;
    }

    public PatientPhone getPartnerPhoneId() {
        return partnerPhoneId;
    }

    public void setPartnerPhoneId(PatientPhone partnerPhoneId) {
        this.partnerPhoneId = partnerPhoneId;
    }

    public PatientPhoto getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(PatientPhoto avatarId) {
        this.avatarId = avatarId;
    }

    public RefInfoSourceType getRefInfoSrcTypeId() {
        return refInfoSrcTypeId;
    }

    public void setRefInfoSrcTypeId(RefInfoSourceType refInfoSrcTypeId) {
        this.refInfoSrcTypeId = refInfoSrcTypeId;
    }

    public UaState getAdrUaStateId() {
        return adrUaStateId;
    }

    public void setAdrUaStateId(UaState adrUaStateId) {
        this.adrUaStateId = adrUaStateId;
    }

    public UaTown getWorkUaTownId() {
        return workUaTownId;
    }

    public void setWorkUaTownId(UaTown workUaTownId) {
        this.workUaTownId = workUaTownId;
    }

    public UaTown getAdrUaTownId() {
        return adrUaTownId;
    }

    public void setAdrUaTownId(UaTown adrUaTownId) {
        this.adrUaTownId = adrUaTownId;
    }

    @XmlTransient
    @JsonIgnore
    public List<PatientCall> getPatientCallList() {
        return patientCallList;
    }

    public void setPatientCallList(List<PatientCall> patientCallList) {
        this.patientCallList = patientCallList;
    }

    @XmlTransient
    @JsonIgnore
    public List<PatientPhone> getPatientPhoneList() {
        return patientPhoneList;
    }

    public void setPatientPhoneList(List<PatientPhone> patientPhoneList) {
        this.patientPhoneList = patientPhoneList;
    }

    @XmlTransient
    @JsonIgnore
    public List<PatientPhoto> getPatientPhotoList() {
        return patientPhotoList;
    }

    public void setPatientPhotoList(List<PatientPhoto> patientPhotoList) {
        this.patientPhotoList = patientPhotoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Psg> getPsgList() {
        return psgList;
    }

    public void setPsgList(List<Psg> psgList) {
        this.psgList = psgList;
    }

    public String getCpapStatus() {
        return cpapStatus;
    }

    public void setCpapStatus(String cpapStatus) {
        this.cpapStatus = cpapStatus;
    }

    @XmlTransient
    @JsonIgnore
    public List<PatientDocument> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<PatientDocument> documentList) {
        this.documentList = documentList;
    }

    public boolean getIsBirtDayNotValid() {
        return isBirtDayNotValid.getAsBool();
    }

    public void setIsBirtDayNotValid(boolean isBirtDayNotValid) {
        this.isBirtDayNotValid = DbBoolEnum.valueOf(isBirtDayNotValid);
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
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String fio = getFio();
          if(pseudoName!=null && !pseudoName.trim().isEmpty()){
            return "[" + id + "] "+fio+" ("+pseudoName+")";
          }else{
              return "[" + id + "] "+fio;
          }
    }
    
    /**
     * Получить ФИО пациента
     * @return 
     */
    public String getFio(){
      return name+" "+firstName+" "+secondName;  
    };

    
    /**
     * Получить полный адрес пациента
     * @return 
     */
    public String getFullAddress(){
        StringBuilder sb = new StringBuilder();
        if(adrCountry !=null && !adrCountry.isEmpty()){
            sb.append(adrCountry+", ");
        }
        
        if(adrCity !=null && !adrCity.isEmpty()){
            sb.append(adrCity+", ");
        }
        
        sb.append(adrStreet).append(" ");
        
        if(adrHouse !=null && !adrHouse.isEmpty()){
            sb.append("дом "+adrHouse);
        }
        
        if(adrFlat !=null && !adrFlat.isEmpty()){
            sb.append(",кв "+adrFlat);
        }
        
        return sb.toString().trim();
        
    }
    
    
}
