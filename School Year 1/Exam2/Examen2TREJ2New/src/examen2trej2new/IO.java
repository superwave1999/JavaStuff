
package examen2trej2new;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IO {
    
    public static String readFileToText(File file) {
        try {
            InputStream is = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while(line != null){
                sb.append(line).append("\n");
                line = br.readLine();
            }
            
            is.close();
            br.close();
            
            return sb.toString();
            
        } catch (IOException ex) {
            System.out.println("Error de lectura de linea");
            return null;
        }
        
    }
    
}
