/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer.componente;

import dao.DAOFactory;
import observer.design.ObservadorEstadistica;


import to.UsuarioTemaTO;


/**
 *
 * @author kevinMC
 */
public class EstadisticaAsignatura implements ObservadorEstadistica{

    @Override
    public void update(UsuarioTemaTO subtema) {
        int temasT = DAOFactory.getInstance().getAsignaturaDAO().getTemasByAsignatura(subtema.getIdTema().getIdTema());
        
//        int temasCompletos = DAOFactory.getInstance().getTemaDAO().getTemasCompletados(usuarioA);
        
    }
    
}
