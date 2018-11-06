/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1filetodbo;

import java.io.Serializable;

/**
 *
 * @author super
 */
public class Contacto implements Serializable {
    
    private String nombre;
    private String numero;
    
    Contacto() {
        
        
    }
    
    Contacto (String nombre, String numero) {
        this.nombre=nombre;
        this.numero=numero;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
}
