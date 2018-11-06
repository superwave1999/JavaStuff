package simucajero;
import java.util.Scanner;

public class SimuCajero {

    public static void main(String[] args) {
//Preambulo y ajuste de intentos
        Scanner input=new Scanner(System.in);
        int pinin,pinstr,intentos;
        boolean correcto;
        intentos = 3;
        correcto=false;

        System.out.println("Has abierto tu cuneta");
        System.out.println("Introduce tu pin");
            pinstr=input.nextInt();
        System.out.println("Al dia siguiente...");

	System.out.println("Tarjeta introducida");
        
//Entrada
        do {
            System.out.println("Introduce su pin");
            pinin=input.nextInt();
            
//Comporbación pin
	
		if (pinin==pinstr) {
			System.out.println("Numero correcto");
			correcto=true;
                } else {
			intentos--;
			if (intentos==0) {
                            System.out.println("Quedan "+intentos+" intentos, tarjeta retirada");
                        } else {
                            System.out.println("Numero incorrecto, quedan "+intentos+" intentos");
                        }
                }
        } while (intentos!=0 || correcto==false);

    }
    
}
