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
public class JuegoPrimitiva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numAc = 0;
        int numTotalPrimitivas = 100;
        Primitiva miPrimitiva = new Primitiva();
        PrimitivaSorteo sorteo = new PrimitivaSorteo();
        Estadistica estadisticaPrimitivas = new Estadistica();
        TablaDePrimitivas tPrimitivas = new TablaDePrimitivas(numTotalPrimitivas);
        sorteo.rellenaAleatorio();
        
        System.out.println(sorteo);
        
        for (int i = 0; i < numTotalPrimitivas; ++i){
            miPrimitiva.rellenaAleatorio();
            numAc = sorteo.numAciertos(miPrimitiva);
            estadisticaPrimitivas.getNumAciertos()[numAc]++;
            for (int j = 0; j < miPrimitiva.getTabla().length; ++j){
                tPrimitivas.gettPrimitiva()[i].getTabla()[j] = miPrimitiva.getTabla(j);
            }
            
            
                System.out.println(i + ":" + miPrimitiva + " num. aciertos:" + numAc);
            
                    
        }
        
        System.out.println(estadisticaPrimitivas);
        System.out.println(tPrimitivas);
    }
    
}
