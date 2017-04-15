/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.verimov.restful;

import com.ipn.verimov.facade.UserFacade;
import com.ipn.verimov.modelo.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 *
 * @author Raul
 * 
 * Clase para realizar los metodos dentro de la pagina index (Login y nuevo usuario)
 * 
 */


    @Path("login")
    public class LoginResource {
    
    @Context
    private ServletContext context;
    private static final Logger LOGGER = Logger.getLogger("com.ipn.verimov.restful.LoginResource");
    private UserFacade uc;
    
    @PostConstruct
    public void init(){
        uc = new UserFacade();
    }
    
    //Metodo para realizar el login
    //Envia el estatus accepted para administrador
    //Estatus ok para autorizar al usuario
    //Envia el estatus Not acceptable en caso de que la contraseña sea incorrecta
    //Envia el estatus Prohibido si no existe el usuario
    @GET
    @Path("{user}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@PathParam("user") String user,@QueryParam("pass") String pass){
        ResponseBuilder rb;
        try{
        Usuario u = uc.getUser(user);
        if(u.getPassword().equals(pass)){
            if(u.isAdmin()){
                rb = Response.accepted();
                LOGGER.log(Level.INFO, "Administrador Logueado");
            }else{
                rb = Response.ok();
                LOGGER.log(Level.INFO, "Usuario Logueado");
            }
        }else{
            rb = Response.status(Response.Status.NOT_ACCEPTABLE);
            LOGGER.log(Level.INFO, "Contraseña incorrecta {0}");
        }
        }catch(NoResultException e){
            rb = Response.status(Response.Status.UNAUTHORIZED);
            LOGGER.log(Level.WARNING, "No existe usuario {0}", e);
        }
        return rb.build();
    }
    
    
    //Metodo para registrarse como nuevo usuario
    //Regresa Respuesta 202 confirmando la creacion del nuevo usuario con rol usuario
    //Regresa Respuesta 406 avisando que este es un usuario existente
    @POST
    @Path("registro")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response signUp(Usuario entity){
        ResponseBuilder rb;
        LOGGER.log(Level.INFO, "Nuevo usuario \n{0}", entity.toString());
        try{
            uc.newUser(entity);
            rb = Response.accepted();
        }catch(RollbackException e){
            rb = Response.status(Response.Status.NOT_ACCEPTABLE);
            LOGGER.log(Level.WARNING, "Usuario ya existente {0}", e);
        }
        return rb.build();
    }  
    
}
