/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer.componente;

import observer.design.ObservadoEstadistica;
import to.SubtemaTO;

/**
 *
 * @author kevinMC
 */
public class estadisticaSubTema extends ObservadoEstadistica{
    private SubtemaTO subtema;

    /**
     * @return the subtema
     */
    public SubtemaTO getSubtema() {
        return subtema;
    }

    /**
     * @param subtema the subtema to set
     */
    public void setSubtema(SubtemaTO subtema) {
        this.subtema = subtema;
    }
    
}
