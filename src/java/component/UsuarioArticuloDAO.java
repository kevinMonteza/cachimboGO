/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import design.IUsuarioArticuloDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import to.ArticuloTO;
import to.UsuarioArticuloTO;
import to.UsuarioTO;

/**
 *
 * @author isaac
 */
public class UsuarioArticuloDAO implements IUsuarioArticuloDAO {

    private final Connection connection;
    private PreparedStatement st;
    private List<UsuarioArticuloTO> usuarioArticulos;

    public UsuarioArticuloDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<UsuarioArticuloTO> getUsuarioArticulos(Integer id_usuario) {
        usuarioArticulos = new ArrayList<>();
        try {
            String sql = "select articulo.id_articulo, articulo.nombre "
                    + "from usuario_articulo "
                    + "inner join articulo "
                    + "on articulo.id_articulo = usuario_articulo.id_articulo "
                    + "where id_usuario = ?;";
            st = connection.prepareStatement(sql);
            st.setInt(1, id_usuario);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                UsuarioArticuloTO usuarioArticulo = new UsuarioArticuloTO();
                UsuarioTO usuario = new UsuarioTO();
                usuario.setIdUsuario(id_usuario);
                usuarioArticulo.setIdUsuario(usuario);
                ArticuloTO articulo = new ArticuloTO();
                articulo.setIdArticulo(rs.getInt(1));
                articulo.setNombre(rs.getString(rs.getString(2)));
                usuarioArticulo.setIdArticulo(articulo);
                usuarioArticulos.add(usuarioArticulo);
            }
            rs.close();
            return usuarioArticulos;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public boolean insertUsuarioArticulo(UsuarioArticuloTO usuarioArticulo) {
        String sql = "insert into usuario_articulo"
                + "(id_usuario, "
                + "id_articulo"
                + "values(?, ?);";
        try {
            connection.setAutoCommit(false);
            st = connection.prepareStatement(sql);
            st.setInt(1, usuarioArticulo.getIdUsuario().getIdUsuario());
            st.setInt(2, usuarioArticulo.getIdArticulo().getIdArticulo());
            st.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(UsuarioArticuloDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            return false;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
