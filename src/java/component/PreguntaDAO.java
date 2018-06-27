/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import design.IPreguntaDAO;
import facade.FachadaPregunta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import to.DificultadTO;
import to.PreguntaTO;
import to.SubtemaTO;
import to.TipoPreguntaTO;

/**
 *
 * @author isaac
 */
public class PreguntaDAO implements IPreguntaDAO {

    private Connection connection;
    private PreparedStatement st;
    private List<PreguntaTO> preguntas;
    FachadaPregunta fachada = null;

    public PreguntaDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<PreguntaTO> getPreguntas() {
        preguntas = new ArrayList<>();
        try {
            String sql = "select id_pregunta, enunciado, clave1, clave2, clave3, clave4, clave5, estado, s.id_subtema, tp.id_tipopregunta, d.id_dificultad, d.nivel, correcta_num, informacion "
                    + "from pregunta "
                    + "inner join subtema s on pregunta.id_subtema = s.id_subtema "
                    + "inner join dificultad d on pregunta.id_dificultad = d.id_dificultad "
                    + "inner join tipo_pregunta tp on pregunta.id_tipopregunta = tp.id_tipopregunta;";
            st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                fachada = new FachadaPregunta(rs);
                preguntas.add(fachada.getPregunta());
            }
            rs.close();
            return preguntas;
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
    public PreguntaTO getPreguntaById(Integer id_pregunta) {
        PreguntaTO pregunta = new PreguntaTO();
        try {
            String sql = "select enunciado, clave1, clave2, clave3, clave4, clave5, estado, s.id_subtema, tp.id_tipopregunta, d.id_dificultad, d.nivel, correcta_num, informacion "
                    + "from pregunta "
                    + "inner join subtema s on pregunta.id_subtema = s.id_subtema "
                    + "inner join dificultad d on pregunta.id_dificultad = d.id_dificultad "
                    + "inner join tipo_pregunta tp on pregunta.id_tipopregunta = tp.id_tipopregunta "
                    + "where id_pregunta = ?";
            st = connection.prepareStatement(sql);
            st.setInt(1, id_pregunta);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                SubtemaTO subtema = new SubtemaTO();
                TipoPreguntaTO tp = new TipoPreguntaTO();
                DificultadTO dificultad = new DificultadTO();
                pregunta.setIdPregunta(id_pregunta);
                pregunta.setEnunciado(rs.getString(1));
                pregunta.setClave1(rs.getString(2));
                pregunta.setClave2(rs.getString(3));
                pregunta.setClave3(rs.getString(4));
                pregunta.setClave4(rs.getString(5));
                pregunta.setClave5(rs.getString(6));
                pregunta.setEstado(rs.getInt(7));
                subtema.setIdSubtema(rs.getInt(8));
                tp.setIdTipopregunta(rs.getInt(9));
                dificultad.setIdDificultad(rs.getInt(10));
                dificultad.setNivel(rs.getString(11));
                pregunta.setIdDificultad(dificultad);
                pregunta.setIdSubtema(subtema);
                pregunta.setIdTipopregunta(tp);
                pregunta.setCorrectaNum(rs.getInt(12));
                pregunta.setInformacion(rs.getString(13));
                rs.close();
                return pregunta;
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
    public List<PreguntaTO> getPreguntasBySubtema(Integer id_subtema) {
        preguntas = new ArrayList<>();
        try {
            String sql = "select id_pregunta, enunciado, clave1, clave2, clave3, clave4, clave5, estado, tp.id_tipopregunta, d.id_dificultad, d.nivel, correcta_num, informacion "
                    + "from pregunta "
                    + "inner join subtema s on pregunta.id_subtema = s.id_subtema "
                    + "inner join dificultad d on pregunta.id_dificultad = d.id_dificultad "
                    + "inner join tipo_pregunta tp on pregunta.id_tipopregunta = tp.id_tipopregunta "
                    + "where s.id_subtema = ?";
            st = connection.prepareStatement(sql);
            st.setInt(1, id_subtema);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                fachada = new FachadaPregunta(rs);
                preguntas.add(fachada.getPreguntaBySubtema(id_subtema));
            }
            rs.close();
            return preguntas;
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
    public boolean deletePregunta(Integer id_pregunta) {
        String sql = "delete from pregunta where id_pregunta = ?";
        try {
            connection.setAutoCommit(false);
            st = connection.prepareStatement(sql);
            st.setInt(1, id_pregunta);
            st.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PreguntaDAO.class.getName()).log(Level.SEVERE, null, ex);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(PreguntaDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            return false;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(PreguntaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    public boolean updatePregunta(PreguntaTO id_pregunta) {
        String sql = "update pregunta "
                + "set enunciado = ?, "
                + "clave1 = ?, "
                + "clave2 = ?, "
                + "clave3 = ?, "
                + "clave4 = ?, "
                + "clave5 = ?, "
                + "estado = ?, "
                + "id_subtema = ?, "
                + "id_tipopregunta = ?, "
                + "id_dificultad = ?, "
                + "correcta_num = ?, "
                + "informacion = ? "
                + "where id_pregunta = ?;";
        try {
            connection.setAutoCommit(false);
            st = connection.prepareStatement(sql);
            st.setString(1, id_pregunta.getEnunciado());
            st.setString(2, id_pregunta.getClave1());
            st.setString(3, id_pregunta.getClave2());
            st.setString(4, id_pregunta.getClave3());
            st.setString(5, id_pregunta.getClave4());
            st.setString(6, id_pregunta.getClave5());
            st.setInt(7, id_pregunta.getEstado());
            st.setInt(8, id_pregunta.getIdSubtema().getIdSubtema());
            st.setInt(9, id_pregunta.getIdTipopregunta().getIdTipopregunta());
            st.setInt(10, id_pregunta.getIdDificultad().getIdDificultad());
            st.setInt(11, id_pregunta.getCorrectaNum());
            st.setString(12, id_pregunta.getInformacion());
            st.setInt(13, id_pregunta.getIdPregunta());
            st.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PreguntaDAO.class.getName()).log(Level.SEVERE, null, ex);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(PreguntaDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            return false;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(PreguntaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    public boolean insertPregunta(PreguntaTO id_pregunta) {
        String sql = "insert into pregunta"
                + "(id_pregunta, "
                + "enunciado, "
                + "clave1, "
                + "clave2, "
                + "clave3, "
                + "clave4, "
                + "clave5, "
                + "estado, "
                + "id_subtema, "
                + "id_tipopregunta, "
                + "id_dificultad, "
                + "correcta_num, "
                + "informacion) "
                + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            connection.setAutoCommit(false);
            st = connection.prepareStatement(sql);
            st.setInt(1, id_pregunta.getIdPregunta());
            st.setString(2, id_pregunta.getEnunciado());
            st.setString(3, id_pregunta.getClave1());
            st.setString(4, id_pregunta.getClave2());
            st.setString(5, id_pregunta.getClave3());
            st.setString(6, id_pregunta.getClave4());
            st.setString(7, id_pregunta.getClave5());
            st.setInt(8, id_pregunta.getEstado());
            st.setInt(9, id_pregunta.getIdSubtema().getIdSubtema());
            st.setInt(10, id_pregunta.getIdTipopregunta().getIdTipopregunta());
            st.setInt(11, id_pregunta.getIdDificultad().getIdDificultad());
            st.setInt(12, id_pregunta.getCorrectaNum());
            st.setString(13, id_pregunta.getInformacion());
            st.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PreguntaDAO.class.getName()).log(Level.SEVERE, null, ex);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(PreguntaDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            return false;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(PreguntaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    public List<PreguntaTO> getPreguntasRandom(Integer id_subtema, Integer tipo) {
        Integer i = 0, cantidad;
        System.out.println("entro");
        preguntas = new ArrayList<>();
        List<PreguntaTO> preguntasRandom = new ArrayList<>();
        List<Integer> randoms = new ArrayList<>();
        if (tipo == 0) {
            cantidad = 7;
        } else {
            cantidad = 10;
        }
        while (i < cantidad) {
            preguntas = this.getPreguntasBySubtema(id_subtema);
            Random rand = new Random();
            Integer nrand = rand.nextInt(preguntas.size());
            if (randoms.isEmpty() || !randoms.contains(nrand)) {
                randoms.add(nrand);
                preguntasRandom.add(preguntas.get(nrand));
                i++;
            }
        }
        return preguntasRandom;
    }

}
