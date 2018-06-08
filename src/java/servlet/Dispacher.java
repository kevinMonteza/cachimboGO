/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kevinMC
 */
/**
 *
 * Clase intermedia responsable de la autorizacion de acceso (login) administrar
 * las diferenctes vistas .jsp
 *
 */
public class Dispacher {

    RequestDispatcher dispatcher;

    public Dispacher() {
    }

    public String viewLogin() {
        return "";
    }

    public String viewIndex() {
        return "";
    }

    void isUser(HttpServletRequest request, HttpServletResponse response) {
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String path="";
        if (true) {
            path="/index.jsp";
        } else {
            path="error.jsp";
        }
        try {
            dispatcher = request.getRequestDispatcher(path);
            dispatcher.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(Dispacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
