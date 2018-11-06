package otroPaquete;
import java.util.Scanner;
public class Alumno {
  Scanner sc=new Scanner(System.in);
  private String nombre;
  private int edad;
  private float notaProgramacion;
  private float notaEd;
  public void inicialDatos(String n, int e,  int np, int ne){
    this.nombre =n;
    this.edad=e;
    notaProgramacion=np;
    notaEd=ne;
  }
  public void visualDatos(){
    System.out.println("nombre: "+nombre);
    System.out.println("edad:   "+edad);
    System.out.println("nota programacion: "+notaProgramacion);
    System.out.println("nota entorno desarrollo:     "+notaEd);
  }
  public void modificarDatos(){
    pedirNombre();
    pedirEdad();
    pedirNotaProgramacion();
    pedirNotaEd();
  }
  public void pedirNombre(){
    System.out.print("teclee su nombre ");
    nombre=sc.nextLine();
  }
  public void pedirEdad(){
    System.out.print("teclee su edad   ");
    edad=sc.nextInt();
  }
  public void pedirNotaProgramacion(){
    System.out.print("teclee nota programacion ");
    notaProgramacion=sc.nextInt();
  }
  public void pedirNotaEd(){
    System.out.print("teclee nota entorno desarrollo ");
    notaEd=sc.nextInt();
  }
  public float calcularMedia(){
    float media;
    media=((float)notaProgramacion+notaEd)/2;
    return media;
  }
  
  public void subirNotaProg () { 
       float porSubir;
       Scanner input = new Scanner(System.in);
       
       System.out.println("Introduce el porcentaje a subir (10%)");
       porSubir=input.nextInt();
       if (porSubir==0) {
           porSubir=10;
       }
 
       porSubir=(porSubir/100);
       
       this.notaProgramacion=notaProgramacion+(notaProgramacion*porSubir);
 
       System.out.println("La nota de programacion es "+notaProgramacion);
  }
    public void subirNotaEd () { 
       float porSubir;
       Scanner input = new Scanner(System.in);
       
       System.out.println("Introduce el porcentaje a subir ED (10%)");
       porSubir=input.nextInt();
       if (porSubir==0) {
           porSubir=10;
       }
 
       porSubir=(porSubir/100);
       
       this.notaEd=notaEd+(notaEd*porSubir);
 
       System.out.println("La nota de ED es "+notaEd);
  }
    public void subirNotas() {
        
        float porSubir;
       Scanner input = new Scanner(System.in);
       
       System.out.println("Introduce el porcentaje a subir notas (10%)");
       porSubir=input.nextInt();
        
        this.notaProgramacion=notaProgramacion+(notaProgramacion*porSubir);
        this.notaEd=notaEd+(notaEd*porSubir);
    }

    public Scanner getSc() {
        return sc;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public float getNotaProgramacion() {
        return notaProgramacion;
    }

    public float getNotaEd() {
        return notaEd;
    }
    
    
}
