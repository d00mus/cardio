/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mdl.CardioPartner;

/**
 *
 * @author d00mus
 */
@Stateless
public class CardioPartnerFacade extends AbstractFacade<CardioPartner> {
    @PersistenceContext(unitName = "cardio1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CardioPartnerFacade() {
        super(CardioPartner.class);
    }

    @Override
    public List<CardioPartner> findAll() {
        return super.findAllNotClosed(); 
    }
    
    public void closeRecord(CardioPartner forClose) {
        forClose.setClosed(true);
        edit(forClose);
    }
    
}
