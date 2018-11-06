/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcopybits;

import java.util.Scanner;

/**
 *
 * @author roxas
 */
public class AppCopyBits {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        String origen,destino;
        Copiador copy=new Copiador();
        System.out.println("Dame una ruta de origen");
        origen=sc.nextLine();
        System.out.println("Dame una ruta de destino");
        destino=sc.nextLine();
        copy.copiarArchivo(origen, destino);
        
        
        
    }
    
}
