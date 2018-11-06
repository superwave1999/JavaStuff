/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



/**
 *
 * @author andres
 */
public class FicherosTexto {
        
        public static void sustituyeCaracteres () {
            String actual;
            String cambio;
            String cambiarPor;
            String cambiado;
            
            actual=fileRead();
            cambio=inputCadena();
            cambiarPor=inputCadena();
            
            cambiado=replaceText(actual,cambio,cambiarPor);
            
            fileCreate(cambiado,false);
            
        }
        
        public static String replaceText (String input, String toReplace, String replaceWith) {
            return input.replaceAll(toReplace,replaceWith);
        }
        
        public static String inputCadena() {
            Scanner leer = new Scanner (System.in);
            String linea;
            
            System.out.println("Teclee texto, terminar doble intro");
            linea=leer.nextLine();
            
            return linea;
            
        }
        
        //FILES START HERE ==================================
        
        public static boolean fileCreate(String cad,boolean addTo) {
            
            // The name of the file to open.
            String fileName = "amigos.txt";
            boolean status=true;

            try {
                
                FileWriter fileWriter = new FileWriter(fileName,addTo);

                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write(cad);

                bufferedWriter.close();
            }
            catch(IOException ex) {
                status=false;
            }
            return status;
        }
        
        public static String fileRead() {

            // The name of the file to open.
            String fileName = "amigos.txt";

            // This will reference one line at a time
            String line = null;
            String linearet=null;

            try {
                FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                    linearet=line;
                }   

                bufferedReader.close();         
            }
            catch(FileNotFoundException ex) {
             
            } catch(IOException ex) {
 
            }

            return linearet;
        }
        
        public static void fileDelete () {
            File file = new File("amigos.txt");
         
            if(file.delete()) {
                System.out.println("File deleted successfully");
            } else {
                System.out.println("Failed to delete the file");
            }
        }
        
}

