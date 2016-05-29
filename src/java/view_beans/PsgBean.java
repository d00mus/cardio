/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view_beans;

import ctrl.util.JsfUtil;
import dao.PatientFacade;
import dao.PsgAttrAdFacade;
import dao.PsgAttrApnoeFacade;
import dao.PsgAttrBreathFreqFacade;
import dao.PsgAttrCpapBalancePrmFacade;
import dao.PsgAttrCpapCurrPressFacade;
import dao.PsgAttrCpapVentPressueFacade;
import dao.PsgAttrDetectorTuneFacade;
import dao.PsgAttrEcgFacade;
import dao.PsgAttrPullsFacade;
import dao.PsgAttrSnoringFacade;
import dao.PsgAttrSpO2Facade;
import dao.PsgAttrToiletWakeFacade;
import dao.PsgFacade;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import mdl.Psg;
import mdl.PsgAttrAd;
import mdl.PsgAttrApnoe;
import mdl.PsgAttrBreathFreq;
import mdl.PsgAttrCpapBalancePrm;
import mdl.PsgAttrCpapCurrPress;
import mdl.PsgAttrCpapVentPressue;
import mdl.PsgAttrDetectorTune;
import mdl.PsgAttrEcg;
import mdl.PsgAttrPulls;
import mdl.PsgAttrSnoring;
import mdl.PsgAttrSpO2;
import mdl.PsgAttrToiletWake;
import mdl.PsgResult;

@Named("psgBean")
@SessionScoped
public class PsgBean implements Serializable{
    
  private Psg curr; 

  @EJB
  PsgFacade psgDao;
  
  @EJB
  PatientFacade patientDao;
  
  @Inject
  LoginBean login;
  
  @Inject
  PatientTableBean patientTableBean;
  
  //текущие аргументы, выставленные юзером
  private PsgAttrAd currAd=new PsgAttrAd();
  @EJB
  private PsgAttrAdFacade adDao;
  
  
  private PsgAttrApnoe currApnoe = new PsgAttrApnoe();
  @EJB
  private PsgAttrApnoeFacade apnoeDao;
  
  
  private PsgAttrEcg currEcg = new PsgAttrEcg();
  @EJB
  private PsgAttrEcgFacade ecgDao;
  
  private PsgAttrPulls currPulls = new PsgAttrPulls();
  @EJB
  private PsgAttrPullsFacade pullsDao;

  
  //----------
  private PsgAttrSnoring currSnoring = new PsgAttrSnoring();
  @EJB
  private PsgAttrSnoringFacade snoringDao;
  
  //----------
  private PsgAttrSpO2 currSpO2 = new PsgAttrSpO2();
  @EJB
  private PsgAttrSpO2Facade spO2Dao;
  
  //----------
  private PsgAttrToiletWake currToiletWake = new PsgAttrToiletWake();
  @EJB
  private PsgAttrToiletWakeFacade toiletWakeDao;
  
  //----------
  private PsgAttrDetectorTune currDetTune = new PsgAttrDetectorTune();
  @EJB
  private PsgAttrDetectorTuneFacade detTuneDao;
  
  //----------
  private PsgAttrCpapBalancePrm currCpapBalPrm = new PsgAttrCpapBalancePrm();
  @EJB 
  private PsgAttrCpapBalancePrmFacade cpapBalPrmDao;
  
  //----------
  private PsgAttrCpapCurrPress currCpapPress = new PsgAttrCpapCurrPress();
  @EJB
  private PsgAttrCpapCurrPressFacade cpapPressDao;
  
  //----------
  private PsgAttrCpapVentPressue currCpapVentPress = new PsgAttrCpapVentPressue();
  @EJB
  private PsgAttrCpapVentPressueFacade cpapVentDao;
  
  //----------
  private PsgAttrBreathFreq currBreathFreq = new PsgAttrBreathFreq();
  @EJB
  private PsgAttrBreathFreqFacade breathFreqDao;
  
    
  
  
  @Inject
  private PatientProfileBean patientProfile;
  
      //текущий таб в результате ПСГ
    private int curPsgResTabIdx=0;


  
  public PsgAttrDetectorTune getCurrDetTune(){
      if(currDetTune==null){
        currDetTune = new PsgAttrDetectorTune();
       currDetTune.setPsgId(curr);
      }
    return currDetTune;  
  }
  
  
  public PsgAttrAd getCurrAd(){
    return currAd;  
  }
  
