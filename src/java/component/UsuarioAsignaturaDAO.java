/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import design.IUsuarioAsignaturaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import to.AsignaturaTO;
import to.UsuarioAsignaturaTO;
import to.UsuarioTO;

/**
 *
 * @author isaac
 */
public class UsuarioAsignaturaDAO implements IUsuarioAsignaturaDAO{
    private final Connection connection;
    private PreparedStatement st;
    private List<UsuarioAsignaturaTO> usuarioAsignaturas;
    
    public UsuarioAsignaturaDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public List<UsuarioAsignaturaTO> getAsignaturaByUsuario(UsuarioTO usuario) {
        usuarioAsignaturas = new ArrayList<>();
        try {
            String sql = "select A.id_asignatura, A.nombre, A.id_tipo_asignatura, porcentaje "
                    + "from usuario_asignatura as UA inner join asignatura as A "
                    + "on UA.id_asignatura = A.id_asignatura"
                    + "where id_usuario = ?;";
            st = connection.prepareStatement(sql);
            st.setInt(1, usuario.getIdUsuario());
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                AsignaturaTO asignatura = new AsignaturaTO();
                UsuarioAsignaturaTO usuarioAsignatura = new UsuarioAsignaturaTO();
                usuarioAsignatura.setIdUsuario(usuario);
                asignatura.setIdAsignatura(rs.getInt(1));
                asignatura.setNombre(rs.getString(2));
                asignatura.setIdTipoAsignatura(rs.getInt(3));
                usuarioAsignatura.setIdAsignatura(asignatura);
                usuarioAsignatura.setPorcentaje(rs.getDouble(4));
                usuarioAsignaturas.add(usuarioAsignatura);
            }
            rs.close();
            return usuarioAsignaturas;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioAsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioAsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public boolean insertUsuarioAsignatura(UsuarioAsignaturaTO usuarioAsignatura) {
        String sql = "insert into usuario_asignatura"
                + "(id_usuario, "
                + "id_asignatura, "
                + "porcentaje) "
                + "values(?, ?, ?);";
        try {
            connection.setAutoCommit(false);
            st = connection.prepareStatement(sql);
            st.setInt(1, usuarioAsignatura.getIdUsuario().getIdUsuario());
            st.setInt(2, usuarioAsignatura.getIdAsignatura().getIdAsignatura());
            st.setDouble(3, usuarioAsignatura.getPorcentaje());
            st.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioAsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(UsuarioAsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            return false;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioAsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioAsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public boolean updateUsuarioAsignatura(UsuarioAsignaturaTO usuarioAsignatura) {
        String sql = "update usuario_asignatura "
                + "set porcentaje = ?"
                + "where id_asignatura = ? and id_usuario = ?;";
        try {
            connection.setAutoCommit(false);
            st = connection.prepareStatement(sql);
            st.setDouble(1, usuarioAsignatura.getPorcentaje());
            st.setInt(2, usuarioAsignatura.getIdAsignatura().getIdAsignatura());
            st.setInt(3, usuarioAsignatura.getIdUsuario().getIdUsuario());
            st.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioAsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(UsuarioAsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            return false;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioAsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioAsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
}
