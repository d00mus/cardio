/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view_beans;

import ctrl.util.JsfUtil;
import dao.PatientFacade;
import dao.UaStateFacade;
import dao.UaTownFacade;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import mdl.Contacts;
import mdl.DbGenderEnum;
import mdl.Patient;
import mdl.PatientPhone;
import mdl.PatientPhoto;
import mdl.RefInfoSourceType;
import mdl.UaState;
import mdl.UaTown;
import org.primefaces.component.fileupload.FileUpload;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import viewModel.PartnerEmployeVM;

/**
 *
 * @author d00mus
 */
@SessionScoped
@Named("patientEditBean")
public class PatientEditBean implements Serializable{
    
   //текущий пациент, которого редактируем
    private Patient current;
    
    @Inject
    private LoginBean login;
    
    private boolean doCreateNew=true;//признак создания нового пациента
    
    //страница, на которую нужно вернуться после создания/правки
    private String returnPage;
    
    @EJB private PatientFacade dao;  
    
    @EJB private UaStateFacade stateDao;
    
    @EJB private UaTownFacade townDao;
    
    private List<UaTown> uaTowns;
    
    private List<UaState> uaStates;
    
   //Добавляемый телефон
    private PatientPhone newPhone = new PatientPhone();
    
    //Тип адреса - UKR(украинский) или не UKR - прочие страны
    private String adrType="UKR";
    
    ISimpleCallBack client;//заказчик правки, его будем уведомлять
    
    
        
    @PostConstruct
    private void init(){
      uaStates = stateDao.findAll();//найти все области усраины
      uaTowns = townDao.findAll();//найти все города усраины
    }

    /**
     * Очистка всех полей текущего контрагента
     */
     public void clean(){
     current = prepareNew();
      doCreateNew = true;

    }

    
    /**
     * Создаём нового пациента
     * @param client заказчик создания нового пациента
     */    
    public void createNew(ISimpleCallBack client){
     current = prepareNew();
      doCreateNew = true;
      this.client = client; 
    }
    
    /**
     * Редактируем существующего пациента
     * @param edited - редактируемый пациент
     * @param client заказчик правки пациента
     */
    public void edit(Patient edited,ISimpleCallBack client){
      if(edited!=null){  
       current = edited;
        doCreateNew = false;
         prepareEdit();
      }else{ current = new Patient();
             doCreateNew = true;
            }
      this.client = client;

    }
    
    public Patient getCurrent() {
        return current;
    }

    /*
    public void setCurrent(Patient current) {
        this.current = current;
    }
  */
    /**
    * Проверить поля текущего поциента перед сохранением в базу
    * TODO:добавить проверки!
    */
    private void checkPreSave(){
    
    }
    
    public String update(){
        dao.edit(current);
        if(client!=null){
            client.callBack();//уведомить клиента о том, что пациент поменялся
        }
      return null;  
    }


 /**
  * Сохранить пациента в базе
  * @return 
  */    
    public String save() {
        
        checkPreSave();//Проверить поца на валидность/логичность
        //Донастроить необходимые поля, если создание нового
        PatientPhoto ava=null;
        
        //запомнить ссылки на телефоны родственника и супруга
        PatientPhone partPhone = current.getPartnerPhoneId();
        PatientPhone famPhone = current.getFamMemberPhoneId();
        
        
        //почистить ссылки на телефоны родственника и супруга
         current.setPartnerPhoneId(null);
         current.setFamMemberPhoneId(null);
        
          ava = current.getAvatarId();//получить аву 
           current.setAvatarId(null);//отвязать аву, чтоб не цеплялась автоматом
           
        if(doCreateNew){//если идёт создание нового пациента
             Contacts cts = new Contacts();
              current.setContactsId(cts);
        }
        
        try {
            if(doCreateNew){//если идёт создание нового пациента
              dao.create(current);//создать пациента
              
               //подвязать обратную ссылку на аву
                 ava.setPatientId(current);//подвязать ему аву
                 current.setAvatarId(ava);//связать аву с поцом
            
            //подвязать телефоны членов семьи
            current.setPartnerPhoneId(partPhone);
            current.setFamMemberPhoneId(famPhone);
            
            dao.edit(current);//поправить поца с обратными ссылками
            JsfUtil.addSuccessMessage("Пациент успешно создан");
            doCreateNew=false;//отключить режим создания
            }else{//если идёт правка существующего пациента
                
              dao.edit(current);//поправить пациента без ссылок
              current = dao.refresh(current.getId());//обновить
              //найти телефоны
              if(partPhone!=null || famPhone!=null){
                  for(PatientPhone pp:current.getPatientPhoneList()){
             //подвязать телефоны членов семьи
                     if(partPhone!=null && pp.getPhoneRaw().equals(partPhone.getPhoneRaw())){
                         current.setPartnerPhoneId(pp);
                     } 
                     
                     if(famPhone!=null && pp.getPhoneRaw().equals(famPhone.getPhoneRaw())){
                         current.setFamMemberPhoneId(pp);
                     } 
                  }
              }
             
             ava.setPatientId(current);//подвязать ему аву
             current.setAvatarId(ava);//связать аву с поцом
                   
              dao.edit(current);//поправить пациента
             
              JsfUtil.addSuccessMessage("Пациент успешно поправлен");
                
            }
            
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "Ошибка при создании/правке пациента");
           e.printStackTrace();
        }
        
