/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author super
 */
public class FicherosSerial {
    
    //Use on load and on save

    public void writeSerial (String filename, ArrayList<Contacto> alCon) {
        ObjectOutputStream stout= null;
        try {
            FileOutputStream fout= new FileOutputStream (filename);
            stout = new ObjectOutputStream (fout);
            stout.writeObject(alCon);
            fout.close();
            stout.close();
        } catch (IOException ex) {
            
        } finally {
            try {
                stout.close();
            } catch (IOException ex) {

            }
        }
        
        
        
    }
    
    public void readSerial (String filename) {
        ArrayList<Contacto> alCon;
        ObjectInputStream in = null;
        try {
            FileInputStream file = new FileInputStream(filename);
            in = new ObjectInputStream(file);
            alCon = (ArrayList<Contacto>)in.readObject();
            in.close();
            file.close();
        } catch (IOException | ClassNotFoundException ex) {

        }
        
    }
    
    public boolean exists (String filename) {
        File f = new File(filename);
        if (f.exists() && !f.isDirectory()) {
            System.out.println("Encontrado agenda");
            return true;
        } else {
            System.out.println("Agenda no encontrada");
            return false;
        }
        
    }
    
}
