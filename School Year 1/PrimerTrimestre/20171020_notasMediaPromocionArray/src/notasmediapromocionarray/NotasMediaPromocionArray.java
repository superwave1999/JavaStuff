/*
 Meter notas 3 trimestres, redondear, hacer media y sacar
 */
package notasmediapromocionarray;

import java.util.Scanner;

/**
 *
 * @author Imanol Raimundo Romera Lockhart
 * @serial super
 */
public class NotasMediaPromocionArray {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        boolean run;
        int runcheck;
      do {
          
        int cantAsig, contadorSusp=0;
        
        System.out.println("Dame el numero de asignaturas");
        cantAsig=input.nextInt();
        
        float[] notas=new float[cantAsig];
        float[] notas2=new float[cantAsig];
        float[] notas3=new float[cantAsig];
        
        int[] notaRed=new int[cantAsig];
        int[] notaRed2=new int[cantAsig];
        int[] notaRed3=new int[cantAsig];
        
        float[] media=new float[cantAsig];
        
        
        float sumaPaMedia=0,mediaTotal;
        
        
        System.out.println("Primer trimestre");
        for (int i=0; i<cantAsig; i++) {
            System.out.println("Introduce la nota "+(i+1));
            notas[i]=input.nextFloat();
            notaRed[i]=Math.round(notas[i]);
            System.out.println("Nota "+(i+1)+" es "+notas[i]+" Redondeado: "+notaRed[i]);
        }
        
        System.out.println("Segundo trimestre");
        for (int i=0; i<cantAsig; i++) {
            System.out.println("Introduce la nota "+(i+1));
            notas2[i]=input.nextFloat();
            notaRed2[i]=Math.round(notas2[i]);
            System.out.println("Nota "+(i+1)+" es "+notas2[i]+" Redondeado: "+notaRed2[i]);
        }
        
        System.out.println("Tercer trimestre");
        for (int i=0; i<cantAsig; i++) {
            System.out.println("Introduce la nota "+(i+1));
            notas3[i]=input.nextFloat();
            notaRed3[i]=Math.round(notas3[i]);
            System.out.println("Nota "+(i+1)+" es "+notas3[i]+" Redondeado: "+notaRed3[i]);
        }        

        for (int i=0; i<cantAsig; i++) {
            media[i]=((notaRed[i]+notaRed2[i]+notaRed3[i])/(3));
            
            System.out.print("La media de la asignatura "+(i+1)+" es "+media[i]);
            
            if (media[i]<5) {
                contadorSusp++;
                System.out.println(" por lo tanto has suspendido");
            } else {
                System.out.println(" por lo tanto has aprobado");
            }
        }      

        for (int i=0; i<cantAsig; i++) {
            sumaPaMedia=sumaPaMedia+media[i];
        } 
      
        mediaTotal=sumaPaMedia/cantAsig;
        
        System.out.println("La media de todas es "+mediaTotal);
        
        System.out.print("Has suspendido "+contadorSusp+" asignaturas");

        if (contadorSusp>2) {
            System.out.println(" por lo tanto repites");
        } else {
            System.out.println(" por lo tanto promocionas");
        }
            
        
        System.out.println("Violar a otro alumno? 0 cancela, !0 continua ");
        runcheck=input.nextInt();

        run = runcheck != 0;
      } while (run==true);
    } 
}
