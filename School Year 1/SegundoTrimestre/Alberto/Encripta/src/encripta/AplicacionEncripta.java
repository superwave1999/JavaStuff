/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encripta;

import java.util.Scanner;

/**
 *
 * @author Alberto
 */
public class AplicacionEncripta {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        String nomFichEntrada = "", nomFichSalida = "";
        byte clave;
           
           do{
                System.out.println("Dame el nombre del fichero a encriptar:");
                nomFichEntrada = entrada.nextLine();
           } while (nomFichEntrada.length() == 0);
           
           do{
                System.out.println("Dame el nombre del fichero encriptado:");
                nomFichSalida = entrada.nextLine();
           } while (nomFichSalida.length() == 0);
           
           do{
                System.out.println("Dame la clave de encriptacion(0-255):");
                clave = entrada.nextByte();
           } while (clave < 0 || clave > 255);
           
            
		Encripta.encripta (nomFichEntrada, nomFichSalida, clave);
                Encripta.desencripta(nomFichSalida, nomFichEntrada, clave);
    }
}
