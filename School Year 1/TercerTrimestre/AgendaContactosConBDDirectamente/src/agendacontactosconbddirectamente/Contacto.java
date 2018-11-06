/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendacontactosconbddirectamente;

/**
 *
 * @author alberto
 */
public class Contacto {
    private String nombre;
    private String telefono;

    public Contacto() {
    }

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre.toUpperCase();
        this.telefono = telefono;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Contacto{" + "nombre=" + nombre + ", telefono=" + telefono + '}';
    }
    
    public static boolean esTelefono(String cad){
        //Una cadena es considera un telefono valido si:
        //Tiene 3 cifras y comienza por cualquier numero
        //Tiene 4 cifras y comienza por cualquier numero
        //Tiene 9 cifras y comienza por 9, 8, 7, 6 y 5
        
        boolean esCorrecto = true;
        
        if (cad.length() != 3 && cad.length() != 4 && cad.length() != 9){
            //System.out.println("El numero de cifras es incorrecto");
            return false;
        }
        
        for (int i = 0; i < cad.length() && esCorrecto; ++i){
            if (! Character.isDigit(cad.charAt(i))){
                esCorrecto = false;
            }
        }
        
        if (!esCorrecto){
            //System.out.println(cad + " es incorrecto porque contiene letras");
            return false;
        }
        
        if (cad.length() == 9){
            if (cad.charAt(0) < '5'){
               // System.out.println(cad + " es incorrecto porque no empieza por 9,8,7,6 ó 5"); 
                return false;
            }   
        }
        
        return true;
        
    }
    
    public static boolean esNombre(String cad){
        //Un nombre al menos debe tener un caracter
        //Un nombre debe comenzar por una letra
        //Debe contener letras o numeros pero no otros signos de puntuacion
        
        if (cad.length() == 0){
           // System.out.println("Error: El nombre debe tener al menos un caracter");
            return false;
        } else if (cad.length()>25){ //Numero maximo de caracteres para nombre
            return false;
        }
        
        if (! Character.isLetter(cad.charAt(0))){
            // System.out.println("Error: El nombre debe comenzar por letra");
             return false;
        }
        
        boolean esCorrecto = true;
        
        for (int i = 1; i < cad.length() ; ++i){
          if (! Character.isAlphabetic(cad.charAt(i)) &&
              ! Character.isDigit(cad.charAt(i))){
              esCorrecto = false;
          } 
        }
        return esCorrecto;
    }
    
    
    
    
}
