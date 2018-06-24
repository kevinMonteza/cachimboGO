/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import dao.DAOFactory;
import to.UsuarioTO;

/**
 *
 * @author isaac
 */
public class CashStrategy implements PaymentStrategy {
    
    public CashStrategy() {
    }

   public void pay(Double amount,UsuarioTO usuario) {
        if(amount==10.0){
            usuario.setMonedas(usuario.getMonedas()+10);
        }else if(amount==20.0){
             usuario.setMonedas(usuario.getMonedas()+20);
        }else{
             usuario.setMonedas(usuario.getMonedas()+30);
        }
        DAOFactory.getInstance().getUsuarioDAO().updateUser(usuario);
    }
}