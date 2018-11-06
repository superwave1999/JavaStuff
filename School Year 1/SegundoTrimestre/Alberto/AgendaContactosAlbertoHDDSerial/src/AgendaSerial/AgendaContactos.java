/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgendaSerial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alberto
 */
public class AgendaContactos implements Serializable {

    private ArrayList <Contacto> agenda;
    
    public AgendaContactos(){
        agenda = new ArrayList();
    }

    public void setAgenda(ArrayList<Contacto> agenda) {
        this.agenda = agenda;
    }
    
    public boolean add(Contacto con){
        return agenda.add(con);
    }

    public ArrayList<Contacto> getAgenda() {
        return agenda;
    }
    
    
    
    public Contacto busca(String cad){ //Busca por nombre o telefono
        for (int i = 0; i < agenda.size(); ++i){
            if (agenda.get(i).getNombre().toUpperCase().compareTo(cad.toUpperCase()) == 0){
                return agenda.get(i);
            } else if (agenda.get(i).getTelefono().compareTo(cad) == 0){
                return agenda.get(i);
            }
        }
        
        return null;
    }
    
    
    public boolean remove(Contacto con){
      return  agenda.remove(con);
    }
    
    public void lista(){
        if (agenda.isEmpty()){
            System.out.println("Agenda vacia");
        } else{
            for (int i = 0; i < agenda.size(); ++i){
                System.out.println(agenda.get(i));
            }
        }
    }
    
    public String  leeContacto(){
            Scanner entrada = new Scanner(System.in);
            String cad;
           
            System.out.println("Dame nombre o telefono del contacto o # para prefijo [intro = terminar]:");
            cad = entrada.nextLine();
                       
            return cad;
    }
    
    public void modifica(Contacto con, boolean esUnTelef){
            String cad;
            Contacto conBus;
            Scanner entrada = new Scanner(System.in);
            if (esUnTelef){
                modificaPorNombre(con);
            } else{
                modificaPorTelefono(con);
            }    
    }
     
    public void modificaPorNombre(Contacto con){
        
        String cad;
        Contacto conBus;
        Scanner entrada = new Scanner(System.in);
        boolean continuar;
         
        do{
            continuar = true;
            System.out.println("Nuevo nombre[Intro = Sin cambios]:");
            cad = entrada.nextLine();
                    
            if (cad.length() >0){
                if (!Contacto.esNombre(cad)){
                   System.out.println("Nombre invalido");
                } else{
                    continuar = false;
                }
            } else{
                continuar = false;
            }
        } while (continuar);


        if (cad.length() != 0){
                if (busca(cad) != null){
                System.out.println("Error, ya existe el nombre");
            } else{
                   con.setNombre(cad);
            }
                  
        }
    }
    
    public void modificaPorTelefono(Contacto con){
        
        String cad;
        Scanner entrada = new Scanner(System.in);
        boolean continuar;
         
        do{
            continuar = true;
            System.out.println("Nuevo telefono[Intro = Sin cambios]:");
            cad = entrada.nextLine();
                    
            if (cad.length() >0){
                if (!Contacto.esTelefono(cad)){
                   System.out.println("Telefono invalido");
                } else {
                    continuar = false;
                }
            } else{
                continuar = false;
            }
        } while (continuar);


        if (cad.length() != 0){
            if (busca(cad) != null){
                System.out.println("Error, ya existe el telefono");
            } else{
                   con.setTelefono(cad);
            }
        }
    }
    
    
     
     public void baja(Contacto con){
            char res;
            Scanner entrada = new Scanner(System.in);
            System.out.println("¿Confirma la baja (s/n)?");
            res = entrada.nextLine().charAt(0); 
            if (res == 's' || res == 'S'){
                agenda.remove(con);
                System.out.println("Contacto borrado");
            }
    }
     
    public boolean alta(String cad){
            
            if (Contacto.esTelefono(cad)){
                System.out.println("Alta con telefono:" + cad);
                return altaPorTelefono(cad);
            }
            else if (Contacto.esNombre(cad)){
                System.out.println("Alta con nombre:" + cad);
                return altaPorNombre(cad);
            } else {
                System.out.println("Error, no es nombre, ni telefono");
                return false;
            }
    }