  public PsgAttrApnoe getCurrApnoe(){
    return currApnoe;  
  }
  
  public PsgAttrEcg getCurrEcg(){
    return currEcg;  
  }
  
  public PsgAttrPulls getCurrPulls(){
    return currPulls;  
  }

  public PsgAttrSnoring getCurrSnoring(){
    return currSnoring;  
  }
  

  public PsgAttrSpO2 getCurrSpO2(){
    return currSpO2;  
  }
  
  
  public PsgAttrToiletWake getCurrToiletWake(){
    return currToiletWake;  
  }

    
  /**
   * Игры с локалью
   * @return 
   */
    public String getCurLocale(){
     return FacesContext.getCurrentInstance().getViewRoot().getLocale().toString();
   
    }
    
    public Psg getCurr() {
        return curr;
    }

    public void setCurr(Psg curr) {
        this.curr = curr;
    }
    
    public void refresh(){
      curr = psgDao.refresh(curr.getId());//наш лоховской рефреш        
    }

    public int getCurPsgResTabIdx() {
        return curPsgResTabIdx;
    }

    public void setCurPsgResTabIdx(int curPsgResTabIdx) {
        this.curPsgResTabIdx = curPsgResTabIdx;
    }

    public PsgAttrCpapBalancePrm getCurrCpapBalPrm() {
        return currCpapBalPrm;
    }

    public void setCurrCpapBalPrm(PsgAttrCpapBalancePrm currCpapBalPrm) {
        this.currCpapBalPrm = currCpapBalPrm;
    }

    public PsgAttrCpapCurrPress getCurrCpapPress() {
        return currCpapPress;
    }

    public void setCurrCpapPress(PsgAttrCpapCurrPress currCpapPress) {
        this.currCpapPress = currCpapPress;
    }

    public PsgAttrCpapVentPressue getCurrCpapVentPress() {
        return currCpapVentPress;
    }

    public void setCurrCpapVentPress(PsgAttrCpapVentPressue currCpapVentPress) {
        this.currCpapVentPress = currCpapVentPress;
    }

    public PsgAttrBreathFreq getCurrBreathFreq() {
        return currBreathFreq;
    }

    public void setCurrBreathFreq(PsgAttrBreathFreq currBreathFreq) {
        this.currBreathFreq = currBreathFreq;
    }

    
    
    
    
    //--------------------
    /**
     * Добавить замер частоты дыхания
     * @return 
     */
    public String addBreathFreq(){
        //транслировать время относительно даты ПСГ
       currBreathFreq.setMeasuringTime(convPsgTime(currBreathFreq.getMeasuringTime()));
       currBreathFreq.setPsg(curr);//выставить ссылку на текущее ПСГ
        breathFreqDao.create(currBreathFreq);
        currBreathFreq = new PsgAttrBreathFreq() ;//новый замер пульса
        currBreathFreq.setMeasuringTime(new Date());//выставить текущее время в новом замере
        JsfUtil.addSuccessMessage("Замер частоты дыхания добавлен");
       refresh();
      return null;
    }
    
    /**
     * Удалить замер частоты дыхания
     * @param forDel
     * @return 
     */
    public String delBreathFreq(PsgAttrBreathFreq forDel){
        breathFreqDao.remove(forDel);//удалить из базы
        currBreathFreq = forDel;//выставить текущее в удаляемое
        JsfUtil.addSuccessMessage("Замер частоты дыхания удалён");
        refresh();
      return null;
    }
        
    //------------------------
    /**
     * CPAP: текущее давление
     * @return 
     */
    public String addCurrPressue(){
        //транслировать время относительно даты ПСГ
       currCpapPress.setMeasuringTime(convPsgTime(currCpapPress.getMeasuringTime()));
       currCpapPress.setPsg(curr);//выставить ссылку на текущее ПСГ
       cpapPressDao.create(currCpapPress);
        currCpapPress = new PsgAttrCpapCurrPress() ;//новый замер пульса
        currCpapPress.setMeasuringTime(new Date());//выставить текущее время в новом замере
        JsfUtil.addSuccessMessage("Замер давления CPAP добавлен");
       refresh();
      return null;
    }
    
