/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentas;

import java.util.Scanner;

public class Cuentas {

    
    
    public static void main(String[] args) {
        ACC[] accs = {new ACC("Paco", "12345", 100, 100),
                      new ACC("Sergio", "12345", 100, 100)};
        
        Scanner e = new Scanner(System.in);
        
        while (true) {
            System.out.println("Logeese:");
            String nom = e.nextLine();
            String pass = e.nextLine();
        for (ACC cuenta : accs) {
            if (cuenta.getNick().equalsIgnoreCase(nom) && cuenta.getPass().equals(pass)) {
                boolean salir = false;
                while (!salir) {
                    int opcion;
                    double sacar;
                    double ingresar;
                    float pago;
                    System.out.println("pulsa 1 para sacar dinero");
                    System.out.println("pulsa 2 para ingresar dinero");
                    System.out.println("pulsa 3 para realizar un pago");
                    System.out.println("pulsa 4 para mostar saldo");
                    System.out.println("pulsa 5 para salir");
                    opcion = e.nextInt();
                    e.nextLine();
                    switch (opcion) {
                        case 1:
                            System.out.println("cuanto dinero quieres sacar?");
                            sacar = e.nextFloat();
                            e.nextLine();
                            if (sacar > cuenta.getSaldo()) {
                                System.out.println("no tienes suficiente saldo");
                            } else {
                                cuenta.setSaldo(cuenta.getSaldo() - sacar);
                                System.out.println("su saldo restante es: " + cuenta.getSaldo());
                            }
                            break;
                        case 2:
                            System.out.println("cuanto dinero quiere ingresar?");
                            ingresar = e.nextFloat();
                            e.nextLine();
                            cuenta.ingreso(ingresar);
                            System.out.println("su saldo es de " + cuenta.getSaldo());
                            break;
                        case 3:
                            System.out.println("ingrese el numero de cuenta al que va a realizar el reintegro");
                            System.out.println("ingrese cuanto va a pagar?");
                            pago = e.nextFloat();
                            e.nextLine();
                            cuenta.setSaldo(cuenta.getSaldo() - pago);
                            String n = e.nextLine();
                            for(ACC cuentaX:accs)
                            {
                                if(cuentaX.getNick().equalsIgnoreCase(n))
                                {
                                    cuentaX.setSaldo(cuentaX.getSaldo()+pago);
                                    break;
                                }
                            }
                            System.out.println("su saldo restante es " + cuenta.getSaldo());
                            break;
                        case 4:
                            System.out.println("su saldo es de " + cuenta.getSaldo());
                            break;
                        case 5:
                            salir = true;
                            break;
                    }
                }
                break;
            }
        }
        }
        
    }

}
