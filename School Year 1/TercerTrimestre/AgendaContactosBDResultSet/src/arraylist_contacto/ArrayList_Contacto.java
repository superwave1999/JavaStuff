/*
ArrayList - Acceso Directo a un dato
Incremento de tamaño automatico

ArrayList <Persona> arrayPersona = new ArrayList();
arrayPersona.add (new Persona ("Paco",999));
arrayPersona.size();
arrayPersona.get(3);


Funciona

 */
package arraylist_contacto;

import static java.lang.Integer.parseInt;
import java.util.Scanner;

public class ArrayList_Contacto {
        
    public static int menuPrinc() {
        Scanner input = new Scanner(System.in);
        String option;
        
        System.out.println("Agenda de contactos");
        System.out.println("1. Crea contacto FUNCIONA");
        System.out.println("2. Busca contacto FUNCIONA");
        System.out.println("3. Edita contacto");
        System.out.println("4. Ver todos los contactos FUNCIONA");
        System.out.println("5. Borra contacto FUNCIONA");
        System.out.println("Otro - Salir");
        
        option=input.nextLine();
        while (Utils.esNumero(option)==false) {
            System.out.println("Numero no valido");
            option=input.nextLine();
        }
        
        return parseInt(option);
    }

    public static void main(String[] args) {
        boolean exit=false;
        //Connection con = AccesoBD.conectaBD();
        AccesoBD.createTable("agenda");
        
        Agenda agenda = new Agenda();
        
        do {
        switch (menuPrinc()) {
            case 1:
                agenda.altaContacto();
                break;
            case 2:
                agenda.buscaContacto();
                break;
            case 3:
                agenda.modificaContacto();
                break;
            case 4:
                agenda.visualizaContactosBD();
                break;
            case 5:
                agenda.bajaContacto();
                break;
            default:
                exit=true;
                break;
        }
        } while (exit==false);
    }
    
}
