/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import component.*;
import database.MysqlConnection;
import design.*;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author isaac
 */
public class DAOFactory {
    private static DAOFactory daoFac;
    private static Connection connection;
    
    static{
        daoFac = new DAOFactory();
        connection = MysqlConnection.getConexion();
    }
    
    public static DAOFactory getInstance(){
        return daoFac;
    }
    
    public IAsignaturaDAO getAsignaturaDAO() throws SQLException{
        return new AsignaturaDAO(connection);
    }
    
    public IDificultadDAO getDificultadDAO(){
        return new DificultadDAO(connection);
    }
    
    public IPreguntaDAO getPreguntaDAO() throws SQLException{
        return new PreguntaDAO(connection);
    }
    
    public IRespuestaDAO getRespuestaDAO(){
        return new RespuestaDAO(connection);
    }
    
    public ISubtemaDAO getSubtemaDAO() throws SQLException{
        return new SubtemaDAO(connection);
    }
    
    public ITemaDAO getTemaDAO() throws SQLException{
        return new TemaDAO(connection);
    }
    
    public ITipoPreguntaDAO getTipoPreguntaDAO(){
        return new TipoPreguntaDAO(connection);
    }
    
    public IUsuarioAsignaturaDAO getUsuarioAsignaturaDAO(){
        return new UsuarioAsignaturaDAO(connection);
    }
    
    public IUsuarioDAO getUsuarioDAO(){
        return new UsuarioDAO(connection);
    }
    
    public IUsuarioSubtemaDAO getUsuarioSubtemaDAO(){
        return new UsuarioSubtemaDAO(connection);
    }
    
    public IUsuarioTemaDAO getUsuarioTemaDAO(){
        return new UsuarioTemaDAO(connection);
    }
}