        if(doCreateNew){
             refresh();//перечитать пациента из базы
        }
        
        if(client!=null){
            client.callBack();//уведомить клиента о том, что пациент поменялся
        }

        if(returnPage!=null){//возрат на исходную страницу
            return returnPage;
        }
        
        return null;
    }
    

    public List<UaState> getUaStates() {
        return uaStates;
    }

    
    public void setUaStates(List<UaState> uaStates) {
        this.uaStates = uaStates;
    }

    public List<UaTown> getUaTowns() {
        return uaTowns;
    }

    public void setUaTowns(List<UaTown> uaTowns) {
        this.uaTowns = uaTowns;
    }

    /**
     * Метод для автокомплита областей
     * @param query
     * @return 
     */
    public List<UaState> stateAutoComplete(String query){
        
            List<UaState> stateSuggestion = new ArrayList<UaState>();
            int i=0;
            for (UaState t : uaStates) {
                if (t.getRusName().toLowerCase().indexOf(query.toLowerCase()) >= 0) {
                    stateSuggestion.add(t);
                 i++;
                }
             if(i>30) break;  
            }
       return stateSuggestion;
    }
    

    /**
     * Метод для автокомплита городов
     * @param query
     * @return 
     */
    public List<UaTown> townAutoComplete(String query){
/*        
         boolean useState=false;//использовать ограничение по области?
         Integer curStateId=null;
         if(current.getAdrUaStateId()!=null){
             useState=true;
             curStateId = current.getAdrUaStateId().getId();
         }
             
         useState = false;//TODO: пока не используем ограничение по области!!
  */       
            List<UaTown> townSuggestion = new ArrayList<UaTown>();
            int i=0;
            for (UaTown t : uaTowns) {
                if (t.getUkrName().toLowerCase().indexOf(query.toLowerCase()) >= 0){
/*                    
                     &&(!useState ||(curStateId == t.getStateId().getId()))     
                        ) {
*/                
                    townSuggestion.add(t);
                 i++;
                }
             if(i>50) break;  
            }
            return townSuggestion;
    }
  

    /**
     * Автокомплит для ввода рабочего города
     * @param query
     * @return 
     */
    public List<UaTown> wkTownAutoComplete(String query){
             
            List<UaTown> townSuggestion = new ArrayList<UaTown>();
            int i=0;
            for (UaTown t : uaTowns) {
                if (t.getUkrName().toLowerCase().indexOf(query.toLowerCase()) >= 0){
                    townSuggestion.add(t);
                 i++;
                }
             if(i>50) break;  
            }
            return townSuggestion;
    }
    
    /*
    private DbGenderEnum sexLst=DbGenderEnum.F;
    public DbGenderEnum getSexLst() {
    return sexLst;
    }
     */
    public PatientPhone getNewPhone() {
        return newPhone;
    }

    public void setNewPhone(PatientPhone newPhone) {
        this.newPhone = newPhone;
    }
    
    
    
    /**
     * Добавить новый телефон пациенту
     */
   public void addPhone(){
       if(newPhone == null)return;//на всякий случай
       String newPhoneNum = newPhone.getPhoneRaw();
      //проверить телефон на пустоту 
       if(newPhoneNum == null ||newPhoneNum.trim().isEmpty()){
            JsfUtil.addErrorMessage("Новый телефон пуст, номер не добавлен");
           return;
       }
     //попробовать найти такой телефон в списке
      for(PatientPhone pp:current.getPatientPhoneList()) {
         if(newPhoneNum.equals(pp.getPhoneRaw())){//если такой телефон уже есть у этого поца
            JsfUtil.addErrorMessage("Такой номер уже есть");
             return;
         } 
      }
       
     newPhone.setPatientId(current);
     current.getPatientPhoneList().add(newPhone);
     newPhone = new PatientPhone();
    JsfUtil.addSuccessMessage("Номер телефона добавлен");
   } 
   
   /**
    * Удалить телефон предприятия
     * @param pp
    */
   public void delPhone(PatientPhone pp){
     current.getPatientPhoneList().remove(pp);//удалить указанный телефон из списка
     pp.setPatientId(null);//убрать ссылку на поца
     //Выставить удаляемый телефон текущим
     newPhone = pp;//
    JsfUtil.addSuccessMessage("Телефон удалён");
   }

    /**
     * Обработчик загрузки фоток
     * @param event
     */
    public void avatarListener(FileUploadEvent event) { 
        UploadedFile file = event.getFile();
         setNewAvatar(file);
             FacesMessage msg = new FacesMessage("Файл "+file.getFileName() + " загружен на сервер");  
               FacesContext.getCurrentInstance().addMessage(null, msg);  
    }      


