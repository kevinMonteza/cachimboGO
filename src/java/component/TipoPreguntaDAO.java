/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import design.ITipoPreguntaDAO;
import java.sql.Connection;

/**
 *
 * @author isaac
 */
public class TipoPreguntaDAO implements ITipoPreguntaDAO{
    private final Connection connection;
    public TipoPreguntaDAO(Connection connection) {
        this.connection=connection;
    }
}
