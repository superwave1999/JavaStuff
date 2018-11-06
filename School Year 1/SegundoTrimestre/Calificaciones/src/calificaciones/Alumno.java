/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calificaciones;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author alberto
 */
public class Alumno {
    
    private static final int TAMMAXCODIGO = 4;  // un int tiene 4 bytes
    private static final int TAMMAXDNI = 9;
    private static final int TAMMAXNOMBRE = 30;
    private static final int TAMMAXAPELLIDO1 = 30;
    private static final int TAMMAXAPELLIDO2 = 30;
    private static final int TAMMAXEMAIL = 50;
    private static final int TAMMAXMOVIL = 9;
    private static final int TAMMAXFIJO = 9;
    private static final int TAMMAXDIRECCION = 60;
    private static final int TAMMAXCP = 5;
    private static final int TAMMAXPROVINCIA = 20;
    
    
   
    
    private int    codigo;      //Coincide con la posicion dentro del archivo directo
    private String dni;         // Tamaño max 9
    private String nombre;      //Tamaño max 30
    private String apellido1;   //Tamaño max 30
    private String apellido2;   //Tamaño max 30
    private String email;       //Tamaño max 50
    private String movil;       //Tamaño  9
    private String fijo;        //Tamaño  9
    private String direccion;   //Tamaño max 60
    private String cp;          //Tamaño 5
    private String provincia;   //Tamaño max 20

