/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

import java.util.List;
import to.UsuarioAsignaturaTO;
import to.UsuarioTO;

/**
 *
 * @author isaac
 */
public interface IUsuarioAsignaturaDAO {
    public List<UsuarioAsignaturaTO> getAsignaturaByUsuario(UsuarioTO usuario);
    public boolean insertUsuarioAsignatura(UsuarioAsignaturaTO usuarioAsignatura);
    public boolean updateUsuarioAsignatura(UsuarioAsignaturaTO usuarioAsignatura);
}
