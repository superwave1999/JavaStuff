
package juego7medio;

import java.util.Scanner;

public class Juego7Medio {

    public static void main(String[] args) {
        
        int players,playerNature;
        String playerName;
        Scanner input = new Scanner(System.in);
        Jugador jugador[] = null;
        
        boolean gameRun=true;
        boolean gameWin=false;
        
        System.out.println("DEBUG TEST CARTA");
        //testsJuego.testCarta();
        System.out.println("Debug test baraja con carta");
        //testsJuego.testBaraja();
        
        System.out.println("Juego 7.5");
        
        System.out.println("Elige tu numero de jugadores");
            
        players=input.nextInt();
        
        for (int numJug=0; numJug<players; numJug++) {
            System.out.println("Jugador-1, Maquina-2");
            playerNature=input.nextInt();

            
            if (playerNature==1) {
                System.out.println("Dame el nombre del jugador "+numJug);
                playerName=input.next();
                
                jugador[numJug]= new Jugador(playerName,false);
            } else {
                jugador[numJug]= new Jugador("BOT",true);
            }
            
        }

        System.out.println("Comienza el juego");
        
        do {
            
            for (int numJug=0; numJug<players; numJug++) {
                System.out.println("Turno de "+jugador[numJug].getNombre());
                System.out.println("Jugador numero "+numJug);
                
                System.out.println("Carta sacada");
                jugador[numJug].jugadorSacaCarta();
                
              
            
            }
            
            
        } while (gameWin==false || gameRun==true);
        
        
    }
    
}
