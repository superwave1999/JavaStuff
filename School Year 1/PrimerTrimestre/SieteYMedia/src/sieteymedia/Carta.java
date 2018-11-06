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

public class Carta {
     
     public enum TipoPalo {OROS, BASTOS, ESPADAS, COPAS};
     
     private final int numero; //Baraja española 1,2,3,4,5,6,7, 10, 11, 12
     private TipoPalo palo;

    public Carta(int numero, TipoPalo palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public int getNumero() {
        return numero;
    }

    public TipoPalo getPalo() {
        return palo;
    }

    public void setPalo(TipoPalo palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return "Carta{" + "numero=" + numero + ", palo=" + palo + '}';
    }
    
    
     
}