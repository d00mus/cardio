/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mdl.PartnerEmploye;

/**
 *
 * @author d00mus
 */
@Stateless
public class PartnerEmployeFacade extends AbstractFacade<PartnerEmploye> {
    @PersistenceContext(unitName = "cardio1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PartnerEmployeFacade() {
        super(PartnerEmploye.class);
    }
    
}
