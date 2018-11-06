
package examen2trej1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

class Serializacion {
    
    public static Alumno leerDeFichero () {
        
        File filename = new File("alumno5.fch");  
        Alumno alumnoIn=null;
        
        if (filename.exists()) {
            try {

                FileInputStream fis = new FileInputStream(filename);
                ObjectInputStream ois = new ObjectInputStream(fis);
                alumnoIn = (Alumno) ois.readObject();
                fis.close();
                ois.close();

            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("Fichero erroneo");
                return null;
            }
        }
        return alumnoIn;
    }
}
