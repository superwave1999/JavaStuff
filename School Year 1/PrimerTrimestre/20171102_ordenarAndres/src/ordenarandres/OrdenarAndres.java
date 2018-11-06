
package ordenarandres;

import java.util.Scanner;

public class OrdenarAndres {
    
    
    public static void ordenaBurbuja (String[] nom) {
        String temp;
        for (int i=nom.length; i>1; i--) {
            for (int j=0; j<i-1; j++) {
                if (nom[j].compareTo(nom[j+1])>0) {
                    temp=nom[j];
                    nom[j]=nom[j+1];
                    nom[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int length;
        Scanner input=new Scanner(System.in);
        
        System.out.println("Dame la cantidad de valores a introducir");
        length=input.nextInt();
        
        for (int i=0; i<length; i++) {
            System.out.println("Dame el valor "+(i+1));
            
        }
        
        String nom[]=new String[length];
        ordenaBurbuja(nom);
        
    }
    
}
