/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view_beans;

import dao.CardioRoleFacade;
import dao.CardioUserFacade;
import dao.UaStateFacade;
import dao.UaTownFacade;
import dao.UserFilesFacade;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import mdl.CardioRole;
import mdl.CardioUser;
import mdl.PatientPhone;
import mdl.UaState;
import mdl.UaTown;
import mdl.UserEducation;
import mdl.UserFiles;
import mdl.UserOccupation;
import mdl.UserPhone;
import org.apache.commons.codec.binary.Hex;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.DualListModel;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author d00mus
 */
@Named("userEditBean")
@SessionScoped

public class UserEditBean implements Serializable{
    
    
    private CardioUser current;
    private boolean doCreateNew;//признак того, что идёт создание нового пользователя
    
    private String returnPath=null;//на какую страницу возвращатся после сохранения
    

    /*
    @EJB
    private UserFilesFacade filesDao;
    */
    
    @EJB
    private CardioUserFacade dao;

    @EJB
    private UaStateFacade stateDao;
    
    @EJB
    private UaTownFacade townDao;
            
    private List<UaState> uaStates;
    private List<UaTown> uaTowns;
    //private int phone_seq;
    
    @EJB
    private CardioRoleFacade rolesDao;
    
    
    
    //Модель для списка ролей
    private DualListModel<CardioRole> rolesPickUpList; 
    
    @PersistenceContext(unitName = "cardio1PU")
    private EntityManager em;

    //текущий элемент списка файлов, который правим
    private UserFiles curUserFile = new UserFiles();
    
    //текущий элемент образования юзера, который правим
    private UserEducation currEdu = new UserEducation();
    
    //текущий элемент работы юзера, который правим
    private UserOccupation currOccup = new UserOccupation();
    
    //текущий телефон пользователя, который правим
    private UserPhone currPhone = new UserPhone();
    
    //для смены паролей
    private String newPassword1="1";
    private String newPassword2="2";

    @PostConstruct
    private void init(){
      uaStates = stateDao.findAll();//найти все области усраины
      uaTowns = townDao.findAll();//найти все города усраины
    }
    

    
  /**
   * Очистка всех полей текущего юзера
   */  
   public void clean(){
     current = new CardioUser();
      doCreateNew = true;
//       phone_seq = 1;

    }

    
   /**
    * Инициализировать список ролей юзера
    */
    private void initRolesPickUp(){
        List<CardioRole> notAssignedRoles;
        //создать список с ролями текущего юзера
        if(current.getId()!=null){//если текущий юзер есть в базе
            TypedQuery<CardioRole> rolesQ = em.createQuery("select r from CardioRole r where r.id not in(select rr.id from CardioUser u join u.roleList rr where  u = :pCurrentUser ) ",CardioRole.class );
            rolesQ.setParameter("pCurrentUser", getCurrent());
            notAssignedRoles = rolesQ.getResultList();
        }else{//если текущего юзера в базе ещё нету - значит список с доступными ролями просто равен списку всех ролей
            //TODO:это глючный код..
          notAssignedRoles = rolesDao.findAll(); //просто получить полный список ролей
          if(current.getRoleList()==null){//если списка ролей нету - создать новый
             current.setRoleList(new ArrayList<CardioRole>());
          }
            
        }
        
         rolesPickUpList = new DualListModel<CardioRole>(notAssignedRoles,getCurrent().getRoleList());
    }
    

    
    /**
     * Сменить пароль
     */
    public void changePassword(){
      
        
     if(newPassword1!=null && newPassword1.equals(newPassword2)){//если пароли равны - можно менять
         current.setPassword(getPassword(newPassword1));
      //сообщить
      FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Пароль измененён","Пароль изменен");  
       FacesContext.getCurrentInstance().addMessage(null, msg);  
         
     }else{//если не равны - сообщить об ошибке
      //сообщить
      FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ошибка смена пароля","Пароли не совпали!");  
       FacesContext.getCurrentInstance().addMessage(null, msg);  
     }  
    }
    
    
    /**
     * Запустить создание нового юзера
     * @return 
     */
    public String startCreateNewUser(){
     doCreateNew = true;   
     current = new CardioUser();
     initRolesPickUp();//инициировать список для правки ролей пользователя
     return null;    
    }
    
