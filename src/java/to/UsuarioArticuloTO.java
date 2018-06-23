/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to;

/**
 *
 * @author isaac
 */
public class UsuarioArticuloTO {
    private UsuarioTO id_usuario;
    private ArticuloTO id_articulo;

    /**
     * @return the id_usuario
     */
    public UsuarioTO getIdUsuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setIdUsuario(UsuarioTO id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the id_articulo
     */
    public ArticuloTO getIdArticulo() {
        return id_articulo;
    }

    /**
     * @param id_articulo the id_articulo to set
     */
    public void setIdArticulo(ArticuloTO id_articulo) {
        this.id_articulo = id_articulo;
    }
}
