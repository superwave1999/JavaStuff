
package cochecitoalberto;

public class Mapa {
    private Array[];
    private int mapaX;
    private int mapaY;
    private int tamX=3;
    private int tamY=3;
    
    Mapa() {
        
    }
    
//    public void placeMapa () {
//        Array[] mapa = new Array[tamX][];
//
//        
//        
//    }
    
    public void drawMapa () {
        for (int i=-tamX; i<tamX; tamX++) {
            
            for (int j=-tamY; j<tamY; tamY++) {
                
                if (mapaX==i && mapaY==j) {
                    mapa[i][j]="1";
                    System.out.println(mapa[i][j]);
                } else {
                    mapa[i][j]="0";
                    System.out.println(mapa[i][j]);
                }

            }
          
        }
    
    }
    
    
    public void coordenadaMapa () {
        
    }
    
    
    public void setTamX (double tamX) {
        this.tamX= (int) Math.round(tamX);
    }
    public void setTamY (double tamY) {
        this.tamY= (int) Math.round(tamY);
    }
    
    
}
