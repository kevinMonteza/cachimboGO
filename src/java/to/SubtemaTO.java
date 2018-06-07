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
public class SubtemaTO {
    private Integer id_subtema;
    private String nombre;
    private TemaTO id_tema;

    /**
     * @return the id_subtema
     */
    public Integer getIdSubtema() {
        return id_subtema;
    }

    /**
     * @param id_subtema the id_subtema to set
     */
    public void setIdSubtema(Integer id_subtema) {
        this.id_subtema = id_subtema;
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
     * @return the id_tema
     */
    public TemaTO getIdTema() {
        return id_tema;
    }

    /**
     * @param id_tema the id_tema to set
     */
    public void setIdTema(TemaTO id_tema) {
        this.id_tema = id_tema;
    }
}
