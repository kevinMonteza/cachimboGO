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
            while(rs.next()){
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
    public boolean insertUsuarioSubtema(UsuarioSubtemaTO usuarioSubtema) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateUsuarioSubtema(UsuarioSubtemaTO usuarioSubtema) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
