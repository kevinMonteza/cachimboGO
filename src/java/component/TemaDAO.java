/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import design.ITemaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import to.AsignaturaTO;
import to.TemaTO;
import to.UsuarioAsignaturaTO;

/**
 *
 * @author isaac
 */
public class TemaDAO implements ITemaDAO {

    private final Connection connection;
    private PreparedStatement st;
    private List<TemaTO> temas;
  

    public TemaDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public TemaTO getTemaById(Integer id_tema) {
        TemaTO tema = new TemaTO();
        try {
            String sql = "select nombre, id_asignatura from tema where id_tema = ?;";
            st = connection.prepareStatement(sql);
            st.setInt(1, id_tema);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                AsignaturaTO asignatura = new AsignaturaTO();
                asignatura.setIdAsignatura(rs.getInt(2));
                tema.setIdAsignatura(asignatura);
                tema.setIdTema(id_tema);
                tema.setNombre(rs.getString(1));
                return tema;
            } else {
                rs.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TemaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TemaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<TemaTO> getTemas() {
        temas = new ArrayList<>();
        try {
            String sql = "select id_tema, nombre, id_asignatura from asignatura;";
            st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                AsignaturaTO asignatura = new AsignaturaTO();
                TemaTO tema = new TemaTO();
                asignatura.setIdAsignatura(rs.getInt(3));
                tema.setIdAsignatura(asignatura);
                tema.setIdTema(rs.getInt(1));
                tema.setNombre(rs.getString(2));
                temas.add(tema);
            }
            rs.close();
            return temas;
        } catch (SQLException ex) {
            Logger.getLogger(TemaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TemaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<TemaTO> getTemasByAsignatura(Integer id_asignatura) {
        temas = new ArrayList<>();
        try {
            String sql = "select * from tema where id_asignatura=?;";
            st = connection.prepareStatement(sql);
            st.setInt(1, id_asignatura);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                AsignaturaTO asignatura = new AsignaturaTO();
                TemaTO tema = new TemaTO();
                asignatura.setIdAsignatura(id_asignatura);
                tema.setIdAsignatura(asignatura);
                tema.setIdTema(rs.getInt(1));
                tema.setNombre(rs.getString(2));
                temas.add(tema);
            }
            rs.close();
            return temas;
        } catch (SQLException ex) {
            Logger.getLogger(TemaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TemaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public int getTemasCompletados(UsuarioAsignaturaTO usuarioA) {

        try {
            String sql = "select count(*) from usuario_tema inner join usuario u on usuario_tema.id_usuario = u.id_usuario"
                    + "inner join usuario_asignatura a on u.id_usuario = a.id_usuario"
                    + " where u.id_usuario= ? and a.id_asignatura=? and usuario_tema.porcentaje=100;";
            st = connection.prepareStatement(sql);
            st.setInt(1, usuarioA.getIdUsuario().getIdUsuario());
            st.setInt(2, usuarioA.getIdAsignatura().getIdAsignatura());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TemaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TemaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
