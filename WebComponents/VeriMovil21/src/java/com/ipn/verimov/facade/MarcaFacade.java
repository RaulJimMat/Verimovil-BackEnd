/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.verimov.facade;

import com.ipn.verimov.modelo.Marca;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Raul
 */
public class MarcaFacade extends FacadeAbstract<Marca>{

    public MarcaFacade() {
        super();
    }
    
    @Override
    public List<Marca> getEntities() {
        TypedQuery<Marca> query = em.createNamedQuery("Marca.findAll", Marca.class);
        return query.getResultList();
    }

    @Override
    public Marca getEntity(Object id) {
        Integer primaryKey = (Integer)id;
        Marca m;
        m = em.find(Marca.class, primaryKey); //Regresa IllegalArgumentException Si no lo encuentra
        return m;
    }

    @Override
    public void save(Marca entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void update(Marca entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Marca entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }
    
    
    
    public List<Marca> getByName(String name){
        List<Marca> list = new ArrayList<>();
        TypedQuery<Marca> query = em.createNamedQuery("Marca.findByNombreMarca", Marca.class);
        query.setParameter("nombreMarca", name);
        return query.getResultList();
    }
    
    
}
