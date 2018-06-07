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
public class UsuarioAsignaturaTO {
    private UsuarioTO id_usuario;
    private AsignaturaTO id_asignatura;
    private Double porcentaje;

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
    public AsignaturaTO getIdAsignatura() {
        return id_asignatura;
    }

    /**
     * @param id_asignatura the id_asignatura to set
     */
    public void setIdAsignatura(AsignaturaTO id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    /**
     * @return the porcentaje
     */
    public Double getPorcentaje() {
        return porcentaje;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }
}
