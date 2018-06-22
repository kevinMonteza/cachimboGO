/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import design.IArticulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import to.ArticuloTO;
import to.AsignaturaTO;

/**
 *
 * @author kevinMC
 */
public class ArticuloDAO implements IArticulo {

    private Connection connection;
    private PreparedStatement st;
    private List<ArticuloTO> lista;

    public ArticuloDAO(Connection connection) throws SQLException {
        this.connection = connection;
    }

    @Override
    public List<ArticuloTO> getArticulos() {
        lista = new ArrayList<>();
        try {
            String sql = "select * from articulo;";
            st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ArticuloTO articulo = new ArticuloTO();
                articulo.setId_articulo(rs.getInt(1));
                articulo.setNombre(rs.getString(2));
                articulo.setDescripcion(rs.getString(3));
                articulo.setCosto(rs.getDouble(4));
                lista.add(articulo);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(AsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
