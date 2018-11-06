package pack_random;

import java.util.Random;
import java.util.Scanner;

public class mainRandom {

    public static char azar(){
        Random rnd=new Random();
        return (char) rnd.nextInt(26);
    }
    
    public static void main(String[] args) {
        char n1;
        int num;
        
        Scanner input=new Scanner(System.in);
        System.out.println("Dime cuantas letras quieres");
        num=input.nextInt();
        
        for (int i=0 ; i<num ; i++) {
            n1=azar();
            System.out.println("Su letra "+(i+1)+" es "+n1);
        }

    }

}
