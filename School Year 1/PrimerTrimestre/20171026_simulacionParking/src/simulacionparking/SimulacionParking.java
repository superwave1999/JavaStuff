/*
parking japones
100 plazas
lee matricula
lee hora entrada
dar precio por minuto

plazas libres
retirar coche
minutos que ha estado el coche
menu

CONTROL ERRORES

 */
package simulacionparking;

import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class SimulacionParking {

    public static void calculoPVP (String matriculaIn, int numAparcamientos, double precioPorMinuto, int[] minutoEntrada, int minutoActual, String[] aparcamientos, double numerosPVP) {

        boolean findCorrect=false;
        
        for (int i=0; i<numAparcamientos; i++) {
            if (matriculaIn.equals(aparcamientos[i])) {
                numerosPVP=minutoActual-minutoEntrada[i];
                numerosPVP=numerosPVP*precioPorMinuto;

                System.out.println("A pagar: "+numerosPVP);
                findCorrect=true;
            }
        }
        if (findCorrect==false) {
            System.out.println("Matricula erronea");
        }
        
    }
    
    public static void meterCoche (String[] aparcamientos, boolean[] cocheAparcado, int[] minutoEntrada, int numAparcamientos) {
      
        Scanner input=new Scanner(System.in);
        
        for (int i=0; i<numAparcamientos; i++) {
            if (cocheAparcado[i]==false) {
                System.out.println("Introduce su matricula");
                aparcamientos[i]=toUpperCase(input.next());
                System.out.println("Introduce la hora inicio (en min)");
                minutoEntrada[i]=input.nextInt();
                cocheAparcado[i]=true;
                i=numAparcamientos+1;
            }
        }
    }
    
    public static int plazasDisponibles (int numAparcamientos, boolean[] cocheAparcado){
        int plazas=0;
        for (int i=0; i<numAparcamientos; i++) {
            if (cocheAparcado[i]==false) {
                plazas++;
            }
            
        }
        return plazas;
    }
    
    public static void saleVehiculo (int numAparcamientos, String[] aparcamientos, int[] minutoEntrada, boolean[] cocheAparcado, double precioPorMinuto, double caja, double numerosPVP) {
        
        Scanner input=new Scanner(System.in);
        String matriculaIn;
        int minutoActual;
        boolean findCorrect=false;
        
        System.out.println("Introduce matricula a retirar");
        matriculaIn=toUpperCase(input.next());
        
        for (int i=0; i<numAparcamientos; i++) {
            if (matriculaIn.equals(aparcamientos[i])) {
                System.out.println("Su coche se encuentra en la plaza "+(i+1));
                findCorrect=true;
 
                System.out.println("Introduce el minuto actual");
                minutoActual=input.nextInt();
                calculoPVP(matriculaIn, numAparcamientos, precioPorMinuto, minutoEntrada, minutoActual, aparcamientos, numerosPVP);
                
                aparcamientos[i]=null;
                minutoEntrada[i]=0;
                cocheAparcado[i]=false;
                
                i=numAparcamientos+1;
                
            }
        }
        
        if (findCorrect==false) {
            System.out.println("Sin coincidencias de matricula");
        }
        
  
    }
    
    public static void buscaMatricula (int numAparcamientos, String[] aparcamientos) {
        Scanner input=new Scanner(System.in);
        String findNumPlate;
        boolean findCorrect=false;
        
        System.out.println("Introduce matricula a buscar");
        findNumPlate=toUpperCase(input.next());
        
        for (int i=0; i<numAparcamientos; i++) {
            if (findNumPlate.equals(aparcamientos[i])) {
                System.out.println("Su coche se encuentra en la plaza "+(i+1));
                findCorrect=true;
            }
        }
        
        if (findCorrect==false) {
            System.out.println("Sin coincidencias");
        }
    }
    
    public static void visualizaParking (int numAparcamientos, String[] aparcamientos) {
        for (int i=0; i<numAparcamientos; i++) {
            System.out.print("Plaza "+(i+1));
            if (aparcamientos[i]==null) {
                System.out.println(" vacía");
            } else {
                System.out.println(" ocupada, matrícula: "+aparcamientos[i]);
            }
        }
        
        
    }
    
    public static int menuPrincipal (int numAparcamientos, boolean[] cocheAparcado, double caja) {
        Scanner input=new Scanner(System.in);
        int codigoMenu,plazas;

        
        plazas=plazasDisponibles(numAparcamientos, cocheAparcado);
        
        System.out.println("Plazas disponibles "+plazas);
        // System.out.println("Dineros del parking "+caja);        FIX THIS SHIT
        System.out.println("1- Meter coche");
        System.out.println("2- Buscar coche");
        System.out.println("3- Ver parking");
        System.out.println("4- Calcular recibo");
        System.out.println("5- Retirar coche");

        System.out.println("0- shutdown.exe");
        
        
        codigoMenu=input.nextInt();
        return codigoMenu;
        
    }
    
    
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);       //Typical scanner

        int numAparcamientos=3;                     //No string
        double precioPorMinuto=0.05,caja=0,numerosPVP=0;
        int codigoMenu,minutoActual;
        String matriculaIn;
        boolean running=true;
        
        
        String aparcamientos[]=new String[numAparcamientos];        //Si string
        int minutoEntrada[]=new int[numAparcamientos];
        boolean cocheAparcado[]=new boolean[numAparcamientos];
        
        //System.out.println("Introduce su matricula");
        //matriculaIn = input.next();
        
        System.out.println("Bienvenido "+System.getProperty("user.name"));
        
        do{
            
        codigoMenu=menuPrincipal(numAparcamientos, cocheAparcado, caja);      //init menu
           
        switch (codigoMenu) {
            case 1:
                meterCoche (aparcamientos, cocheAparcado, minutoEntrada, numAparcamientos); //FUFA
                break;
            
            case 2:
                buscaMatricula (numAparcamientos, aparcamientos);   //FUFA
                break;
   
            case 3:
                visualizaParking (numAparcamientos, aparcamientos); //FUFA
                break;
                
            case 4:
                System.out.println("Introduce su matricula");
                matriculaIn=toUpperCase(input.next());
                
                System.out.println("Introduce el minuto actual");
                minutoActual=input.nextInt();
                
                calculoPVP(matriculaIn, numAparcamientos, precioPorMinuto, minutoEntrada, minutoActual, aparcamientos, numerosPVP); //FUFA
                
                break;
                
            case 5:
                saleVehiculo (numAparcamientos,aparcamientos,minutoEntrada,cocheAparcado,precioPorMinuto,caja,numerosPVP);
                caja=caja+numerosPVP;
                break;
                
            case 0:
                running=false;
                
            }

        } while (running==true);

    }
    
}
