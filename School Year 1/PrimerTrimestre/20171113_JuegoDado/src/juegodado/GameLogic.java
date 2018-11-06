
package juegodado;

public class GameLogic {
    private final Dado dado1;
    private final Dado dado2;
    
    public GameLogic(){
        dado1=new Dado();
        dado2=new Dado();
    }
    
    public GameLogic(int dadoMin, int dadoMax){
        dado1=new Dado(dadoMin, dadoMax);
        dado2=new Dado(dadoMin, dadoMax);
    }
    
    public int jugar(){
        return dado1.lanzar()+dado2.lanzar();
    }
    
    //Getters

    public Dado getDado1() {
        return dado1;
    }

    public Dado getDado2() {
        return dado2;
    }
    
}
