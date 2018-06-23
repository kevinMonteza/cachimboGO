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
public class StrategyFactory {
        public PaymentStrategy getStrategy(String strategyType){
        if(strategyType == null){
            return new NullStrategy();
        }
        else if(strategyType.equalsIgnoreCase("CASH")){
            return new CashStrategy();
        }
        else if(strategyType.equalsIgnoreCase("CARD")){
            return new CardStrategy();
        }
        else{
            return new NullStrategy();
        }
    }
}
