/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.verimovil.servlets;

import com.ipn.verimovil.rest.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.catalina.WebResource;
import org.glassfish.jersey.client.ClientResponse;

/**
 *
 * @author Raul
 */
@WebServlet(name = "NewUser", urlPatterns = {"/newuser"})
public class NewUser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            //Se  obtiene los parametros que envia el usuario
            Usuario u = new Usuario();
            u.setNombreUsuario(request.getParameter("username"));
            u.setNombre(request.getParameter("nombre"));
            u.setAPaterno(request.getParameter("apellidop"));
            u.setAMaterno(request.getParameter("apellidom"));
            u.setCorreo(request.getParameter("email"));
            char g = (request.getParameter("sexo").equals("Hombre"))?'m':'f';
            u.setGenero(Character.valueOf(g));
            u.setPassword(request.getParameter("pass"));
            u.setRol(Character.valueOf('u'));
            
            //Esto va en una clase controladora del servicio rest regresa un objeto response y de parametro entran un Usuario u
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://localhost:8080/VeriMovil21/resources/login");
            
            
            Response resp = target.path("registro")
                                    .request().accept(MediaType.APPLICATION_JSON).post(Entity.json(u));
            
            System.out.println(resp.getStatus());
            
            if(resp.getStatus() == 202){
                System.out.println("Usuario agregado");
            }
            if(resp.getStatus() == 406){
                System.out.println("usuario ya existe");
            }
            
            
        
        
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
