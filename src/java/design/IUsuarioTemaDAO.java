/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

import java.util.List;
import to.UsuarioTO;
import to.UsuarioTemaTO;

/**
 *
 * @author isaac
 */
public interface IUsuarioTemaDAO {
    public List<UsuarioTemaTO> getTemaByUsuario(UsuarioTO usuario);
    public boolean insertUsuarioTema(UsuarioTemaTO usuarioTema);
    public boolean updateUsuarioTema(UsuarioTemaTO usuarioTema);
}
