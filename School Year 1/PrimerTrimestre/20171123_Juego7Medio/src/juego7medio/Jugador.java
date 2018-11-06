
package juego7medio;

public class Jugador {
    
    private boolean intelArt;
    private String nombre;
    private Baraja baraja;

    
    Jugador (String nombre, boolean intelArt) {

        this.nombre = nombre;
        baraja = new Baraja();
        this.intelArt = intelArt;
    }
    
    Jugador () {

        nombre = "BOT";
        baraja = new Baraja();
        intelArt = true;
    }
    
    public void jugadorSacaCarta() {
        baraja.sacarCarta();
    
    }
    
    //Setters

    public void setIntelArt(boolean intelArt) {
        this.intelArt = intelArt;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setBaraja(Baraja baraja) {
        this.baraja = baraja;
    }



    public boolean isIntelArt() {
        return intelArt;
    }

    public String getNombre() {
        return nombre;
    }

    //Getters
    public Baraja getBaraja() {
        return baraja;
    }

    @Override
    public String toString() {
        return "Jugador{" + "intelArt=" + intelArt + ", nombre=" + nombre + ", baraja=" + baraja + '}';
    }

    
    
    
}
