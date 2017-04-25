/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.verimov.restful;

import com.ipn.verimov.facade.AnioFacade;
import com.ipn.verimov.facade.AutomotorFacade;
import com.ipn.verimov.facade.MarcaFacade;
import com.ipn.verimov.facade.ModeloFacade;
import com.ipn.verimov.facade.VersionFacade;
import com.ipn.verimov.modelo.Anio;
import com.ipn.verimov.modelo.Automotor;
import com.ipn.verimov.modelo.Marca;
import com.ipn.verimov.modelo.Modelo;
import com.ipn.verimov.modelo.Version;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Raul
 */

@Path("automotor")
public class AutomotorResource {
    
    private static final Logger logger = Logger.getLogger("com.ipn.verimov.restful.AutomotorResource");
    
     @PostConstruct
    public void init(){
        
    } 
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Automotor> getAutomotors() {
        List<Automotor> list = new ArrayList<>();
        AutomotorFacade af = new AutomotorFacade();
        try{
            list = af.getEntitiesbyUser();
        }catch(IllegalArgumentException e){
            logger.log(Level.SEVERE, "Error al consultar las marcas, se envia vacio");
        }
        return list;
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Marca> getMarcas() {
        List<Marca> list = new ArrayList<>();
        MarcaFacade mf = new MarcaFacade();
        try{
            list = mf.getEntities();
        }catch(IllegalArgumentException e){
            logger.log(Level.SEVERE, "Error al consultar las marcas, se envia vacio");
        }
        return list;
    }
    
    @GET
    @Path("{marca}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Modelo> getModelos(@PathParam("marca") int marca) {
        List<Modelo> list = new ArrayList<>();
        ModeloFacade mf = new ModeloFacade();
        try{
            list = mf.getRange(marca);
        }catch(IllegalArgumentException e){
            logger.log(Level.SEVERE, "Error al consultar los modelos, se envia vacio");
        }
        return list;
    }
    
    @GET
    @Path("{marca}/{modelo}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Anio> getAnios(@PathParam("marca") int marca,@PathParam("modelo") int modelo) {
        List<Anio> list = new ArrayList<>();
        AnioFacade af = new AnioFacade();
        try{
            list = af.getRange(marca,modelo);
        }catch(IllegalArgumentException e){
            logger.log(Level.SEVERE, "Error al consultar los anios, se envia vacio");
        }
        return list;
    }
    
    @GET
    @Path("{marca}/{modelo}/{anio}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Version> getVersiones(@PathParam("marca") int marca,@PathParam("modelo") int modelo,@PathParam("anio") int anio) {
        List<Version> list = new ArrayList<>();
        VersionFacade vf = new VersionFacade();
        try{
            list = vf.getRange(marca,modelo,anio);
        }catch(IllegalArgumentException e){
            logger.log(Level.SEVERE, "Error al consultar los anios, se envia vacio");
        }
        return list;
    }
    
    //Metodo para insertar nueva marca
    //Regresa Respuesta 202 confirmando la creacion de la marca
    //Regresa Respuesta 406 avisando que esta ya existe
    @POST
    @Path("savemarca")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveMarca(Marca m){
        Response.ResponseBuilder rb;
        MarcaFacade mf = new MarcaFacade();
        //Reviso si ya existe un registro Marca con ese nombre, si no procedo a crearla
        if(mf.getByName(m.getNombreMarca()).isEmpty()){
            mf.save(m);
            rb = Response.status(Response.Status.CREATED);
        }
        else{
            rb = Response.status(Response.Status.NOT_ACCEPTABLE);
        }
        return rb.build();
    }
    
    
    //Metodo para insertar nuevo modelo
    //Regresa Respuesta 202 confirmando la creacion de la modelo
    //Regresa Respuesta 406 avisando que esta ya existe
    @POST
    @Path("savemodelo")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveMarca(Modelo m){
        Response.ResponseBuilder rb;
        ModeloFacade mf = new ModeloFacade();
        //Reviso si ya existe un registro Marca con ese nombre, si no procedo a crearla
        if(mf.getByName(m.getNombreModelo(),m.getModeloPK().getMarcaidMarca()).isEmpty()){
            mf.save(m);
            rb = Response.status(Response.Status.CREATED);
        }
        else{
            rb = Response.status(Response.Status.NOT_ACCEPTABLE);
        }
        return rb.build();
    }
    
    
    //Metodo para insertar nuevo año
    //Regresa Respuesta 202 confirmando la creacion del año
    //Regresa Respuesta 406 avisando que esta ya existe
    @POST
    @Path("saveanio")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveAnio(Anio a){
        Response.ResponseBuilder rb;
        AnioFacade af = new AnioFacade();
        //Reviso si ya existe un registro Marca con ese nombre, si no procedo a crearla
        if(af.getByAnio(a.getNumAnio(),a.getAnioPK().getModeloMarcaidMarca(),a.getAnioPK().getModeloidModelo()).isEmpty()){
            af.save(a);
            rb = Response.status(Response.Status.CREATED);
        }
        else{
            rb = Response.status(Response.Status.NOT_ACCEPTABLE);
        }
        return rb.build();
    }
    
    //Metodo para insertar nuevo version
    //Regresa Respuesta 202 confirmando la creacion de la version
    //Regresa Respuesta 406 avisando que esta ya existe
    @POST
    @Path("saveversion")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveVersion(Version v){
        Response.ResponseBuilder rb;
        VersionFacade vf = new VersionFacade();
        try{
            vf.save(v);
            rb = Response.status(Response.Status.CREATED);
        }catch(Exception e){
            logger.log(Level.INFO, "No se pudo crear la nueva version");
            rb = Response.status(Response.Status.NOT_ACCEPTABLE);
        }
        return rb.build();
    }
    
    //Metodo para insertar nuevo version
    //Regresa Respuesta 202 confirmando la creacion de la version
    //Regresa Respuesta 406 avisando que esta ya existe
    @POST
    @Path("saveautomotor")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveAutomotor(Automotor a){
        Response.ResponseBuilder rb;
        AutomotorFacade af = new AutomotorFacade();
        try{
            af.save(a);
            rb = Response.status(Response.Status.CREATED);
        }catch(Exception e){
            logger.log(Level.INFO, "No se pudo insertar el nuevo automotor, ya existe para este usuario");
            rb = Response.status(Response.Status.NOT_ACCEPTABLE);
        }
        return rb.build();
    }
    
}
