/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer.componente;

import Adapter.DAOAdapter;
import Adapter.DBAction;
import java.util.List;
import observer.design.ObservadorEstadistica;
import to.SubtemaTO;
import to.UsuarioTemaTO;

/**
 *
 * @author kevinMC
 */
public class EstadisticaTema implements ObservadorEstadistica {
    
    DBAction adapter = new DAOAdapter();
    
    @Override
    public void update(UsuarioTemaTO usuTema) {
        System.out.println("update tema");
        List<SubtemaTO> lista = adapter.obtenerSubtemasPorTema(usuTema.getIdTema().getIdTema());
        System.out.println("nro de subtemas por tema"+lista.size());
        int cant = adapter.obtenerSubtemasporTema(usuTema);
        System.out.println("usuario temas"+cant);
        double porcentaje = cant * 100 / lista.size();
        usuTema.setPorcentaje(porcentaje);
        if (adapter.exiteUSuarioTema(usuTema)) {
            System.out.println("actualiza usuario tema");
            adapter.actualizarUsuarioTema(usuTema);
        } else {
            System.out.println("inserta suario tema");
            adapter.insertarUsuarioTema(usuTema);
        }
    }
    
}
