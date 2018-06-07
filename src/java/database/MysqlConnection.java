/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author isaac
 */
public class MysqlConnection {
    private static Connection _connection;
    String name_db = "u736411459_bd";
    String host = "sql141.main-hosting.eu";
    String user = "u736411459_alexk";
    String password = "ruEvGTzVY1F7";

    private MysqlConnection() {
        String driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver).newInstance();
            _connection = DriverManager.getConnection("jdbc:mysql://"+host+":3306/" + name_db, user, password);
        } catch (Exception e) {
            System.out.println("Error Duplicado el objeto _connection" + e.getMessage());
            e.printStackTrace();
        }

    }

    public static Connection getConexion() {

        if (_connection == null) {
            new MysqlConnection();
        }
        return _connection;
    }
}
