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
public class PlazaAparcamiento {
    private String matricula;
    
    public PlazaAparcamiento(){
        matricula = "LIBRE";
    }
    
    public PlazaAparcamiento(String mat){
        matricula = mat;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public String toString(){
        return "Matricula:" + matricula + "\n";
    }
}
