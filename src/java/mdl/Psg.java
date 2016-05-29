/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mdl;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author d00mus
 */
@Entity
@Table(name = "PSG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Psg.findAll", query = "SELECT p FROM Psg p"),
    @NamedQuery(name = "Psg.findById", query = "SELECT p FROM Psg p WHERE p.id = :id"),
    @NamedQuery(name = "Psg.findByPsgDate", query = "SELECT p FROM Psg p WHERE p.psgDate = :psgDate"),
    @NamedQuery(name = "Psg.findByCurrentWeigth", query = "SELECT p FROM Psg p WHERE p.currentWeigth = :currentWeigth"),
    @NamedQuery(name = "Psg.findByCurrentHeight", query = "SELECT p FROM Psg p WHERE p.currentHeight = :currentHeight"),
    @NamedQuery(name = "Psg.findByIsDone", query = "SELECT p FROM Psg p WHERE p.isDone = :isDone"),
    @NamedQuery(name = "Psg.findByNotes", query = "SELECT p FROM Psg p WHERE p.notes = :notes"),
    @NamedQuery(name = "Psg.findByDetectorOnTime", query = "SELECT p FROM Psg p WHERE p.detectorOnTime = :detectorOnTime"),
    @NamedQuery(name = "Psg.findByLightOffTime", query = "SELECT p FROM Psg p WHERE p.lightOffTime = :lightOffTime"),
    @NamedQuery(name = "Psg.findByGoToSleepTime", query = "SELECT p FROM Psg p WHERE p.goToSleepTime = :goToSleepTime"),
    @NamedQuery(name = "Psg.findByWakeUpTime", query = "SELECT p FROM Psg p WHERE p.wakeUpTime = :wakeUpTime"),
    @NamedQuery(name = "Psg.findByTotalSleepTimeHour", query = "SELECT p FROM Psg p WHERE p.totalSleepTimeHour = :totalSleepTimeHour"),
    @NamedQuery(name = "Psg.findByCpapBeginTime", query = "SELECT p FROM Psg p WHERE p.cpapBeginTime = :cpapBeginTime"),
    @NamedQuery(name = "Psg.findByOxymatBeginTime", query = "SELECT p FROM Psg p WHERE p.oxymatBeginTime = :oxymatBeginTime"),
    @NamedQuery(name = "Psg.findByCpapSerial", query = "SELECT p FROM Psg p WHERE p.cpapSerial = :cpapSerial")})
