/*
1. Crear fichero
2. Añadir al fichero
3. Leer fichero
4. Sustituir
5.Salir
 */
package hddandres;

public class HDDAndres {

    public static void main(String[] args) {
        
        do {
            menuPrinc();
        } while (Programa.operar());
    }
    
    public static void menuPrinc() {
        System.out.println("Microsoft Office 1992");
        System.out.println("1. Crea fichero");
        System.out.println("2. Añade al fichero");
        System.out.println("3. Lee fichero");
        System.out.println("4. Sustituir");
        System.out.println("5. Borra fichero");
        System.out.println("Otro - Salir");
    }
    
}