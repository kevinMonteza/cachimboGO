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
public class NullStrategy implements PaymentStrategy{
    
    public NullStrategy(){
    
    }

    @Override
   public void pay(Double amount,UsuarioTO usuario) {
       
   }
}

