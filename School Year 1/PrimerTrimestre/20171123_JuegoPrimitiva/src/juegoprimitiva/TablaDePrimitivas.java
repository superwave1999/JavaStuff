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
public class TablaDePrimitivas {
    private Primitiva[] tPrimitiva;
    TablaDePrimitivas(int num){
        tPrimitiva = new Primitiva[num];
        for (int i = 0; i < tPrimitiva.length; ++i){
            tPrimitiva[i] = new Primitiva();
        }
    }

    public Primitiva[] gettPrimitiva() {
        return tPrimitiva;
    }

    @Override
    public String toString() {
        String cad = "Tabla de primitivas\n";
        for (int i = 0; i < tPrimitiva.length; ++i){
            cad += tPrimitiva[i] + "\n"; // cad = cad + tPrimitiva[i] + "\n"
        }
        return cad;
    }
    
    
}
