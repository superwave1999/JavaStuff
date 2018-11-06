package pack_random;

import java.util.Random;
import java.util.Scanner;

public class mainRandom {

    public static int azar(){
        Random rnd=new Random();
        return rnd.nextInt(9)+1;
    }
    
    public static void main(String[] args) {
        int n1,num;
        
        Scanner input=new Scanner(System.in);
        System.out.println("Dime cuantos numeros quieres");
        num=input.nextInt();
        
        for (int i=0 ; i<num ; i++) {
            n1=azar();
            System.out.println("Su numero "+(i+1)+" es "+n1);
        }

    }

}
