
package juego7medio;

import java.util.Arrays;

public class Baraja {
    
    private Carta[] baraja;

    
    
    Baraja() {
        int contCarta=0;
        
        baraja = new Carta [41];
    
        for (Carta.Palo p : Carta.Palo.values()) {
            for (int i=1; i<=10; i++) {
                baraja[i]= new Carta(i,p);
                    
                
            }
        }        
    }
    
    public Carta sacarCarta () {
        
        Carta carta = null;
        int cartaRnd;
        
        cartaRnd = (int) (Math.random()*(40)+1);
   

        for (int r=1; r<=40; r++) {

            if (baraja[r] != null && cartaRnd==r) {
                carta =  baraja[r];
                baraja[r]=null;
                System.out.println("OK" +r);
                
            }

        }
        return carta;
    }
    
    
    //ToString

    @Override
    public String toString() {
        return "Baraja{" + "baraja=" + Arrays.toString(baraja) + '}';
    }
    
    
}
    
