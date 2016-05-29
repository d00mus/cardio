package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mdl.CardioStore;

/**
 *
 * @author d00mus
 */
@Stateless
public class CardioStoreFacade extends AbstractFacade<CardioStore> {
    @PersistenceContext(unitName = "cardio1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CardioStoreFacade() {
        super(CardioStore.class);
    }
    
}
