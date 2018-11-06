/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calificaciones;

import java.io.IOException;

/**
 *
 * @author alberto
 */
public class Calificaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Alumno alu = new Alumno();
        FicheroAlumnos fAlumnos = new FicheroAlumnos("Alumnos.dat", "rw");
        int opcion = 0;
        
      
        
        try {
               int numAlumnos = (int) fAlumnos.getFichero().length() / alu.tamRegistro();
               if (numAlumnos == 0){
                 System.out.println("El fichero alumnos esta vacio");
                  alu.alta(fAlumnos.getFichero(), numAlumnos);
                  numAlumnos++;

             }
                do {    
                    opcion = Alumno.menu();
                    switch (opcion){
                        case 1:
                            alu.consulta(fAlumnos.getFichero(), numAlumnos);
                            break;
                        case 2:
                            break;
                        case 3:
                            alu.borra(fAlumnos.getFichero(), numAlumnos);
                            break;
                        case 4:
                            alu.alta(fAlumnos.getFichero(), numAlumnos);
                            numAlumnos++;
                            break;
                        case 5:
                             alu.lista(fAlumnos.getFichero(), numAlumnos);
        
                            break;
                        case 6:
                             alu.recuparaBorrado(fAlumnos.getFichero(), numAlumnos);
                            break;
                    }
                } while (opcion != 7);

        }
        catch (IOException e){
            
        }
        
       
        
        
        fAlumnos.cierra();
    }
    
}
