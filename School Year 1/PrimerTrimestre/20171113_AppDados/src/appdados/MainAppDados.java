package appdados;

import java.util.Scanner;

public class MainAppDados {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       Partida partida = new Partida();
       Histograma histograma = new Histograma();
       Partida[] partidasJugadas = new Partida[100];
       int verPartidas = 0;
       
       for(int i = 0; i < partidasJugadas.length; ++i)
           partidasJugadas[i] = new Partida();
       
       for(int i = 0; i < partidasJugadas.length; ++i)
        partidasJugadas[i].jugar();
       
       
       histograma.setHistograma(partidasJugadas);
       histograma.mostrarHistograma();
       histograma.porcentajePartidasGanadas();
       System.out.println("\nHAN GANADO UN "+histograma.porcentajePartidasGanadas()+"% DE PARTIDAS");
       
       System.out.print("\n¿VISUALIZAR LISTA DE PARTIDAS?(0(NO), 1(SI)): ");
       verPartidas = sc.nextInt();
       if(verPartidas == 1)
           histograma.visualiza(partidasJugadas);
    }
}
