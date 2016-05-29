/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view_beans;

import dao.CardioProjectFacade;
import dao.TaskFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import mdl.CardioProject;
import mdl.Task;

/**
 *
 * @author d00mus
 */
@Named("projectListBean")
@SessionScoped
public class ProjectListBean implements Serializable{
    
  
    
  private List<Task> taskList;
  private List<Task> myTaskList;
  private List<CardioProject> projectList;
  private List<CardioProject> myProjectList;
  
  private List<Task> taskListFiltered;
  private List<Task> myTaskListFiltered;
  private List<CardioProject> projectListFiltered;
  private List<CardioProject> myProjectListFiltered;

    @PersistenceContext(unitName = "cardio1PU")
    private EntityManager em;
  
  
  @EJB
  private TaskFacade taskDao;
  
  @EJB
  private CardioProjectFacade projectDao;
  
  @Inject
  private LoginBean loginBean;
  
  @Inject
  private TaskEditBean taskEditBean;
  
  @Inject
  private ProjectEditBean projectEditBean;
  
  public ProjectListBean(){
      
  }
  
  
  @PostConstruct
  private void init(){
      //вычитать из базы всю инфу
      updateMyProjects();
      updateMyTasks();
      updateProjects();
      updateTasks();
  }
    /**
     * Обновить список проектов
     */
  public void updateProjects(){
    projectDao.flush();
    projectList = projectDao.findAll();
  }  
  
  /**
   * Обновить список задач
   */
  public void updateTasks(){
    taskDao.flush();
     taskList = taskDao.findAll();
  }
  
  
  /**
   * Обновить список моих проектов
   */
  public void updateMyProjects(){
//В таблице Мои проекты каждый пользователь видит только те проекты, в пункте Менеджер которых выбрано его ФИО.      
     myProjectList = loginBean.getCurrentUser().getUserProjectList();
  }
  
  /**
   * Обновить список моих задач
   */
  public void updateMyTasks(){
   taskDao.flush();
   //В таблице Мои задачи каждый пользователь типа Менеджер видит только те задачи, в пункте Менеджер которых выбрано его ФИО. 
   //Пользователь типа Инженер видит только те задачи, в пункте Инженер которых выбрано его ФИО.
    TypedQuery<Task> taskQ = em.createQuery("select t from Task t where t.user=:pUserId or t.engineer=:pUserId", Task.class);
     taskQ.setParameter("pUserId", loginBean.getCurrentUser());
      myTaskList = taskQ.getResultList();
      
  }

 
  /**
   * Создать новую задачу
   * @return 
   */
  public String goCreateNewTask(){
   taskEditBean.createNew();
  return "task_edit?faces-redirect=true";    
  }
  
  /**
   * Перейти к просмотру/правке выбранной задачи
   * @return 
   */
  public String goEditTask(Task forEdit){
    taskEditBean.beginEdit(forEdit);
  return "task_edit?faces-redirect=true";    
  }
  
  /**
   * Удалить задачу
   * @param forEdit 
   */
  public void deleteTask(Task forEdit){
          forEdit.getPartner().getPartnerTaskList().remove(forEdit);
          loginBean.getCurrentUser().getUserTaskList().remove(forEdit);
         taskDao.remove(forEdit);
        updateMyTasks();
        updateTasks();
      FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Задача удалёна","Задача удалёна");  
     FacesContext.getCurrentInstance().addMessage(null, msg);  
  }
  

  
  /**
   * Создать новый проект
   * @return 
   */
  public String goCreateNewProject(){
   projectEditBean.createNew();
  return "project_edit?faces-redirect=true";    
  }
  
  /**
   * Перейти к просмотру/правке выбранной задачи
   * @return 
   */
  public String goEditProject(CardioProject forEdit){
    projectEditBean.beginEdit(forEdit);
  return "project_edit?faces-redirect=true";    
  }
  
  /**
   * Удалить проект
   * @param forEdit 
   */
  public void deleteProject(CardioProject forEdit){
           forEdit.getPartner().getPartnerProjectList().remove(forEdit);
          loginBean.getCurrentUser().getUserProjectList().remove(forEdit);
         projectDao.remove(forEdit);
        updateMyProjects();
        updateProjects();
      FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Проект удалён","Проект удалён");  
     FacesContext.getCurrentInstance().addMessage(null, msg);  
  }
  
  
  
  
//=============== гетты и сеттеры ======================  
    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public List<Task> getMyTaskList() {
        return myTaskList;
    }

    public void setMyTaskList(List<Task> myTaskList) {
        this.myTaskList = myTaskList;
    }

    public List<CardioProject> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<CardioProject> projectList) {
        this.projectList = projectList;
    }

    public List<CardioProject> getMyProjectList() {
        return myProjectList;
    }

    public void setMyProjectList(List<CardioProject> myProjectList) {
        this.myProjectList = myProjectList;
    }

    public List<Task> getTaskListFiltered() {
        return taskListFiltered;
    }

    public void setTaskListFiltered(List<Task> taskListFiltered) {
        this.taskListFiltered = taskListFiltered;
    }

    public List<Task> getMyTaskListFiltered() {
        return myTaskListFiltered;
    }

    public void setMyTaskListFiltered(List<Task> myTaskListFiltered) {
        this.myTaskListFiltered = myTaskListFiltered;
    }

    public List<CardioProject> getProjectListFiltered() {
        return projectListFiltered;
    }

    public void setProjectListFiltered(List<CardioProject> projectListFiltered) {
        this.projectListFiltered = projectListFiltered;
    }

    public List<CardioProject> getMyProjectListFiltered() {
        return myProjectListFiltered;
    }

    public void setMyProjectListFiltered(List<CardioProject> myProjectListFiltered) {
        this.myProjectListFiltered = myProjectListFiltered;
    }
  
  
    
  
  
    
}
