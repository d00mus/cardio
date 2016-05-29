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
@Table(name = "PATIENT_CALL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientCall.findAll", query = "SELECT p FROM PatientCall p"),
    @NamedQuery(name = "PatientCall.findById", query = "SELECT p FROM PatientCall p WHERE p.id = :id"),
    @NamedQuery(name = "PatientCall.findByCallDate", query = "SELECT p FROM PatientCall p WHERE p.callDate = :callDate"),
    @NamedQuery(name = "PatientCall.findByRecallAfterReq", query = "SELECT p FROM PatientCall p WHERE p.recallAfterReq = :recallAfterReq"),
    @NamedQuery(name = "PatientCall.findByCallDetails", query = "SELECT p FROM PatientCall p WHERE p.callDetails = :callDetails"),
    @NamedQuery(name = "PatientCall.findByNewPsgDate", query = "SELECT p FROM PatientCall p WHERE p.newPsgDate = :newPsgDate"),
    @NamedQuery(name = "PatientCall.findByCurrPressSis", query = "SELECT p FROM PatientCall p WHERE p.currPressSis = :currPressSis"),
    @NamedQuery(name = "PatientCall.findByCurrPressDia", query = "SELECT p FROM PatientCall p WHERE p.currPressDia = :currPressDia"),
    @NamedQuery(name = "PatientCall.findByCurrWeight", query = "SELECT p FROM PatientCall p WHERE p.currWeight = :currWeight"),
    @NamedQuery(name = "PatientCall.findBySp02Min", query = "SELECT p FROM PatientCall p WHERE p.sp02Min = :sp02Min"),
    @NamedQuery(name = "PatientCall.findBySp02Avg", query = "SELECT p FROM PatientCall p WHERE p.sp02Avg = :sp02Avg"),
    @NamedQuery(name = "PatientCall.findByMsrFreq", query = "SELECT p FROM PatientCall p WHERE p.msrFreq = :msrFreq"),
    @NamedQuery(name = "PatientCall.findByIsSleepModeOk", query = "SELECT p FROM PatientCall p WHERE p.isSleepModeOk = :isSleepModeOk"),
    @NamedQuery(name = "PatientCall.findByIsSleepCultureOk", query = "SELECT p FROM PatientCall p WHERE p.isSleepCultureOk = :isSleepCultureOk"),
    @NamedQuery(name = "PatientCall.findByIsSleepyIs", query = "SELECT p FROM PatientCall p WHERE p.isSleepyIs = :isSleepyIs"),
    @NamedQuery(name = "PatientCall.findByIsSleepPosOk", query = "SELECT p FROM PatientCall p WHERE p.isSleepPosOk = :isSleepPosOk"),
    @NamedQuery(name = "PatientCall.findByIsDocConsulted", query = "SELECT p FROM PatientCall p WHERE p.isDocConsulted = :isDocConsulted"),
    @NamedQuery(name = "PatientCall.findByConsultedByDoc", query = "SELECT p FROM PatientCall p WHERE p.consultedByDoc = :consultedByDoc"),
    @NamedQuery(name = "PatientCall.findByIsCardPrgPassed", query = "SELECT p FROM PatientCall p WHERE p.isCardPrgPassed = :isCardPrgPassed"),
    @NamedQuery(name = "PatientCall.findByIsCardPrgInUtm", query = "SELECT p FROM PatientCall p WHERE p.isCardPrgInUtm = :isCardPrgInUtm"),
    @NamedQuery(name = "PatientCall.findByHaveQAboMask", query = "SELECT p FROM PatientCall p WHERE p.haveQAboMask = :haveQAboMask"),
    @NamedQuery(name = "PatientCall.findByHaveQAboDev", query = "SELECT p FROM PatientCall p WHERE p.haveQAboDev = :haveQAboDev"),
    @NamedQuery(name = "PatientCall.findByNurseNotes", query = "SELECT p FROM PatientCall p WHERE p.nurseNotes = :nurseNotes"),
    @NamedQuery(name = "PatientCall.findByNurseId", query = "SELECT p FROM PatientCall p WHERE p.nurseId = :nurseId")})
