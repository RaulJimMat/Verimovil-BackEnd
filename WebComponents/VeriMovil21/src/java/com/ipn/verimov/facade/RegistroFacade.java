/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.verimov.facade;

import com.ipn.verimov.modelo.Registro;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Raul
 */
public class RegistroFacade extends FacadeAbstract<Registro>{

    public RegistroFacade() {
        super();
    }
    
    
    
    @Override
    public List<Registro> getEntities() {
        TypedQuery<Registro> q = em.createNamedQuery("Registro.findAll", Registro.class);
        return q.getResultList();
    }

    @Override
    public Registro getEntity(Object id) {
        Registro r;
        Integer primaryKey = (Integer)id;
        r = em.find(Registro.class, primaryKey);
        return r;
    }

    @Override
    public void save(Registro entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void update(Registro entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Registro entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }
    
}
