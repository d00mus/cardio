/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viewModel;

import ctrl.util.JsfUtil;
import dao.PartnerEmployeFacade;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import mdl.CardioPartner;
import mdl.PartnerEmploye;
import mdl.PartnerEmployePhone;
import mdl.PartnerEvent;
import mdl.PartnerEventAttrs;
import view_beans.LoginBean;
import view_beans.PartnerEventDataModel;

/**
 * Вью-модель для работы с сотрудниками
 * @author d00mus
 */

@SessionScoped
@Named("partnerEmployeVM")
public class PartnerEmployeVM implements Serializable{
  
  private static String C_MANAGER_ROLE = "MANAGER";
    
  private static final String C_VIEW_INFO_CAPTION="Просмотр информации о выбранном сотруднике";
  private static final String C_ADD_NEW_CAPTION="Добавить нового сотрудника";
  
  //режим добавления нового сотрудника(а не просмотра существующего)
  private boolean newEmploye=false;
  
  
  private PartnerEmploye defaultEmpl = new PartnerEmploye();
  private PartnerEmployePhone defalultPhone = new PartnerEmployePhone();
  
  private PartnerEvent defaultEvent = new PartnerEvent();
  
  
  //TODO:по лоховски телефоны сотрудников!
  private PartnerEmployePhone newPhone = new PartnerEmployePhone();
  
  
  //поддержка выделения строк в событиях
  private PartnerEventDataModel eventDataModel;
    
  //выбранная строка с событием
  private PartnerEvent selectedEventRow;//чтоб не было нулл поинтер..
  
 //=======поддержка фильтра по событиям=========
    //список отфильтрованнных событий
    private List<PartnerEvent> filteredEvents;
    
    private String fltEventLabel;
    
    private String fltEventUser;
    
    private String fltEventSubj;
    
    private String fltEventType;  
    
    private boolean newEventMode=true;//режим создания нового события
//=====================================    
  
    @Inject
    private LoginBean loginBean;
    
     
    
  
  
    public PartnerEmployeVM(){
      defaultEmpl.setFirstName("выберите сотрудника");
      defaultEmpl.setLastName("или создайте нового");
      current = defaultEmpl;    
      currPhone = defalultPhone;
      
      viewCaption=C_VIEW_INFO_CAPTION;
      defaultEvent.setAttrs(new PartnerEventAttrs(defaultEvent));
      selectedEventRow = defaultEvent;
    }
    
    /**
     * Признак того, что текущий сотрудник - ещё не сохранён в базу
     */
    private boolean currIsNew=false;
    
    /**
     * При сохранении текущих модификаций в базу
     */
    public void onPersist(){
        
    }
    
    /**
     * При обновлении данных из базы
     */
    public void onRefresh(){
        
    }
    /**
     * Текущий сотрудник, который выбран
     */
    private PartnerEmploye current;
    
        
    /**
     * Текущий, выбранный телефон сотрудника
     */
    private PartnerEmployePhone currPhone;
    
    /**
     * Признак того, что текущий телефон ещё не добавлен в базу
     */
    private boolean phoneIsNew=false;
    
   
    /**
     * Начать создание нового сотрудника
     * @return 
     */
    public void startCreateNew(CardioPartner partner){
        startCreateNew();
       current.setPartner(partner);//связать с текущим сотрудником
    }
    
