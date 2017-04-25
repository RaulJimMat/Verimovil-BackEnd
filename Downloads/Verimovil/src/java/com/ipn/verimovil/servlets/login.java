/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.verimovil.servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Raul
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class login extends HttpServlet {

    private static final int STATUS_OK = 200;
    private static final int STATUS_ACCEPTED = 202;
    private static final int STATUS_UNAUTHORIZED = 401;
    private static final int STATUS_NOT_ACCEPTABLE = 406;

    private static final Logger LOGGER = Logger.getLogger("com.ipn.verimovil.servlets.login");

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
        String Username = request.getParameter("username");
        String Password = request.getParameter("password");

        //Se prepara la peticion del servico RESTFul
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/VeriMovil21/resources/login/" + Username + "?pass=" + Password);
        Response resp = target.request().accept(MediaType.APPLICATION_JSON).get(Response.class);

        int status = resp.getStatus();

        switch (status) {
            case STATUS_ACCEPTED:
                //Logueo de un Administrador
                LOGGER.log(Level.INFO, "Administrador logueado {0}", Username);
                request.getSession().setAttribute("admin", Username);
                response.sendRedirect("admin.html");
                break;

            case STATUS_OK:
                //Logueo de un Usuario
                LOGGER.log(Level.INFO, "Usuario logueado {0}", Username);
                request.getSession().setAttribute("user", Username);
                response.sendRedirect("home.jsp");
                break;

            case STATUS_NOT_ACCEPTABLE:
                //Contraseña equivocada
                LOGGER.log(Level.INFO, "Contraseña erronea {0}", Username);
                response.sendRedirect("errorlogin.jsp");
                break;

            case STATUS_UNAUTHORIZED:
                //No existe Usuario
                LOGGER.log(Level.INFO, "No existe usuario}");
                response.sendRedirect("errorlogin.jsp");
                break;

            default:
                LOGGER.log(Level.INFO, "Error inesperado status {0}", status);
                response.sendRedirect("index.jsp");

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