    /**
     * Начать редактирование существующего(!!!) в базе юзера
     * @param edited
     * @param retPath
     * @return 
     */
    public String startEdit(CardioUser edited, String retPath){
        current = edited;//выставить текущего юзера для правки
        
        //создать список с ролями текущего юзера
        initRolesPickUp();
        
        doCreateNew = false;//отключить режим создания нового юзера
      return "edit_user?faces-redirect=true";  
    };
    

    /**
     * Добавить текущему юзеру образование
     */
    public void addEducation(){
      if(current.getUserEducaionList()==null){
        current.setUserEducaionList(new ArrayList<UserEducation>());
      }
      currEdu.setUser(current);//связать текущий элемент с юзером
      String newEduName = currEdu.getSpec();
      current.getUserEducaionList().add(currEdu);//добавить текущий элемент образования в список
      currEdu = new UserEducation();
      
      //сообщить
      FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Образование добавлено",newEduName);  
       FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
    
    /**
     * Удалить у текущего юзера элемент образования
     */
    public void dellEducation(UserEducation forDel){
       current.getUserEducaionList().remove(forDel);
       forDel.setUser(null);
      currEdu = forDel;//назначить текущее образование редактируемым 
      //сообщить
      FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Образование удалено",forDel.getSpec());  
       FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    

    /**
     * Добавить текущему юзеру работу на фирме
     */
    public void addFirmWork(){
      if(current.getUserOccupationList()==null){
          current.setUserOccupationList(new ArrayList<UserOccupation>());
      }  
       currOccup.setUser(current);
       current.getUserOccupationList().add(currOccup);
       String newOccpName = currOccup.getPosition();
       currOccup = new UserOccupation();
       //сообщить
      FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Работа добавлена",newOccpName);  
       FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
    
    /**
     * Удалить работу текущего юзера
     */
    public void delFirmWork(UserOccupation forDel){
     current.getUserOccupationList().remove(forDel);
      forDel.setUser(null);
       currOccup = forDel;
      //сообщить
      FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Работа удалена",forDel.getPosition());  
       FacesContext.getCurrentInstance().addMessage(null, msg);  
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
     * Обработчик загрузки фоток
     * @param event
     */
    public void avatarListener(FileUploadEvent event) { 
        System.out.println("userEditBean:avatarListener");//debug
        
        UploadedFile file = event.getFile();
         setNewAvatar(file);
             FacesMessage msg = new FacesMessage("Файл "+file.getFileName() + " загружен на сервер");  
               FacesContext.getCurrentInstance().addMessage(null, msg);  
    }      

 
/**
 * Добавить текущему юзеру файл
 * @param us 
 */    
private void addFile(UserFiles uf){
   if(current.getUserFilesList()==null){
     current.setUserFilesList(new ArrayList<UserFiles>());
   }
 current.getUserFilesList().add(uf);
}
    

/**
 * Выставить юзеру аву, согласно загруженного файла,
 * если ава уже была - она обновится, и новый файл не добавится
 * @param f 
 */
private void setNewAvatar(UploadedFile f){
            if(current.getAvatarFile() == null){//если нет текущего аватара, тогда создать новую фотку
                UserFiles uf = new UserFiles();
                uf.setDescription("Фотка на аватарке");
                uf.setUser(current);//связать аву с юзером
                uf.setFileDate(new Date());//выставить дату файла
                current.setAvatarFile(uf);//выставить фотку как аву
              addFile(uf);//добавить аву в список файлов 
              
            }else{ //если файсл с авой уже есть, тогда обновить его
                UserFiles af = current.getAvatarFile(); 
                af.setDescription("Фотка на аватарке");
                af.setUser(current);
                af.setFileDate(new Date());
            }
            
            current.getAvatarFile().setFileName(f.getFileName());//обновить имя файла
         
       //обновить содержимое фотки(контент)
         byte []fileContent = new byte[(int)f.getSize()];   
        try {
            int rb = f.getInputstream().read(fileContent);
        } catch (IOException ex) {
            //TODO:добавить обработку ошибки чтения
            Logger.getLogger(PatientEditBean.class.getName()).log(Level.SEVERE, null, ex);
           ex.printStackTrace();
        }
       current.getAvatarFile().setFileData(fileContent);
      current.getAvatarFile().setUploaded(new Date());
 }


    /**
     * Добавить новый телефон юзеру
     */

   public void addPhone(){
/*       
       System.out.println("addPhone:seq="+phone_seq);
       //TODO:неплохо бы тут проверять наличие такого телефона в списке, чтоб не было повторов
     newPhone.setId(phone_seq);//временно подставляем левый ID
     phone_seq++;
*/       
     if(current.getUserPhoneList()==null){//если список телефонов пока пуст
       current.setUserPhoneList(new ArrayList<UserPhone>());//создать пустой список телефонов
     }  
        currPhone.setUser(current);//связать телефон с текущим юзером
        current.getUserPhoneList().add(currPhone);
        String newPhoneName = currPhone.getPhone();
        currPhone = new UserPhone();
      //написать сообщение
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Телефон добавлен",newPhoneName);  
       FacesContext.getCurrentInstance().addMessage(null, msg);  
   } 
   
   /**
    * Удалить тел
     * @param pp
    */
   public void delPhone(UserPhone forDel){
       current.getUserPhoneList().remove(forDel);
       forDel.setUser(null);
       currPhone = forDel;
       
      //написать сообщение
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Телефон удалён",forDel.getPhone());  
       FacesContext.getCurrentInstance().addMessage(null, msg);  
   }


    /**
     * Заголовок страницы
     * @return 
     */
    public String pageCaption(){
        if(doCreateNew){
            return "Создать нового сотрудника";
        }else{
            return "Правка сотрудника №"+current.getUserName();
        }
        
    }
    
    
    /**
     * Перечитать данные по текущему юзеру из базы
     */
    public void refresh(){
        if(!doCreateNew){
           current = dao.refresh(current.getId());
           
        }
      initRolesPickUp();//обновить список с ролями юзеров
    }
    
    /**
     * Получить пароль из строки
     */
    private String getPassword(String pswd){
        MessageDigest md=null; 
        try{
          md = MessageDigest.getInstance("MD5");
        }catch(Exception ex){
            Logger.getLogger(UserEditBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        try {
            md.update(pswd.getBytes("CP1251"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UserEditBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        char[] encodeHex = Hex.encodeHex(md.digest());
        String result = new String(encodeHex).toLowerCase();
      return result;  
    }
    
    /**
     * Сохранение нового юзера, которого нету в базе
     */
    private void saveNewUser(){
        
      if(current.getPassword()==null){//если пароль пустой - выставить 1
        current.setPassword(getPassword("1"));
      }  
        //обнулить аву и список файлов
        UserFiles uf = current.getAvatarFile();
        List<UserFiles> ulf = current.getUserFilesList();
        
        //обнулить лишние ссылки
        current.setUserFilesList(null);
        current.setAvatarFile(null);
      
        //обработать телефоны  
      
        //создать юзера в базе
            dao.create(current);
            
        //вернуть аву и ссылки   
        //выставить аву
            current.setAvatarFile(uf);
            current.setUserFilesList(ulf);
            
            dao.edit(current);//сохранить вместе с авой и файлами
            
    }
    
    
    /**
     * Обновление юзера, уже существующего в базе 
     */
    private void updateExisted(){
       dao.edit(current);
    }
    
    /**
     * Сохранить текущее состояние юзера
     */
    public void save(){
        
        System.out.println("userEditBean:save()");
        
        if(doCreateNew){//если создавали нового юзера
          saveNewUser();
          doCreateNew = false;//Сбросить признак создания нового юзера
        }else{
          updateExisted();
         }
             FacesMessage msg = new FacesMessage("Анкета сохранена");  
               FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
    
 /**
     * Добавить файл текущему юзеру
     */
    public void addFile(){
      if(curUserFile.getFileData()!=null && curUserFile.getFileData().length>0){
        curUserFile.setUser(current);

        /*
        if(!doCreateNew){//уже существующему в базе юзеру добавляем файл сразу
         filesDao.create(curUserFile);
        }*/
        
          current.getUserFilesList().add(curUserFile);
         FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Файл добавлен",curUserFile.getFileName());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
       curUserFile = new UserFiles();//создать новый документ 
         
      }
    }
    
    /**
     * Удалить файл
     * @param forDel
     */
    public void delFile(UserFiles forDel){
        
       current.getUserFilesList().remove(forDel);
        forDel.setUser(null);
        curUserFile = forDel;//Выставить текущий файл в только что удалённый
        //проверить равенство удалённого файла с авой юзера
        if(current.getAvatarFile().equals(forDel)){
            current.setAvatarFile(null);//если это ава - обнулить аву
        }
      
       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Файл удалён",curUserFile.getFileName());  
      FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
    
    /**
     * Получить текущий файл как поток, для скачивания
     * @param doc
     * @return 
     */
    public StreamedContent getFile(UserFiles doc) throws UnsupportedEncodingException{
        InputStream stream =  new ByteArrayInputStream(doc.getFileData());  
         return new DefaultStreamedContent(stream, "application/octet-stream", URLEncoder.encode(doc.getFileName(), "UTF8").replaceAll("\\+", "%20") );  
    }
    
    
    

  /**
   * Метод для работы с загрузчиком файлов от primeFaces
   * @param event 
   */  
    
   public void handleFileUpload(FileUploadEvent event) { 
         curUserFile.setFileName(event.getFile().getFileName());
         
         int fileSize = (int)(event.getFile().getSize());
//          curUserFile.setFileSize((int)event.getFile().getSize());
          
          byte [] fileContent = new byte[fileSize];
        try {
            //прочесть содержимое загруженного файла
            event.getFile().getInputstream().read(fileContent);
        } catch (IOException ex) {
            Logger.getLogger(DocumentBean.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ошибка работы с базой", ex.toString());  
           FacesContext.getCurrentInstance().addMessage(null, msg);  
         return; 
        }
          //выставить содержимое в энтети
          curUserFile.setFileData(fileContent);
           
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Файл загружен на сервер",event.getFile().getFileName());  
             FacesContext.getCurrentInstance().addMessage(null, msg);  
    }

    //================ геттеры и сеттеры =========
    public String getNewPassword1() {
        return newPassword1;
    }

    public void setNewPassword1(String newPassword1) {
        this.newPassword1 = newPassword1;
    }

    public String getNewPassword2() {
        return newPassword2;
    }

    public void setNewPassword2(String newPassword2) {
        this.newPassword2 = newPassword2;
    }
   
   
   
       public boolean isDoCreateNew() {
        return doCreateNew;
    }
    
    public void setDoCreateNew(boolean doCreateNew) {
        this.doCreateNew = doCreateNew;
    }


   
    public UserPhone getCurrPhone() {
        return currPhone;
    }

    public void setCurrPhone(UserPhone currPhone) {
        this.currPhone = currPhone;
    }
   
   
   
    public UserEducation getCurrEdu() {
        return currEdu;
    }

    public void setCurrEdu(UserEducation currEdu) {
        this.currEdu = currEdu;
    }

    public UserOccupation getCurrOccup() {
        return currOccup;
    }

    public void setCurrOccup(UserOccupation currOccup) {
        this.currOccup = currOccup;
    }
   
   
   
    public DualListModel<CardioRole> getRolesPickUpList() {
        return rolesPickUpList;
    }

    public void setRolesPickUpList(DualListModel<CardioRole> rolesPickUpList) {
        this.rolesPickUpList = rolesPickUpList;
    }
   

    
/**
 * Обработчик перемещения ролей
 * @param event 
 */    
public void onTransfer(TransferEvent event) {  
        for(Object item : event.getItems()) {  
            CardioRole r = (CardioRole)item;
            
            if(event.isAdd()){//если роль добавили
             current.getRoleList().add(r);//добавить юзеру в список
            }
            
            if(event.isRemove()){//если роль удалили
              current.getRoleList().remove(r);//удалить у юзера роль
            }
            
        }  
          
        FacesMessage msg = new FacesMessage();  
        msg.setSeverity(FacesMessage.SEVERITY_INFO);  
        msg.setSummary("Права пользователя");  
        if(event.isAdd()){
          msg.setDetail("Роли добавлены");  
        }else{
          msg.setDetail("Роли забраны");  
        }
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        
    }      
   
   
   
    public UserFiles getCurFile() {
         return curUserFile;
    }

    
    public void setCurFile(UserFiles curDoc) {
        this.curUserFile = curDoc;
    }

   
    public CardioUser getCurrent() {
        if(current==null){
            current = new CardioUser();
        }
        return current;
    }

    public void setCurrent(CardioUser current) {
        this.current = current;
    }
    
    
    
}
