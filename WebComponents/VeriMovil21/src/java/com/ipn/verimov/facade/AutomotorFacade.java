/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.verimov.facade;

import com.ipn.verimov.modelo.Automotor;
import com.ipn.verimov.modelo.AutomotorPK;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Raul
 */
public class AutomotorFacade extends FacadeAbstract<Automotor>{

    public AutomotorFacade() {
        super();
    }
    
    @Override
    public List<Automotor> getEntities() {
        TypedQuery<Automotor> query = em.createNamedQuery("Automotor.findAll", Automotor.class);
        return query.getResultList();
    }

    @Override
    public Automotor getEntity(Object id) {
        Automotor a;
        AutomotorPK primaryKey = (AutomotorPK)id;
        a = em.find(Automotor.class, primaryKey);
        return a;
    }

    @Override
    public void save(Automotor entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void update(Automotor entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Automotor entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    public List<Automotor> getEntitiesbyUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
