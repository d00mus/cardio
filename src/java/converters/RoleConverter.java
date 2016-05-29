/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package converters;

import dao.CardioRoleFacade;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import mdl.CardioRole;

/**
 *
 * @author d00mus
 */
@FacesConverter("roleConverter")

public class RoleConverter implements Converter{

    
    @PersistenceContext(unitName = "cardio1PU")
    private EntityManager em;
    

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        TypedQuery<CardioRole> nm = em.createNamedQuery("CardioRole.findByDescription", CardioRole.class);
       nm.setParameter("description", value);
      return nm.getSingleResult();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value!=null){
            if(value instanceof CardioRole){
                return ((CardioRole)value).getDescription();
            }
        }
     return null;    
    }
    
    
}
