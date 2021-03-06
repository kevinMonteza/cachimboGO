/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import design.ISubtemaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import to.AsignaturaTO;
import to.SubtemaTO;
import to.TemaTO;

/**
 *
 * @author isaac
 */
public class SubtemaDAO implements ISubtemaDAO {

    private final Connection connection;
    private PreparedStatement st;
    private List<SubtemaTO> subtemas;

    public SubtemaDAO(Connection connection) {
        this.connection = connection;
    }
    

    @Override
    public SubtemaTO getSubtemaById(Integer id_subtema) {
        SubtemaTO subtema = new SubtemaTO();
        try {
            String sql = "select nombre, id_tema from subtema where id_subtema = ?;";
            st = connection.prepareStatement(sql);
            st.setInt(1, id_subtema);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                TemaTO tema = new TemaTO();
                subtema.setIdSubtema(id_subtema);
                subtema.setNombre(rs.getString(1));
                tema.setIdTema(rs.getInt(2));
                subtema.setIdTema(tema);
                rs.close();
                return subtema;
            } else {
                rs.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubtemaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SubtemaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<SubtemaTO> getSubtemas() {
        subtemas = new ArrayList<>();
        try {
            String sql = "select id_subtema, nombre, id_tema from subtema;";
            st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TemaTO tema = new TemaTO();
                SubtemaTO subtema = new SubtemaTO();
                subtema.setIdSubtema(rs.getInt(1));
                subtema.setNombre(rs.getString(2));
                tema.setIdTema(rs.getInt(3));
                subtema.setIdTema(tema);
                subtemas.add(subtema);
            }
            rs.close();
            return subtemas;
        } catch (SQLException ex) {
            Logger.getLogger(SubtemaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SubtemaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<SubtemaTO> getSubtemasByTema(Integer id_tema) {
        subtemas = new ArrayList<>();
        try {
            String sql = "select id_subtema, nombre from subtema where id_tema = ?;";
            st = connection.prepareStatement(sql);
            st.setInt(1, id_tema);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TemaTO tema = new TemaTO();
                SubtemaTO subtema = new SubtemaTO();
                subtema.setIdSubtema(rs.getInt(1));
                subtema.setNombre(rs.getString(2));
                tema.setIdTema(id_tema);
                subtema.setIdTema(tema);
                subtemas.add(subtema);
            }
            rs.close();
            return subtemas;
        } catch (SQLException ex) {
            Logger.getLogger(SubtemaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SubtemaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public TemaTO getTemaBySubtema(int id_subtema) {
        try {
            TemaTO tema = new TemaTO();
            String sql = "select tema.id_tema,tema.nombre,tema.id_asignatura from tema inner join subtema s on tema.id_tema = s.id_tema where id_subtema= ?;";
            st = connection.prepareStatement(sql);
            st.setInt(1, id_subtema);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                tema.setIdTema(rs.getInt(1));
                tema.setNombre(rs.getString(2));
                AsignaturaTO asignatura = new AsignaturaTO();
                asignatura.setIdAsignatura(rs.getInt(3));
                tema.setIdAsignatura(asignatura);
                return tema;
            } else {
                rs.close();
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SubtemaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SubtemaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
