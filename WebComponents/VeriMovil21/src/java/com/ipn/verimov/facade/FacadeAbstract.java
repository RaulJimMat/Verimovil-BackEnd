/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.verimov.facade;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


/**
 * 
 * @author Raul
 */
public abstract class FacadeAbstract<T> {
    
    protected final EntityManager em = Persistence.createEntityManagerFactory("VeriMovil21PU").createEntityManager();
    
    public abstract List<T> getEntities();
    public abstract T getEntity(Object id);
    public abstract void save(T entity);
    public abstract void update(T entity);
    public abstract void delete(T entity);
    
    
    
}
