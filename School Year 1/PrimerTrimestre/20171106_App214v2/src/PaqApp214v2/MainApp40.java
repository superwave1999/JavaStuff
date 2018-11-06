package PaqApp214v2;
import otroPaquete.Alumno;
import otroPaquete.Profesor;
public class MainApp40 {
    
  public static void mostrarAlum() {
      alumno1.getNombre();
  }  
  public static void main(String[] args) {
    float media;
    Alumno alumno1=new Alumno();
    //Alumno alumno2=new Alumno("belen", 19, 6, 8);
    Profesor profesor1=new Profesor();
    alumno1.inicialDatos("ana", 18, 6, 4);
    System.out.println("visualizar datos alumno");
    alumno1.visualDatos();
    System.out.println("modificar datos alumno");
    alumno1.modificarDatos();
    System.out.println("visualizar datos alumno");
    alumno1.visualDatos();
    profesor1.inicialDatosProfesor("belen", "anatomia");
    System.out.println("visualizar datos profesor");
    profesor1.visualDatosProfesor();
    System.out.println("modificar datos profesor");
    profesor1.modificarDatosProfesor();
    System.out.println("visualizar datos profesor");
    profesor1.visualDatosProfesor();
    System.out.println("visualizar nota media alumno");
    media=alumno1.calcularMedia();
    System.out.println("nota media alumno1: "+media);
    
    Alumno[] alumnos=new Alumno[2];
    for (int i=0;i<alumnos.length;i++){
        
    }
    
    System.out.println("Porcentaje para incrementar la nota programacion (10% defecto)");
    alumno1.subirNotaProg();
    
    alumno1.subirNotas();

  }    
}
