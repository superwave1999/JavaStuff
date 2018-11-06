/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1filetodbo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.util.ArrayList;

/**
 *
 * @author super
 */
public class FileIO {
    
    public static ArrayList<Contacto> readFileRetArr(String fileName) {
        
        ArrayList<Contacto> alCon = new ArrayList<>();
        String line, lineSpl[];
        
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            while ((line=br.readLine()) != null) {
                line = line.replace("\n", "").replace("\r", "");
                lineSpl=line.split(" ");
                Contacto con = new Contacto(lineSpl[0],lineSpl[1]);
                alCon.add(con);

            }
            
        } catch (IOException ex) {
            System.out.println("Error de lectura");
            return null;   
        }        
        return alCon;

    }
    
    public static void writeFile(String fileName, ArrayList<Contacto> alCon) {
        String strContac;
        
        try {
            FileWriter fr = new FileWriter(fileName,false);
            BufferedWriter br = new BufferedWriter(fr);
            StringBuilder sb = new StringBuilder();
            
            for (int i=0; i<alCon.size(); i++) {
                strContac = alCon.get(i).getNombre()+" "+alCon.get(i).getNumero()+"\n";
                sb.append(strContac);
            }
  
            br.write(sb.toString());          
            br.close();
            fr.close();
            
        } catch (IOException ex) {
            System.out.println("Error de escritura");
        }
        
    }
    
    public static void writeSerial (String filename, ArrayList<Contacto> alCon) {
        try {
            FileOutputStream fout= new FileOutputStream (filename);
            ObjectOutputStream stout = new ObjectOutputStream (fout);
            stout.writeObject(alCon);
            fout.close();
            stout.close();
        } catch (IOException ex) {
            System.out.println("Error writing serial");
        }
        
    }
    
    public static ArrayList<Contacto> readSerial (String filename) {
        ArrayList<Contacto> alCon = null;

        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            alCon = (ArrayList<Contacto>)in.readObject();
            in.close();
            file.close();
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
        return alCon;
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