public class Psg implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @SequenceGenerator(name="PSG_ID_GENERATOR", sequenceName="PSG_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PSG_ID_GENERATOR")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "PSG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date psgDate;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "CURRENT_WEIGTH")
    private BigDecimal currentWeigth;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CURRENT_HEIGHT")
    private BigDecimal currentHeight;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "PSG_NO")
    private short psgNo;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_DONE")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isDone;
    
    @Size(max = 2000)
    @Column(name = "NOTES")
    private String notes;
    
    @Column(name = "DETECTOR_ON_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date detectorOnTime;
    
    @Column(name = "LIGHT_OFF_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lightOffTime;
    
    @Column(name = "GO_TO_SLEEP_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date goToSleepTime;
    
    @Column(name = "WAKE_UP_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date wakeUpTime;
    
    @Column(name = "TOTAL_SLEEP_TIME_HOUR")
    private BigDecimal totalSleepTimeHour;
    
    @Column(name = "CPAP_BEGIN_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cpapBeginTime;
    
    @Column(name = "OXYMAT_BEGIN_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date oxymatBeginTime;
    
    @Size(max = 32)
    @Column(name = "CPAP_SERIAL")
    private String cpapSerial;

    
    //CPAP: Плавный старт - да/нет
    @Column(name = "IS_SMOOTH_START")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isSmoothStart = DbBoolEnum.F;
    
    //CPAP: Длительность плавного старта: 5,10,15,20,25,30 минут
    @Column(name = "SMOOTH_START_DURATION")
    private Integer smoothStartDuration;

    //CPAP: увлажнение дыхания
    @Column(name = "BREATH_HUMIDITY")
    private Integer breathHumidity;//1,2,3,4,5,6
        
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "psgId",fetch = FetchType.EAGER)
    private List<PsgAttrDetectorTune> psgAttrDetectorTuneList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "psgId",fetch = FetchType.EAGER)
    private List<PsgAttrSpO2> psgAttrSpO2List;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "psgId",fetch = FetchType.EAGER)
    private List<PsgAttrToiletWake> psgAttrToiletWakeList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "psgId",fetch = FetchType.EAGER)
    private List<PsgAttrEcg> psgAttrEcgList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "psgId",fetch = FetchType.EAGER)
    private List<PsgAttrAd> psgAttrAdList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "psgId",fetch = FetchType.EAGER)
    private List<PsgAttrApnoe> psgAttrApnoeList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "psgId",fetch = FetchType.EAGER)
    private List<PsgAttrSnoring> psgAttrSnoringList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "psg",fetch = FetchType.EAGER)
    private List<PsgAttrBreathFreq> psgAttrBreathFreqList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "psg",fetch = FetchType.EAGER)
    private List<PsgAttrCpapVentPressue> psgAttrCpapVentPressueList;
    

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "psg",fetch = FetchType.EAGER)
    private List<PsgAttrCpapCurrPress> psgAttrCpapCurrPressList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "psg",fetch = FetchType.EAGER)
    private List<PsgAttrCpapBalancePrm> psgAttrCpapBalancePrmList;
 
    
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Patient patientId;
    
    @JoinColumn(name = "NURSE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private CardioUser nurseId;
    
    @JoinColumn(name = "OXYMAT_MASK_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne
    private MaskType oxymatMaskTypeId;
    
    @JoinColumn(name = "CPAP_MASK_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne
    private MaskType cpapMaskTypeId;
    
    @JoinColumn(name = "CPAP_MASK_SIZE_ID", referencedColumnName = "ID")
    @ManyToOne
    private MaskSize cpapMaskSizeId;

    @JoinColumn(name = "OXYMAT_MASK_SIZE_ID", referencedColumnName = "ID")
    @ManyToOne
    private MaskSize oxymatMaskSizeId;

    
    @JoinColumn(name = "CUSHION_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne
    private CushionType cushionTypeId;
    
    @JoinColumn(name = "CPAP_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne
    private CpapType cpapTypeId;


    @JoinColumn(name = "OXYMAT_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne
    private OxymatType oxymatTypeId;
    
    @JoinColumn(name = "CABINET_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cabinet cabinetId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "psgId")
    private List<PsgAttrPulls> psgAttrPullsList;
    
        
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "psg", fetch = FetchType.EAGER)
    private PsgResult psgResult;

    

    public Psg() {
      isSmoothStart = DbBoolEnum.F;
        
    }

    public Psg(Long id) {
        this.id = id;
    }

    public Psg(Long id, Date psgDate, BigDecimal currentWeigth, BigDecimal currentHeight, boolean isDone) {
        this.id = id;
        this.psgDate = psgDate;
        this.currentWeigth = currentWeigth;
        this.currentHeight = currentHeight;
        this.isDone = DbBoolEnum.valueOf(isDone);
    }

    public short getPsgNo() {
        return psgNo;
    }

    public void setPsgNo(short psgNo) {
        this.psgNo = psgNo;
    }

        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPsgDate() {
        return psgDate;
    }

    public void setPsgDate(Date psgDate) {
        this.psgDate = psgDate;
    }

    public BigDecimal getCurrentWeigth() {
        return currentWeigth;
    }

    public void setCurrentWeigth(BigDecimal currentWeigth) {
        this.currentWeigth = currentWeigth;
    }

    public BigDecimal getCurrentHeight() {
        return currentHeight;
    }

    public void setCurrentHeight(BigDecimal currentHeight) {
        this.currentHeight = currentHeight;
    }

    public boolean getIsDone() {
        return isDone.getAsBool();
    }

    public void setIsDone(boolean isDone) {
        this.isDone = DbBoolEnum.valueOf(isDone);
    }


    public boolean getIsSmoothStart() {
        if(isSmoothStart==null){
           isSmoothStart = DbBoolEnum.F;
        }
        return isSmoothStart.getAsBool();
    }

    public void setIsSmoothStart(boolean isSmoothStart) {
        this.isSmoothStart = DbBoolEnum.valueOf(isSmoothStart);
    }

    public Integer getSmoothStartDuration() {
        return smoothStartDuration;
    }

    public void setSmoothStartDuration(Integer smoothStartDuration) {
        this.smoothStartDuration = smoothStartDuration;
    }

    public Integer getBreathHumidity() {
        return breathHumidity;
    }

    public void setBreathHumidity(Integer breathHumidity) {
        this.breathHumidity = breathHumidity;
    }

    public List<PsgAttrCpapCurrPress> getPsgAttrCpapCurrPressList() {
        return psgAttrCpapCurrPressList;
    }

    public void setPsgAttrCpapCurrPressList(List<PsgAttrCpapCurrPress> psgAttrCpapCurrPressList) {
        this.psgAttrCpapCurrPressList = psgAttrCpapCurrPressList;
    }

    public List<PsgAttrCpapBalancePrm> getPsgAttrCpapBalancePrmList() {
        return psgAttrCpapBalancePrmList;
    }

    public void setPsgAttrCpapBalancePrmList(List<PsgAttrCpapBalancePrm> psgAttrCpapBalancePrmList) {
        this.psgAttrCpapBalancePrmList = psgAttrCpapBalancePrmList;
    }


        
    
    
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDetectorOnTime() {
        return detectorOnTime;
    }

    public void setDetectorOnTime(Date detectorOnTime) {
        this.detectorOnTime = detectorOnTime;
    }

    public Date getLightOffTime() {
        return lightOffTime;
    }

    public void setLightOffTime(Date lightOffTime) {
        this.lightOffTime = lightOffTime;
    }

    public Date getGoToSleepTime() {
        return goToSleepTime;
    }

    public void setGoToSleepTime(Date goToSleepTime) {
        this.goToSleepTime = goToSleepTime;
    }

    public Date getWakeUpTime() {
        return wakeUpTime;
    }

    public void setWakeUpTime(Date wakeUpTime) {
        this.wakeUpTime = wakeUpTime;
    }

    public BigDecimal getTotalSleepTimeHour() {
        return totalSleepTimeHour;
    }

    public void setTotalSleepTimeHour(BigDecimal totalSleepTimeHour) {
        this.totalSleepTimeHour = totalSleepTimeHour;
    }

    public Date getCpapBeginTime() {
        return cpapBeginTime;
    }

    public void setCpapBeginTime(Date cpapBeginTime) {
        this.cpapBeginTime = cpapBeginTime;
    }

    public Date getOxymatBeginTime() {
        return oxymatBeginTime;
    }

    public void setOxymatBeginTime(Date oxymatBeginTime) {
        this.oxymatBeginTime = oxymatBeginTime;
    }

    public String getCpapSerial() {
        return cpapSerial;
    }

    public void setCpapSerial(String cpapSerial) {
        this.cpapSerial = cpapSerial;
    }

    @XmlTransient
    public List<PsgAttrDetectorTune> getPsgAttrDetectorTuneList() {
        return psgAttrDetectorTuneList;
    }

    public void setPsgAttrDetectorTuneList(List<PsgAttrDetectorTune> psgAttrDetectorTuneList) {
        this.psgAttrDetectorTuneList = psgAttrDetectorTuneList;
    }

    @XmlTransient
    public List<PsgAttrSpO2> getPsgAttrSpO2List() {
        return psgAttrSpO2List;
    }

    public void setPsgAttrSpO2List(List<PsgAttrSpO2> psgAttrSpO2List) {
        this.psgAttrSpO2List = psgAttrSpO2List;
    }

    @XmlTransient
    public List<PsgAttrToiletWake> getPsgAttrToiletWakeList() {
        return psgAttrToiletWakeList;
    }

    public void setPsgAttrToiletWakeList(List<PsgAttrToiletWake> psgAttrToiletWakeList) {
        this.psgAttrToiletWakeList = psgAttrToiletWakeList;
    }

    @XmlTransient
    public List<PsgAttrEcg> getPsgAttrEcgList() {
        return psgAttrEcgList;
    }

    public void setPsgAttrEcgList(List<PsgAttrEcg> psgAttrEcgList) {
        this.psgAttrEcgList = psgAttrEcgList;
    }

    @XmlTransient
    public List<PsgAttrAd> getPsgAttrAdList() {
        return psgAttrAdList;
    }

    public void setPsgAttrAdList(List<PsgAttrAd> psgAttrAdList) {
        this.psgAttrAdList = psgAttrAdList;
    }

    @XmlTransient
    public List<PsgAttrApnoe> getPsgAttrApnoeList() {
        return psgAttrApnoeList;
    }

    public void setPsgAttrApnoeList(List<PsgAttrApnoe> psgAttrApnoeList) {
        this.psgAttrApnoeList = psgAttrApnoeList;
    }

    @XmlTransient
    public List<PsgAttrSnoring> getPsgAttrSnoringList() {
        return psgAttrSnoringList;
    }

    public void setPsgAttrSnoringList(List<PsgAttrSnoring> psgAttrSnoringList) {
        this.psgAttrSnoringList = psgAttrSnoringList;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    public CardioUser getNurseId() {
        return nurseId;
    }

    public void setNurseId(CardioUser nurseId) {
        this.nurseId = nurseId;
    }

    public MaskType getOxymatMaskTypeId() {
        return oxymatMaskTypeId;
    }

    public void setOxymatMaskTypeId(MaskType oxymatMaskTypeId) {
        this.oxymatMaskTypeId = oxymatMaskTypeId;
    }

    public MaskType getCpapMaskTypeId() {
        return cpapMaskTypeId;
    }

    public void setCpapMaskTypeId(MaskType cpapMaskTypeId) {
        this.cpapMaskTypeId = cpapMaskTypeId;
    }

    public CushionType getCushionTypeId() {
        return cushionTypeId;
    }

    public void setCushionTypeId(CushionType cushionTypeId) {
        this.cushionTypeId = cushionTypeId;
    }

    public CpapType getCpapTypeId() {
        return cpapTypeId;
    }

    public void setCpapTypeId(CpapType cpapTypeId) {
        this.cpapTypeId = cpapTypeId;
    }

    public Cabinet getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(Cabinet cabinetId) {
        this.cabinetId = cabinetId;
    }

    @XmlTransient
    public List<PsgAttrPulls> getPsgAttrPullsList() {
        return psgAttrPullsList;
    }

    public void setPsgAttrPullsList(List<PsgAttrPulls> psgAttrPullsList) {
        this.psgAttrPullsList = psgAttrPullsList;
    }

    public MaskSize getCpapMaskSizeId() {
        return cpapMaskSizeId;
    }

    public void setCpapMaskSizeId(MaskSize cpapMaskSizeId) {
        this.cpapMaskSizeId = cpapMaskSizeId;
    }

    public MaskSize getOxymatMaskSizeId() {
        return oxymatMaskSizeId;
    }

    public void setOxymatMaskSizeId(MaskSize oxymatMaskSizeId) {
        this.oxymatMaskSizeId = oxymatMaskSizeId;
    }

    public OxymatType getOxymatTypeId() {
        return oxymatTypeId;
    }

    public void setOxymatTypeId(OxymatType oxymatTypeId) {
        this.oxymatTypeId = oxymatTypeId;
    }

    public PsgResult getPsgResult() {
        return psgResult;
    }

    public void setPsgResult(PsgResult psgResult) {
        this.psgResult = psgResult;
    }

    public List<PsgAttrBreathFreq> getPsgAttrBreathFreqList() {
        return psgAttrBreathFreqList;
    }

    public void setPsgAttrBreathFreqList(List<PsgAttrBreathFreq> psgAttrBreathFreqList) {
        this.psgAttrBreathFreqList = psgAttrBreathFreqList;
    }

    public List<PsgAttrCpapVentPressue> getPsgAttrCpapVentPressueList() {
        return psgAttrCpapVentPressueList;
    }

    public void setPsgAttrCpapVentPressueList(List<PsgAttrCpapVentPressue> psgAttrCpapVentPressueList) {
        this.psgAttrCpapVentPressueList = psgAttrCpapVentPressueList;
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
        if (!(object instanceof Psg)) {
            return false;
        }
        Psg other = (Psg) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdl.Psg[ id=" + id + " ]";
    }
    
}
