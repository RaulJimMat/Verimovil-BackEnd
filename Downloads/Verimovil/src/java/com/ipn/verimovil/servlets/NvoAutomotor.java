/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.verimovil.servlets;

import com.ipn.verimov.consumer.RestConsumer;
import com.ipn.verimovil.rest.Automotor;
import com.ipn.verimovil.rest.AutomotorPK;
import com.ipn.verimovil.rest.Usuario;
import com.ipn.verimovil.rest.Version;
import com.ipn.verimovil.rest.VersionPK;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

/**
 *
 * @author Raul
 */
@WebServlet(name = "NvoAutomotor", urlPatterns = {"/NvoAutomotor"})
public class NvoAutomotor extends HttpServlet {

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
        RestConsumer rc = new RestConsumer();
        
        String idMarca = (String)(request.getSession().getAttribute("idMarca"));
        String idModelo = (String) request.getSession().getAttribute("idModelo");
        String idAnio = (String) request.getSession().getAttribute("idAnio");
        String user = (String) request.getSession().getAttribute("user");
        String idVersion = request.getParameter("version");
        String numSerie = request.getParameter("numserie");
        String transmision = request.getParameter("transmision");
        
        Automotor a = new Automotor(new AutomotorPK(numSerie, user));
        a.setTipoTransmision(transmision);
        a.setUsuario(new Usuario(user));
        a.setVersion(new Version(new VersionPK(Integer.parseInt(idVersion), Integer.parseInt(idAnio), Integer.parseInt(idModelo), Integer.parseInt(idMarca))));
        
        Response r = rc.saveAutomotor(a);
        
        if(r.getStatus() == Response.Status.CREATED.getStatusCode()){
            request.getSession().removeAttribute("idMarca");
            request.getSession().removeAttribute("idModelo");
            request.getSession().removeAttribute("idAnio");
            RequestDispatcher dispatcher = request.getRequestDispatcher("ListaAutomotores");
            dispatcher.forward(request, response);
        }else{
            if(r.getStatus() == Response.Status.NOT_ACCEPTABLE.getStatusCode()){
                request.getSession().removeAttribute("idMarca");
                request.getSession().removeAttribute("idModelo");
                request.getSession().removeAttribute("idAnio");
                RequestDispatcher dispatcher = request.getRequestDispatcher("Autoyetcreated.jsp");
                dispatcher.forward(request, response);
            }else{
                response.sendRedirect("error.jsp");
            }
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
