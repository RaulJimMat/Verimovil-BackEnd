/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.verimov.consumer;

import com.ipn.verimovil.rest.Anio;
import com.ipn.verimovil.rest.Automotor;
import com.ipn.verimovil.rest.Marca;
import com.ipn.verimovil.rest.Modelo;
import com.ipn.verimovil.rest.Version;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.catalina.WebResource;

/**
 *
 * @author Raul
 */
public class RestConsumer {
    
    private Client client ;
    private WebTarget target ;
    private WebResource resource;
    
    private static final Logger LOGGER = Logger.getLogger("com.ipn.verimovil.consumer.RestConsumer");

    public RestConsumer() {
        client = ClientBuilder.newClient();
        target = client.target("http://localhost:8080/VeriMovil21/resources/");
    }
    
    public Response enviarMail(String user){
        Response resp = target.path("login").path("recover").path(user).request().accept(MediaType.APPLICATION_JSON).get(Response.class);
        return resp;
    }
    
    public List<Marca> getMarcas(){
        List<Marca> lista = target.path("automotor").request().get(new GenericType<List<Marca>>(){});
        LOGGER.log(Level.INFO, "lISTA DE {0}", lista.size());
        return lista;
    }

    public List<Modelo> getModelos(String idMarca) {
        List<Modelo> list = target.path("automotor").path(idMarca).request().get(new GenericType<List<Modelo>>(){});
        return list;
    }
    
    public List<Anio> getAnios(String idMarca, String idModelo){
        List<Anio> list = target.path("automotor").path(idMarca).path(idModelo).request().get(new GenericType<List<Anio>>(){});
        return list;
    }

    public List<Version> getVersions(String idMarca, String idModelo, String idAnio) {
        List<Version> list = target.path("automotor").path(idMarca).path(idModelo).path(idAnio).request().get(new GenericType<List<Version>>(){});
        return list;
    }
    
    public Response saveAutomotor(Automotor a){
        Response resp = target.path("automotor").path("saveautomotor").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(a));
        return resp;
    }
    
    public List<Automotor> getAutomotors(String Username){
        
        List<Automotor> automotors = target.path("automotor").queryParam("user", Username).request().get(new GenericType<List<Automotor>>(){});
        return automotors;
    }
    
}
