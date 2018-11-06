/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingconobjetos;

import java.util.Scanner;

/**
 *
 * @author alberto
 */
public class Parking {
    
    private String nombre;
    private double precioMin;
    private int capacidad;
    private double caja;
    private PlazaAparcamiento[] tablaPlazas;

    public Parking(String nombre, double precioMin, int capacidad, double caja) {
        this.nombre = nombre;
        this.precioMin = precioMin;
        this.capacidad = capacidad;
        this.caja = caja;
        
        //Array de objetos
        tablaPlazas = new PlazaAparcamiento[capacidad];
        
        //Crear cada uno de los objetos del array
           
        for (int i = 0; i < tablaPlazas.length; ++i){
            tablaPlazas[i] = new PlazaAparcamiento();
        }
    }

    Parking(String granada, int i, int i0, int i1, int i2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        
        String cad = "Parking{" + "nombre=" + nombre + 
                                  ", precioMin=" + precioMin + 
                                  ", capacidad=" + capacidad + 
                                  ", caja=" + caja + '}' +"\n";
        
        for (int i = 0; i < tablaPlazas.length; ++i){
            cad += i +":"+ tablaPlazas[i] + "\n";
        }
        
        return cad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioMin() {
        return precioMin;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getCaja() {
        return caja;
    }

    public PlazaAparcamiento[] getTablaPlazas() {
        return tablaPlazas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecioMin(double precioMin) {
        this.precioMin = precioMin;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setCaja(double caja) {
        this.caja = caja;
    }

    public void setTablaPlazas(PlazaAparcamiento[] tablaPlazas) {
        this.tablaPlazas = tablaPlazas;
    }
    
    
     public int plazasLibres(){
        int cont = 0;
        for (int i = 0; i < tablaPlazas.length; ++i){
            if (tablaPlazas[i].getMatricula().compareTo("LIBRE")== 0){
                cont++;
            }
        }
        return cont;
    }
    
    public TarjetaParking entraVehiculo(){
        Scanner entrada = new Scanner(System.in); 
        String matricula ="";
        boolean valida = false;
        int posLibre = 0;
        int minEntrada = 0;
        
        
        if (plazasLibres() == 0){
            System.out.println("PARKING COMPLETO");
        }
        else{ 
             do {
                 System.out.println("Matricula:");
                 matricula = entrada.nextLine();
                 valida = validaMatricula(matricula.toUpperCase());
                 if (!valida){
                     System.out.println("Error, matricula no valida");
                 }
             } while (!valida);
             
             if (buscaMatricula(matricula) != -1){
                 System.out.println("Error, esta matricula ya esta en el parking");
             }else{
                 posLibre = buscaPrimeraPlazaLibre();
                 tablaPlazas[posLibre].setMatricula(matricula.toUpperCase());
                 do {
                     System.out.println("Minuto de entrada(>=0):");
                     minEntrada = entrada.nextInt();
                 } while (minEntrada < 0);
             }
        }
    
        
        
        return new TarjetaParking(matricula.toUpperCase(), minEntrada);
    }
    
    public double saleVehiculo(TarjetaParking tarjeta){
         Scanner entrada = new Scanner(System.in);
        String matricula = "";
        boolean valida = false;
        int pos = 0;
        int duracion = 0;
        double total = 0.0;
        int minSalida = 0;
            
            
            pos = buscaMatricula(tarjeta.getMatricula());
            if (pos == -1){
                 System.out.println("Error, esta matricula NO esta en el parking");
            }else{
                do {
                    System.out.println("Minuto de salida(>=" + tarjeta.getMinEntrada()+")");
                    minSalida = entrada.nextInt();
                } while (minSalida < tarjeta.getMinEntrada());
                
                System.out.println("Matricula:" + tarjeta.getMatricula());
                System.out.println("Minuto inicial:" + tarjeta.getMinEntrada());
                System.out.println("Minuto salida:" + minSalida); 
                duracion = minSalida - tarjeta.getMinEntrada();
                total = duracion * precioMin;
                System.out.println(duracion + " min. x " + precioMin + 
                                      "€/min. = " + total);
                
                System.out.println("Vehiculo sale...");
            }
            
            return total;
    }
    
    public int numPlazasLibres(){
        return 0;
    }
    
    public int buscaMatricula(String matriculaBuscar){ // -1 si no está
        int posicion = -1;
        boolean encontrado = false;
        
        for (int i = 0; i < tablaPlazas.length && !encontrado; ++i){
            if (tablaPlazas[i].getMatricula().compareTo(matriculaBuscar.toUpperCase()) == 0){
                encontrado = true;
                posicion = i;
            }
        }
        return posicion;
    }
    
    public int buscaPrimeraPlazaLibre(){ //- 1 si no hay plazas libres
        return buscaMatricula("LIBRE");  
    }
    
    public int menu(){
        Scanner entrada = new Scanner(System.in);
        int op = 0;
        do{
            System.out.println("Menu");
            System.out.println("----");
            System.out.println("1. Entra vehiculo");
            System.out.println("2. Sale vehiculo");
            System.out.println("3.Terminar");
            System.out.println("Opcion:");
            op = Integer.parseInt(entrada.nextLine());
            if (op< 1 || op > 3){
                   System.out.println("Error, opcion invalida");     
            }
        } while (op < 1 || op >3);
        
        return op;
    }
    
     public boolean validaMatricula(String matricula){
        //Se supone la matricula valida si contiene algun numero
        // y letras o espacios blancos
        boolean valida = true;
        boolean hayNumero = false;
        boolean hayLetras = false;
        
        if(matricula.length() == 0){
            return false;
        } else {
                for (int i = 0; i < matricula.length() && valida; ++i){
                    
                    if (!(matricula.charAt(i) == ' ' || 
                         (matricula.charAt(i)>= '0' && matricula.charAt(i)<= '9') ||
                         (matricula.charAt(i)>= 'A' && matricula.charAt(i)<= 'Z')))
                            valida = false;
                    else if (matricula.charAt(i)>= '0' && matricula.charAt(i)<= '9'){
                            hayNumero = true;
                    } else if (matricula.charAt(i)>= 'A' && matricula.charAt(i)<= 'Z'){
                    
                            hayLetras = true;
                    }
                    
                }
                
        }
        return valida && hayNumero && hayLetras ;
        
    }
    
    
}
