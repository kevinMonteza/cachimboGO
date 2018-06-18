/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import design.IUsuarioDAO;
import java.sql.Connection;

/**
 *
 * @author isaac
 */
public class UsuarioDAO implements IUsuarioDAO{
    private Connection connection;
    public UsuarioDAO(Connection connection) {
        this.connection=connection;
    }
    
}
