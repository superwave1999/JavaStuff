/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaobjectsdb;

/**
 *
 * @author Tarde
 */
public class Alumno {
    
    private String nif;
    private String nombre;
    private int edad;
    private double telefono;

    public Alumno() {
    }

    public Alumno(String nif, String nombre, int edad, double telefono) {
        this.nif = nif;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getTelefono() {
        return telefono;
    }

    public void setTelefono(double telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nif=" + nif + ", nombre=" + nombre + ", edad=" + edad + ", telefono=" + telefono + '}';
    }
    
    
    
}
