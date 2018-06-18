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
public class UsuarioSubtemaTO {
    private UsuarioTO id_usuario;
    private SubtemaTO id_subtema;
    private Boolean completado;

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
     * @return the id_asignatura
     */
    public SubtemaTO getIdSubtema() {
        return id_subtema;
    }

    /**
     * @param id_asignatura the id_asignatura to set
     */
    public void setIdSubtema(SubtemaTO id_subtema) {
        this.id_subtema = id_subtema;
    }

    /**
     * @return the porcentaje
     */
    public Boolean getCompletado() {
        return completado;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }
}
