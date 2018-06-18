/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

import java.util.List;
import to.UsuarioSubtemaTO;
import to.UsuarioTO;

/**
 *
 * @author isaac
 */
public interface IUsuarioSubtemaDAO {
    public List<UsuarioSubtemaTO> getSubtemaByUsuario(UsuarioTO usuario);
    public boolean insertUsuarioSubtema(UsuarioSubtemaTO usuarioSubtema);
    public boolean updateUsuarioSubtema(UsuarioSubtemaTO usuarioSubtema);
}
