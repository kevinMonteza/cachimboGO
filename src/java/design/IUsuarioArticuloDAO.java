/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

import java.util.List;
import to.UsuarioArticuloTO;

/**
 *
 * @author isaac
 */
public interface IUsuarioArticuloDAO {
    public List<UsuarioArticuloTO> getUsuarioArticulos(Integer id_usuario);
    public boolean insertUsuarioArticulo(UsuarioArticuloTO usuarioArticulo);
}
