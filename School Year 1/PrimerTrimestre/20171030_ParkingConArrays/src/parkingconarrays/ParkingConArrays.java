/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingconarrays;

import java.util.Scanner;

/**
 *
 * @author alberto
 */
public class ParkingConArrays {

    public static void inicializaParking(String[] aparcamientos, int[] minutoEntrada, int[] minutoSalida){
        //Suponemos que el parking está vacío al principio
        
        for (int i = 0; i < aparcamientos.length; ++i){
            aparcamientos[i] = "Libre";
            minutoEntrada[i] = 0;
            minutoSalida[i] = 0;
        }
        
    }
    
    public static int menu(){
        Scanner entrada = new Scanner(System.in);
        int op = 0;
        do{
            System.out.println("Menu");
            System.out.println("----");
            System.out.println("1. Entra vehiculo");
            System.out.println("2. Sale vehiculo");
            System.out.println("3.Terminar");
            System.out.println("Opcion:");
            op = entrada.nextInt();
            if (op< 1 || op > 3){
                   System.out.println("Error, opcion invalida");     
            }
        } while (op < 1 || op >3);
        
        return op;
    }
    
    public static int buscaMatricula(String[] aparcamientos, String matriculaBuscar){ // -1 si no está
        int posicion = -1;
        boolean encontrado = false;
        
        for (int i = 0; i < aparcamientos.length && !encontrado; ++i){
            if (aparcamientos[i].compareTo(matriculaBuscar.toUpperCase()) == 0){
                encontrado = true;
                posicion = i;
            }
        }
        return posicion;
    }
    
    public static int plazasLibres(String[] aparcamientos){
        int cont = 0;
        for (int i = 0; i < aparcamientos.length; ++i){
            if (aparcamientos[i].compareTo("Libre")== 0){
                cont++;
            }
        }
        return cont;
    }
    
    public static int buscaPrimeraPlazaLibre(String[] aparcamientos){ //- 1 si no hay plazas libres
        return 0;
    }
    
    public static boolean validaMatricula(String matricula){
        //Se supone la matricula valida si contiene algun numero
        // y letras o espacios blancos
        boolean valida = true;
        boolean hayNumero = false;
        boolean hayLetras = false;
        
        if(matricula.length() == 0){
            return false;
        } else {
                for (int i = 0; i < matricula.length() && valida; ++i){
                    
                    if (!(matricula.charAt(i) == ' ' || 
                         (matricula.charAt(i)>= '0' && matricula.charAt(i)<= '9') ||
                         (matricula.charAt(i)>= 'A' && matricula.charAt(i)<= 'Z')))
                            valida = false;
                    else if (matricula.charAt(i)>= '0' && matricula.charAt(i)<= '9'){
                            hayNumero = true;
                    } else if (matricula.charAt(i)>= 'A' && matricula.charAt(i)<= 'Z'){
                    
                            hayLetras = true;
                    }
                    
                }
                
        }
        return valida && hayNumero && hayLetras ;
        
    }
    
//     public static int  entraVehiculo(String[] aparcamientos, int[] minutoEntrada){
//        Scanner entrada = new Scanner(System.in); 
//        if (plazasLibres(aparcamientos) == 0){
//            System.out.println("PARKING COMPLETO");
//        }
//        else{ //Introducir matricula desde teclado
                //Validarla
                //Comprobar que no esta en el parking
    
                //Busca primera plaza libre
                // Introduce minuto entradas y vehiculo en plaza
                
//            
//        }
//    }
//    
    
    /*
   
    
    
    
    public static double saleVehiculo(String[] aparcamientos, int[] minutoEntrada, int[] minutoSalida){
        
    }
    
    
    */
    public static void visualizaParking(String nomParking, String[] aparcamientos, int[] minutoEntrada, int[] minutoSalida, double caja){
        System.out.println("Estado del parking:" + nomParking);
        System.out.println("---------------------------------");
        System.out.println("Num.\t Matric. \t MinIn. \t MinFin.");
         System.out.println("------------------------------------------------");
        for (int i = 0; i < aparcamientos.length; ++i){
            System.out.println(i + "\t" + aparcamientos[i] + "\t\t" 
                                 + minutoEntrada[i] + "\t" + minutoSalida[i]);
        }
        
        System.out.println("Caja:" + caja);
       
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        int TAMPARKING = 10;
        String nom = "Granada";
        String[] aparcamientos = new String[TAMPARKING];
        int[] minutoEntrada = new int[TAMPARKING];
        int[] minutoSalida = new int[TAMPARKING];
        
        double caja = 0.0;
        int opcion; 
        
        inicializaParking(aparcamientos, minutoEntrada, minutoSalida);
//        visualizaParking(nom,aparcamientos, minutoEntrada, minutoSalida, caja);
//        
//        opcion = menu();
//        System.out.println("Opcion elegida:" + opcion);
        
        
        aparcamientos[5] = "1234ABC";
        aparcamientos[7] = "Libre";
        //String matBuscar = "2345BCD";
        //int pos = buscaMatricula(aparcamientos,  matBuscar);
        //System.out.println("Posicion:" + pos);
        
        System.out.println("Plazas libres:" + plazasLibres(aparcamientos));
        
        System.out.println("Libre:" + validaMatricula("Libre"));
        System.out.println("1234 ABC:" + validaMatricula("1234 ABC"));
        System.out.println("1234!ABC:" + validaMatricula("1234!ABC"));
    }
    
}
