package notas_media;

import java.util.Scanner;

public class Notas_media {
    public static int calculoMedia(int nota1, int nota2, int nota3, int nota4){     
        return (nota1+nota2+nota3+nota4)/4;
    }
    
    public static boolean promociona(float media){
        return media>=5;
    }
    
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int nota1;
        int nota2;
        int nota3;
        int nota4;
        char cont;
        float media;
        
        System.out.println("Deme la nota 1");
        nota1=input.nextInt();
        
        System.out.println("Deme la nota 2");
        nota2=input.nextInt();
        
        System.out.println("Deme la nota 3");
        nota3=input.nextInt();

        System.out.println("Deme la nota 4");
        nota4=input.nextInt();
        
        media=calculoMedia(nota1,nota2,nota3,nota4);
        System.out.println("Su media es "+media);

        if (promociona(media)){
            System.out.println("Ha promocionado");
        } else {
            System.out.println("No ha promocionado");
        }
        
    }

}
