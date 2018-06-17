/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import design.IUsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import to.UsuarioTO;

/**
 *
 * @author isaac
 */
public class UsuarioDAO implements IUsuarioDAO {

    private final Connection connection;
    private PreparedStatement st;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean usuarioAuth(UsuarioTO usuario) {
        try {
            String sql = "select id_usuario from usuario where usuario = ? and password = ?";
            st = connection.prepareStatement(sql);
            st.setString(1, usuario.getUsuario());
            st.setString(2, usuario.getPassword());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                rs.close();
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    @Override
    public boolean insertUsuario(UsuarioTO usuario) {
        String sql = "insert into usuario"
                + "(id_usuario, "
                + "usuario, "
                + "password, "
                + "nombres, "
                + "apellidos, "
                + "correo, "
                + "monedas) "
                + "values(?, ?, ?, ?, ?, ?, ?);";
        try {
            connection.setAutoCommit(false);
            st = connection.prepareStatement(sql);
            st.setInt(1, 0);
            st.setString(2, usuario.getUsuario());
            st.setString(3, usuario.getPassword());
            st.setString(4, usuario.getNombres());
            st.setString(5, usuario.getApellido());
            st.setString(6, usuario.getCorreo());
            st.setInt(7, 0);
            st.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            return false;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
