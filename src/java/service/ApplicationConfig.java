/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author d00mus
 */
@javax.ws.rs.ApplicationPath("webresources")//эта аннотация указывает папку, где будет лежать REST - сервис
public class ApplicationConfig extends Application {
/*
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        // following code can be used to customize Jersey 1.x JSON provider:
        try {
            Class jacksonProvider = Class.forName("org.codehaus.jackson.jaxrs.JacksonJsonProvider");
            resources.add(jacksonProvider);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
//        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(service.CardioUserFacadeREST.class);
        resources.add(service.ContactsFacadeREST.class);
        resources.add(service.DoctorsExternalFacadeREST.class);
        resources.add(service.ExDocTypeFacadeREST.class);
        resources.add(service.PatientFacadeREST.class);
        resources.add(service.SendRankFacadeREST.class);
        resources.add(service.VipRankFacadeREST.class);
    }
  */  
}