    public Alumno() {
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getDni() {
        return dni;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getEmail() {
        return email;
    }

    public String getMovil() {
        return movil;
    }

    public String getFijo() {
        return fijo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCp() {
        return cp;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public void setFijo(String fijo) {
        this.fijo = fijo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Alumno{" + "codigo=" + codigo + "\n" 
                         + "dni=" +    dni +    "\n" 
                         + "nombre=" + nombre + "\n" 
                         + "apellido1=" + apellido1 + "\n" 
                         + "apellido2=" + apellido2 + "\n" 
                         + "email=" + email + "\n" 
                         + "movil=" + movil + "\n" 
                         + "fijo=" + fijo + "\n" 
                         + "direccion=" + direccion + "\n" 
                         + "cp=" + cp + "\n" 
                         + "provincia=" + provincia + '}';
    }
    
    public static String nBlancos(int n){
        String cad  ="";
        for (int i = 1; i <= n; ++i){
            cad += " ";
        }
        return cad;
    }
    
    public  String introduce(String mensaje, int tamMax, boolean tamFijo){
        Scanner entrada = new Scanner(System.in);
        String cadLeida = "";
        boolean seguir;
        int numBlancos;
        do{
            seguir = false;
            System.out.print(mensaje);
            cadLeida = entrada.nextLine();
            if (tamFijo && cadLeida.length() != tamMax){
                System.out.println("Error, no tiene el numero de caracteres adecuado");
                seguir = true;
            } else if (!tamFijo && cadLeida.length() > tamMax ){
                System.out.println("Error, tiene demasiados caracteres");
                seguir = true;
            }
        } while (seguir);
        
        if (!tamFijo) {
            numBlancos = tamMax - cadLeida.length();
            cadLeida += nBlancos(numBlancos);
        }
        
        return cadLeida;
    }
    
    public int tamRegistro(){
        return TAMMAXCODIGO + 
               TAMMAXDNI + 
               TAMMAXNOMBRE +
               TAMMAXAPELLIDO1 +
               TAMMAXAPELLIDO2 +
               TAMMAXEMAIL +
               TAMMAXMOVIL + 
               TAMMAXFIJO +
               TAMMAXDIRECCION + 
               TAMMAXCP + 
               TAMMAXPROVINCIA + 20; //Correccion cada String usa dos bytes mas que su longitud
               //para almacenar su longitud efectiva
   }
    
    public boolean graba(RandomAccessFile fichero){
        try{
                        fichero.seek(codigo * tamRegistro());
                        fichero.writeInt(codigo); 
                        fichero.writeUTF(dni);
                        fichero.writeUTF(nombre);
                        fichero.writeUTF(apellido1);
                        fichero.writeUTF(apellido2);
                        fichero.writeUTF(email);
                        fichero.writeUTF(movil);
                        fichero.writeUTF(fijo);
                        fichero.writeUTF(direccion);
                        fichero.writeUTF(cp);
                        fichero.writeUTF(provincia);
                        
                        
                        
           
        }
        catch(IOException ex){
             System.out.println(ex.getMessage());
             return false;
        }
        return true;
    }
    
    
    
    
    
    
     public Alumno recupera(RandomAccessFile fichero, int codAlumno){
         
        Alumno aluAux = new Alumno();
        
        try{
            fichero.seek(codAlumno * tamRegistro()); 
            aluAux.setCodigo(fichero.readInt()); 
            aluAux.setDni(fichero.readUTF()); 
            aluAux.setNombre(fichero.readUTF());
            aluAux.setApellido1(fichero.readUTF());
            aluAux.setApellido2(fichero.readUTF());
            aluAux.setEmail(fichero.readUTF());
            aluAux.setMovil(fichero.readUTF());
            aluAux.setFijo(fichero.readUTF());
            aluAux.setDireccion(fichero.readUTF());
            aluAux.setCp(fichero.readUTF());
            aluAux.setProvincia(fichero.readUTF());
            
        }
        catch(IOException ex){
             System.out.println(ex.getMessage());
            
        }
        
        return aluAux;
    }
     
    public void introduceAlumno(int codigo){
        this.codigo = codigo;
        System.out.println("Datos del alumnos con codigo:" + codigo);
        dni = introduce("Dame el dni:", Alumno.TAMMAXDNI, true);
        nombre = introduce("Dame el nombre:", Alumno.TAMMAXNOMBRE, false);
        apellido1 = introduce("Dame el apellido1:", Alumno.TAMMAXAPELLIDO1, false);
        apellido2 = introduce("Dame el apellido2:", Alumno.TAMMAXAPELLIDO2, false);
        email = introduce("Dame el email:", Alumno.TAMMAXEMAIL, false);
        movil = introduce("Dame el telefono movil:", Alumno.TAMMAXMOVIL, true);
        fijo = introduce("Dame el telefono fijo:", Alumno.TAMMAXFIJO, true);
        direccion = introduce("Dame la direccion:", Alumno.TAMMAXDIRECCION, false);
        cp = introduce("Dame el codigo postal:", Alumno.TAMMAXCP, true);       
        provincia = introduce("Dame la provincia:", Alumno.TAMMAXPROVINCIA, false);
    }
    
    public static int menu(){
        Scanner entrada = new Scanner(System.in);
        int op;
        do{
            System.out.println("Menu");
            System.out.println("1.Consulta");
            System.out.println("2.Modificación");
            System.out.println("3.Baja");
            System.out.println("4.Alta");
            System.out.println("5.Listar fichero");
            System.out.println("6.Recuperar borrado");
            System.out.println("7.Terminar");
            op = entrada.nextInt();
        }while (op  < 1 || op > 7);
        return op;
    }
    
    public void consulta(RandomAccessFile fichero, int nMax){
        Scanner entrada = new Scanner(System.in);
        int dir = 0;
        do{
            System.out.println("Introduce el codigo (0-" + (nMax - 1) +"):");
            dir = entrada.nextInt();
        } while (dir < 0 || dir > nMax - 1);
        
        Alumno alu  = recupera(fichero, dir);
        System.out.println(alu);
    }
    
    public void lista(RandomAccessFile fichero, int nMax){
        for (int i = 0 ; i < nMax; ++i){
            System.out.println(recupera(fichero, i));
            System.out.println("=====================================");
        }
    }
    
    public boolean borra(RandomAccessFile fichero, int nMax){
        Scanner entrada = new Scanner(System.in);
        int dir = 0;
        try{
            
            do{
            System.out.println("Introduce el codigo (0-" + (nMax - 1) +"):");
            dir = entrada.nextInt();
        } while (dir < 0 || dir > nMax - 1);
            
                        Alumno alu  = recupera(fichero, dir);
            
                        fichero.seek(dir * tamRegistro());
                        fichero.writeInt(-1); 
                        fichero.writeUTF(alu.getDni());
                        fichero.writeUTF(alu.getNombre());
                        fichero.writeUTF(alu.getApellido1());
                        fichero.writeUTF(alu.getApellido2());
                        fichero.writeUTF(alu.getEmail());
                        fichero.writeUTF(alu.getMovil());
                        fichero.writeUTF(alu.getFijo());
                        fichero.writeUTF(alu.getDireccion());
                        fichero.writeUTF(alu.getCp());
                        fichero.writeUTF(alu.getProvincia());
                        
           
        }
        catch(IOException ex){
             System.out.println(ex.getMessage());
             return false;
        }
        return true;
    }
    
    public boolean alta(RandomAccessFile fichero, int nMax){
        introduceAlumno(nMax);
        return graba(fichero);
        
    }
    
    public boolean recuparaBorrado(RandomAccessFile fichero, int nMax){
        
    
        Scanner entrada = new Scanner(System.in);
        int dir = 0;
        boolean realizado;
         do{
            System.out.println("Introduce el codigo (0-" + (nMax - 1) +") a recuperar:");
            dir = entrada.nextInt();
        } while (dir < 0 || dir > nMax - 1);
         
         
         Alumno alu  = recupera(fichero, dir);
         System.out.println(alu);
         if (alu.getCodigo() != -1){
             System.out.println("Error, este registro no esta borrado");
             realizado =  false;
         } else{
             
         
             try{
                        fichero.seek(dir * tamRegistro());
                        fichero.writeInt(dir);
                        realizado =  true;
             }
             catch(IOException ex){
                System.out.println(ex.getMessage());
                realizado = false;
            }
        }
         return realizado;   
    }
}
    

