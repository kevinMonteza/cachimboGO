/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import design.IArticuloDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import to.ArticuloTO;

/**
 *
 * @author isaac
 */
public class ArticuloDAO implements IArticuloDAO {

    private final Connection connection;
    private PreparedStatement st;
    private List<ArticuloTO> articulos;

    public ArticuloDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<ArticuloTO> getArticulos() {
        articulos = new ArrayList<>();
        try {
            String sql = "select id_articulo, nombre, descripcion, costo from articulo;";
            st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ArticuloTO articulo = new ArticuloTO();
                articulo.setIdArticulo(rs.getInt(1));
                articulo.setNombre(rs.getString(2));
                articulo.setDescripcion(rs.getString(3));
                articulo.setCosto(rs.getInt(4));
                articulos.add(articulo);
            }
            rs.close();
            return articulos;
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public ArticuloTO getArticuloById(Integer id_articulo) {
        ArticuloTO articulo = new ArticuloTO();
        try {
            String sql = "select nombre, descripcion, costo from articulo where id_articulo = ?;";
            st = connection.prepareStatement(sql);
            st.setInt(1, id_articulo);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                articulo.setIdArticulo(id_articulo);
                articulo.setNombre(rs.getString(1));
                articulo.setDescripcion(rs.getString(2));
                articulo.setCosto(rs.getInt(3));
                rs.close();
                return articulo;
            } else {
                rs.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public boolean insertArticulo(ArticuloTO articulo) {
        String sql = "insert into articulo"
                + "(id_articulo, "
                + "nombre, "
                + "descripcion, "
                + "costo) "
                + "values(?, ?, ?, ?);";
        try {
            connection.setAutoCommit(false);
            st = connection.prepareStatement(sql);
            st.setInt(1, articulo.getIdArticulo());
            st.setString(2, articulo.getNombre());
            st.setString(3, articulo.getDescripcion());
            st.setInt(4, articulo.getCosto());
            st.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            return false;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ArticuloDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
