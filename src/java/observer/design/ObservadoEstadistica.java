/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer.design;

import Adapter.DAOAdapter;
import Adapter.DBAction;
import dao.DAOFactory;
import java.util.ArrayList;
import java.util.List;
import to.TemaTO;
import to.UsuarioSubtemaTO;
import to.UsuarioTemaTO;

/**
 *
 * @author kevinMC
 */
public abstract class ObservadoEstadistica {
    List<ObservadorEstadistica> lista = new ArrayList<>();
    DBAction adapter;
     TemaTO tema ;
     UsuarioTemaTO usuarioT;
    
    public void updateEstadistica(UsuarioSubtemaTO subtema){
        adapter = new DAOAdapter();
        if(DAOFactory.getInstance().getUsuarioSubtemaDAO().existeUsuarioSubtema(subtema)){
            System.out.println("en el if de upadateestadistica");
            adapter.actualizarUsuarioSubtema(subtema);
        }else{
            System.out.println("en el else de upadate estadistica");
            adapter.insertarUsuarioSubtema(subtema);
        }
        tema = adapter.obtenerTemaBysubtemid(subtema.getIdSubtema().getIdSubtema());
        usuarioT = new UsuarioTemaTO();
        usuarioT.setIdTema(tema);
        usuarioT.setIdUsuario(subtema.getIdUsuario());
        this.notificarUpdate(usuarioT);
    }
    
    public void notificarUpdate(UsuarioTemaTO Usubtema){
        lista.forEach((OE) -> {
            OE.update(Usubtema);
        });
    }
    public void addObservadores(ObservadorEstadistica OE){
        lista.add(OE);
    }
    public void deleteObservadores(ObservadorEstadistica OE){
        lista.remove(OE);
    }
}