    /**
     * Удалить замер текущего давления CPAP
     * @param forDel
     * @return 
     */
    public String delCurrPressue(PsgAttrCpapCurrPress forDel){
        cpapPressDao.remove(forDel);//удалить из базы
        currCpapPress = forDel;//выставить текущее в удаляемое
        JsfUtil.addSuccessMessage("Замер давления CPAP удалён");
        refresh();
      return null;
    }
        
    //--------------------
    
      /**
       * Добавить замеры давления сомновента
       * @return 
       */
    public String addCpapVentPress(){
        //транслировать время относительно даты ПСГ
       currCpapVentPress.setMeasuringTime(convPsgTime(currCpapVentPress.getMeasuringTime()));
       currCpapVentPress.setPsg(curr);//выставить ссылку на текущее ПСГ
       cpapVentDao.create(currCpapVentPress);
        currCpapVentPress = new PsgAttrCpapVentPressue();//новый замер пульса
        currCpapVentPress.setMeasuringTime(new Date());//выставить текущее время в новом замере
        JsfUtil.addSuccessMessage("Замер давлений Somnovent добавлен");
       refresh();
      return null;
    }
    
    /**
     * Удалить замеры давления сомновента
     * @param forDel
     * @return 
     */
    public String delCpapVentPress(PsgAttrCpapVentPressue forDel){
        cpapVentDao.remove(forDel);//удалить из базы
        currCpapVentPress = forDel;//выставить текущее в удаляемое
        JsfUtil.addSuccessMessage("Замер давлений Somnovent удалён");
        refresh();
      return null;
    } 
       
    //--------------------


    //--------------------
    /**
     * Добавить замер параметров Somnobalance
     * @return 
     */
    public String addCpapBalPrm(){
        //транслировать время относительно даты ПСГ
       currCpapBalPrm.setMeasuringTime(convPsgTime(currCpapBalPrm.getMeasuringTime()));
       currCpapBalPrm.setPsg(curr);//выставить ссылку на текущее ПСГ
       cpapBalPrmDao.create(currCpapBalPrm);
        currCpapBalPrm = new PsgAttrCpapBalancePrm() ;//новый замер пульса
        currCpapBalPrm.setMeasuringTime(new Date());//выставить текущее время в новом замере
        JsfUtil.addSuccessMessage("Замер параметров Somnobalance добавлен");
       refresh();
      return null;
    }
    
    /**
     * Удалить замеры параметров Somnobalance
     * @param forDel
     * @return 
     */
    public String delCpapBalPrm(PsgAttrCpapBalancePrm forDel){
        cpapBalPrmDao.remove(forDel);//удалить из базы
        currCpapBalPrm = forDel;//выставить текущее в удаляемое
        JsfUtil.addSuccessMessage("Замер параметров Somnobalance удалён");
        refresh();
      return null;
    } 
       
    //--------------------
    
    
    
    public String addEcg(){
       //транслировать время относительно даты ПСГ 
       currEcg.setMeasuringTime(convPsgTime(currEcg.getMeasuringTime()));
       
       currEcg.setPsgId(curr);//выставить ссылку на текущее ПСГ
        ecgDao.create(currEcg);
        currEcg = new PsgAttrEcg();//новый замер Ecg
        currEcg.setMeasuringTime(new Date());//выставить текущее время в новом замере
        JsfUtil.addSuccessMessage("Замер ЕКГ добавлен");
        refresh();
      return null;
    }

    
    public String addPulse(){
        //транслировать время относительно даты ПСГ
       currPulls.setMeasuringTime(convPsgTime(currPulls.getMeasuringTime()));
       currPulls.setPsgId(curr);//выставить ссылку на текущее ПСГ
        pullsDao.create(currPulls);
        currPulls = new PsgAttrPulls();//новый замер пульса
        currPulls.setMeasuringTime(new Date());//выставить текущее время в новом замере
        JsfUtil.addSuccessMessage("Замер пульса добавлен");
       refresh();
      return null;
    }
    
    
    public String addAD(){
      //валидация правильности значений  
       if(currAd.getDiastolPressue()>=currAd.getSystolPressue()){
           JsfUtil.addErrorMessage("Замер давления: сперва идёт бОльшая цифра, потом меньшая, пример: 120/70");
        return null;           
       } 
     //нормализовать время
       currAd.setMeasuringTime(convPsgTime(currAd.getMeasuringTime()));
       currAd.setPsgId(curr);//выставить ссылку на текущее ПСГ
       
        adDao.create(currAd);
        currAd = new PsgAttrAd();//новое ПСГ   
        currAd.setMeasuringTime(new Date());
        JsfUtil.addSuccessMessage("Замер давления добавлен");
        refresh();
      return null;
    }