    public void startCreateNew() {
       currPhone = defalultPhone;
       current = new PartnerEmploye();
       eventDataModel = new PartnerEventDataModel(current.getPartnerEventList());
       viewCaption=C_ADD_NEW_CAPTION;
      currIsNew = true;
      phoneIsNew = true;
      selectedEventRow = defaultEvent;
      
      
    }
    
    
    /**
     * Добавить нового сотрудника
     */
    public void endCreateNew(){
      if(!defaultEmpl.equals(current)) {
       current.getPartner().getPartnerEmployeList().add(current);
        current = defaultEmpl;
         currIsNew = false;//TODO:нах мне 2 флага??
         newEmploye = false;
          phoneIsNew = false;
           currPhone = defalultPhone;
         FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Сотрудник добавлен","Добавлен");  
      FacesContext.getCurrentInstance().addMessage(null, msg);  
      }else{
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Сотрудник не добавлен","Внутренняя ошибка!");  
       FacesContext.getCurrentInstance().addMessage(null, msg);  
      }
    }
    
    
    /**
     * Конец редактирования сотрудника
     */
    public void endEdit(){
       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Сотрудник обновлён","Поправлено");  
      FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
    /**
     * Удалить указанного сотрудника
     * @param forDel 
     */
    public void delEmploye(PartnerEmploye forDel){
       current = forDel;
         boolean remove = current.getPartner().getPartnerEmployeList().remove(forDel);
         if(!remove){
             FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Сотрудник не удалён","Ошибка!");  
             FacesContext.getCurrentInstance().addMessage(null, msg);  
          return;   
         }
        currIsNew = true;
        currPhone = defalultPhone;
        phoneIsNew = true;
        viewCaption = C_ADD_NEW_CAPTION;
       //сообщить      
       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Сотрудник удалён","Удален");  
     FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
    
    
    /**
     * Начать создание нового телефона для текущего сотрудника
     */
    public void createNewPhone(){
       phoneIsNew = true;
       
       currPhone = new PartnerEmployePhone();
      currPhone.setEmploye(current);
    }
    
    
    /**
     * Завершить создание нового телефона для текущего сотрудника
     */
    public void endCreateNewPhone(){
      if(phoneIsNew)  
          current.getPartnerEmployePhoneList().add(currPhone);
    }
    

    /**
     *Удалить указанный телефон 
     * @param forDel - удаляемый телефон
     */    
    public void delPhone(PartnerEmployePhone forDel){
     if(forDel!=null){//если удаляем не null
         if(forDel.getEmploye().equals(current)){//и если удаляемый телефон касается текущего партнёра
             current.getPartnerEmployePhoneList().remove(forDel);
             phoneIsNew=true;
//             currPhone=forDel;
//             forDel.setEmploye(null);
             newPhone = forDel;//TODO:по лоховски
             FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Телефон удалён","Удалено");  
           FacesContext.getCurrentInstance().addMessage(null, msg);  
         }
     }
    }
   
    /**
     * Заголовок режима правки сотрудников
     */
   private String viewCaption;

   
/**
 * TODO:телефоны по лоховски!!
 */   
    public void addPhone(){
       newPhone.setEmploye(current);
        current.getPartnerEmployePhoneList().add(newPhone);
         newPhone = new PartnerEmployePhone();
       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Телефон добавлен","Добавлен");  
     FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
//------------------------------------------------------------------------------------------    
    
    /**
     * Сброс фильтра событий
     */
    public void clearFilter(){
        filteredEvents=null;
    }

/*    
    public void addEvent(){
     selectedEventRow.setCreateDate(new Date());
       selectedEventRow.setUser(loginBean.getCurrentUser());
       selectedEventRow.getAttrs().setEvent(selectedEventRow);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Событие добавлено","Добавлено");  
         FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
  */  
    
        /**
     * Удалить событие
     * @param forDel
     */
    public void delEvent(PartnerEvent forDel){
       current.getPartnerEventList().remove(forDel);
       current.getPartner().getPartnerEventList().remove(forDel);
       newEventMode=true;
         selectedEventRow = forDel;
       //сообщить      
       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Событие удалёно","Удалено");  
     FacesContext.getCurrentInstance().addMessage(null, msg);  
    }    
   
    
    /**
     * Начать создание нового события для текущего юзера
     */
   public void startCreateNewEvent(){
      newEventMode=true;
        selectedEventRow=new PartnerEvent();
         selectedEventRow.setEmploye(current);
          selectedEventRow.setPartner(current.getPartner());
   } 
    
   /**
    * Сохранить текущее событие
    */
   public void saveEvent(){
       FacesMessage msg;
      if(newEventMode){
          current.getPartner().getPartnerEventList().add(selectedEventRow);
           current.getPartnerEventList().add(selectedEventRow);
            selectedEventRow.setCreateDate(new Date());
             selectedEventRow.setUser(loginBean.getCurrentUser());
              selectedEventRow.getAttrs().setEvent(selectedEventRow);
       msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Событие добавлено","Добавлено");  
      } 
      else{
       msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Событие поправлено","Поправлено");  
      }
      newEventMode=false;
       //сообщить      
     FacesContext.getCurrentInstance().addMessage(null, msg);  
   }
//========== геттеры и сеттеры =======================
    
    
    
    public PartnerEmployePhone getNewPhone() {
        return newPhone;
    }

    public void setNewPhone(PartnerEmployePhone newPhone) {
        this.newPhone = newPhone;
    }
    
    
    
    public String getViewCaption() {
        if(newEmploye){
          return  C_ADD_NEW_CAPTION;
                }
        else return C_VIEW_INFO_CAPTION; 
    }

    public void setViewCaption(String viewCaption) {
        this.viewCaption = viewCaption;
    }
    
   
   

    public PartnerEmploye getCurrent() {
        return current;
    }
    
    /**
     * Начать редактирование существующего сотрудника
     * @param aCurrent 
     */
    public void setCurrent(PartnerEmploye aCurrent) {
        currIsNew = false;            
        phoneIsNew = true;
        if(aCurrent!=null){
         this.current = aCurrent;
        }else{
            this.current = new PartnerEmploye();
        }
      viewCaption=C_VIEW_INFO_CAPTION;
      eventDataModel = new PartnerEventDataModel(this.current.getPartnerEventList());
      selectedEventRow = null;
      newEventMode=false;

    }

    public PartnerEmployePhone getCurrPhone() {
        return currPhone;
    }

    /**
     * Начать редактирование существующего телефона
     * @param currPhone 
     */
    public void setCurrPhone(PartnerEmployePhone currPhone) {
        phoneIsNew = false;
        if(currPhone!=null){
          this.currPhone = currPhone;
        }else{
            this.currPhone = new PartnerEmployePhone();
        }
    }

    
    public boolean isCurrIsNew() {
        return currIsNew;
    }

    public void setCurrIsNew(boolean currIsNew) {
        this.currIsNew = currIsNew;
        this.phoneIsNew = true;
    }

    
    public PartnerEventDataModel getEventDataModel() {
        return eventDataModel;
    }

    public void setEventDataModel(PartnerEventDataModel eventDataModel) {
        this.eventDataModel = eventDataModel;
    }

    public PartnerEvent getSelectedEventRow() {
        return selectedEventRow;
    }

    public void setSelectedEventRow(PartnerEvent selectedEventRow) {
        this.selectedEventRow = selectedEventRow;
        newEventMode=false;
    }

    public List<PartnerEvent> getFilteredEvents() {
        return filteredEvents;
    }

    public void setFilteredEvents(List<PartnerEvent> filteredEvents) {
        this.filteredEvents = filteredEvents;
    }

    public String getFltEventLabel() {
        return fltEventLabel;
    }

    public void setFltEventLabel(String fltEventLabel) {
        this.fltEventLabel = fltEventLabel;
    }

    public String getFltEventUser() {
        return fltEventUser;
    }

    public void setFltEventUser(String fltEventUser) {
        this.fltEventUser = fltEventUser;
    }

    public String getFltEventSubj() {
        return fltEventSubj;
    }

    public void setFltEventSubj(String fltEventSubj) {
        this.fltEventSubj = fltEventSubj;
    }

    public String getFltEventType() {
        return fltEventType;
    }

    public void setFltEventType(String fltEventType) {
        this.fltEventType = fltEventType;
    }

    public boolean isNewEmploye() {
        return newEmploye;
    }

    public void setNewEmploye(boolean newEmploye) {
        this.newEmploye = newEmploye;
    }

    public boolean isNewEventMode() {
        return newEventMode;
    }

    public void setNewEventMode(boolean newEventMode) {
        this.newEventMode = newEventMode;
    }
  

    public String getManagerRoleName(){
        return C_MANAGER_ROLE;
    }
    
    /**
     * Заголовок для блока просмотра создания событий
     * @return 
     */
    public String getEventViewCaption(){
        if(newEventMode){
            return "Добавить событие";
        }else{
            return "Просмотр выбранного события";
        }
    }
    
    
 
    
}
