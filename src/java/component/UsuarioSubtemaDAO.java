/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import design.IUsuarioSubtemaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import to.SubtemaTO;
import to.UsuarioSubtemaTO;
import to.UsuarioTO;
import to.UsuarioTemaTO;

/**
 *
 * @author isaac
 */
public class UsuarioSubtemaDAO implements IUsuarioSubtemaDAO {

    private final Connection connection;
    private PreparedStatement st;
    private List<UsuarioSubtemaTO> usuarioSubtemas;

    public UsuarioSubtemaDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int countSubtemasbyTemas(UsuarioTemaTO usuarioT) {
        try {
            String sql = "select count(*) from usuario_subtema"
                    + "  inner join subtema s on usuario_subtema.id_subtema = s.id_subtema"
                    + "  inner join tema t on s.id_tema = t.id_tema where s.id_tema=? and id_usuario=? and completado=1;";
            st = connection.prepareStatement(sql);
            st.setInt(1, usuarioT.getIdTema().getIdTema());
            st.setInt(2,usuarioT.getIdUsuario().getIdUsuario());
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }else{
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSubtemaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioSubtemaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<UsuarioSubtemaTO> getSubtemaByUsuario(UsuarioTO usuario) {
        usuarioSubtemas = new ArrayList<>();
        try {
            String sql = "select S.id_subtema, US.completado, S.nombre "
                    + "from usuario_subtema as US "
                    + "inner join subtema as S on US.id_subtema = S.id_subtema "
                    + "where id_usuario = ?;";
            st = connection.prepareStatement(sql);
            st.setInt(1, usuario.getIdUsuario());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SubtemaTO subtema = new SubtemaTO();
                UsuarioSubtemaTO usuarioTema = new UsuarioSubtemaTO();
                usuarioTema.setIdUsuario(usuario);
                subtema.setIdSubtema(rs.getInt(1));
                subtema.setNombre(rs.getString(3));
                usuarioTema.setIdSubtema(subtema);
                usuarioTema.setCompletado(rs.getBoolean(2));
                usuarioSubtemas.add(usuarioTema);
            }
            rs.close();
            return usuarioSubtemas;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSubtemaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioSubtemaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public boolean insertUsuarioSubtema(UsuarioSubtemaTO usuarioSubtema) {
        System.out.println("insert subtemaUsuario");
        String sql = "insert into usuario_subtema"
                + "(id_usuario, "
                + "id_subtema, "
                + "completado) "
                + "values(?, ?, ?);";
        try {
            connection.setAutoCommit(false);
            st = connection.prepareStatement(sql);
            st.setInt(1, usuarioSubtema.getIdUsuario().getIdUsuario());
            st.setInt(2, usuarioSubtema.getIdSubtema().getIdSubtema());
            st.setBoolean(3, usuarioSubtema.getCompletado());
            st.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSubtemaDAO.class.getName()).log(Level.SEVERE, null, ex);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(UsuarioSubtemaDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            return false;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioSubtemaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioSubtemaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public boolean updateUsuarioSubtema(UsuarioSubtemaTO usuarioSubtema) {
        System.out.println("en updateUsuarioSubtema");
        String sql = "update usuario_subtema set completado = 1 where id_usuario = ? and id_subtema = ?;";
        try {
            connection.setAutoCommit(false);
            st = connection.prepareStatement(sql);
            st.setInt(1, usuarioSubtema.getIdSubtema().getIdSubtema());
            st.setInt(2, usuarioSubtema.getIdUsuario().getIdUsuario());
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
    public boolean existeUsuarioSubtema(UsuarioSubtemaTO usuarioS) {
        try {
            String sql = "select count(*) from usuario_subtema where id_subtema = ? and id_usuario=?;";
            st = connection.prepareStatement(sql);
            st.setInt(1, usuarioS.getIdSubtema().getIdSubtema());
            st.setInt(2, usuarioS.getIdUsuario().getIdUsuario());
            ResultSet rs = st.executeQuery();
            if(rs.next())
               return rs.getInt(1)!=0;
            else
                return false;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioTemaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
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
}
