/*
Contiene el arraylist
 */
package arraylist_contacto;

import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class Agenda {
    private final Scanner input;
    
    public Agenda() {
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
            buscaNombreBD(chk);
            return true;
        } else if (telchk) {
            buscaTelefonoBD(Utils.quitarEspacios(chk));
            return true;
        } else {
            return false;
        }
        
    }
    
    public void buscaNombreBD(String busca) {
        String query="select * from agenda where nombre='"+busca+"';";
        AccesoBD.queryBD(query);
    }
    
    public void buscaTelefonoBD(String busca) {
        String query="select * from agenda where numero='"+busca+"';";
        AccesoBD.queryBD(query);

    }
    
    public void deleteNombreBD(String busca) {
        String query="delete * from agenda where nombre='"+busca+"';";
        AccesoBD.queryBD(query);
    }
    
    public void deleteTelefonoBD(String busca) {
        String query="delete * from agenda where numero='"+busca+"';";
        AccesoBD.queryBD(query);

    }
    
    public void altaContacto () {
        String numIn, nameIn;
        String query;
        
        
        System.out.println("Introduce nombre");
        nameIn=toUpperCase(input.nextLine());
        
        while (Utils.esTelefono(nameIn)) {
            System.out.println("Introduce nombre");
            nameIn=toUpperCase(input.nextLine());
        }
        
        System.out.println("Introduce numero");
        numIn=input.nextLine();
        numIn=Utils.quitarEspacios(numIn);
        while (Utils.esNombre(numIn)) {
            System.out.println("Introduce numero");
            numIn=input.nextLine();
            numIn=Utils.quitarEspacios(numIn);
        }
        
        
        query = "insert into agenda values('"+nameIn+"',"+numIn+")";
        AccesoBD.updateBD(query);
    }
    
    public void bajaContacto () {
        String chk,option;
        int verify;
        
        System.out.println("1. Borra un contacto");
        System.out.println("2. Borra TODOS los contactos");
        System.out.println("Otro. Cancela");
        option=input.nextLine();
        while (Utils.verificaMenu(option)==false) {
            System.out.println("Numero no valido");
            option=input.nextLine();
        }
        
        if (option=="1") {
        
            System.out.println("Introduce nombre o numero");
            chk=toUpperCase(input.nextLine());
        
            if (Utils.esNombre(chk)) {
                deleteNombreBD(chk);
            } else {
                deleteTelefonoBD(Utils.quitarEspacios(chk));
            }
        
        } else if (option=="2") {
            System.out.println("Como verificacion, teclea 1 para confirmar");
                verify=input.nextInt();
                if (verify==1) {
                    AccesoBD.updateBD("delete * from agenda;");
                    System.out.println("Agenda borrada");
                }
        } else {
            System.out.println("Cancelado");
        }
    }
    
    public void visualizaContactosBD() {
        String query="select * from agenda";
        AccesoBD.queryBD(query);
    }
    
    public void modificaContacto() {
        String busca;
        
        System.out.println("Introduce el numero o nombre EXACTO para modificar");
        busca=input.nextLine();
        busca=toUpperCase(busca);
        
        if (Utils.esNombre(busca)) {
            modificaNombreBD(busca);
        } else {
            modificaTelefonoBD(Utils.quitarEspacios(busca));
        }
    }
    
    public void modificaNombreBD(String busca) {
        System.out.println("Introduce numero nuevo para este numero");
        String newNum = input.nextLine();
        
        if (Utils.esTelefono(newNum)) {
            String query="Update agenda set numero='"+newNum+"' where nombre='"+busca+"';";
            AccesoBD.updateBD(query);
            
        } else {
            System.out.println("No parece ser un numero válido - volviendo");
        }
        
    }
    
    public void modificaTelefonoBD(String busca) {
        System.out.println("Introduce nombre nuevo para este numero");
        String newString = input.nextLine();
        
        if (Utils.esNombre(newString)) {
            String query="Update agenda set nombre='"+newString+"' where numero='"+busca+"';";
            AccesoBD.updateBD(query);
            
        } else {
            System.out.println("No parece ser un nombre válido - volviendo");
        }
    }
}
