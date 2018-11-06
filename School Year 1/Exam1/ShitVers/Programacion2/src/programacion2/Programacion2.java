
package programacion2;

import java.util.Scanner;

public class Programacion2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int contadorPersonas=1;
        boolean run=true;
        int salida = 0;
        
        do {
            Gordos calculo;
            calculo = new Gordos();

            System.out.println("Nombre de persona "+contadorPersonas);
            calculo.nombre = input.nextLine();
            System.out.println("Peso de persona "+contadorPersonas);
            calculo.peso = input.nextFloat();
            System.out.println("Altura de persona "+contadorPersonas);
            calculo.altura = input.nextFloat();
            input.nextLine();

            System.out.println("IMC: "+calculo.calcularIMC());
            System.out.println("Clasificacion: "+calculo.clasificaIMC());
            
            contadorPersonas++;
            
            System.out.println("Salir? 0=Si");
            salida=input.nextInt();
            if (salida==0) {
                run=false;
            }
        } while (run==true);
            
    }
    
}
