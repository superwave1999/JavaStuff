/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgendaSerial;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alberto
 */
public class AgendaContactosPrefijos extends AgendaContactos{
    
    private final ArrayList <Contacto> agendaPrefijos;
    
    public  AgendaContactosPrefijos(ArrayList <Contacto> ag){   
        super.setAgenda(ag);
        agendaPrefijos = new ArrayList();
    }

    public ArrayList<Contacto> getAgendaPrefijos() {
        return agendaPrefijos;
    }
    
   
    
     public static boolean esPrefijo(String cad){
        return (cad.charAt(0) == '#');
    }
    
    public static String eliminaAlmohadilla(String cad){
        String cadAux = "";
        if (esPrefijo(cad)){
            for (int i = 1; i < cad.length(); ++i){
                cadAux += cad.charAt(i);
            }
            return cadAux;
        }
        return cad;
    }
    
    public static boolean coincidePrefijo(String prefijo, String cad){
        if (prefijo.length() > cad.length()){
            return false;
        }
        for (int i = 0; i < prefijo.length(); ++i){
            if (prefijo.toUpperCase().charAt(i) != cad.toUpperCase().charAt(i)){
                return false;
            }
        }
        return true;
    }
    
     public void listaPorPrefijos(){
        if (agendaPrefijos.isEmpty()){
            System.out.println("No hay contactos que coincidan con el prefijo");
        } else{
            for (int i = 0; i < agendaPrefijos.size(); ++i){
                System.out.println("[" + i + "]" + agendaPrefijos.get(i));
            }
        }
    }
    
    public void buscaPorPrefijo(String prefijo){
         
          for (int i = 0; i < super.getAgenda().size(); ++i){
             if(AgendaContactosPrefijos.coincidePrefijo(prefijo, super.getAgenda().get(i).getNombre())){
                 agendaPrefijos.add(super.getAgenda().get(i));
             } else if (AgendaContactosPrefijos.coincidePrefijo(prefijo, 
                          super.getAgenda().get(i).getTelefono())){
                          agendaPrefijos.add(super.getAgenda().get(i));
             }
          }
         
    }
    
    @Override
    public String toString(){
        String cad = "";
        if (agendaPrefijos.isEmpty()){
            cad = "Agenda de prefijos vacia";
        }
        else{
            for (int i = 0; i < agendaPrefijos.size(); ++i){
                cad += "[" + i + "]" + agendaPrefijos.get(i) + "\n";
            }
        }
        return cad;
        
    }
    
    public Contacto elijeContacto(){
        Scanner entrada = new Scanner(System.in);
        int numContacto = 0;
        String cadNum;
        boolean numCorrecto;
        System.out.println("Elije el contacto con el que operar");
        do {
            
            numCorrecto = true;
            do {
                
                try{
                    cadNum = entrada.nextLine();
                    numContacto = Integer.parseInt(cadNum);
                } catch (NumberFormatException  e){

                    System.out.println("Error, formato de numero incorrecto");
                    numCorrecto = false;
                }
            } while (!numCorrecto);
            
            if (numContacto < 0 || numContacto >agendaPrefijos.size()){
                System.out.println("Error, " + numContacto + "fuera de rango");
            }
        } while (numContacto < 0 || numContacto >= agendaPrefijos.size());
        
        return agendaPrefijos.get(numContacto);
    }
    
    
   
    public void operar(Contacto con){
         boolean continuar;
         Scanner entrada = new Scanner(System.in);
         String lin;
         char opcion;
         boolean esUnTelefono = false;
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
    
}
