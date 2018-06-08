/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import to.AsignaturaTO;

/**
 *
 * @author kevinMC
 *
 * https://jarroba.com/ajax-con-jsp-y-servelts/ https://github.com/miw-upm
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    Dispacher dispacher = new Dispacher();

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
        response.setContentType("text/html;charset=UTF-8");
        String instruccion = request.getParameter("instruccion");
        switch (instruccion) {
            case "asignaturas":
                getAsignaturas(request, response);
                break;
            case "login":
                dispacher.isUser(request, response);
                break;
            case "temas":
                getTemas(request, response);
                break;
            case "subtemas":
                getSubtemas(request, response);
                break;
            case "preguntas":
                getPreguntas(request, response);
                break;
            default:
                throw new AssertionError();
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

    private void getAsignaturas(HttpServletRequest request, HttpServletResponse response) {
        try {
            /**
             * Aca obtenemos las asiganturas desde los daos
             */
            List<AsignaturaTO> lista = DAOFactory.getInstance().getAsignaturaDAO().getAsignaturas();
            System.out.println("entro !!!!"+lista);
            request.setAttribute("lista", lista);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        } catch (ServletException | IOException | SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getTemas(HttpServletRequest request, HttpServletResponse response) {
        /**
         * aca se obtiene los temas por asignatura desdelos daos recibe como
         * parametro un id =>request.getParametrer("id")
         */
    }

    private void getSubtemas(HttpServletRequest request, HttpServletResponse response) {
        /**
         * aca obtenemos los subtemas por tema desde los daos recibe como
         * parametro un id =>request.getParametrer("id")
         */
    }

    private void getPreguntas(HttpServletRequest request, HttpServletResponse response) {
        /**
         * obtiene las preguntas por subtema recibe un id
         * =>request;getParametrer("id")
         */
    }

}
