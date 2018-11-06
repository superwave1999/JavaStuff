package pack_random;

import java.util.Random;
import java.util.Scanner;

public class mainRandom {

    public static int azar(){
        Random rnd=new Random();
        return rnd.nextInt(10);
    }
    
    public static int ayudante(int n1, int adiv){
        if (n1>adiv) {
            return 1;
        } else if (n1<adiv) {
            return -1;
        } else
            return 0;
    }
    
    public static void main(String[] args) {
        int adiv,n1,check;
        
        Scanner input=new Scanner(System.in);
        
        adiv=azar();
        
        do {
            System.out.println("Dame un numero 0-10");
            n1=input.nextInt();

            check=ayudante(n1,adiv);

        
            if (check>0) {
                System.out.println("Tu numero es mayor al mio");
            } else if (check<0) {
                System.out.println("Tu numero es menor al mio");
            } else if (check==0) {
                System.out.println("Tu numero es igual al mio");
            }
        } while (check!=0);
        
        System.exit(0);
    }

}
