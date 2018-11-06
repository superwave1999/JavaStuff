/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoprimitiva;

/**
 *
 * @author alberto
 */
public class Estadistica {
    private int[] numAciertos;

    public Estadistica() {
        numAciertos = new int[8]; //numAciertos[7] da las primitivas 
                                  //con 5 aciertos y el complementario
           
    }

    public int[] getNumAciertos() {
        return numAciertos;
    }

    @Override
    public String toString() {
        String cad = "Estadistica de las primitivas\n";
        for (int i = 3; i < numAciertos.length; ++i){
            if (i < 7){
                cad += "Con " + i + " aciertos hay " + numAciertos[i] + " primitivas\n";
            } else{
                cad += "Con 5 aciertos y el complementario hay: " + numAciertos[i] + " primitivas\n";
            }
        }
        return cad;
    }
    
    
    
    
}
