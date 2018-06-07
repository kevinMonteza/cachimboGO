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
public class TipoPreguntaTO {
    private Integer id_tipopregunta;
    private String nombre;

    /**
     * @return the id_tipopregunta
     */
    public Integer getIdTipopregunta() {
        return id_tipopregunta;
    }

    /**
     * @param id_tipopregunta the id_tipopregunta to set
     */
    public void setIdTipopregunta(Integer id_tipopregunta) {
        this.id_tipopregunta = id_tipopregunta;
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
}
