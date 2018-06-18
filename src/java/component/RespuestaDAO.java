/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import design.IRespuestaDAO;
import java.sql.Connection;

/**
 *
 * @author isaac
 */
public class RespuestaDAO implements IRespuestaDAO{

    private Connection connection;
    public RespuestaDAO(Connection connection) {
        this.connection=connection;
    }
    
}