    public boolean altaPorTelefono(String cadTelefono){
        Scanner entrada = new Scanner(System.in);
        boolean continuar;
        String cadAux;
        Contacto contactoAlta = null;
        
        do{
            continuar = true;
            System.out.println("Nombre:");
            cadAux= entrada.nextLine(); //Lee un nombre o intro
            if (cadAux.length() != 0){
                if (!Contacto.esNombre(cadAux)){
                    System.out.println("Error, nombre incorrecto");
                } else{
                     if (busca(cadAux) != null){
                        System.out.println("Error, ya existe el contacto");
                     } else{
                          contactoAlta = new Contacto();
                          contactoAlta.setNombre(cadAux);
                          contactoAlta.setTelefono(cadTelefono);
                          continuar = false;
                     }
                }
             } else{
                continuar = false;
            }
        } while(continuar);
        if (contactoAlta != null)
            return agenda.add(contactoAlta);
        else
            return false;
    }
    
    
    
    public boolean altaPorNombre(String cadNombre){
        Scanner entrada = new Scanner(System.in);
        boolean continuar;
        String cadAux;
        Contacto contactoAlta = null;
        
        do{
            continuar = true;
            System.out.println("Telefono:");
            cadAux= entrada.nextLine(); //Lee un telefono o intro
            if (cadAux.length() != 0){
                if (!Contacto.esTelefono(cadAux)){
                    System.out.println("Error, telefono incorrecto");
                } else{
                     if (busca(cadAux) != null){
                        System.out.println("Error, ya existe el contacto");
                     } else{
                          contactoAlta = new Contacto();
                          contactoAlta.setNombre(cadNombre);
                          contactoAlta.setTelefono(cadAux);
                          continuar = false;
                     }
                }
             } else{
                continuar = false;
            }
        } while(continuar);
        if (contactoAlta != null)
            return agenda.add(contactoAlta);
        else
            return false;
    }
   
     
    public boolean operar(){
            Scanner entrada = new Scanner(System.in);
            String cad, lin;
            Contacto con;
            char opcion;
            boolean continuar;
            
          
            cad = leeContacto();
            if (cad.length() == 0){
                return false;
            }
            
            if (AgendaContactosPrefijos.esPrefijo(cad)){
                AgendaContactosPrefijos agendaPref  = new AgendaContactosPrefijos(agenda);
                agendaPref.buscaPorPrefijo(AgendaContactosPrefijos.eliminaAlmohadilla(cad));
                agendaPref.listaPorPrefijos();
                if (!agendaPref.getAgendaPrefijos().isEmpty()){
                    con = agendaPref.elijeContacto();
                    agendaPref.operar(con);
                }
            } else {
            

            
                boolean esUnTelefono = Contacto.esTelefono(cad);

                con = busca(cad);
                if (con != null){
                    System.out.println(con);
                    do {
                        continuar = true;
                        System.out.println("[M]:modificar   [B]:baja   [intro]:salir");

                        lin = entrada.nextLine();
                        if (lin.length() == 0){
                            continuar = false;
                        } else {
                                opcion = lin.charAt(0);
                                switch (opcion){
                                    case 'm':
                                    case 'M':   
                                                modifica(con, esUnTelefono);
                                                continuar = false;
                                                break;

                                    case 'b':   
                                    case 'B':            
                                                baja(con);
                                                continuar = false;
                                                break;

                                    default:
                                                System.out.println("Opción incorrecta");

                                }
                        }
                    } while (continuar);

                }
                else {  // Es un contacto que no existe   
                    alta(cad);
                }
            }
            return true;
        }
    

    public void saveAgenda (String filename) {
        ObjectOutputStream stout= null;
        try {
            FileOutputStream fout= new FileOutputStream (filename);
            stout = new ObjectOutputStream (fout);
            stout.writeObject(agenda);
            fout.close();
            stout.close();
        } catch (IOException ex) {
            
        } finally {
            try {
                stout.close();
            } catch (IOException ex) {

            }
        }
        
        
        
    }
    
    public void loadAgenda (String filename) {
        ObjectInputStream in = null;
        try {
            FileInputStream file = new FileInputStream(filename);
            in = new ObjectInputStream(file);
            agenda = (ArrayList<Contacto>)in.readObject();
            in.close();
            file.close();
        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        } finally {
            try {
                in.close();
            } catch (IOException ex) {

            }
        }
        
    }
    
    public boolean existe (String filename) {
        File f = new File(filename);
        if (f.exists() && !f.isDirectory()) {
            System.out.println("Encontrado agenda");
            return true;
        } else {
            System.out.println("Agenda no encontrada");
            return false;
        }
        
    }
    
    @Override
    public String toString(){
        String cad = "";
        if (agenda.isEmpty()){
            cad = "Agenda vacia";
        }
        else{
            for (int i = 0; i < agenda.size(); ++i){
                cad += agenda.get(i) + "\n";
            }
        }
        return cad;
        
    }
    
}
