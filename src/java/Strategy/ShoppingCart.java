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
public class ShoppingCart implements PaymentStrategy{
    
    private Double amount;
    
    public ShoppingCart(){
    }
    @Override
    public void pay(Double amount,UsuarioTO usuario) {
        if(amount==10.0){
            usuario.setMonedas(usuario.getMonedas()+20);
        }else if(amount==13.0){
             usuario.setMonedas(usuario.getMonedas()+30);
        }else{
             usuario.setMonedas(usuario.getMonedas()+40);
        }
        DAOFactory.getInstance().getUsuarioDAO().updateUser(usuario);
    }

}
