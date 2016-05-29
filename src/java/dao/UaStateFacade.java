/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mdl.UaState;

/**
 *
 * @author d00mus
 */
@Stateless
public class UaStateFacade extends AbstractFacade<UaState> {
    @PersistenceContext(unitName = "cardio1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<UaState> findAll() {
        List<UaState> findAllResult = super.findAll();
        Collections.sort(findAllResult, new Comparator<UaState>(){
            @Override
            public int compare(UaState o1, UaState o2) {
                return o1.getRusName().compareTo(o2.getRusName());
            }
        });
        
        return findAllResult;
    }

    
    public UaStateFacade() {
        super(UaState.class);
    }
    
}
