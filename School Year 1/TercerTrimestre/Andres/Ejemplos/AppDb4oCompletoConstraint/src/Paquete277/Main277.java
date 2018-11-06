//1.- m herramientas>bibliotecas>nueva biblioteca>MyLibraryDb4o
//    agregar archivo jar/carpeta:db4o-8.0-all-java5.jar>aceptar
//2.- Application277>bibliotecas>agregar biblioteca>MyLibraryDb4o>añadir
package Paquete277;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import java.io.File;
public class Main277 {
  public static void main(String[] args) {
  int opcion;
  //new File("alumnos.db4o").delete();
  ObjectContainer ocbdAlumnos=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"alumnos.db4o");
  try{
    do{
      opcion=menu();
      switch(opcion){
        case 1:Alumno.almacenarAlumnos(ocbdAlumnos);
               break;
        case 2:Alumno.muestraAlumno(ocbdAlumnos);
               break;
        case 3:Alumno.muestraAlumnos(ocbdAlumnos);
               break;
        case 4:Alumno.actualizarAlumno(ocbdAlumnos);
               break;
        case 5:Alumno.borrarAlumno(ocbdAlumnos);
               break;
      }
    }while(opcion!=6);
  }catch(Exception exc){
    System.out.println(exc.toString());
  }finally{
    ocbdAlumnos.close();
  }
  }
  public static int menu(){
    int opcion;
    do{
      System.out.println("1 almacenar alumnos");
      System.out.println("2 muestra   alumno ");
      System.out.println("3 muestra   alumnos");
      System.out.println("4 actualiza alumno ");
      System.out.println("5 borrar    alumno ");
      System.out.println("6 fin");
      System.out.print("teclee opcion .......");
      opcion=Leer.datoInt();
    }while(opcion<1 || opcion>6);
    return opcion;
  }
}
