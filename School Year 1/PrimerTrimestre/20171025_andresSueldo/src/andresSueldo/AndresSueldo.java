
package andresSueldo;

import java.util.Scanner;


public class AndresSueldo {
    
   
    static float [] sueldos = new float [5];
    
    public static void meterSueldo(float [] sueldos){
        Scanner input=new Scanner(System.in);
         
        for(int i=0; i<sueldos.length; i++){
            try{
                System.out.println("Introduce sueldos");
                sueldos[i]= input.nextFloat();
            }catch(Exception e){
                System.out.println("Error al introducir sueldos");
            }
        }
    }
    
    
    public static float calculoMedia(float [] sueldos){
        float media=0;
        for(int i=0; i<sueldos.length;i++){
            media = media + sueldos[i];
        }
        media= media/sueldos.length;
        System.out.println("Media " + media);
        return media;
    }
    
    
    public static float calculoMax(float [] sueldos){
        
        float maximo= sueldos[0];
        for(int i = 0; i<sueldos.length; i++){
            if(sueldos[i]>maximo){
                maximo = sueldos[i];
            }
        }
        System.out.println("Máximo " + maximo);
        return maximo;
        
    }
    
    public static float calculoMin(float[] sueldos){
        float minimo=sueldos[0];
        for(int i=0; i<sueldos.length; i++){
            if(sueldos[i]< minimo){
                minimo = sueldos[i];
            }
        }
        System.out.println("Mínimo: " + minimo);
        return minimo;
    }
    
    public static void main(String[] args) {
  
        Scanner sc =new Scanner (System.in);
        boolean salir= false;
        int opciones=0;
        
        do{
            System.out.println("1. Introducir sueldos.");
            System.out.println("2. Calcular media.");
            System.out.println("3. Ver sueldo máximo.");
            System.out.println("4. Ver sueldo mínimo.");
            System.out.println("5. Terminar");
            
            System.out.println("Escribe una opción");
            opciones=sc.nextInt();
        
        switch (opciones) {
            case 1:
                AndresSueldo.meterSueldo(sueldos);
                break;
            case 2:
                AndresSueldo.calculoMedia(sueldos);
                break;
            case 3:
                AndresSueldo.calculoMax(sueldos);
                break;
            case 4:
                AndresSueldo.calculoMin(sueldos);
                break;
            case 5:
                break;
            default:
                break;
        }
        } while (opciones!=5);
        
        
    }
    
}
