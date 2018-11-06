
package juegodado;

import java.util.Scanner;

public class JuegoDado {
    
    public static int dadoMin () {
        Scanner input = new Scanner(System.in);
        int dadoMin;
        System.out.println("Introduce minimo");
        dadoMin=input.nextInt();
        return dadoMin;
    }
    
    public static int dadoMax () {
        Scanner input = new Scanner(System.in);
        int dadoMax;
        System.out.println("Introduce maximo");
        dadoMax=input.nextInt();
        return dadoMax;
    }
    
    public static int dadoWin () {
        Scanner input = new Scanner(System.in);
        int dadoWin;
        System.out.println("Introduce suma ganadora");
        dadoWin=input.nextInt();
        return dadoWin;
    }
    
    public static int mainMenu () {
        Scanner input = new Scanner(System.in);
        int select;
        
        System.out.println("1.Jugar");
        System.out.println("2.Opciones");
        System.out.println("3.Historial");
        System.out.println("0.Salir");
        
        select=input.nextInt();
        return select;
        
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        
        boolean run=true;
        int dadoMin=1, dadoMax=6, dadoWin=7;
        int resultado;
        
        System.out.println("Juego del Dado");
        
        do{
        GameLogic game=new GameLogic(dadoMin,dadoMax);
        
        switch (mainMenu()) {
            case 0:
                run=false;
                
            case 1:
                resultado=game.jugar();
                
                System.out.println("Numero obtenido "+resultado);
                if (resultado==dadoWin) {
                    System.out.println("Has acertado!");
                } else {
                    System.out.println("Los numeros no coinciden");
                }
                
                break;
            case 2:
                dadoMin=dadoMin();
                dadoMax=dadoMax();
                dadoWin=dadoWin();

                break;
            case 3:
                break;
            default:
                break;
                
        }

        } while (run==true);
        
        
    }
    
}
