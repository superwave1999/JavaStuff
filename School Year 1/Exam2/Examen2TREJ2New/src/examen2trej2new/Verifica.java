
package examen2trej2new;

import java.io.File;
import java.util.Scanner;

public class Verifica {
    
    public static boolean compruebaRuta(String ruta) {
        boolean isCorrecto=true;
        if (ruta.length()<1) {
            System.out.println("Ruta vacía");
            isCorrecto=false;
        }
        return isCorrecto;
    }

    public static boolean ficheroValido(File file) {
        boolean fileExists=true;
        if (file.exists()==false) {
            System.out.println("Archivo no encontrado");
            fileExists=false;
        }
        return fileExists;
    }
    
    public static boolean verificaContinua(){
        String pregunta;
        Scanner input= new Scanner (System.in);

        System.out.println("Desea continuar? 1-Si, Otro-No");
        pregunta=input.nextLine();
        if (pregunta.equals("1")){
            return true;
        } else {
            return false;
        }
        
    }
    
}
