package conversiontemperaturas;

import java.util.Scanner;

public class ConversionTemperaturas {
    
    public static double convertTemp (int select, int selectout, double tempin){
        if (select==2 && selectout==1) {         //Works
            return (((tempin)-32)*(0.5556));
        } else if (select==1 && selectout==2) {  //Works
            return tempin*1.8+32;
        } else if (select==2 && selectout==3) {  //Works
            return ((tempin-32)*(0.5556)+273.15);
        } else if (select==3 && selectout==2) {  //Works
            return ((tempin-273.15)*(1.8)+32);
        } else if (select==1 && selectout==3) {  //Works - cel
            return tempin-273;
        } else if (select==3 && selectout==1) {  //Works - cel
            return tempin-273;
        } else {
            return tempin;
        }
    }    
    
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int select,selectout,runcheck;
        double tempin,tempout;
        boolean run=true;
        
        do {
        //Entrada

        System.out.println("Temperatura de entrada | 1-C 2-F 3-K");
        select=input.nextInt();
        while (select>3 || select<1){
            System.out.println("Temperatura de entrada incorrecta, repite");
            select=input.nextInt();
        }

        System.out.println("Introduce su temperatura");
        tempin=input.nextDouble();

        //Salida

        System.out.println("Introduce su temperatura de salida | 1-C 2-F 3-K");
        selectout=input.nextInt();
        while (selectout>3 || selectout<1){
            System.out.println("Temperatura de salida incorrecta, repite");
            selectout=input.nextInt();
        }

        tempout=convertTemp(select, selectout, tempin);

        System.out.println("Su temperatura es "+tempout);
        
        System.out.println("¿Desea continuar? 1 Si, 0 No");
        runcheck=input.nextInt();
        if (runcheck==0) {
            run=false;
        }
        
        } while (run==true);
        
    }
    
}