public class PatientCall implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="PATIENT_CALL_ID_GENERATOR", sequenceName="PATIENT_CALL_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PATIENT_CALL_ID_GENERATOR")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CALL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date callDate;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_ACCEPTED")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isAccepted = DbBoolEnum.F;
    
    @Column(name = "RECALL_AFTER_REQ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recallAfterReq;
    
    @Size(max = 4000)
    @Column(name = "CALL_DETAILS")
    private String callDetails;
    
    @Column(name = "NEW_PSG_DATE")
    @Temporal(TemporalType.DATE)
    private Date newPsgDate;
    
    @Column(name = "CURR_PRESS_SIS")
    private Short currPressSis;
    
    @Column(name = "CURR_PRESS_DIA")
    private Short currPressDia;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CURR_WEIGHT")
    private BigDecimal currWeight;
    
    @Column(name = "SP02_MIN")
    private BigDecimal sp02Min;
    
    @Column(name = "SP02_AVG")
    private BigDecimal sp02Avg;
    
    @Column(name = "MSR_FREQ")
    private Short msrFreq;

    @Column(name = "IS_AD_CONTROL")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isAdControl = DbBoolEnum.F;
    
    @Column(name = "IS_SP02_CONTROL")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isSpO2Control = DbBoolEnum.F;

    @Column(name = "IS_SLEEP_MODE_OK")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isSleepModeOk = DbBoolEnum.F;
    
    @Column(name = "IS_SLEEP_CULTURE_OK")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isSleepCultureOk = DbBoolEnum.F;
    
    @Column(name = "IS_SLEEPY_IS")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isSleepyIs = DbBoolEnum.F;
    
    @Column(name = "IS_SLEEP_POS_OK")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isSleepPosOk = DbBoolEnum.F;
    
    @Column(name = "IS_DOC_CONSULTED")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isDocConsulted = DbBoolEnum.F;
    
    @Size(max = 64)
    @Column(name = "CONSULTED_BY_DOC")
    private String consultedByDoc;
    
    @Column(name = "IS_CARD_PRG_PASSED")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isCardPrgPassed = DbBoolEnum.F;
    
    @Column(name = "IS_CARD_PRG_IN_UTM")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum isCardPrgInUtm = DbBoolEnum.F;
    
    @Column(name = "HAVE_Q_ABO_MASK")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum haveQAboMask = DbBoolEnum.F;
    
    @Column(name = "HAVE_Q_ABO_DEV")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum haveQAboDev = DbBoolEnum.F;
    
    @Column(name = "FLTR_REPLA_FREQ")
    private Short fltrReplaceFreq;
    
    @Size(max = 4000)
    @Column(name = "NURSE_NOTES")
    private String nurseNotes;
    
    @NotNull
    @JoinColumn(name = "NURSE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private CardioUser nurseId;
    
    @JoinColumn(name = "PHONE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PatientPhone phoneId;
    
    @JoinColumn(name = "CMN_FEELING_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private PatientFeeling cmnFeelingId;
    
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Patient patientId;

    
    /**
     * CPR_IS_SLEEP_NORMAL
     * CPR_IS_ACTIVE_GROW
     * CPR_IS_CARDIO_OK
     * CPR_IS_SLIMMING
     * CPR_SLIMMING_BY
     * CPR_IS_SEXUAL_OK
     * CPR_IS_LIVE_FUN
     * CPR_IS_DEPRESS_OFF
     * CPR_OTHER
     */
    //Результат лечения. Нормализация полноценного сна
    @Column(name = "CPR_IS_SLEEP_NORMAL")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum cprIsSleepNormal = DbBoolEnum.F;
  
    //Результат лечения. Повышение работоспособности
    @Column(name = "CPR_IS_ACTIVE_GROW")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum cprIsActiveGrow = DbBoolEnum.F;
    
    //Результат лечения. Улучшение сердечных показателей - давление и ритм
    @Column(name = "CPR_IS_CARDIO_OK")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum cprIsCardioOk = DbBoolEnum.F;

    //Результат лечения. Есть похудение
    @Column(name = "CPR_IS_SLIMMING")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum cprIsSlimming = DbBoolEnum.F;
    
    //Результат лечения. Похудение на сколько килограмм
    @Column(name = "CPR_SLIMMING_BY")
    private BigDecimal cprSlimmingBy;

    //Результат лечения. Восстановление потенции и активизация половой функции
    @Column(name = "CPR_IS_SEXUAL_OK")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum cprIsSexualOk = DbBoolEnum.F;
    
    //Результат лечения. Возвращение радости жизни
    @Column(name = "CPR_IS_LIVE_FUN")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum cprIsLiveFun = DbBoolEnum.F;

    //Результат лечения. Устранение депрессии
    @Column(name = "CPR_IS_DEPRESS_OFF")
    @Enumerated(EnumType.STRING)
    private DbBoolEnum cprIsDepressOff = DbBoolEnum.F;

    //Результат лечения. Другие положительные результаты, описать
    @Column(name = "CPR_OTHER")
    private String cprOther;
    
    
    public PatientCall() {
    }

    public PatientCall(Long id) {
        this.id = id;
    }

    public PatientCall(Long id, Date callDate, boolean notAccepted, CardioUser nurseId) {
        this.id = id;
        this.callDate = callDate;
        this.isAccepted = DbBoolEnum.valueOf(notAccepted);
        this.nurseId = nurseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCallDate() {
        return callDate;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }

    public boolean getIsAccepted() {
        return isAccepted.getAsBool();
    }

    public void setIsAccepted(boolean notAccepted) {
        this.isAccepted = DbBoolEnum.valueOf(notAccepted);
    }

    public Date getRecallAfterReq() {
        return recallAfterReq;
    }

    public void setRecallAfterReq(Date recallAfterReq) {
        this.recallAfterReq = recallAfterReq;
    }

    public String getCallDetails() {
        return callDetails;
    }

    public void setCallDetails(String callDetails) {
        this.callDetails = callDetails;
    }

    public Date getNewPsgDate() {
        return newPsgDate;
    }

    public void setNewPsgDate(Date newPsgDate) {
        this.newPsgDate = newPsgDate;
    }

    public Short getCurrPressSis() {
        return currPressSis;
    }

    public void setCurrPressSis(Short currPressSis) {
        this.currPressSis = currPressSis;
    }

    public Short getCurrPressDia() {
        return currPressDia;
    }

    public void setCurrPressDia(Short currPressDia) {
        this.currPressDia = currPressDia;
    }

    public BigDecimal getCurrWeight() {
        return currWeight;
    }

    public void setCurrWeight(BigDecimal currWeight) {
        this.currWeight = currWeight;
    }

    public BigDecimal getSp02Min() {
        return sp02Min;
    }

    public void setSp02Min(BigDecimal sp02Min) {
        this.sp02Min = sp02Min;
    }

    public BigDecimal getSp02Avg() {
        return sp02Avg;
    }

    public void setSp02Avg(BigDecimal sp02Avg) {
        this.sp02Avg = sp02Avg;
    }

    public Short getMsrFreq() {
        return msrFreq;
    }

    public void setMsrFreq(Short msrFreq) {
        this.msrFreq = msrFreq;
    }

    public boolean getIsSleepModeOk() {
        return isSleepModeOk.getAsBool();
    }

    public void setIsSleepModeOk(boolean isSleepModeOk) {
        this.isSleepModeOk = DbBoolEnum.valueOf(isSleepModeOk);
    }

    public boolean getIsSleepCultureOk() {
        return isSleepCultureOk.getAsBool();
    }

    public void setIsSleepCultureOk(boolean isSleepCultureOk) {
        this.isSleepCultureOk = DbBoolEnum.valueOf(isSleepCultureOk);
    }

    public boolean getIsSleepyIs() {
        return isSleepyIs.getAsBool();
    }

    public void setIsSleepyIs(boolean isSleepyIs) {
        this.isSleepyIs = DbBoolEnum.valueOf(isSleepyIs);
    }

        
    public boolean getIsSleepPosOk() {
        return isSleepPosOk.getAsBool();
    }

    public void setIsSleepPosOk(boolean isSleepPosOk) {
        this.isSleepPosOk = DbBoolEnum.valueOf(isSleepPosOk);
    }

    public boolean getIsDocConsulted() {
        return isDocConsulted.getAsBool();
    }

    public void setIsDocConsulted(boolean isDocConsulted) {
        this.isDocConsulted = DbBoolEnum.valueOf(isDocConsulted);
    }

    public String getConsultedByDoc() {
        return consultedByDoc;
    }

    public void setConsultedByDoc(String consultedByDoc) {
        this.consultedByDoc = consultedByDoc;
    }

    public boolean getIsCardPrgPassed() {
        return isCardPrgPassed.getAsBool();
    }

    public void setIsCardPrgPassed(boolean isCardPrgPassed) {
        this.isCardPrgPassed = DbBoolEnum.valueOf(isCardPrgPassed);
    }

    public boolean getIsCardPrgInUtm() {
        return isCardPrgInUtm.getAsBool();
    }

    public void setIsCardPrgInUtm(boolean isCardPrgInUtm) {
        this.isCardPrgInUtm = DbBoolEnum.valueOf(isCardPrgInUtm);
    }

    public boolean getHaveQAboMask() {
        return haveQAboMask.getAsBool();
    }

    public void setHaveQAboMask(boolean haveQAboMask) {
        this.haveQAboMask = DbBoolEnum.valueOf(haveQAboMask);
    }

    public boolean getHaveQAboDev() {
        return haveQAboDev.getAsBool();
    }

    public void setHaveQAboDev(boolean haveQAboDev) {
        this.haveQAboDev = DbBoolEnum.valueOf(haveQAboDev);
    }

    public Short getFltrReplaceFreq() {
        return fltrReplaceFreq;
    }

    public void setFltrReplaceFreq(Short fltrReplaceFreq) {
        this.fltrReplaceFreq = fltrReplaceFreq;
    }

    public String getNurseNotes() {
        return nurseNotes;
    }

    public void setNurseNotes(String nurseNotes) {
        this.nurseNotes = nurseNotes;
    }

    public CardioUser getNurseId() {
        return nurseId;
    }

    public void setNurseId(CardioUser nurseId) {
        this.nurseId = nurseId;
    }

    public PatientPhone getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(PatientPhone phoneId) {
        this.phoneId = phoneId;
    }

    public PatientFeeling getCmnFeelingId() {
        return cmnFeelingId;
    }

    public void setCmnFeelingId(PatientFeeling cmnFeelingId) {
        this.cmnFeelingId = cmnFeelingId;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    public boolean getIsAdControl() {
        return isAdControl.getAsBool();
    }

    public void setIsAdControl(boolean isAdControl) {
        this.isAdControl = DbBoolEnum.valueOf(isAdControl);
    }


    public boolean getIsSpO2Control() {
        return isSpO2Control.getAsBool();
    }

    public void setIsSpO2Control(boolean isSpO2Control) {
        this.isSpO2Control = DbBoolEnum.valueOf(isSpO2Control);
    }

    
    public boolean getCprIsSleepNormal() {
        return cprIsSleepNormal.getAsBool();
    }

    public void setCprIsSleepNormal(boolean cprIsSleepNormal) {
        this.cprIsSleepNormal = DbBoolEnum.valueOf(cprIsSleepNormal);
    }

    public boolean getCprIsActiveGrow() {
        return cprIsActiveGrow.getAsBool();
    }

    public void setCprIsActiveGrow(boolean cprIsActiveGrow) {
        this.cprIsActiveGrow = DbBoolEnum.valueOf(cprIsActiveGrow);
    }

    public boolean getCprIsCardioOk() {
        return cprIsCardioOk.getAsBool();
    }

    public void setCprIsCardioOk(boolean cprIsCardioOk) {
        this.cprIsCardioOk = DbBoolEnum.valueOf(cprIsCardioOk);
    }

    public boolean getCprIsSlimming() {
        return cprIsSlimming.getAsBool();
    }

    public void setCprIsSlimming(boolean cprIsSlimming) {
        this.cprIsSlimming = DbBoolEnum.valueOf(cprIsSlimming);
    }

    public BigDecimal getCprSlimmingBy() {
        return cprSlimmingBy;
    }

    public void setCprSlimmingBy(BigDecimal cprSlimmingBy) {
        this.cprSlimmingBy = cprSlimmingBy;
    }

    public boolean getCprIsSexualOk() {
        return cprIsSexualOk.getAsBool();
    }

    public void setCprIsSexualOk(boolean cprIsSexualOk) {
        this.cprIsSexualOk = DbBoolEnum.valueOf(cprIsSexualOk);
    }

    public boolean getCprIsLiveFun() {
        return cprIsLiveFun.getAsBool();
    }

    public void setCprIsLiveFun(boolean cprIsLiveFun) {
        this.cprIsLiveFun = DbBoolEnum.valueOf(cprIsLiveFun);
    }

    public boolean getCprIsDepressOff() {
        return cprIsDepressOff.getAsBool();
    }

    public void setCprIsDepressOff(boolean cprIsDepressOff) {
        this.cprIsDepressOff = DbBoolEnum.valueOf(cprIsDepressOff);
    }

    public String getCprOther() {
        return cprOther;
    }

    public void setCprOther(String cprOther) {
        this.cprOther = cprOther;
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
        if (!(object instanceof PatientCall)) {
            return false;
        }
        PatientCall other = (PatientCall) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdl.PatientCall[ id=" + id + " ]";
    }
    
}
