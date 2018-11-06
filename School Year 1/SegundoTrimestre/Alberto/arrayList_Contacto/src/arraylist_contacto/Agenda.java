/*
Contiene el arraylist
 */
package arraylist_contacto;

import static arraylist_contacto.ArrayList_Contacto.verificaMenu;
import java.util.ArrayList;
import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class Agenda {
    private final ArrayList<Contacto> agenda;
    private final Scanner input;
    
    public Agenda() {
        agenda = new ArrayList<>();
        input = new Scanner (System.in);
    }
    
    public boolean buscaContacto () {
        String chk;
        boolean telchk;
        boolean nomchk;
        
        System.out.println("Introduce nombre o numero");
        chk=toUpperCase(input.nextLine());
        
        telchk=Utils.esNumero(Utils.quitarEspacios(chk));
        nomchk=Utils.esNombre(chk);
        
        
        if (nomchk) {
            return buscaNombre(chk);
        } else if (telchk) {
            return buscaTelefono(Utils.quitarEspacios(chk));
        } else {
            return false;
        }
        
    }
    
    public boolean buscaNombre(String busca) {
        boolean buscado=false;
        
        for (int i=0; i<agenda.size(); i++) {
            if (agenda.get(i).getNombre().indexOf(busca)>=0) {
                    System.out.println("Encontrado");
                    System.out.println("Nombre: "+agenda.get(i).getNombre());
                    System.out.println("Numero: "+agenda.get(i).getTelefono());
                    buscado=true;
            }
        }
        return buscado;
    }
    
    public boolean buscaTelefono(String busca) {
        boolean buscado=false;
        
        for (int i=0; i<agenda.size(); i++) {
            if (agenda.get(i).getTelefono().indexOf(busca)>=0) {
                    System.out.println("Encontrado");
                    System.out.println("Nombre: "+agenda.get(i).getNombre());
                    System.out.println("Numero: "+agenda.get(i).getTelefono());
                    buscado=true;
            }
        }
        return buscado;
    }
        
    public int compruebaDuplicados (String busca) {
        int position=-1;
        for (int i=0; i<agenda.size(); i++) {
            if (agenda.get(i).getTelefono().equals(busca)) {
                    System.out.println("Encontrado telefono duplicado");
                    position=i;

            }
        }
        
        for (int i=0; i<agenda.size(); i++) {
            if (agenda.get(i).getNombre().equals(busca)) {
                    System.out.println("Encontrado nombre duplicado");
                    position=i;

            }
        }
        return position;
    }
    
    public boolean compruebaDuplicadosExcepto (String busca,int j) {
        boolean sw=false;
        for (int i=0; i<agenda.size(); i++) {
            if (agenda.get(i).getTelefono().equals(busca) && !(i==j)) {
                    System.out.println("Encontrado telefono duplicado");
                    sw=true;

            }
            
            
        }
        
        for (int i=0; i<agenda.size(); i++) {
            if (agenda.get(i).getNombre().equals(busca) && !(i==j)) {
                    System.out.println("Encontrado nombre duplicado");
                    sw=true;

            }
        }
        return sw;
    }
    
    public void altaContacto () {
        String numIn, nameIn;
        
        
        System.out.println("Introduce nombre");
        nameIn=toUpperCase(input.nextLine());
        
        while (Utils.esNombre(nameIn)==false || compruebaDuplicados(nameIn)>=0) {
            System.out.println("Introduce nombre");
            nameIn=toUpperCase(input.nextLine());
        }
        
        System.out.println("Introduce numero");
        numIn=input.nextLine();
        numIn=Utils.quitarEspacios(numIn);
        while (Utils.esTelefono(numIn)==false || compruebaDuplicados(numIn)>=0) {
            System.out.println("Introduce numero");
            numIn=input.nextLine();
            numIn=Utils.quitarEspacios(numIn);
        }
        
        agenda.add(new Contacto(nameIn,numIn));
    }
    
    public void bajaContacto () {
        String busca,option;
        int position,verify;
        
        System.out.println("1. Borra un contacto");
        System.out.println("2. Borra TODOS los contactos");
        System.out.println("Otro. Cancela");
        option=input.nextLine();
        while (verificaMenu(option)==false) {
            System.out.println("Numero no valido");
            option=input.nextLine();
        }
        
        if (option=="1") {
        
            System.out.println("Introduce el numero o nombre EXACTO");
            busca=toUpperCase(input.nextLine());

            if (compruebaDuplicados(busca)>=0){
                position=compruebaDuplicados(busca);
                System.out.println("Como verificacion, teclea "+position+" para confirmar");
                verify=input.nextInt();
                if (position==verify) {
                    agenda.remove(position);
                }
            } else {
                System.out.println("No se han encontrado coincidencias");
            }
        
        } else if (option=="2") {
            System.out.println("Como verificacion, teclea 1 para confirmar");
                verify=input.nextInt();
                if (verify==1) {
                    agenda.clear();
                    System.out.println("Agenda borrada");
                }
        } else {
            System.out.println("Cancelado");
        }
    }
    
    public void visualizaContactos() {
        for (int i=0; i<agenda.size(); i++) {
                    System.out.println(agenda.get(i).getNombre()+" "+agenda.get(i).getTelefono());
        }
    }
    
    public void modificaContacto() {
        String busca,nameIn,numIn;
        int position;
        
        System.out.println("Introduce el numero o nombre EXACTO");
        busca=input.nextLine();
        busca=toUpperCase(busca);
        position=compruebaDuplicados(busca);
        
        if (position>=0){
            
            System.out.println("Introduce nombre");
            nameIn=toUpperCase(input.nextLine());
        
            while (Utils.esNombre(nameIn)==false || compruebaDuplicadosExcepto(nameIn,position)==true) {
                System.out.println("Introduce nombre");
                nameIn=toUpperCase(input.nextLine());
            }
        
            System.out.println("Introduce numero");
            numIn=input.nextLine();
            numIn=Utils.quitarEspacios(numIn);
            while (Utils.esTelefono(numIn)==false || compruebaDuplicadosExcepto(numIn,position)==true) {
                System.out.println("Introduce numero");
                numIn=input.nextLine();
                numIn=Utils.quitarEspacios(numIn);
            }
                
            agenda.set(position,new Contacto(nameIn,numIn));
            
        } else {
            System.out.println("No se han encontrado coincidencias");
        
        }
    }
    
    public static void testString() {
        
    }
}
