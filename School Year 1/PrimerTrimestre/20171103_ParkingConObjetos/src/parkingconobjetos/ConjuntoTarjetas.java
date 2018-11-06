/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingconobjetos;

/**
 *
 * @author alberto
 */
public class ConjuntoTarjetas {
    private TarjetaParking[] tablaTarjetas;
    public ConjuntoTarjetas(){ //Por defecto, con tamaño 100
        tablaTarjetas = new TarjetaParking[100];
        for (int i = 0; i < tablaTarjetas.length; ++i){
            tablaTarjetas[i] = new TarjetaParking();
        }
    }

    public TarjetaParking[] getTablaTarjetas() {
        return tablaTarjetas;
    }

    public void setTablaTarjetas(TarjetaParking[] tablaTarjetas) {
        this.tablaTarjetas = tablaTarjetas;
    }
    
    
    
}
