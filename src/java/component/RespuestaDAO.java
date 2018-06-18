/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import design.IRespuestaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import to.PreguntaTO;
import to.RespuestaTO;
import to.UsuarioTO;

/**
 *
 * @author isaac
 */
public class RespuestaDAO implements IRespuestaDAO {

    private final Connection connection;
    private PreparedStatement st;
    private List<RespuestaTO> respuestas;

    public RespuestaDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<RespuestaTO> getRespuestasBySubtema(Integer id_subtema, Integer id_usuario) {
        respuestas = new ArrayList<>();
        List<Integer> idPreguntas = new ArrayList<>();
        try {
            String sql = "select id_pregunta from pregunta where id_subtema = ?;";
            st = connection.prepareStatement(sql);
            st.setInt(1, id_subtema);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                idPreguntas.add(rs.getInt(1));
            }
            rs.close();
            st.close();
            for (Integer id_pregunta : idPreguntas) {
                sql = "select acertada from respuesta where id_usuario = ? and id_pregunta = ?;";
                st = connection.prepareStatement(sql);
                st.setInt(1, id_usuario);
                st.setInt(2, id_pregunta);
                rs = st.executeQuery();
                if (rs.next()) {
                    RespuestaTO respuesta = new RespuestaTO();
                    PreguntaTO pregunta = new PreguntaTO();
                    UsuarioTO usuario = new UsuarioTO();
                    respuesta.setAcertada(rs.getInt(1));
                    pregunta.setIdPregunta(id_pregunta);
                    usuario.setIdUsuario(id_usuario);
                    respuesta.setIdPregunta(pregunta);
                    respuesta.setIdUsuario(usuario);
                    respuestas.add(respuesta);
                }
            }
            rs.close();
            return respuestas;
        } catch (SQLException ex) {
            Logger.getLogger(RespuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RespuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public boolean insertRespuesta(RespuestaTO respuesta) {
        String sql = "insert into respuesta"
                + "(id_usuario, "
                + "id_pregunta, "
                + "acertada) "
                + "values(?, ?, ?);";
        try {
            connection.setAutoCommit(false);
            st = connection.prepareStatement(sql);
            st.setInt(1, respuesta.getIdUsuario().getIdUsuario());
            st.setInt(2, respuesta.getIdPregunta().getIdPregunta());
            st.setInt(3, respuesta.getAcertada());
            st.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RespuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(RespuestaDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            return false;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(RespuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RespuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public boolean updateRespuesta(RespuestaTO respuesta) {
        String sql = "update respuesta "
                + "set acertada = ?"
                + "where id_pregunta = ? and id_usuario = ?;";
        try {
            connection.setAutoCommit(false);
            st = connection.prepareStatement(sql);
            st.setInt(1, respuesta.getAcertada());
            st.setInt(2, respuesta.getIdPregunta().getIdPregunta());
            st.setInt(3, respuesta.getIdUsuario().getIdUsuario());
            st.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RespuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(RespuestaDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            return false;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(RespuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RespuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
