/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.verimov.facade;

import com.ipn.verimov.modelo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Raul
 */


public class UserFacade {
    
    
    private final EntityManager em;
    private TypedQuery<Usuario> query;
    
    public UserFacade(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("VeriMovil21PU");
        em = emf.createEntityManager();    
    }
    
    public List<Usuario> getUsers(){
        List<Usuario> lista;
        query = em.createNamedQuery("Usuario.findAll", Usuario.class);
        lista = query.getResultList();
        return lista;
    }
    
    public Usuario getUser(String username){
        query = em.createNamedQuery("Usuario.findByNombreUsuario", Usuario.class);
        query.setParameter("nombreUsuario", username);
        return query.getSingleResult();     
    }
    
    public void newUser(Usuario u){ 
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
    }
    
    public void updateUser(Usuario u){
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
    }
    
    public void deleteUser(Usuario u){
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
    }
    
}
