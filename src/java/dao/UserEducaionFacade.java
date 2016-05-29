/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mdl.UserEducation;

/**
 *
 * @author d00mus
 */
@Stateless
public class UserEducaionFacade extends AbstractFacade<UserEducation> {
    @PersistenceContext(unitName = "cardio1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserEducaionFacade() {
        super(UserEducation.class);
    }
    
}
