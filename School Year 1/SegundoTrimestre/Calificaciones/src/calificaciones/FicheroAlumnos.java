/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calificaciones;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author alberto
 */
public class FicheroAlumnos {
    private RandomAccessFile fichero;
    
    public FicheroAlumnos(String nomFich, String modo){
        try {
            //se abre el fichero para lectura y escritura
            fichero = new RandomAccessFile(nomFich, modo);
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } 
    }

    public RandomAccessFile getFichero() {
        return fichero;
    }
    
    public boolean posicionate(long pos){
        try{
            fichero.seek(pos);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        } 
        return true;
    }
    
    public boolean cierra(){
         try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return false;
            }
         return true;
    }
    
    
    
}