/**
 * Выставить текущему юзеру аватар из загруженного файла
 */
private void setNewAvatar(UploadedFile f){
            if(current.getAvatarId() == null){//если нет текущего аватара, тогда создать новую фотку
              PatientPhoto ph = new PatientPhoto();
              ph.setPatientId(current);//связать аву с поцом
              current.setAvatarId(ph);
            }
         current.getAvatarId().setFileName(f.getFileName());//обновить имя файла
         
       //обновить содержимое фотки
         byte []fileContent = new byte[(int)f.getSize()];   
        try {
            int rb = f.getInputstream().read(fileContent);
        } catch (IOException ex) {
            //TODO:добавить обработку ошибки чтения
            Logger.getLogger(PatientEditBean.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
        }
       current.getAvatarId().setFileData(fileContent);
      current.getAvatarId().setUploadDate(new Date());
 }
/**
 * Источник информации - доктор? 
 * @return 
 */
 public boolean isRefSourceIsDoc(){
     System.out.println("isRefSourceIsDoc:current="+current);
     
  RefInfoSourceType ref = getCurrent().getRefInfoSrcTypeId();
   return ref!=null && "DOC".equals(ref.getCode());    
 }
 
/**
 * Источник информации - пациент?
 * @return 
 */
 public boolean isRefSourceIsPat(){
  RefInfoSourceType ref = getCurrent().getRefInfoSrcTypeId();
   return ref!=null && "PATIENT".equals(ref.getCode());    
 }

    /**
     * Получить тип адреса - в Украине он или нет
     * @return 
     */
    public String getAdrType() {
        return adrType;
    }

    public void setAdrType(String adrType) {
        this.adrType = adrType;
        if("UKR".equals(adrType)){//если выбран тип адреса в Украине - автоматически её подставить
            current.setAdrCountry("Украина");
        }else{
            current.setAdrCountry("...");
            current.setAdrUaStateId(null);
            current.setAdrUaTownId(null);
            current.setWorkUaTownId(null);
        }
    }
 
    /**
     * Какой тип адреса используется для ввода
     * @return 
     */
    public boolean isUkrAddress(){
       return "UKR".equals(adrType);
    }
    
    /**
     * Подготовка пациента для правки, обработки
     */
    private void prepareEdit(){
        if(current.getAvatarId()==null){
            PatientPhoto ava = new PatientPhoto();
             ava.setPatientId(current);
              current.setAvatarId(ava);
        }
        
    }
   
    private Patient prepareNew() {
        Patient p = new Patient();
        p.setBirthDate(new Date());
        p.setCreatedByUserId(login.getCurrentUser());
        p.setCreateDate(new Date());
        p.setIsActive(true);
        p.setIsChecked(false);
        p.setIsFotoAdsAllowed(false);
        p.setIsInterest(false);
        p.setIsTvAdsAllowed(false);
        p.setIsOtherAdsAllowed(false);
        p.setSex(DbGenderEnum.M);
        p.setAvatarId(new PatientPhoto());
        p.setIsLorInvasion(false);
        p.setIsCertGiven(false);
        return p;
    }

    
    public String getReturnPage() {
        return returnPage;
    }

    public void setReturnPage(String returnPage) {
        this.returnPage = returnPage;
    }

    public boolean isDoCreateNew() {
        return doCreateNew;
    }

    public void setDoCreateNew(boolean doCreateNew) {
        this.doCreateNew = doCreateNew;
    }
    
    /**
     * Перечитать данные по текущему пациенту из базы
     */
    public void refresh(){
        if(!doCreateNew){
           current = dao.refresh(current.getId());
        }
    }
    
    /**
     * Заголовок страницы
     * @return 
     */
    public String pageCaption(){
        if(doCreateNew){
            return "Создать нового пациента";
        }else{
            return "Правка пациента №"+current.getId();
        }
        
    }
    
}
