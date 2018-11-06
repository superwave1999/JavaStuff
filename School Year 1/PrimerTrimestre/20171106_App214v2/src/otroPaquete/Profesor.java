package otroPaquete;
import java.util.Scanner;
public class Profesor {
  Scanner sc=new Scanner(System.in);
  private String nombre;
  private String especialidad;
  public void inicialDatosProfesor(String n, String e){
    nombre=n;
    especialidad=e;
  }
  public void visualDatosProfesor(){
    System.out.println("nombre:       "+nombre);
    System.out.println("especialidad: "+especialidad);
  }
  public void modificarDatosProfesor(){
    pedirNombre();
    pedirEspecialidad();
  }
  public void pedirNombre(){
    System.out.print("teclee su nombre       ");
    nombre=sc.nextLine();
  }
  public void pedirEspecialidad(){
    System.out.print("teclee su especialidad ");
    especialidad=sc.nextLine();
  }    
}
