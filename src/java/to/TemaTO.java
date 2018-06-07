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
public class TemaTO {
    private Integer id_tema;
    private String nombre;
    private AsignaturaTO id_asignatura;

    /**
     * @return the id_tema
     */
    public Integer getIdTema() {
        return id_tema;
    }

    /**
     * @param id_tema the id_tema to set
     */
    public void setIdTema(Integer id_tema) {
        this.id_tema = id_tema;
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
}
