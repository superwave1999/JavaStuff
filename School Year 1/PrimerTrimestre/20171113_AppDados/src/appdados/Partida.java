package appdados;

public class Partida {
    private Dado dado1;
    private Dado dado2;
    private int resultado;

    public Partida() {
        dado1 = new Dado();
        dado2 = new Dado();
    }

    public Dado getDado1() {
        return dado1;
    }

    public Dado getDado2() {
        return dado2;
    } 

    public int getResultado() {
        return resultado;
    }
    
    public void setResultado(int resultado){
        this.resultado = resultado;
    }
    
    public int jugar(){
        resultado = dado1.lanzar() + dado2.lanzar();
        return resultado;
    }            
}
