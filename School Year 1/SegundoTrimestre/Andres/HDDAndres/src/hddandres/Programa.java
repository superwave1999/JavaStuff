
package hddandres;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Programa {
        
        public static boolean operar() {
            Scanner input = new Scanner (System.in);
            String option,cadIn;
        
            option=input.nextLine();
            while (!Tool.esNumero(option)) {
                option=input.nextLine();
            }

            if ("1".equals(option)) {
                creaFichero();
                return true;

            } else if ("2".equals(option)) {
                addFichero();
                return true;

            } else if ("3".equals(option)) {
                leeFichero();
                return true;

            } else if ("4".equals(option)) {
                sustituyeCaracteres();
                return true;

            } else if ("5".equals(option)) {
                fileDelete();
                return true;
            } else {
                System.out.println("Adios");
                return false;
            }

        }
        
        public static void creaFichero() {
                String linea;
                linea=inputCadena();              
                
                if (fileCreate(linea,true)==false) {
                    System.out.println("Error");
                }
                leeFichero();
                
        }
        
        public static void addFichero() {

                String linea;
                linea=inputCadena();              
                System.out.println(fileRead());
                if (fileCreate(linea,false)==false) {
                    System.out.println("Error");

                }   
        }
        
        public static void leeFichero() {

                String linea;
                linea = fileRead();
                System.out.println(linea);


        }
        
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
        
        
        
        public static boolean fileCreate(String cad,boolean addTo) {

                // The name of the file to open.
            String fileName = "amigos.txt";
            boolean status=true;

            try {
                // Assume default encoding.
                FileWriter fileWriter =
                    new FileWriter(fileName,addTo);

                // Always wrap FileWriter in BufferedWriter.
                BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);

                // Note that write() does not automatically
                // append a newline character.
                bufferedWriter.write(cad);

                // Always close files.
                bufferedWriter.close();
            }
            catch(IOException ex) {
                System.out.println(
                    "Error writing to file '"
                    + fileName + "'");
                // Or we could just do this:
                // ex.printStackTrace();
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
                // FileReader reads text files in the default encoding.
                FileReader fileReader = 
                    new FileReader(fileName);

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader = 
                    new BufferedReader(fileReader);

                while((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                    linearet=line;
                }   

                // Always close files.
                bufferedReader.close();         
            }
            catch(FileNotFoundException ex) {
                System.out.println(
                    "Unable to open file '" + 
                    fileName + "'");                
            }
            catch(IOException ex) {
                System.out.println(
                    "Error reading file '" 
                    + fileName + "'");                  
                // Or we could just do this: 
                // ex.printStackTrace();    
                
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