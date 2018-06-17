/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import design.IUsuarioTemaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import to.TemaTO;
import to.UsuarioTO;
import to.UsuarioTemaTO;

/**
 *
 * @author isaac
 */
public class UsuarioTemaDAO implements IUsuarioTemaDAO{
    private final Connection connection;
    private PreparedStatement st;
    private List<UsuarioTemaTO> usuarioTemas;
    
    public UsuarioTemaDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public List<UsuarioTemaTO> getTemaByUsuario(UsuarioTO usuario) {
        usuarioTemas = new ArrayList<>();
        try {
            String sql = "select T.id_tema, UT.porcentaje, T.nombre "
                    + "from usuario_tema as UT "
                    + "inner join tema as T on UT.id_tema = T.id_tema "
                    + "where id_usuario = ?;";
            st = connection.prepareStatement(sql);
            st.setInt(1, usuario.getIdUsuario());
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                TemaTO tema = new TemaTO();
                UsuarioTemaTO usuarioTema = new UsuarioTemaTO();
                usuarioTema.setIdUsuario(usuario);
                tema.setIdTema(rs.getInt(2));
                tema.setNombre(rs.getString(4));
                usuarioTema.setIdTema(tema);
                usuarioTema.setPorcentaje(rs.getDouble(3));
                usuarioTemas.add(usuarioTema);
            }
            rs.close();
            return usuarioTemas;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioTemaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioTemaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public boolean insertUsuarioTema(UsuarioTemaTO usuarioTema) {
        String sql = "insert into usuario_tema"
                + "(id_usuario, "
                + "id_tema, "
                + "porcentaje) "
                + "values(?, ?, ?);";
        try {
            connection.setAutoCommit(false);
            st = connection.prepareStatement(sql);
            st.setInt(1, usuarioTema.getIdUsuario().getIdUsuario());
            st.setInt(2, usuarioTema.getIdTema().getIdTema());
            st.setDouble(3, usuarioTema.getPorcentaje());
            st.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioTemaDAO.class.getName()).log(Level.SEVERE, null, ex);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(UsuarioTemaDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            return false;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioTemaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioTemaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public boolean updateUsuarioTema(UsuarioTemaTO usuarioTema) {
        String sql = "update usuario_tema "
                + "set porcentaje = ?"
                + "where id_tema = ? and id_usuario = ?;";
        try {
            connection.setAutoCommit(false);
            st = connection.prepareStatement(sql);
            st.setDouble(1, usuarioTema.getPorcentaje());
            st.setInt(2, usuarioTema.getIdTema().getIdTema());
            st.setInt(3, usuarioTema.getIdUsuario().getIdUsuario());
            st.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioTemaDAO.class.getName()).log(Level.SEVERE, null, ex);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(UsuarioTemaDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            return false;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioTemaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioTemaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
