
package servlets;

import beans.QuidditchEJB;
import entities.Coaches;
import exceptions.QuidditchException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InsertEntrenador extends HttpServlet {

    @EJB QuidditchEJB miEJB;
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, QuidditchException {
        String username = request.getParameter("username");
        String password = request.getParameter("passw");
        String fecha_nac = request.getParameter("fecha");
        DateFormat df = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
        Date fecha =  df.parse(fecha_nac);
        String fullname = request.getParameter("ncompleto");        
        
        Coaches c = new Coaches(username, fullname, fecha, password);
        
        try {
            miEJB.insertEntrenador(c);
            request.setAttribute("status", "Empleado registrado");
        } catch (QuidditchException ex) {
            request.setAttribute("status", ex.getMessage());
        }
        
        request.getRequestDispatcher("/final.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(InsertEntrenador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (QuidditchException ex) {
            Logger.getLogger(InsertEntrenador.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(InsertEntrenador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (QuidditchException ex) {
            Logger.getLogger(InsertEntrenador.class.getName()).log(Level.SEVERE, null, ex);
        }
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