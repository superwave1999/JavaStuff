/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

/**
 *
 * @author super
 */
public class Coche extends VehiculoConHerencia {
    //Un coche esun tipode vehiculo
    private int numPlazas;
    
    public Coche () {
        
        //Super referencia a la superclase
        //Antes de crear un coche debe existir el objeto super
        super();
        numPlazas=0;
        
    }
    
    public Coche (int numPlazas, String propietario, String matricula, double potencia, double velodicad) {
        super(propietario, matricula, potencia, velodicad);
        this.numPlazas=numPlazas;
    }
}
