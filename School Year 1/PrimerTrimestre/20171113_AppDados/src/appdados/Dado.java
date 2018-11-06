package appdados;

import java.util.Random;

public class Dado {
    private int cara;

    public Dado() {
        cara = 1;
    }    
    
    public Dado(int cara) {
        this.cara = cara;
    }

    public int getCara() {
        return cara;
    }

    public void setCara(int cara) {
        this.cara = cara;
    }        
         
    public int lanzar(){    //Obtiene de forma azarosa un numero entre 1 y 6
        cara = (int)(Math.random()*6) + 1;
        return cara;    
    }
}
