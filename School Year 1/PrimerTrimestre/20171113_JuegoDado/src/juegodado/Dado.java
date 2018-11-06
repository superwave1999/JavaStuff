
package juegodado;

import java.util.Random;

public class Dado {
    private int cara;
    private int dadoMax;
    private int dadoMin;
    
    public Dado() {
        
    }
    
    public Dado(int dadoMin,int dadoMax) {
        this.dadoMin=dadoMin;
        this.dadoMax=dadoMax;
    }
    
    
    public int lanzar(){
        Random random = new Random();
        cara=random.nextInt(dadoMax - dadoMin + 1) + dadoMin;
        return cara;
    }
    
    //Getters
    
    public int getCara() {
        return cara;
    }

    public int getDadoMax() {
        return dadoMax;
    }

    public int getDadoMin() {
        return dadoMin;
    }
    
    //Setters

    public void setCara(int cara) {
        this.cara = cara;
    }

    public void setDadoMax(int dadoMax) {
        this.dadoMax = dadoMax;
    }

    public void setDadoMin(int dadoMin) {
        this.dadoMin = dadoMin;
    }
    
    
    
}
