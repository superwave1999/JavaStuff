/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaobjectsdb;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.io.File;

/**
 *
 * @author Tarde
 */
public class JavaObjectsDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new File("alumnos.db4o").delete();
        
        ObjectContainer ocbdAlumnos = Db4oEmbedded.openFile("alumno.db4o");
        
        Alumno alu1 = new Alumno("24240240Z","Ana",18,958121314);
        Alumno alu2 = new Alumno("25250250X","Belen",19,958121315);
        Alumno alu3 = new Alumno("X7068337T","Imanol",20,634890883);
        ocbdAlumnos.store(alu1);
        ocbdAlumnos.store(alu2);
        ocbdAlumnos.store(alu3);
        
        Alumno alu4 = new Alumno(null,null,0,0);
        ObjectSet os = ocbdAlumnos.queryByExample(alu4);
        
        
        Alumno alu5 = new Alumno();
        while (os.hasNext()) {
            alu5=(Alumno)os.next();
            System.out.println(alu5.toString());
        }
        
        //Cambiar datos
        
        alu4 = new Alumno(null,"Ana",0,0);
        os = ocbdAlumnos.queryByExample(alu4);
        while (os.hasNext()) {
            alu5=(Alumno)os.next();
            System.out.println(alu5.toString());
            alu5.setEdad(19);
            ocbdAlumnos.store(alu5);
            System.out.println(alu5.toString());
        }

        ocbdAlumnos.close();
        
    }
    
}
