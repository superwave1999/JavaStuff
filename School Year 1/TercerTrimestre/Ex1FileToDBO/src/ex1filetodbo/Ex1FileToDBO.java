/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1filetodbo;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author super
 */
public class Ex1FileToDBO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        do {
            
        } while (operate());
        
    }
    
    public static boolean operate(){
        
        Scanner input = new Scanner (System.in);
        String option,option2,nameFile,nameDB;
        boolean fileoption;
        
        System.out.println("1. File to DB | 2. DB to File | Other. Exit");
        option = input.nextLine();
        
        System.out.println("1.Archivo texto | 2.Archivo serial");
        option2=input.nextLine();
        
        if ("1".equals(option2)) {
            fileoption=true;
        } else if ("2".equals(option2)) {
            fileoption=false;
        } else {
            return false;
        }
        
        System.out.println("Nombre del archivo");
        nameFile = input.nextLine();
        System.out.println("Nombre de la BDO");
        nameDB = input.nextLine();
        
        if ("1".equals(option)) {
            fileToDB(nameFile, nameDB, fileoption);
        } else if ("2".equals(option)) {
            DBToFile(nameFile, nameDB, fileoption);
        } else {
            
            return false;
            
        }
        
        return true;
        
    }
    
    
    
    public static boolean fileToDB (String nameFile, String nameDB, boolean fileoption) {
        
        ObjectContainer oc = Db4oEmbedded.openFile(nameDB);
        ArrayList<Contacto> alCon = new ArrayList<>();
        
        if (fileoption) {
            alCon=FileIO.readFileRetArr(nameFile);
        } else if (!fileoption){
            alCon=FileIO.readSerial(nameFile);
        }
        
        if (alCon==null) {
            return false;
        }
        
        
        for (int i=0; i<alCon.size(); i++) {
            DBIO.writeDB(oc, (Contacto) alCon.get(i));
        }
        
        DBIO.viewDB(oc);
        oc.close();
        
        return true;

    }
    
    public static boolean DBToFile(String nameFile, String nameDB, boolean fileoption) {
        
        ObjectContainer oc = Db4oEmbedded.openFile(nameDB);
        ArrayList<Contacto> alCon = new ArrayList<>();
        
        alCon = DBIO.readDB(oc);
        
        if (alCon==null) {
            return false;
        }
        
        if (fileoption) {
            FileIO.writeFile(nameFile, alCon);
        } else if (!fileoption){
            FileIO.writeSerial(nameFile, alCon);
        }
        
        
        oc.close();

        return true;
    }
    
}
