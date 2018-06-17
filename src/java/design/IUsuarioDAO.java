package design;

import to.UsuarioTO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author isaac
 */
public interface IUsuarioDAO {
    public boolean usuarioAuth(UsuarioTO usuario);
    public boolean insertUsuario(UsuarioTO usuario);
}
