
package agendacontactosfinalrelacional;

public class Utils {
    //Has space remover
    public static boolean esTelefono(String cad){
        //Comprueba si valor introducido es numero telefonico o no
        
        //Una cadena es considera un telefono valido si:
        //Tiene 3 cifras y comienza por cualquier numero
        //Tiene 4 cifras y comienza por cualquier numero
        //Tiene 9 cifras y comienza por 9, 8, 7, 6 y 5
        
        boolean esCorrecto = true;
        
        cad=quitarEspacios(cad);
        
        for (int i = 0; i < cad.length() && esCorrecto; ++i){
            if (! Character.isDigit(cad.charAt(i))){
                esCorrecto = false;
            }
        }
        
        if (!esCorrecto){
            System.out.println(cad + " es un numero incorrecto");
            return false;
        }
        
        if (cad.length() != 3 && cad.length() != 4 && cad.length() != 9){
            System.out.println("El numero de cifras es incorrecto");
            return false;
        }
        
        if (cad.length() == 9){
            if (cad.charAt(0) < '5'){
                System.out.println(cad + " es incorrecto porque no empieza por 9,8,7,6 o 5"); 
                return false;
            }   
        }
        return true;
    }
        
    public static boolean esNombre(String cad){
        //Comprueba si valor introducido es un nombre de contacto valido
        
        if (cad.length()<1) {
            return false;
        }
        
        for(int i=0; i<cad.length(); i++){
            char ch = cad.charAt(i);
            if (i==0 && !((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))) {
                return false;
            }
            
            if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch == ' ' || (ch >= '0' && ch <= '9'))) {
                return false;               
            }
        }
        return true; 
    }
    
    public static String quitarEspacios(String input) {
        return input.replaceAll(" ","");
    }    
}
