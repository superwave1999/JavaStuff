/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego7medio;

/**
 *
 * @author Tarde
 */
public class testsJuego {
    
    public static void testCarta() {
        Carta carta = new Carta(2,Carta.Palo.Copas);
        carta.toString();
        System.out.println(carta.getNumero());
        System.out.println(carta.getPalo());
        
        //System.exit(0);
    }
    
    public static void testBaraja () {
        Baraja baraja = new Baraja();
        
        baraja.sacarCarta();
        System.out.println(baraja.toString());
        
        System.exit(0);
    }
}
