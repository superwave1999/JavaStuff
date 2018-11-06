
package examen2trej2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

class Textmgr {
    
    private String[] textoPal;

    private void mostrar() {
        
        for (int i=0; i<textoPal.length; i++) {
            System.out.println(textoPal[i]);
        }
        System.out.println("Numero palabras: "+textoPal.length);
    }
    
    public boolean operar() {
        boolean fileactive=false;
        
        while (fileactive==false) {
            fileactive=readFile();
        }
        
        if (fileactive==true) {
            mostrar();
        }
        
        
    }
    
    public boolean compruebaRuta(String ruta) {
        boolean isCorrecto=true;
        
        if (ruta==null) {
            System.out.println("Ruta null");
            isCorrecto=false;
        }
        
        if (ruta.length()<1) {
            System.out.println("Ruta vacía");
            isCorrecto=false;
        }
        
        return isCorrecto;
        
        
    }

    private File rutaFichero() {
        
        boolean isCorrecto=true;
        Scanner input=new Scanner (System.in);
        String ruta;
        
        
        System.out.println("Introduce ruta");
        ruta=input.nextLine();
        
        while (!compruebaRuta(ruta)) {
            System.out.println("Introduce ruta correcta");
            ruta=input.nextLine();
        }
        
        File file = new File(ruta);
        
        return file;
    }
    
    public boolean readFile() {
        
        String texto;
        
        File file=rutaFichero();
        
        while (!file.exists()) {
            System.out.println("Archivo no encontrado");
            file=rutaFichero();
            
        }
        
        try {
            InputStream is = new FileInputStream(file);
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));
        
            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();
        
            while(line != null){
                sb.append(line).append("\n");
                line = buf.readLine();
            }
        
            texto = sb.toString();
            
            if (dividirEnPalabras(texto)==false) {
                return false;
            }
            
        } catch (IOException ex) {
            System.out.println("Error de lectura, comprueba la ruta");
            return false;
        }
        
        
        

        return true;
    }
    
    public boolean dividirEnPalabras(String texto) {

        textoPal = texto.split("[\t|,|;| |\n|.]");
        
        return true;
    }
    
    
}
