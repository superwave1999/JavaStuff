/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exantej2;

/**
 *
 * @author super
 */
public class Alumno {

    private String nombre;
    private int edad;
    private double nota;
    
    public Alumno() {
        
    }
    
    public Alumno (String n, int e) {
        this.nombre=n;
        this.edad=e;
    }
    
    public Alumno (String n, int e, double nt) {
        this.nombre=n;
        this.edad=e;
        this.nota=nt;
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

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", edad=" + edad + ", nota=" + nota + '}';
    }
    
    
}
