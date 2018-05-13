/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.QuidditchEJB;
import exceptions.QuidditchException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JOSEP Mª
 */
public class ModificarPerfilServlet extends HttpServlet {

    @EJB
    QuidditchEJB miEJB;

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
        String nombre = (String) request.getSession(true).getAttribute("username");
        String fullName = request.getParameter("fullName");
        String password = request.getParameter("password");

        Class<?> enclosingClass = getClass().getEnclosingClass();
        if (enclosingClass != null) {
            System.out.println(enclosingClass.getName());
        } else {
            System.out.println(getClass().getName());
        }

        try {
            if (enclosingClass.equals("Coaches")) {
                miEJB.modificarPerfilCoaches(fullName, password, nombre);
                request.setAttribute("status", "Se ha modificado correctamente el perfil");

            } else if (enclosingClass.equals("Players")) {
                miEJB.modificarPerfilPlayers(fullName, password, nombre);
                request.setAttribute("status", "Se ha modificado correctamente el perfil");
            } else if (enclosingClass.equals("Schools")) {
                miEJB.modificarPerfilSchools(fullName, password, nombre);
                request.setAttribute("status", "Se ha modificado correctamente el perfil");
            }
        } catch (QuidditchException ex) {
            request.setAttribute("status", ex.getMessage());
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
