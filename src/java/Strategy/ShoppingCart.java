/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

/**
 *
 * @author isaac
 */
public class ShoppingCart {
    
    private Double amount;
    
    public ShoppingCart(Double amount){
        this.amount = amount;
    }
    
    public void pay(PaymentStrategy paymentMethod) {
        paymentMethod.pay(amount);
    }

}
