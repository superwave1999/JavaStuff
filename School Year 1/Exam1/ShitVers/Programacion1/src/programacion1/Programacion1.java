
package programacion1;

import java.util.Scanner;

public class Programacion1 {
    
    public static int mainMenu(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Elige operacion");
        System.out.println("1-Meter pasta");
        System.out.println("2-Sacar pasta");
        System.out.println("3-Transferir pasta");
        System.out.println("4-Cambiar cuenta");
        System.out.println("5-Ver datos de mi cuenta");
        System.out.println("0-Salir");
        
        return input.nextInt();
        
    }

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        int toCreate,saldoC,interesC,activeAc,cuentaTrans;
        double cantIng,cantRet,cantTrans;
        String nombreC,passC,activeName,activePass;
        
        System.out.println("Banco bueno");
        
        System.out.println("No existen cuentas");
        
        System.out.println("Num cuentas a crear");
        
        toCreate=input.nextInt();
        while (toCreate<=0) {
            System.out.println("Necesito un numero serio para un banco serio");
            toCreate=input.nextInt();
        }
        
        Cuenta[] cuenta= new Cuenta[toCreate];
        
        for (int i=0; i<cuenta.length; i++) {
            System.out.println("Nombre cuenta");
            nombreC = input.next();
            System.out.println("Pass cuenta");
            passC = input.next();
            
            System.out.println("Saldo inicial cuenta");
            saldoC = input.nextInt();
            System.out.println("Intereses cuenta");
            interesC=input.nextInt();


            cuenta[i] = new Cuenta(nombreC,passC,i,saldoC,interesC);
        }
        
        //Elige cuenta
        
//        System.out.println("Deme nombre de cuenta activa");
//        activeName=input.next();
//        System.out.println("Deme contraseña de cuenta activa");
//        activePass=input.next();
//        
//        for (int i=0; i<cuenta.length; i++) {
//            String getName;
//            
//            getName=cuenta[i].getNombre();
//            if (getName==activeName) {
//                activeAc=i;
//            }
//            
//        }
        
        
        
        
        System.out.println("Numero de cuenta activa");
        activeAc=input.nextInt();
        while (activeAc<0) {
                System.out.println("Escribe un valor correcto");
                activeAc=input.nextInt();
        }
        
        do {

            switch (mainMenu()) {
                case 1:
                    System.out.println("Introduce");
                    cantIng=input.nextDouble();
                    while (cantIng<0) {
                        System.out.println("Introduce valor positivo");
                        cantIng=input.nextDouble();
                    }
                    
                    cuenta[activeAc].ingreso(cantIng);
                    System.out.println(cuenta[activeAc].visualiza());
                break;
                case 2:
                    System.out.println("Introduce");
                    cantRet=input.nextDouble();
                    while (cantRet<0) {
                        System.out.println("Introduce valor positivo");
                        cantRet=input.nextDouble();
                    }
                    
                    cuenta[activeAc].reintegro(cantRet);
                    System.out.println(cuenta[activeAc].visualiza());
                break;
                case 3:
                    System.out.println("Introduce cantidad a transferir");
                    cantTrans=input.nextDouble();
                    while (cantTrans<0) {
                        System.out.println("Introduce valor positivo");
                        cantTrans=input.nextDouble();
                    }
                    
                    System.out.println("Introduce cuenta destino");
                    cuentaTrans=input.nextInt();
                    while (cuentaTrans<0) {
                        System.out.println("Introduce valor correcto");
                        cuentaTrans=input.nextInt();
                    }
                    
                    
                    cuenta[activeAc].transferencia(cuenta[cuentaTrans], cantTrans);
                    
                    System.out.println(cuenta[activeAc].visualiza());
                    System.out.println(cuenta[cuentaTrans].visualiza());
                break;
                case 4:
                    System.out.println("Elige cuenta activa (0 cancela)");
                    activeAc=input.nextInt();
                    while (activeAc<0) {
                        System.out.println("Escribe un valor correcto");
                        activeAc=input.nextInt();
                    }
                break;
                case 5:
                    System.out.println(cuenta[activeAc].visualiza());
                break;
                default:
                    activeAc=0;
                break;     
            }
            
        } while (activeAc>0);
    }
    
}
