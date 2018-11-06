
package cochecitoalberto;

import java.util.Scanner;

public class Vehiculo {     //AXAXAXAX HA DICHO CULO XDDDDDDD
    
    //Objetos y por defecto (DONE)
    
    private String propietario;
    private double orientacion;
    private double posX;
    private double posY;
    private boolean arranca;

    public Vehiculo() {
        this.propietario = "BOT Car";       //Counter
        this.orientacion = 0;
        this.posX = 0;
        this.posY = 0;
        this.arranca = false;
    }

    public Vehiculo(String propietario, double orientacion, double posX, double posY, double arranca) {
        this.propietario = propietario;
        this.orientacion = orientacion;
        this.posX = posX;
        this.posY = posY;
        this.arranca = true;
    }
  
    //Introducir por teclado (Done)
    
    public void introDatosPorTeclado(){
        Scanner input=new Scanner(System.in);
       
        System.out.println("Inserta nombre");
        propietario=input.nextLine();
        
        System.out.println("Inserta orientacion en º");
        orientacion=input.nextDouble();
        
        System.out.println("Inserta posicion horizontal X");
        posX=input.nextDouble();
        
        System.out.println("Inserta posicion vertical Y");
        posY=input.nextDouble();
        
    }
    
    //Arrancar y parar (Done)
    
    public void arrancaCoche() {
        arranca=true;
    }
    
    public void paraCoche() {
        arranca=false;
    }
    
    //Orientar el coche (Legit)
    
    
    public void orientaCoche() {
        
        if (arranca==true) {
            Scanner input=new Scanner(System.in);
            System.out.println("Orientar coche (0 es este, 90 norte, 180 oeste, 270 sur");
            orientacion=input.nextDouble();
        } else {
            System.out.println("Parece que el vehiculo no esta arrancado");
        }
       
    }
    
    //Avanzar y retroceder el coche (UNTZ UNTZ UNTZ UNTZ)
    
    public void avanzaCoche() {

        if (arranca==true) {
            Scanner input=new Scanner(System.in);
            int radio;
            double posXnew,posYnew;
        
            System.out.println("Avanzar coche X unidades");
            radio=input.nextInt();
            posXnew=Math.cos(Math.toRadians(orientacion));
            posYnew=Math.sin(Math.toRadians(orientacion));
        
            posXnew=posXnew*radio;
            posYnew=posYnew*radio;
        
            posY=posY+posYnew;
            posX=posX+posXnew;
        }
        

    }
    
    //David Getters

    public String getPropietario() {
        return propietario;
    }

    public double getOrientacion() {
        return orientacion;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public boolean isArranca() {
        return arranca;
    }
    
    //Setters

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public void setOrientacion(double orientacion) {
        this.orientacion = orientacion;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public void setArranca(boolean arranca) {
        this.arranca = arranca;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "propietario=" + propietario + ", orientacion=" + orientacion + ", posX=" + posX + ", posY=" + posY + ", arranca=" + arranca + '}';
    }
    
    
    
    
    
}
