/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1filetodbo;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author super
 */
public class DBIO {

    //Add to db
    static void writeDB(ObjectContainer con, Contacto cont) {
        con.store(cont);
    }

    //View db
    static void viewDB(ObjectContainer con) {
        Query query = con.query();
        query.constrain(Contacto.class);
        query.descend("nombre").orderAscending();
        
        ObjectSet os = query.execute();
        while (os.hasNext()) {
            
            Contacto displ = (Contacto) os.next();
            System.out.println(displ.getNombre()+" "+displ.getNumero());
            
        }
        
        
        
    }
    
    //Read from DB
    static ArrayList<Contacto> readDB (ObjectContainer con) {
        
        ArrayList<Contacto> alCon = new ArrayList<>();
        
        Query query = con.query();
        query.constrain(Contacto.class);
        query.descend("nombre").orderAscending();
        
        ObjectSet os = query.execute();
        
        while (os.hasNext()) {
            
            Contacto contact = (Contacto) os.next();
            
            System.out.println("Read from DB: "+contact.getNombre()+" "+contact.getNumero());
            
            alCon.add(contact);
            
        }
        
        return alCon;
        
    }
    
    //Not used but has multiple descends
    static void deleteDB(ObjectContainer con, String nomDelete, String numDelete) {
        Query query = con.query();
        query.constrain(Contacto.class);
        query.descend("nombre").constrain(nomDelete).and(query.descend("numero").constrain(numDelete));
        
        ObjectSet os = query.execute();
        if (os.isEmpty()) {
            
        } else {
            Contacto displ = (Contacto) os.next();
            System.out.println(displ.getNombre()+" "+displ.getNumero());
        }
        
    }
    
    //Not used update db
    public static void actualizarAlumno(ObjectContainer oc, String nomOld, String numOld, String nomNew, String numNew){
        Scanner sc=new Scanner(System.in);
 
        Query query=oc.query();
        query.constrain(Contacto.class);
        query.descend("nombre").constrain(nomOld).and(query.descend("numero").constrain(numOld));
        ObjectSet res=query.execute();

        if (res.isEmpty()){
            System.out.println("este alumno no existe");
        } else {
            Contacto contac=(Contacto)res.next();
            System.out.println(contac.toString());

            contac.setNombre(nomNew);
            contac.setNumero(numNew);
            oc.store(contac);
        }
    }
    
}