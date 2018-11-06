/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercadoconarrays;

import java.util.Scanner;

/**
 *
 * @author alberto
 */
public class SuperMercadoConArrays {

    /**
     * @param args the command line arguments
     */
    public static  int menu(String[] art, double[] precio, int[]exis ){
        Scanner entrada = new Scanner(System.in);
        int cod = 0;
        do {
            System.out.println("\t" + "Cod"+ "\t"+ "Articulo\t" + "PVP\t" + 
                               "Existencias");
            for (int i = 0; i < art.length; ++i){
                System.out.println("\t" + i + ":\t" + art[i] + "\t" 
                                        + precio[i] + "\t" + exis[i]);
            }
            System.out.println("Introduce cod(-1 termina factura)(-2 termina prog)");
            cod = entrada.nextInt();
            if (cod < -2 || cod > art.length){
                System.out.println("Codigo erroneo");
            }
            
        } while (cod < -2 || cod > art.length);
        
        return cod;
    }
    
    public static boolean esCodigoArticulo(int cod, int numArticulos){
        if (cod < 0 || cod >= numArticulos){
            return false;
        }
        else{
            return true;
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner entrada = new Scanner(System.in);
        
        int numTotalArticulos = 5;
        double caja = 0.0;
        int unidades = 0;
        double precioDetalle = 0.0;
        String factura = "";
        double totalFactura = 0.0;
        
        //Un array de String con 5 elementos
        String[] articulo = new String[numTotalArticulos];
        int cod = 0;
        
        articulo[0] = "Espaguetis";
        articulo[1] = "Tomate frito";
        articulo[2] = "Patatas 3 kg";
        articulo[3] = "Yogurt\t";
        articulo[4] = "1 docena huevos";
        
        double[] precio = new double[numTotalArticulos];
        precio[0] = 1.0;
        precio[1] = 0.5;
        precio[2] = 1.2;
        precio[3] = 0.3;
        precio[4] = 1.5;
        
        
        int[] existencias = new int[numTotalArticulos];
        existencias[0] = 10;
        existencias[1] = 10;
        existencias[2] = 10;
        existencias[3] = 10;
        existencias[4] = 10;
        
        
        
        do {
            factura = "";
            totalFactura = 0.0;
            do {
                
                cod = menu(articulo, precio, existencias);
                if (esCodigoArticulo(cod, articulo.length)){
                    do{
                        System.out.println("¿Cuantas unidades?");
                        unidades = entrada.nextInt();
                        if (unidades < 0 || unidades > existencias[cod]){
                            System.out.println("Unidades incorrectas");
                        }
                    } while (unidades < 0 || unidades > existencias[cod]);
                    
                    existencias[cod] = existencias[cod] - unidades;
                    //existencias[cod] -= unidades;
                    precioDetalle = precio[cod] * unidades;
                    
                    factura = factura + articulo[cod] + "\t" + 
                                        unidades + "\t" + precio[cod] + "\t"+
                                        precioDetalle + "\n";
                    
                    totalFactura = totalFactura + precioDetalle;
                    
                }
                
            } while (cod != -1 && cod != -2);
           if (totalFactura != 0){
            caja = caja + totalFactura;
            factura += "Total:" + totalFactura;
            System.out.println(factura);
            factura = "";
            totalFactura = 0.0;
            }
            //Ha terminado la factura
            
        } while (cod != -2);
        
       
            System.out.println("Caja:" + caja);
        }
        
        //Ha terminado el programa
        
        
       
        
        
    }
    