/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.verimov.facade;

import com.ipn.verimov.modelo.Anio;
import com.ipn.verimov.modelo.AnioPK;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Raul
 */
public class AnioFacade extends FacadeAbstract<Anio>{

    public AnioFacade() {
        super();
    }

    @Override
    public List<Anio> getEntities() {
        TypedQuery<Anio> query = em.createNamedQuery("Anio.findAll",Anio.class);
        return query.getResultList();
    }

    @Override
    public Anio getEntity(Object id) {
        Anio a;
        AnioPK primaryKey = (AnioPK)id;
        a = em.find(Anio.class, primaryKey);
        return a;
    }

    @Override
    public void save(Anio entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void update(Anio entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Anio entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }
    
    
    
}
