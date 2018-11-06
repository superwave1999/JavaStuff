package Paquete271;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.Scanner;
public class Alumno{
  private String nombre;
  private int edad;
  private double nota;
  public Alumno(){
    this.nombre = null;
    edad = 0;
    nota = 0;
  }
  public Alumno(String n,int e) {
		this.nombre = n;
		this.edad = e;
		this.nota = -1; //nota no establecida
  }
  public Alumno(String nom,int e, double not) {
		this.nombre = nom;
		this.edad = e;
		this.nota = not; 
  }
  public void setNombre(String n) {
		this.nombre = n;
  }
  public String getNombre() {
		return this.nombre;
  }
  public void setNota(double n) {
		this.nota=n;
  }
  public double getNota() {
		return this.nota;
  }
  public void setEdad(int e) {
		this.edad=e;
  }
  public int getEdad() {
 		return this.edad;
  }
  public String toString() {
                
		if (this.nota != -1)
		return String.format("%-20s, %4d, %.2f", nombre, edad, nota);
		return String.format("%-20s, %4d", nombre, edad);
  }
  public static void almacenarAlumnos(ObjectContainer ocbdAlumnos){
          Scanner sc=new Scanner(System.in);
          System.out.print("teclee nombre del alumno ");
          String nombre=sc.nextLine();
          System.out.print("teclee edad   del alumno ");
          int edad=sc.nextInt(); sc.nextLine();
          System.out.print("teclee nota   del alumno ");
          double nota=sc.nextDouble(); sc.nextLine();
          Alumno alumnoAux=new Alumno(nombre, edad, nota);
          ocbdAlumnos.store(alumnoAux);
  }
  public static void muestraAlumno(ObjectContainer ocbdAlumnos){
          Scanner sc=new Scanner(System.in);
          System.out.print("teclee nombre alumno ");
          String nombre=sc.nextLine();
          Alumno alumnoAux=new Alumno(nombre,0,0);
          ObjectSet res=ocbdAlumnos.queryByExample(alumnoAux);
          System.out.println("recuperados "+res.size());
          if (res.isEmpty()){
              System.out.println("este alumno no existe");
          }else {
              Alumno alu=(Alumno)res.next();
              System.out.println(alu.toString());              
          }
  }
  public static void muestraAlumnos(ObjectContainer ocbdAlumnos){
          Alumno alumnoAux=new Alumno(null,0,0);
          ObjectSet res=ocbdAlumnos.queryByExample(alumnoAux);
          System.out.println("recuperados "+res.size());
          while(res.hasNext()){
            System.out.println(res.next().toString());
          }            
  }
  public static void actualizarAlumno(ObjectContainer ocbdAlumnos){
          Scanner sc=new Scanner(System.in);
          System.out.print("teclee nombre alumno ");
          String nombre=sc.nextLine();
          Alumno alumnoAux=new Alumno(nombre,0,0);
          ObjectSet res=ocbdAlumnos.queryByExample(alumnoAux);
          System.out.println("recuperados "+res.size());
          if (res.isEmpty()){
              System.out.println("este alumno no existe");
          }else {
              Alumno alu=(Alumno)res.next();
              System.out.println(alu.toString());
              System.out.print("teclee nota   alumno ");
              double nota=sc.nextDouble(); sc.nextLine();
              alu.setNota(nota);
              ocbdAlumnos.store(alu);
          }
  }
  public static void borrarAlumno(ObjectContainer ocbdAlumnos){
          Scanner sc=new Scanner(System.in);
          System.out.print("teclee nombre alumno ");
          String nombre=sc.nextLine();
          Alumno alumnoAux=new Alumno(nombre,0,0);
          ObjectSet res=ocbdAlumnos.queryByExample(alumnoAux);
          System.out.println("recuperados "+res.size());
          if (res.isEmpty()){
              System.out.println("este alumno no existe");
          }else {
              Alumno alu=(Alumno)res.next();
              System.out.println(alu.toString());
              System.out.print("borrar s/n ");
              char con=sc.nextLine().charAt(0);
              if (con=='s' || con=='S'){
                  ocbdAlumnos.delete(alu);
              }
         }
  }  
}