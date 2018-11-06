/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sieteymedia;

/**
 *
 * @author alberto
 */
public class BarajaEspañola {
  
    private final Carta[] baraja;
    
    BarajaEspañola(){
        
        int[] num = {1,2,3,4,5, 6,7,10,11,12}; //Baraja española
        
        baraja = new Carta[40];
        
        int cont = 0;
        for (Carta.TipoPalo p : Carta.TipoPalo.values()){
            for (int i = 0; i < num.length; ++i){
                baraja[cont] = new Carta(num[i],p);
                cont++;
            }
        }
    }
    
    public String toString(){
        String cad = "Baraja española\n";
        
        for (int i = 0; i < baraja.length; ++i){
            cad += baraja[i] + "\n";
        }
        return cad;
    }
    
    public Carta sacar(){
        
    }
}