    /**
     * Удалить указанное измерение давление, записав его в текущее
     * @return 
     */
    public String delAD(PsgAttrAd forDel){
        adDao.remove(forDel);//удалить из базы
        currAd = forDel;//выставить текущее в удаляемое
        JsfUtil.addSuccessMessage("Замер давления удалён");
        refresh();
      return null;
    }


    public String delPuls(PsgAttrPulls forDel){
        pullsDao.remove(forDel);//удалить из базы
        currPulls = forDel;//выставить текущее в удаляемое
        JsfUtil.addSuccessMessage("Замер пульса удалён");
        refresh();
      return null;
    }

    
    public String delEcg(PsgAttrEcg forDel){
        ecgDao.remove(forDel);//удалить из базы
        currEcg = forDel;//выставить текущее в удаляемое
        JsfUtil.addSuccessMessage("Замер ЕКГ удалён");
        refresh();
      return null;
    }

    public String delApnoe(PsgAttrApnoe forDel){
        apnoeDao.remove(forDel);//удалить из базы
        currApnoe = forDel;//выставить текущее в удаляемое
        JsfUtil.addSuccessMessage("Замер Апное удалён");
        refresh();
      return null;
    }


    public String delSp02(PsgAttrSpO2 forDel){
        spO2Dao.remove(forDel);//удалить из базы
        currSpO2 = forDel;//выставить текущее в удаляемое
        JsfUtil.addSuccessMessage("Замер SpO2 удалён");
        refresh();
      return null;
    }

    public String delSnoring(PsgAttrSnoring forDel){
        snoringDao.remove(forDel);//удалить из базы
        currSnoring = forDel;//выставить текущее в удаляемое
        JsfUtil.addSuccessMessage("Замер храпа удалён");
        refresh();
      return null;
    }

    public String delToiletWake(PsgAttrToiletWake forDel){
        toiletWakeDao.remove(forDel);//удалить из базы
        currToiletWake = forDel;//выставить текущее в удаляемое
        JsfUtil.addSuccessMessage("Поход в туалет удалён");
        refresh();
      return null;
    }

    public String delDetTune(PsgAttrDetectorTune forDel){
        detTuneDao.remove(forDel);//удалить из базы
        currDetTune = forDel;//выставить текущее в удаляемое
        JsfUtil.addSuccessMessage("Правка детектора удалена");
        refresh();
      return null;
    }

    
   public String addSnoring(){
     //нормализовать время
       currSnoring.setBeginTime(convPsgTime(currSnoring.getBeginTime()));
       currSnoring.setEndTime(convPsgTime(currSnoring.getEndTime()));
     //проверить время - время начала должно быть больше чем время окончания
       if(currSnoring.getEndTime().before(currSnoring.getBeginTime())){
           JsfUtil.addErrorMessage("Время начала храпа должно быть раньше, чем время окончания!");
        return null;  
       }
       currSnoring.setPsgId(curr);//выставить ссылку на текущее ПСГ
        snoringDao.create(currSnoring);
        currSnoring = new PsgAttrSnoring();//новый замер пульса
        currSnoring.setBeginTime(new Date());//выставить текущее время в новом замере
        currSnoring.setEndTime(new Date());//выставить текущее время в новом замере
        JsfUtil.addSuccessMessage("Храп добавлен");
       refresh();
     return null;  
    }

    public String addSpO2(){
     //нормализовать время
       currSpO2.setMeasuringTime(convPsgTime(currSpO2.getMeasuringTime()));
       currSpO2.setPsgId(curr);//выставить ссылку на текущее ПСГ
        spO2Dao.create(currSpO2);
        currSpO2 = new PsgAttrSpO2();//новый замер пульса
        currSpO2.setMeasuringTime(new Date());//выставить текущее время в новом замере
        JsfUtil.addSuccessMessage("Замер Sp02 добавлен");
       refresh();
     return null;  
    }
    
