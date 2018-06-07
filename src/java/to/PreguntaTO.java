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
public class PreguntaTO {
    private Integer id_pregunta;
    private String enunciado;
    private String clave1;
    private String clave2;
    private String clave3;
    private String clave4;
    private String clave5;
    private Integer estado;
    private SubtemaTO id_subtema;
    private TipoPreguntaTO id_tipopregunta;
    private DificultadTO id_dificultad;
    private Integer correcta_num;
    private String informacion;

    /**
     * @return the id_pregunta
     */
    public Integer getIdPregunta() {
        return id_pregunta;
    }

    /**
     * @param id_pregunta the id_pregunta to set
     */
    public void setIdPregunta(Integer id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    /**
     * @return the enunciado
     */
    public String getEnunciado() {
        return enunciado;
    }

    /**
     * @param enunciado the enunciado to set
     */
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    /**
     * @return the clave1
     */
    public String getClave1() {
        return clave1;
    }

    /**
     * @param clave1 the clave1 to set
     */
    public void setClave1(String clave1) {
        this.clave1 = clave1;
    }

    /**
     * @return the clave2
     */
    public String getClave2() {
        return clave2;
    }

    /**
     * @param clave2 the clave2 to set
     */
    public void setClave2(String clave2) {
        this.clave2 = clave2;
    }

    /**
     * @return the clave3
     */
    public String getClave3() {
        return clave3;
    }

    /**
     * @param clave3 the clave3 to set
     */
    public void setClave3(String clave3) {
        this.clave3 = clave3;
    }

    /**
     * @return the clave4
     */
    public String getClave4() {
        return clave4;
    }

    /**
     * @param clave4 the clave4 to set
     */
    public void setClave4(String clave4) {
        this.clave4 = clave4;
    }

    /**
     * @return the clave5
     */
    public String getClave5() {
        return clave5;
    }

    /**
     * @param clave5 the clave5 to set
     */
    public void setClave5(String clave5) {
        this.clave5 = clave5;
    }

    /**
     * @return the estado
     */
    public Integer getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    /**
     * @return the id_subtema
     */
    public SubtemaTO getIdSubtema() {
        return id_subtema;
    }

    /**
     * @param id_subtema the id_subtema to set
     */
    public void setIdSubtema(SubtemaTO id_subtema) {
        this.id_subtema = id_subtema;
    }

    /**
     * @return the id_tipopregunta
     */
    public TipoPreguntaTO getIdTipopregunta() {
        return id_tipopregunta;
    }

    /**
     * @param id_tipopregunta the id_tipopregunta to set
     */
    public void setIdTipopregunta(TipoPreguntaTO id_tipopregunta) {
        this.id_tipopregunta = id_tipopregunta;
    }

    /**
     * @return the id_dificultad
     */
    public DificultadTO getIdDificultad() {
        return id_dificultad;
    }

    /**
     * @param id_dificultad the id_dificultad to set
     */
    public void setIdDificultad(DificultadTO id_dificultad) {
        this.id_dificultad = id_dificultad;
    }

    /**
     * @return the correcta_num
     */
    public Integer getCorrectaNum() {
        return correcta_num;
    }

    /**
     * @param correcta_num the correcta_num to set
     */
    public void setCorrectaNum(Integer correcta_num) {
        this.correcta_num = correcta_num;
    }

    /**
     * @return the informacion
     */
    public String getInformacion() {
        return informacion;
    }

    /**
     * @param informacion the informacion to set
     */
    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
}
