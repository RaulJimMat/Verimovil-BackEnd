/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.verimov.restful;

import com.ipn.verimov.modelo.Usuario;
import com.ipn.verimov.facade.UserFacade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.persistence.NoResultException;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author Raul
 */

@Path("user")
public class UserResource {
    
    @Context
    private ServletContext context;
    private static final Logger logger = Logger.getLogger("com.ipn.verimov.restful.UserResource");
    private UserFacade uc;
    
    @PostConstruct
    public void init(){
        uc = new UserFacade();
    }
    //Regresa una lista de todos los usarios
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getUsers(){
        List<Usuario> allUsers = uc.getUsers();
        return allUsers;
    }
    
    
    //Servicio Rest para eliminar un usuario
    //Responde 200 si se realizo sin problemas
    //Responde 406 si no existe la entidad
    @DELETE
    @Path("remove/{userneame}")
    public Response removeUser (@PathParam("username") String username){
        Response.ResponseBuilder rb;
        try{
            uc.deleteUser(uc.getUser(username));
            rb = Response.status(Response.Status.OK);
        }catch(NoResultException e){
            rb = Response.status(Response.Status.NOT_ACCEPTABLE);
            logger.log(Level.WARNING, "No existe usuario {0}", e);
        }
        return rb.build();
    }
    
    
    //Servicio Expuesto por restful para la actualizacion de datos de un usuario
    //Se maneja mediante respuestas
    //Responde 200 si se realiza con exito
    //Responde 304 si no se realizo la accion
    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(Usuario u){
        Response.ResponseBuilder rb;
        try {
            uc.updateUser(u);
            rb = Response.status(Response.Status.OK);
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARNING, "No se encuentra el usuario", e);
            rb = Response.notModified();
        }
        return rb.build();
    }
     
}