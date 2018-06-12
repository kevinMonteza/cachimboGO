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
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
public class Dispacher implements Servlet{

    RequestDispatcher dispatcher;

    public Dispacher() {
    }

    public String viewLogin() {
        return "";
    }

    public String viewIndex() {
        return "";
    }

    public String isUser(HttpServletRequest request) {
        String uname = request.getParameter("uname");
        String upass = request.getParameter("upass");
        String view ="/views/index.jsp";
        HttpSession session=null;
        if (uname.equals("f") && upass.equals("f")) {
            session = request.getSession();
            session.setAttribute("uname", uname);
            session.setAttribute("uname", upass);
        }
        return view;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ServletConfig getServletConfig() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getServletInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
