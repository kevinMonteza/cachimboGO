/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import design.IUsuarioSubtemaDAO;
import java.sql.Connection;

/**
 *
 * @author isaac
 */
public class UsuarioSubtemaDAO implements IUsuarioSubtemaDAO{
    private Connection connection;
    public UsuarioSubtemaDAO(Connection connection) {
        this.connection=connection;
    }
    
}
