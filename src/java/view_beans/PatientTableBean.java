package view_beans;

import dao.PatientFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import mdl.Patient;

/**
 * Бин для списка всех пациентов
 * @author d00mus
 */
@Named("patientTableBean")
@SessionScoped
public class PatientTableBean implements Serializable,ISimpleCallBack{
    
    public PatientTableBean(){
        
    }

    
    @Inject 
    private PatientEditBean patientEditBean;//редактор пациентов

    @EJB
    private PatientFacade dao;  
    
    
    
    //список пациентов
    private List<Patient> items;

    @PostConstruct
    private void init(){
      refresh();
    }
    
    
    //параметры фильтра
    private String fltName;
    
    private String fltFirstsName;
    
    private String fltSecName;
    
    private String fltPseudoName;
    
    private String fltTrackedBy;
    
    private String fltTown;
    
    private String fltDistr;

    public String getFltName() {
        return fltName;
    }

    public void setFltName(String fltName) {
        this.fltName = fltName;
    }

    public String getFltFirstsName() {
        return fltFirstsName;
    }

    public void setFltFirstsName(String fltFirstsName) {
        this.fltFirstsName = fltFirstsName;
    }

    public String getFltSecName() {
        return fltSecName;
    }

    public void setFltSecName(String fltSecName) {
        this.fltSecName = fltSecName;
    }

    public String getFltPseudoName() {
        return fltPseudoName;
    }

    public void setFltPseudoName(String fltPseudoName) {
        this.fltPseudoName = fltPseudoName;
    }

    public String getFltTrackedBy() {
        return fltTrackedBy;
    }

    public void setFltTrackedBy(String fltTrackedBy) {
        this.fltTrackedBy = fltTrackedBy;
    }

    public String getFltTown() {
        return fltTown;
    }

    public void setFltTown(String fltTown) {
        this.fltTown = fltTown;
    }

    public String getFltDistr() {
        return fltDistr;
    }

    public void setFltDistr(String fltDistr) {
        this.fltDistr = fltDistr;
    }
    
    
    
    public void clearFilter(){
        filteredPatients=null;
    }
    
   
    /**
     * Перечитать список пациентов из базы
     */
    public void refresh(){
        items = dao.findAll();
    }
    
    
    /**
     * Переход на правку указанного пациента
     * @return 
     */
    public String goEdit(Patient edited){
      patientEditBean.edit(edited, this);
       return "patient_edit?faces-redirect=true"; //переходим   
    }
    
    public String goCreateNew(){
       patientEditBean.createNew(this);//инициируем создание нового пациента
      return "patient_edit?faces-redirect=true"; //переходим   
    }

    public String goToPatientById(long id){
         return "patient_profile.xhtml?faces-redirect=true&id="+id;   
    }

    public List<Patient> getItems() {
        return items;
    }

    public void setItems(List<Patient> items) {
        this.items = items;
    }

    /**
     * Уведомление о необходимости перечитать список пациентов
     */
    @Override
    public void callBack() {
        refresh();
    }
    
    /**
     * Отфильтрованный таблицей список пациентов
     */
    private List<Patient> filteredPatients;

    public List<Patient> getFilteredPatients() {
        return filteredPatients;
    }

    public void setFilteredPatients(List<Patient> filteredPatients) {
        this.filteredPatients = filteredPatients;
    }
    
    
    

 
}//class


