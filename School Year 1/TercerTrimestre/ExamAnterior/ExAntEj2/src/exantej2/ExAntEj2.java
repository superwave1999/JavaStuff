/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exantej2;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Query;
import static java.lang.Integer.parseInt;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author super
 */
public class ExAntEj2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ObjectContainer bdPreguntas = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"preguntas.db4o");
        ObjectContainer bdAlumnos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"alumnos.db4o");
        
        Pregunta preg = new Pregunta("a is corr", "a", "b", "c", "d", "a");
        bdPreguntas.store(preg);
        preg = new Pregunta("a is corr", "a", "b", "c", "d", "a");
        bdPreguntas.store(preg);
        preg = new Pregunta("a is corr", "a", "b", "c", "d", "a");
        bdPreguntas.store(preg);
        preg = new Pregunta("a is corr", "a", "b", "c", "d", "a");
        bdPreguntas.store(preg);
        preg = new Pregunta("a is corr", "a", "b", "c", "d", "a");
        bdPreguntas.store(preg);
        preg = new Pregunta("a is corr", "a", "b", "c", "d", "a");
        bdPreguntas.store(preg);
        preg = new Pregunta("a is corr", "a", "b", "c", "d", "a");
        bdPreguntas.store(preg);
        preg = new Pregunta("a is corr", "a", "b", "c", "d", "a");
        bdPreguntas.store(preg);
        preg = new Pregunta("a is corr", "a", "b", "c", "d", "a");
        bdPreguntas.store(preg);
        preg = new Pregunta("a is corr", "a", "b", "c", "d", "a");
        bdPreguntas.store(preg);
        
        Alumno alum = new Alumno("imanol",19,0);
        bdAlumnos.store(alum);
        alum = new Alumno("marta",20,0);
        bdAlumnos.store(alum);
        
        //Exam
        realizarPreguntasAlumno(bdPreguntas, bdAlumnos);
        
        bdPreguntas.close();
        bdAlumnos.close();
    }
    
    //Apartado A
    public static boolean realizarPreguntasAlumno(ObjectContainer bdPreguntas, ObjectContainer bdAlumnos) {

        ArrayList<Pregunta> alPreg;
        Alumno alum;
        int points;
        
        //Saca preguntas a un arraylist
        alPreg=readPreguntas(bdPreguntas);
        if (alPreg==null) {
            System.out.println("array principal vacio");
            return false;
        }
       
        //Escogemos alumno
        alum=useAlumno(bdAlumnos);
        if (alum==null) {
            return false;
        }

        //Preguntamos al alumno
        points=printPreg(alPreg,alum);
        
        if (points>10 || points<0) {
            System.out.println("Error de cuenta");
            return false;
        }
        
        //Actualizamos la nota
        storeAlumno(bdAlumnos,alum,points);
        
        //Vemos los alumnos por nota
        viewAllAlumnos(bdAlumnos);
       
        return true;
    }  
    
    public static int printPreg(ArrayList<Pregunta> alPreg, Alumno alum) {
        Scanner input = new Scanner(System.in);
        String correct;
        int points=0;
        
        for (int i=0; i<10; i++) {
            System.out.println("Pregunta "+i+1);
            System.out.println(alPreg.get(i).toString());
            System.out.println("Deme la respuesta correcta (a-b-c-d)");
            correct=input.nextLine();
            
            if (correct.equals(alPreg.get(i).getSolucion())) {
                points++;
            }            
        }
        
        return points;

    }

    public static boolean storeAlumno(ObjectContainer con, Alumno alum, int points) {
        Alumno alNew;
        Query query = con.query();
        query.constrain(Alumno.class);
        query.descend("nombre").constrain(alum.getNombre());
        ObjectSet os = query.execute();
        if (os.isEmpty()) {
            System.out.println("Error de actualizacion");
            return false;
        } else {
            alNew = (Alumno) os.next();
            alNew.setNota(points);
            con.store(alNew);
            return true;
        }
    }

    public static Alumno useAlumno(ObjectContainer con) {
        Scanner input = new Scanner(System.in);
        String nombre;
        System.out.println("Nombre alumno:");
        nombre = input.nextLine();
        Query query = con.query();
        query.constrain(Alumno.class);
        query.descend("nombre").constrain(nombre);
        ObjectSet os = query.execute();
        System.out.println("recuperados " + os.size());
        if (os.isEmpty()) {
            System.out.println("Error");
            return null;
        } else {
            Alumno alum = (Alumno) os.next();
            os.remove(os);
            System.out.println(alum.toString());
            return alum;
        }
    }

    public static ArrayList<Pregunta> readPreguntas(ObjectContainer con) {
        ArrayList<Pregunta> alPreg = new ArrayList<>();
        Query query = con.query();
        query.constrain(Pregunta.class);
        query.descend("pregunta").orderAscending();
        ObjectSet os = query.execute();
        while (os.hasNext()) {
            Pregunta preg = (Pregunta) os.next();
            alPreg.add(preg);
        }
        return alPreg;
    }
    
    //Apartado 2
    public static void viewAllAlumnos(ObjectContainer alum) {
        Scanner input = new Scanner(System.in);
        String notainf;
        int notaInfInt;
        String notasup;
        int notaSupInt;
        System.out.println("Deme una nota maxima de busqueda");
        notasup = input.nextLine();
        notaSupInt = parseInt(notasup);
        System.out.println("Deme una nota minima de busqueda");
        notainf = input.nextLine();
        notaInfInt = parseInt(notainf);
        
        Query query = alum.query();
        query.constrain(Alumno.class);
        Constraint q1 = query.descend("nota").constrain(notaSupInt).smaller();
        query.descend("nota").constrain(notaInfInt).greater().and(q1);
        ObjectSet os = query.execute();
        while (os.hasNext()) {
            Alumno al = (Alumno) os.next();
            System.out.println(al.toString());
        }
    }

}
