/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import design.IDificultadDAO;
import java.sql.Connection;

/**
 *
 * @author isaac
 */
public class DificultadDAO implements IDificultadDAO {

    private final Connection connection;

    public DificultadDAO(Connection connection) {
        this.connection = connection;
    }
}
