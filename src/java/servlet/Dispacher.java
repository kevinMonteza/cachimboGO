/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kevinMC
 */

/**
 * 
 * Clase intermedia responsable de la autorizacion de acceso (login) 
 * administrar las diferenctes vistas .jsp
 * 
 */
public class Dispacher {

    public Dispacher() {
    }
    
    public String  viewLogin(){
        return "";
    }
    public String viewIndex(){
         return "";
    }

    void isUser(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
