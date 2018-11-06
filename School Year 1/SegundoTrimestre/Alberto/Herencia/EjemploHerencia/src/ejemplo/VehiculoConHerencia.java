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
public class VehiculoConHerencia {
    
    private String propietario;
    private String matricula;
    private double potencia;
    private double velodicad;
    
    public VehiculoConHerencia () {
        
    }

    public VehiculoConHerencia(String propietario, String matricula, double potencia, double velodicad) {
        this.propietario = propietario;
        this.matricula = matricula;
        this.potencia = potencia;
        this.velodicad = velodicad;
    }

    public String getPropietario() {
        return propietario;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getPotencia() {
        return potencia;
    }

    public double getVelodicad() {
        return velodicad;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public void setVelodicad(double velodicad) {
        this.velodicad = velodicad;
    }

    @Override
    public String toString() {
        return "VehiculoConHerencia{" + "propietario=" + propietario + ", matricula=" + matricula + ", potencia=" + potencia + ", velodicad=" + velodicad + '}';
    }
    
    
    
    
}
