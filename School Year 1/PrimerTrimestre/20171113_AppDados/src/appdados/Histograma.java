package appdados;

public class Histograma {
    private int[] histograma;

    public Histograma() {                        
        histograma = new int[11];       
    }

    public int[] getHistograma() {
        return histograma;
    }

    public void setHistograma(Partida[] tablaFrecuencias) {
        int index;
        
        for(int i = 0; i < tablaFrecuencias.length; ++i){
            index = tablaFrecuencias[i].getResultado() - 2;
            histograma[index]++; 
        }
    }
    
    public int mayorFrecuencia(){
        int mayor = 0;
        
        for(int i = 0; i < histograma.length; ++i){
            if(histograma[i] >= mayor)
                mayor = histograma[i];
        }
        
        return mayor;
    }
    
    public String existe(int indice,int tope){
        String cadena = "     ";
        
        if(histograma[indice] >= tope)
            cadena = "|||||";
        
        return cadena;
    }
    
    public void mostrarHistograma(){
       int tope = mayorFrecuencia();
        
       System.out.println("==============================================================================================");
       System.out.println("|                                    JUEGO DE LOS DADOS                                      |");
       System.out.println("==============================================================================================");
        
        for(int i = tope; i > 0; --i){
            if((i-1)/10 != 0 || i == 10){
                System.out.print("\033[32m"+i+"| ");
            }else{
                System.out.print(i+" | ");
            }
            for(int j = 0; j < histograma.length; ++j){
                System.out.print("\033[32m"+existe(j,i)+"\t");
                               
                if(j == histograma.length - 1)
                    System.out.println("");
            }
        }
        
        System.out.println("==============================================================================================");
        System.out.println("PTS   2           3       4       5       6       7       8       9      10      11      12");
    }
    
    
    public double porcentajePartidasGanadas(){
        return histograma[6];
    }
    
    public void visualiza(Partida[] tablaFrecuencias){
       System.out.println("\n-------------HISTORIAL DE 100 PARTIDAS--------------");
       System.out.println("TIRADA\tDADO1\tDADO2\tSUMA\t\tRESULTADO");
        System.out.println("....................................................");
       for(int i = 0; i < tablaFrecuencias.length; ++i){
           if(tablaFrecuencias[i].getResultado() == 7) 
            System.out.println((i+1)+".\t"+tablaFrecuencias[i].getDado1().getCara()+"\t"+tablaFrecuencias[i].getDado2().getCara()+"\t"+
                    tablaFrecuencias[i].getResultado()+"ptos.\t\tGANADA");
           else
            System.out.println((i+1)+".\t"+tablaFrecuencias[i].getDado1().getCara()+"\t"+tablaFrecuencias[i].getDado2().getCara()+"\t"+
                    tablaFrecuencias[i].getResultado()+"ptos.\t\tPERDIDA");
       }
   }
}
