/*
Constructor:
Defecto, metodos, get,set,toString;
Operaciones:
Arranca, Orienta, Avanza, Para;
Atributos:
Propietario, posx, posy, arranca o no, orientacion


*/
package cochecitoalberto;

import java.util.Scanner;

public class CochecitoAlberto {
    
    public static void main(String[] args) {
        
        //Scanner, objeto, variables iniciales.
        Scanner input=new Scanner(System.in);
        Vehiculo vehiculo1=new Vehiculo();
        Mapa vismapa=new Mapa();

        int selector;
        boolean run=true;
        
        do {
        

//vismapa.drawMapa();
        System.out.println("Bienvenido "+vehiculo1.getPropietario());
        System.out.println("Orientacion "+vehiculo1.getOrientacion());
        System.out.println("Coordenadas ("+vehiculo1.getPosX()+","+vehiculo1.getPosY()+")");
        System.out.println("1.Ingresar datos de dueño");
        System.out.println("2.Arrancar");
        System.out.println("3.Orienta");
        System.out.println("4.Avanza");
        System.out.println("5.Para");
        System.out.println("0.Salir");
        selector=input.nextInt();
            while (selector>6 || selector<0) {
                System.out.println("Opcion incorrecta");
                selector=input.nextInt();
            }
        
            
        switch (selector) {
            case 1:
                vehiculo1.introDatosPorTeclado();
                break;
            case 2:
                vehiculo1.arrancaCoche();
                break;
            case 3:
                vehiculo1.orientaCoche();
                break;
            case 4:
                vehiculo1.avanzaCoche();
                break;
            case 5:
                vehiculo1.paraCoche();
                break;
            case 0:
                run=false;
                break;
            default:
                break;
        }
        
        //mostrarInfo();
        
        } while (run==true);
    }
    
}
