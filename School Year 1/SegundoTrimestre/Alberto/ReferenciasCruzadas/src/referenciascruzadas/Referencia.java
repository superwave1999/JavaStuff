/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package referenciascruzadas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import static java.util.Collections.sort;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;



/**
 *
 * @author super
 */
public class Referencia {
    
    private String palabras[];
    private String ruta;
    private String texto;
    private File file=null;
    
    public Referencia () {
    }
    
    public boolean mainMenu() {
        String option;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Menu principal");
        if (ruta!=null) {  //FIX PALABRAS.LENGTH NULL POINTER
//            System.out.println("El archivo "+ruta+" tiene "+palabras.length+" palabras");
        } else {
            System.out.println("Archivo no seleccionado");
        }
        
        System.out.println("1- Elige y carga el archivo");
        
        if (file!=null) {
            System.out.println("2- Mostrar el archivo");
            System.out.println("3- Mostrar las plabras y sus ocurrencias");
            System.out.println("4- Guardar log");
        }

        System.out.println("Otro- Salir del programa");
        
        option=input.nextLine();
        
        if (option.equals("1")) {
            readFile();

        } else if (option.equals("2") && file!=null){
            System.out.println(texto);
            
        } else if (option.equals("3") && file!=null){
            mostrarPalabras(texto);
            
        } else if (option.equals("4") && file!=null){
            outputLog();

        } else {
            System.out.println("Adios");
            return false;
        }
        
        return true;
    }
    
    public File initFile(boolean writeOp) {
        Scanner input = new Scanner(System.in);
        String rutain;
        
        System.out.println("Introduce la ruta correcta del archivo");
        rutain=input.nextLine();
        File filein;
        
        filein = new File(rutain);
        
        while (!filein.exists() && writeOp==false) {
            System.out.println("Introduce la ruta correcta del archivo");
            rutain=input.nextLine();
        
            filein = new File(rutain);
        }

        return filein;
    }
    
    public String standariseOutput(String lin){
        return lin.replaceAll("[^A-Za-z0-9' ]", "").replaceAll(" +", " ").replaceAll("\n","").toLowerCase();

    }
    
    public boolean readFile() {
        
        file=initFile(false);
        
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
            
        } catch (IOException ex) {
            System.out.println("Error de lectura, comprueba la ruta");
            return false;
        }
        
        if (dividirEnPalabras(texto)==false) {
            return false;
        }
        

        return true;
    }
    
    public boolean dividirEnPalabras(String texto) {
        
        if (texto==null) return false;

        palabras = texto.split(" ");
        for (int i=0; i<palabras.length; i++) {
            palabras[i]=standariseOutput(palabras[i]);
        }
        
        return true;
    }
    
    
    
    public void mostrarPalabras(String texto){
        
        List<String> arr = Arrays.asList(palabras);
        sort(arr);
        Set<String> printed = new HashSet<>();
        for (String s : arr) {
            if (printed.add(s)) { // Set.add() also tells if the element was in the Set!
                System.out.println("Palabra " + s
                    + " coincidencias: " + Collections.frequency(arr, s));
            }    
        }
        
    }
    
    public boolean outputLog () {

        File fileout;
        
        fileout=initFile(true);
        
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileout));
            List<String> arr = Arrays.asList(palabras);
            sort(arr);

            Set<String> printed = new HashSet<>();
            for (String s : arr) {
                if (printed.add(s)) { // Set.add() also tells if the element was in the Set!
                    writer.write("Palabra " + s
                            + " coincidencias: " + Collections.frequency(arr, s));
                    writer.newLine();
                }    
            }
            writer.close();
            
        } catch (IOException ex) {
            System.out.println("Error: "+ex.toString());
            return false;
        }
        return true;
        
    }
    
}
