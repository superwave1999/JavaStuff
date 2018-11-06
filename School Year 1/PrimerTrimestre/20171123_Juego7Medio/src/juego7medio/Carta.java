
//DONE

/*
Palo: Oros, Bastos, Espadas, Copas.
Numeros: Español 1-10.
 */
package juego7medio;

public class Carta {
    
    public enum Palo {Oros, Palos, Bastos, Copas};
    
    private int numero;
    
    private Palo palo;
    
    
    Carta () {
        numero=0;
        palo=Palo.Oros;
    }
    
    Carta (int numCarta, Palo palo) {
        numero=numCarta;
        this.palo=palo;
    }

    //Getters

    public int getNumero() {
        return numero;
    }

    public Palo getPalo() {
        return palo;
    }
    
    //Setters

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }
    
    //Good toString DONE
    
    @Override
    public String toString() {
        String numFormal="Empty";
        boolean texto=false;
        
        switch (numero) {
            case 1:
                numFormal="As";
                texto=true;
                break;
            case 8:
                numFormal="Sota";
                texto=true;
                break;
            case 9:
                numFormal="Caballo";
                texto=true;
                break;
            case 10:
                numFormal="Rey";
                texto=true;
                break;
            default:
                break;
        }
        
        
        if (texto) {
            return "Carta" + numFormal + "Palo" + palo;
        } else {
            return "Carta" + numero + "Palo" + palo;
        }
        
    }
    
    
    
}
