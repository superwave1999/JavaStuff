/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcopybits;

import java.io.*;

/**
 *
 * @author roxas
 */
public class Copiador {

    public Copiador() {
    }
    
    public void copiarArchivo(String origenn, String destinoo){
         File origen = new File(origenn);
         File destino = new File(destinoo);
         
         
                try {
                        InputStream in = new FileInputStream(origen);
                        OutputStream out = new FileOutputStream(destino);

                        byte[] buf = new byte[1024];
                        int len;

                        while ((len = in.read(buf)) > 0) {
                                out.write(buf, 0, len);
                        }

                        in.close();
                        out.close();
                } catch (IOException ioe){
                        ioe.printStackTrace();
                }
         
    }
    
}
