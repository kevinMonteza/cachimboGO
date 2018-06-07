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
public class RespuestaTO {
    private UsuarioTO id_usuario;
    private PreguntaTO id_pregunta;
    private Integer acertada;

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
     * @return the id_pregunta
     */
    public PreguntaTO getIdPregunta() {
        return id_pregunta;
    }

    /**
     * @param id_pregunta the id_pregunta to set
     */
    public void setIdPregunta(PreguntaTO id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    /**
     * @return the acertada
     */
    public Integer getAcertada() {
        return acertada;
    }

    /**
     * @param acertada the acertada to set
     */
    public void setAcertada(Integer acertada) {
        this.acertada = acertada;
    }
}
