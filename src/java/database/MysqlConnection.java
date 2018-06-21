/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author isaac
 */
public class MysqlConnection {

    private static Connection _connection = null;
   /* String name_db = "u736411459_bd";
    String host = "sql141.main-hosting.eu";
    String user = "u736411459_alexk";
    String password = "ruEvGTzVY1F7";*/
    String name_db = "u736411459_bd";
    String host = "localhost";
    String user = "root";
    String password = "";

    private MysqlConnection() {
        String driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver).newInstance();
            _connection = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + name_db, user, password);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.out.println("Error Duplicado el objeto _connection" + e.getMessage());
           
        }

    }

    public static Connection getConexion() {

        if (_connection == null) {
            System.out.println("entro al if conexion");
            new MysqlConnection();
        } else {
            System.out.println("No entro al if");
        }
        return _connection;
    }
}