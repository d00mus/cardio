/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view_beans;

import dao.CardioUserFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import mdl.CardioUser;

/**
 *
 * @author d00mus
 */
@Named("userListBean")
@SessionScoped

public class UserListBean implements Serializable{
    
  private List <CardioUser> items; 
  
  private List <CardioUser> filteredUsers;
  
  @EJB
  private CardioUserFacade dao;
  
  @Inject
  private UserEditBean userEditBean;
  
  
    @PostConstruct
    private void init(){
      refresh();
    }

    /**
     * Перечитать список пациентов из базы
     */
    public void refresh(){
        items = dao.findAll();
    }

    

    /**
     * Создать нового сотрудника
     * @return 
     */
    public String goCreateNew(){
        userEditBean.startCreateNewUser();
        return "edit_user.xhtml?faces-redirect=true";
    }
    
    /**
     * печать
     * @param usr
     * @return 
     */
    public String print(CardioUser usr) {
        return "../../webresources/report/patient/"+usr.getId()+"?faces-redirect=true";
    }
    /**
     * Очистить фильтр
     */
    public void clearFilter(){
        filteredUsers=null;
    }

    /**
     * Править указанного сотрудника
     * @param usr
     * @return 
     */
    public String goEdit(CardioUser usr){
        userEditBean.startEdit(usr, "user_list");
        return "edit_user?faces-redirect=true";
    }
    
//============== геттеры и сеттеры =================
    
    public List<CardioUser> getItems() {
        return items;
    }

    public void setItems(List<CardioUser> items) {
        this.items = items;
    }

    public List<CardioUser> getFilteredUsers() {
        return filteredUsers;
    }

    public void setFilteredUsers(List<CardioUser> filteredUsers) {
        this.filteredUsers = filteredUsers;
    }

    
    
}

