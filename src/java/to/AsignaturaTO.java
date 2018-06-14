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
public class AsignaturaTO {
    private Integer id_asignatura;
    private String nombre;
    private Integer id_tipo_asignatura;

    /**
     * @return the id_asignatura
     */
    public Integer getIdAsignatura() {
        return id_asignatura;
    }

    /**
     * @param id_asignatura the id_asignatura to set
     */
    public void setIdAsignatura(Integer id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the id_tipo_asignatura
     */
    public Integer getIdTipoAsignatura() {
        return id_tipo_asignatura;
    }

    /**
     * @param id_tipo_asignatura the id_tipo_asignatura to set
     */
    public void setIdTipoAsignatura(Integer id_tipo_asignatura) {
        this.id_tipo_asignatura = id_tipo_asignatura;
    }
    
}
