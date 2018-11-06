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
public class TarjetaParking {
    //Atributos 
    private String matricula;
    private int minEntrada;
    private int posicion;
    
    //Constructores
    //Constructor por defecto o sin argumentos
    
    public TarjetaParking(){
        matricula = "";
        minEntrada = 0;
        posicion = -1;
    }
    
    public TarjetaParking(String matri, int minEnt){
        matricula = matri;
        minEntrada = minEnt;
    }
    
    //Métodos get, que permiten leer los atributos
    public String getMatricula(){
        return matricula;
    }
    
    public int getMinEntrada(){
        return minEntrada; 
    }
    
    public int getPosicion(){
        return posicion;
    }
    
    //Métodos set, que permiten modificar los atributos
    
    public void setMatricula(String mat){
        matricula = mat;
    }
    
    public void setMinEntrada(int minEnt){
        minEntrada = minEnt;
    }
    
    public void setPosicion(int pos){
        posicion = pos;
    }

    @Override
    public String toString() {
        return "TarjetaParking{" + "matricula=" + matricula + ", minEntrada=" + minEntrada + ", posicion=" + posicion + '}';
    }
    
    
}
