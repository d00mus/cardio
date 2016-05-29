/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mdl.UserPhone;

/**
 *
 * @author d00mus
 */
@Stateless
public class UserPhoneFacade extends AbstractFacade<UserPhone> {
    @PersistenceContext(unitName = "cardio1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserPhoneFacade() {
        super(UserPhone.class);
    }
    
}
