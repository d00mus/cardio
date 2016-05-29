/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view_beans;

import ctrl.util.JsfUtil;
import dao.PatientCallFacade;
import dao.PatientFacade;
import dao.PsgFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import mdl.Cabinet;
import mdl.Patient;
import mdl.PatientCall;
import mdl.PatientPhone;
import mdl.Psg;

/**
 *
 * @author d00mus
 */
@SessionScoped
@Named("patientProfileBean")
public class PatientProfileBean implements Serializable{

 @EJB
 private PatientFacade patientDao;
 

 private Patient current=null;//пациент, анкета которого просматривается в текущий момент
  
 private Integer tabId=0;//текущая, просматриваемая вкладка
 
 @EJB
 private PsgFacade psgDao;
 
 private Psg curPsg=null;//текущее ПСГ юзера
 
 //------------------
 @Inject
 private PsgBean psgBean;
 
 //------------------
 @Inject
 private LoginBean login;
 //------------------
 
 private Cabinet newPsgCab;
 
 //------------------
 @EJB
 private PatientCallFacade callDao;
 
 private PatientCall currCall=null;//текущий звонок пациенту
 
 @Inject
 private CallBean callBean;
 //------------------
 
  
 /**
  * Найти и загрузить анкету пациента с указанным ID
  * @param id 
  */
 public void setCurrentById(long id){
     current = patientDao.find(id);
     refreshFromDb();
 }   

    public Patient getCurrent() {
        return current;
    }

    public void setCurrent(Patient current) {
        this.current = current;
        refreshFromDb();//перечитать данные из базы данных
    }

    public Integer getTabId() {
        return tabId;
    }

    public void setTabId(Integer tabId) {
        this.tabId = tabId;
    }

    public Psg getCurPsg() {
        return curPsg;
    }

    public void setCurPsg(Psg curPsg) {
        this.curPsg = curPsg;
    }
  
    
    /**
     * Проверить у текущего пациента наличие текущего ПСГ(не закрытого)
     * @return true, если есть текущее, незаверщённое ПСГ
     */
    public boolean isCurrPsgExist(){
        return getCurrentPsg()!=null;
    }

    /**
     * Получить текущее ПСГ пациента, если оно есть
     * @return 
     */
    public Psg getCurrentPsg(){
      if(current==null)return null; 
      //вернуть первое незакоченное ПСГ
      for(Psg psg:current.getPsgList()){
        if(psg.getIsDone()!=true){
            return psg;
        }  
      }
      return null;  
    }
    
    
    private void refresh(Patient p){
      p = patientDao.refresh(p.getId());  
    }
    
