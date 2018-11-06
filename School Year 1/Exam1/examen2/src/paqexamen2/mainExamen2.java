
package paqexamen2;

import java.util.Scanner;

public class mainExamen2 {
    
    public static boolean cont() {
        Scanner sc = new Scanner (System.in);
        int preg;
        boolean run;
        
        System.out.println("Desea continuar con otro usuario? 1-si 0-no");
        preg=sc.nextInt();
        
        run = preg==1;
        
        return run;
    }
   
    public static void main(String[] args) {
       
        int contador=1;
        boolean run;
        
        do {
            System.out.println("Persona "+contador);
            
            cosas co=new cosas();
            co.pepe();
            co.imce();
            co.perdepeso();
            
            run=cont();
            contador++;
        } while (run==true);
    }
}

