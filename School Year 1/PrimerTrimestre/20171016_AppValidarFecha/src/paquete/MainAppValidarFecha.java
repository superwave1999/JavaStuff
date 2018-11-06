package paquete;

import java.util.Scanner;

public class MainAppValidarFecha {

    public static boolean esBisiesto(int year){
        boolean esBi = false;
        
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))   {     
            esBi = true;
        }
        return esBi;
    }
    
    public static boolean esValido(int day, int month, int year){
        int numDiasMes = 0;
        
        if (year < 0){
            return false;
        }
        
        if (month < 1 || month > 12){
            return false;
        }
        
        if (day < 1 || day > 31){
            return false;
        }
           
        
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month ==10
                || month == 12){
            numDiasMes = 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11){
            numDiasMes = 30;
        } else if (esBisiesto(year)){
            numDiasMes = 29;
        } else {
            numDiasMes = 28;
        }
        
        if (day > numDiasMes){
            return false;
        }
       
        
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dia, mes, anio;
        char respuesta;
        
        do{
            System.out.print("Introduzca un dia: ");
            dia = sc.nextInt();
            System.out.println("");
            
            System.out.print("Introduzca un mes: ");
            mes = sc.nextInt();
            System.out.println("");
            
            System.out.print("Introduzca un año: ");
            anio = sc.nextInt();
            sc.nextLine();
            System.out.println("");
            
            
            if(esValido(dia, mes, anio))
                System.out.println("La fecha "+dia+"/"+mes+"/"+anio+" es valida.");
            else
                System.out.println("La fecha "+dia+"/"+mes+"/"+anio+" NO es valida.");
            
            System.out.print("\n¿Desea continuar? (S/N): ");
            respuesta = sc.nextLine().charAt(0);
            System.out.println("");
        }while(respuesta != 'N' && respuesta != 'n');
    }
    
}
