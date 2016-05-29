/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view_beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author d00mus
 */
@SessionScoped
@Named("indexBean")
public class IndexBean implements Serializable{
    
   public String onBtnClickRedir(String go){
     
    return go+"?faces-redirect=true";   
   } 
    
}