    public String addApnoe(){
     //нормализовать время 
       currApnoe.setBeginTime(convPsgTime(currApnoe.getBeginTime()) );
       currApnoe.setPsgId(curr);//выставить ссылку на текущее ПСГ
        apnoeDao.create(currApnoe);
         currApnoe = new PsgAttrApnoe();//новый замер пульса
          currApnoe.setBeginTime(new Date());//выставить текущее время в новом замере
        JsfUtil.addSuccessMessage("Замер апное добавлен");
       refresh();
     return null;  
    }
    
    
    /**
     * Завершить текущее ПСГ
     * @return 
     */
    public String commitPsg(){
        //запросить подтверждение - правда ли юзер хочет закрыть?
        
        //проверить правильность
        
       //проапдейтить пациента
        curr.getPatientId().setCurHeight(curr.getCurrentHeight());
        curr.getPatientId().setCurWeight(curr.getCurrentWeigth());
        curr.getPatientId().setLastPsgDate(curr.getPsgDate());
       //проапдейтить ПСГ
        curr.setIsDone(true);
        psgDao.edit(curr);//сохранить правки пгс в базе
        patientDao.edit(curr.getPatientId());//сохранить правки пациента в базе
       //перенаправить на профиль юзера 
        patientProfile.setCurrent(curr.getPatientId());
//       patientProfile.refreshFromDb();//перечитать пациента из базы
        
        patientTableBean.refresh();//перечитать список пациентов - в тупую
        
      return "patient_profile.xhtml?faces-redirect=true&id="+curr.getPatientId().getId()+"&tabId=1";
    }
  
    public String addToiletWalk(){
       //нормализовать время 
       currToiletWake.setMeasuringTime(convPsgTime(currToiletWake.getMeasuringTime()));
       currToiletWake.setPsgId(curr);//выставить ссылку на текущее ПСГ
        toiletWakeDao.create(currToiletWake);
        currToiletWake = new PsgAttrToiletWake();//новый поход в туалет
        currToiletWake.setMeasuringTime(new Date());
        JsfUtil.addSuccessMessage("Поход в туалет добавлен");
       refresh();
     return null;  
    }
    
    public String addDetectorTune(){
       //нормализовать время
       currDetTune.setMeasuringTime(convPsgTime(currDetTune.getMeasuringTime()));
       currDetTune.setPsgId(curr);//выставить ссылку на текущее ПСГ
        detTuneDao.create(currDetTune);
        currDetTune = new PsgAttrDetectorTune();//новая правка датчиков
        currDetTune.setMeasuringTime(new Date());
        JsfUtil.addSuccessMessage("Правка детектора добавлена");
       refresh();
     return null;  
    }
    
    //--------------------------------------------------------------------
    
    /**
     * Выбран ли тип CPAP - сомновент?
     * @return 
     */
    public boolean isSomnoVentSelected(){
        if(curr!=null && curr.getCpapTypeId()!=null){
            if(curr.getCpapTypeId().getCode().indexOf("Vent")>0 ){
                return true;
            }
        }
            
      return false;  
    }
    

    /**
     * Выбран ли тип CPAP - Сомнобаланс?
     * @return 
     */
    public boolean isSomnoBalanceSelected(){
        if(curr!=null && curr.getCpapTypeId()!=null){
            if(curr.getCpapTypeId().getCode().indexOf("Balance")>0 ){
                return true;
            }
        }
            
      return false;  
    }
    
    
    /**
     * Сохранить поля экранной формы в ПСГ
     * @return 
     */
    public String save(){
     //проверить наличие прав
     if(curr.getIsDone()&&!login.isAdmin()){
       JsfUtil.addErrorMessage("Вы не имеете права править завершенное ПСГ!");
      return null;   
     }   
     //нормализовать все временные поля!   
     normalizeTime();  
    boolean failed=true;
     try{
      psgDao.edit(curr);
       failed=false;
     }catch(Exception e){
       failed=true;  
        JsfUtil.addErrorMessage(e, "Ошибка при сохранении в базе");
     }
      if(!failed)
          JsfUtil.addSuccessMessage("Cохранено в базе");
       
      return null;  
      
    }
    
