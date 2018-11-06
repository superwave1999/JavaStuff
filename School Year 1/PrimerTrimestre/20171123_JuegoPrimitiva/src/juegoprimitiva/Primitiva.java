/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoprimitiva;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author alberto
 */
public class Primitiva {
    
    private int[] tabla;
    
    public Primitiva(){
        tabla = new int[6];
    }
    
    public int getTabla(int i){
        return tabla[i];
    }
    
    public int[] getTabla(){
        return tabla;
    }
    
    public boolean esta(int elementoBuscado, int lim){
        boolean encontrado = false;
        for (int i = 0; i < lim && !encontrado; ++i){
            if (elementoBuscado == tabla[i]){
                encontrado = true;
            }
        }
        return encontrado;
        
    }
    
    public void rellenaManual(){
        int i;
        int j;
        Scanner entrada = new Scanner(System.in);
        
        for (i=0; i < tabla.length; ++i){
            do {
                System.out.println("Dame el " + (i+1) + "número[1-49]");
                tabla[i] = entrada.nextInt();
                if (esta(tabla[i], i)){
                    System.out.println(tabla[i] + "esta repetido");
                } else if (tabla[i]< 1 || tabla[i]>49){
                    System.out.println(tabla[i] + " esta fuera del rango 1-49");
                }
            } while (tabla[i] < 1 || tabla[i] > 49 || esta(tabla[i], i));   
        }
    }
    public void rellenaAleatorio(){
    int i;
    int j;
    Random generador = new Random();

    for (i=0; i < tabla.length; ++i){
        do {
            
            tabla[i] = generador.nextInt(49) + 1; // Números al azar entre 1 y 49
           
        } while (esta(tabla[i], i));   
    }
    }
    
    @Override
    public String toString(){
        String cad = "";
        cad = "Primitiva= ";
        for (int i = 0; i < tabla.length - 1; ++i){
            cad += tabla[i] + ", ";
        }
        cad += tabla[tabla.length -1];
        return cad;
    }
}
    
    
    
    
    

