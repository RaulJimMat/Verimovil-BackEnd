/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.verimov.facade;

import com.ipn.verimov.modelo.Modelo;
import com.ipn.verimov.modelo.ModeloPK;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Raul
 */
public class ModeloFacade extends FacadeAbstract<Modelo>{

    public ModeloFacade() {
        super();
    }


    @Override
    public List<Modelo> getEntities() {
        TypedQuery<Modelo> query = em.createNamedQuery("Modelo.findAll", Modelo.class);
        return query.getResultList();
    }

    @Override
    public Modelo getEntity(Object id) {
        Modelo m = null;
        ModeloPK primaryKey = (ModeloPK)id;
        m = em.find(Modelo.class, primaryKey);//Lanza Illegal Argument Exception si no existe la referencia
        return m;
    }

    @Override
    public void save(Modelo entity) {
        em.getTransaction().begin();;
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void update(Modelo entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Modelo entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }
    
    
    
}
