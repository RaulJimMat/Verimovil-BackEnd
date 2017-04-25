/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.verimov.facade;

import com.ipn.verimov.modelo.Version;
import com.ipn.verimov.modelo.VersionPK;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Raul
 */
public class VersionFacade extends FacadeAbstract<Version>{

    public VersionFacade() {
        super();
    }
    
    @Override
    public List<Version> getEntities() {
        TypedQuery<Version> query = em.createNamedQuery("Version.findAll", Version.class);
        return  query.getResultList();
    }

    @Override
    public Version getEntity(Object id) {
        Version v;
        VersionPK primaryKey = (VersionPK)id;
        v = em.find(Version.class, primaryKey);// Lanza IllegalArgumentException si no existe la referencia
        return v;
    }

    @Override
    public void save(Version entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void update(Version entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Version entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    public List<Version> getRange(int marca, int modelo, int anio) {
        TypedQuery<Version> query = em.createNamedQuery("Version.findByAnioModeloMarcaidMarcaAndAnioidAnioAndAnioModeloidModelo", Version.class);
        query.setParameter("anioModeloMarcaidMarca", marca);
        query.setParameter("anioModeloidModelo", modelo);
        query.setParameter("anioidAnio", anio);
        return  query.getResultList();
    }
    
    
    
}
