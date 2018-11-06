
package examen2trej2new;

import java.io.File;
import java.util.Scanner;

class Contador {

    boolean operar() {
        Scanner input= new Scanner (System.in);
        String rutain;
        String texto = null;
        File file = null;
        boolean rutaok;
        boolean fileok = false;
        
        System.out.println("Introduce ruta");
        rutain = input.nextLine();
        rutaok=Verifica.compruebaRuta(rutain);
        
        if (rutaok){
            file = new File(rutain);
            fileok=Verifica.ficheroValido(file);
        }
        
        if (fileok) {
            texto=IO.readFileToText(file);
        }
        
        if (texto!=null) {
            outputMostrar(texto);
        }

        return Verifica.verificaContinua();
    }
    
    public void outputMostrar(String texto) {
        String[] palabras;
        palabras = dividirEnPalabras(texto);
        for (int i=0; i<palabras.length; i++) {
            System.out.println("{"+palabras[i]+"}");
        }
        System.out.println("Numero palabras: "+palabras.length);
    }
    
    public String[] dividirEnPalabras(String texto) {
        return texto.split("[\t|,|;| |\n|.]+");
    }
    
}
