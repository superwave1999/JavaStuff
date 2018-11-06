
package examen2trej1;

import java.io.Serializable;
import java.util.Arrays;

public class Alumno implements Serializable {
    private String nombre;
    private float[] notas = new float[4];
    private boolean promociona;
    
    Alumno (String nombre, float[] notas, boolean promociona) {
        this.nombre=nombre;
        this.notas=notas;
        this.promociona=promociona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float[] getNotas() {
        return notas;
    }

    public void setNotas(float[] notas) {
        this.notas = notas;
    }

    public boolean isPromociona() {
        return promociona;
    }

    public void setPromociona(boolean promociona) {
        this.promociona = promociona;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", notas=" + Arrays.toString(notas) + ", promociona=" + promociona + '}';
    }

}
