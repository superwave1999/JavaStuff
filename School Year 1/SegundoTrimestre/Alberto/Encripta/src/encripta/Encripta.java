/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encripta;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author Alberto
 */
public class Encripta {

   public static void encripta (String ficheroOriginal, String ficheroEncriptado,byte clave)
	{
		try
		{
                        // Se abre el fichero original para lectura
			FileInputStream fileInput = new FileInputStream(ficheroOriginal);
			BufferedInputStream bufferedInput = new BufferedInputStream(fileInput);
			
			// Se abre el fichero donde se hará la copia encriptada
			FileOutputStream fileOutput = new FileOutputStream (ficheroEncriptado);
			BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutput);
			
			// Bucle para leer de un fichero y escribir en el otro.
			byte [] array = new byte[1000];
			int leidos = bufferedInput.read(array);
			while (leidos > 0)
			{
                                for (int i = 0; i < leidos; ++i){
                                    array[i] = (byte) ((array[i] + clave) % 256); 
                                }
				bufferedOutput.write(array,0,leidos);
				leidos=bufferedInput.read(array);
			}

			// Cierre de los ficheros
			bufferedInput.close();
			bufferedOutput.close();
		}
		catch (Exception e)
		{
                    System.out.println("Error en el encriptado");
		}
	}
   
   
        public static void desencripta (String ficheroEncriptado, String ficheroOriginal,byte clave)
	{
		try
		{
                        // Se abre el fichero encriptado para lectura
			FileInputStream fileInput = new FileInputStream(ficheroEncriptado);
			BufferedInputStream bufferedInput = new BufferedInputStream(fileInput);
			
			// Se abre el fichero donde se desencriptara
			FileOutputStream fileOutput = new FileOutputStream (ficheroOriginal);
			BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutput);
			
			// Bucle para leer de un fichero y escribir en el otro.
			byte [] array = new byte[1000];
			int leidos = bufferedInput.read(array);
			while (leidos > 0)
			{
                                for (int i = 0; i < leidos; ++i){
                                    array[i] = (byte) ((array[i] - clave) % 256); 
                                }
				bufferedOutput.write(array,0,leidos);
				leidos=bufferedInput.read(array);
			}

			// Cierre de los ficheros
			bufferedInput.close();
			bufferedOutput.close();
		}
		catch (Exception e)
		{
                    System.out.println("Error en el encriptado");
		}
        }
}


    