    /**
     * Получить номер нового ПСГ
     * @return 
     */
    private short getNewPsgNo(){
      return (short) (current.getPsgList().size()+1);
    }
    /**
     * Создать новое ПСГ
     * @return 
     */
    public String createPsg(){
        
        current = patientDao.refresh(current.getId());//обновить дело пациента, перед созданием
        
       if(isCurrPsgExist()){//проверить наличие текущего ПСГ
           JsfUtil.addErrorMessage("Нельзя создать новое ПСГ, пока не закрыто текущее");
        return null;   
       }
       
       curPsg = new Psg();
       curPsg.setPsgNo(getNewPsgNo());
       
       curPsg.setPatientId(current);
       
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY)+2);//тупо пофиксить
        
        Date psgDate = c.getTime();
        System.out.println("psgDate = "+psgDate);
       
       curPsg.setPsgDate(psgDate);// что-то тут не то, с датой..
       
       curPsg.setCabinetId(newPsgCab);
       
       curPsg.setNurseId(login.getCurrentUser());//выставить текущего юзера
       //лажа
       curPsg.setCurrentHeight(BigDecimal.ZERO);
       curPsg.setCurrentWeigth(BigDecimal.ZERO);
       curPsg.setIsDone(false);
       //лажа        
       psgDao.create(curPsg);
       //инициализировать бин ПСГ
       psgBean.setCurr(curPsg);
       
       //обновить
       refresh(current);
       current.getPsgList();
       
       
       return "psg_view.xhtml?faces-redirect=true&psgId="+curPsg.getId();
    }
 
    
    /**
     * Удаление ПСГ(для админов)
     * @param forDel
     */
    public void delPsg(Psg forDel){
        //проверить права доступа
      if(!login.isAdmin()) {
           JsfUtil.addErrorMessage("Удалять ПСГ может только админ");
        return;   
      }
      
      try{
      psgDao.remove(forDel);
      }catch(Exception e){
        JsfUtil.addErrorMessage(e,"Не удалось удалить ПГС");
       return;   
      }
      
     current.getPsgList().remove(forDel);//удалить из экранного списка удалённое ПСГ
      
       //обновить
       refresh(current);
       current.getPsgList();
       
     JsfUtil.addSuccessMessage("ПГС удалено");
   }
    
    
   /**
    * Выставить порядок ПСГ согласно их дат
    */ 
   public void fixPsgOrder(){
 
       Comparator<Psg> cmp = new Comparator<Psg>(){

           @Override
           public int compare(Psg o1, Psg o2) {
              return o1.getPsgDate().compareTo(o2.getPsgDate());
           }
           
       };
       //отсортировать список ПГС по возрастанию дат               
       Collections.sort(current.getPsgList(), cmp);
       
       //переназначить номера
       short psgNo=1;
       for(Psg p:current.getPsgList()){
           p.setPsgNo(psgNo);
         psgNo++;  
       }
       
     patientDao.edit(current);//сохранить модификации в пациенте
     
     JsfUtil.addSuccessMessage("ПГС перенумерованы по датам");
       
   } 
    
    
    /**
     * Переход к указанному ПСГ
     * @param psgId
     * @return 
     */
   public String goToPsg(long psgId){
       
       curPsg = psgDao.find(psgId);
       psgBean.setCurr(curPsg);//выставить текущее ПСГ в бине
       
//       System.out.println("goToPsg called! psgBean.curr.date = "+psgBean.getCurr().getPsgDate());
       
       return "psg_view.xhtml?faces-redirect=true&psgId="+psgId;
   } 
    
   
   /**
    * Создать новый звонок данному пациенту(переход на страницу звонка)
    * @return 
    */
   public String createNewCall(PatientPhone phone){
        refresh(current);
        
        currCall = new PatientCall();
        
        //выставить параметры звонка
        currCall.setPatientId(current);
        currCall.setNurseId(login.getCurrentUser());
        currCall.setCallDate(new Date());
        currCall.setPhoneId(phone);//выставить телефон, по которому звоним
        
        callBean.setCurrent(currCall);
        
//        callDao.create(currCall);//надо ли это тут?? TODO!! (чтоб не удалять)
/*       
         //обновить
         current = patientDao.refresh(current);
         current.getPsgList();
  */  
    //редирект на страницу звонка   
           callBean.setViewOnly(false);
     return "patient_call?faces-redirect=true";
   }

   /**
    * Переход на страницу звонка в режиме просмотра
    * @param selectedCall
    * @return 
    */
    public String viewCall(PatientCall selectedCall){
        System.out.println("viewCall():"+selectedCall.getId());
        //определить нужный звонок по айди
        /*
        for(PatientCall c:current.getPatientCallList()){
            if(c.getId().equals(callId)){
                
            }
        }
        */
         currCall = selectedCall;
         callBean.setCurrent(currCall);
         callBean.setViewOnly(true);
        return "patient_call?faces-redirect=true";
    }
   
   
   /**
    * Перечитать из базы инфу по текущему пациенту
    */
   public String refreshFromDb(){
       if(current!=null)
        refresh(current);
       
     return "patient_profile.xhtml?id="+current.getId()+"&tabId="+tabId+"&faces-redirect=true";
   }

    public Cabinet getNewPsgCab() {
        return newPsgCab;
    }

    public void setNewPsgCab(Cabinet newPsgCab) {
        this.newPsgCab = newPsgCab;
    }
    
    /**
     * Перенаправление на печать
     * @return 
     */
    public String printCurProfile(){
        
      return "../../webresources/report/patient/#{patientProfileBean.current.id}&faces-redirect=true";
    }

    
}
