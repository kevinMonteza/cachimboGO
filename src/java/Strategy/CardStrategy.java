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
public class CardStrategy implements PaymentStrategy{

    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(String dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public CardStrategy() {
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