    /**
     * нормализация в текущем ПСГ всех временных полей,
     * относительно времени начала ПСГ
     */
    private void normalizeTime(){
        //
     curr.setDetectorOnTime(convPsgTime(curr.getDetectorOnTime()));
     curr.setGoToSleepTime(convPsgTime(curr.getGoToSleepTime()));
     curr.setLightOffTime(convPsgTime(curr.getLightOffTime()));
     curr.setCpapBeginTime(convPsgTime(curr.getCpapBeginTime()));
     curr.setOxymatBeginTime(convPsgTime( curr.getOxymatBeginTime()));
     curr.setWakeUpTime(convPsgTime(curr.getWakeUpTime()));
    }
    
    /**
     * Загрузить указанную ПСГ
     * @param id 
     */
    public void loadPsgById(long id){
      curr = psgDao.find(id);
    }
    
    /**
     * Получить кол-во секунд, которые прошли от начала суток
     * @param t
     * @return кол-во секунд, которое прошло от начала суток
     */
    private int getSecOffs(Date t){
//      System.out.println("getSecOffs:input date:"+t);
      
//извлечь из даты временные компоненты
        Calendar cal = new GregorianCalendar();
        cal.setTimeZone(TimeZone.getTimeZone("GMT"));
        cal.setTimeInMillis(t.getTime());
        
        
        int HH = cal.get(Calendar.HOUR_OF_DAY);
        int mm = cal.get(Calendar.MINUTE);
        int ss = cal.get(Calendar.SECOND);
/*
        int HH =  t.getHours();// cal.get(Calendar.HOUR);
        int mm = t.getMinutes();// cal.get(Calendar.MINUTE);
        int ss = t.getSeconds();// cal.get(Calendar.SECOND);
        */
//      System.out.println("getSecOffs:parsed :"+HH+":"+mm+":"+ss);
        
        //определить смещение от начала суток
        int dayBegOffs = HH*60*60+mm*60+ss;//смещение времени от начала суток
//      System.out.println("getSecOffs:result :"+dayBegOffs+":"+new Date(dayBegOffs));
       return  dayBegOffs;
    }
    
    /**
     * Трансформирует введённое юзеров время в корректную время-дату, относительо базового дня
     * Предполагается, что события от базового времени до полуночи произошли в базовом дне, с получночи до базового времени - в следующем дне
     * @param t
     * @return 
     */
    public Date tranlateTime(Date t, Date baseDate){
//       System.out.println("tranlateTime:input date:"+t+",baseDate:"+baseDate);
       int ofs = getSecOffs(t);//смещение от начала суток для указанного момента времени
       int baseDaySecOfs = getSecOffs(baseDate);//смещение базового времени от начала суток
       long baseDayBeginMillis = baseDate.getTime()-baseDaySecOfs*1000;//момент начала базового дня
       int currDayBorder = baseDaySecOfs;//17*60*60;//смещение от начала суток до полудня - это граница текущего дня
       
       long resMillis=baseDayBeginMillis+ofs*1000;//добавить к базовой дате время
       
//       System.out.println("tranlateTime:date before path:"+new Date(resMillis));
       if(ofs < currDayBorder){//если время от 00:00 до 11:59 - значит это уже след день
        resMillis = resMillis + 24*60*60*1000;//добавить к результату день
//       System.out.println("tranlateTime:date after patch:"+new Date(resMillis));
       }
       return new Date(resMillis);
    }
    
    /**
     * Транслирует время события относительно даты текущего ПСГ
     * @return 
     */
    public Date convPsgTime(Date t){
       if(t!=null){ 
        return tranlateTime(t,curr.getPsgDate());  
       }
     return null;  
    }
    
    /**
     * Отрыть для правки текущее ПСГ, это сделать может только админ
     * @return 
     */
    public String openPsg(){
       if(login.isAdmin()){//если текущий юзер - админ, тогда разрешить правку текущего ПСГ
          curr.setIsDone(false);
            psgDao.edit(curr);
             JsfUtil.addSuccessMessage("ПСГ открыто для правок");
       }else{
          JsfUtil.addErrorMessage("У вас нет прав, чтоб открыть ПСГ для правки");
       }
        return null;
    }
    
    /**
     * Создать результат ПСГ
     */
    public void createResult(){
        PsgResult res = new PsgResult();
         res.setPsg(curr);
           curr.setPsgResult(res);
            save();//сохранить в базу  
             refresh();//обновить ПСГ из базы
    }
    
}
