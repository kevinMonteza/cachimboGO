/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import database.MysqlConnection;
import design.IAsignaturaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import to.AsignaturaTO;

/**
 *
 * @author isaac
 */
public class AsignaturaDAO implements IAsignaturaDAO {

    private final Connection connection;
    private PreparedStatement st;
    private List<AsignaturaTO> asignaturas;

    public AsignaturaDAO() throws SQLException {
        connection = MysqlConnection.getConexion();
    }

    @Override
    public AsignaturaTO getAsignaturaById(Integer id_asignatura) {
        AsignaturaTO asignatura = new AsignaturaTO();
        try {
            String sql = "select nombre from asignatura where id_asignatura = ?;";
            st = connection.prepareStatement(sql);
            st.setInt(1, id_asignatura);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                asignatura.setIdAsignatura(id_asignatura);
                asignatura.setNombre(rs.getString(1));
                rs.close();
                return asignatura;
            } else {
                rs.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PreguntaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PreguntaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<AsignaturaTO> getAsignaturas() {
        asignaturas = new ArrayList<>();
        try {
            String sql = "select id_asignatura, nombre from asignatura;";
            st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                AsignaturaTO asignatura = new AsignaturaTO();
                asignatura.setIdAsignatura(rs.getInt(1));
                asignatura.setNombre(rs.getString(2));
                asignaturas.add(asignatura);
            }
            rs.close();
            return asignaturas;
        } catch (SQLException ex) {
            Logger.getLogger(AsignaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PreguntaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
