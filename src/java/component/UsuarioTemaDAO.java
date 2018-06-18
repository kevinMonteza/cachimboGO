/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import design.IUsuarioTemaDAO;
import java.sql.Connection;

/**
 *
 * @author isaac
 */
public class UsuarioTemaDAO implements IUsuarioTemaDAO{
    private Connection connection;
    public UsuarioTemaDAO(Connection connection) {
        this.connection=connection;
    }
    
}
