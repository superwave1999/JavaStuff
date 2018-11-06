
package ecuacionessegundogrado;

import java.util.Scanner;

public class EcuacionesSegundoGrado {
    public static double potenciaMates(double a, double b, double c) {
        double potresult;
           potresult=Math.pow(b,2);
        return (potresult-(4*a*c));
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
            double a;
            double b;
            double c;
            double disc;
            double disccero;
            double sol1;
            double sol2;
            
            System.out.println("Dame la a, 0 termina el programa");
            a=input.nextDouble();
            if (a==0) {
                System.exit(0);
            }
                
            System.out.println("Dame la b");
            b=input.nextFloat();
            System.out.println("Dame la c");
            c=input.nextFloat();
	
	disc=potenciaMates(a,b,c);
        
	if (disc>0) {
            sol1=Math.sqrt(disc);
            sol2=Math.sqrt(disc);
            sol1=((-b)+sol1)/(2*a);
            sol2=((-b)-sol2)/(2*a);
            System.out.println("Tiene dos soluciones "+sol1+" y "+sol2);
        } else
        if (disc==0){
            disccero=((-b)/(2*a));
            System.out.println("La solución es "+disccero);
        } else {
            System.out.println("No hay solución");
        }
    }

}
