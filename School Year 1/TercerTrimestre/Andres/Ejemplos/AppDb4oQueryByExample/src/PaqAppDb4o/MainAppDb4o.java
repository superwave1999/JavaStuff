package PaqAppDb4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.io.File;
public class MainAppDb4o {
  public static void main(String[] args) {
    //new File("alumnos.db4o").delete();  
    ObjectContainer ocbdAlumnos=Db4oEmbedded.openFile("alumnos.db4o");
    Alumno alu1=new Alumno("24.240.240-x","ana",18,958181818);
    Alumno alu2=new Alumno("25.250.250-y","belen",19,958191919);
    Alumno alu3=new Alumno("26.260.260-z","calos",20,958202020);
    Alumno alu4=new Alumno(null,null,0,0);
    Alumno alu5;
    System.out.println("insertar");
    ocbdAlumnos.store(alu1);
    ocbdAlumnos.store(alu2);
    ocbdAlumnos.store(alu3);
    
    System.out.println("select");
    ObjectSet os=ocbdAlumnos.queryByExample(alu4);
    while(os.hasNext()){
      alu5=(Alumno)os.next();
      System.out.println(alu5.toString());
    }
    System.out.println("update");
    System.out.println("");
    alu4=new Alumno(null,"ana",0,0);
    os=ocbdAlumnos.queryByExample(alu4);
    if (os.isEmpty()){
        System.out.println("no existe este alumno");
    }else{    
      alu5=(Alumno)os.next();
      System.out.println(alu5.toString());
      alu5.setEdad(19);
      ocbdAlumnos.store(alu5);
    }
    
    System.out.println("");
    alu4=new Alumno(null,null,0,0);
    os=ocbdAlumnos.queryByExample(alu4);
    while(os.hasNext()){
      alu5=(Alumno)os.next();
      System.out.println(alu5.toString());
    }
    System.out.println("delete");
    System.out.println("");
    alu4=new Alumno(null,"ana",0,0);
    os=ocbdAlumnos.queryByExample(alu4);
    if (os.isEmpty()){
        System.out.println("no existe este alumno");
    }else{    
      alu5=(Alumno)os.next();
      System.out.println(alu5.toString());
      ocbdAlumnos.delete(alu5);
    }
    
    System.out.println("");
    alu4=new Alumno(null,null,0,0);
    os=ocbdAlumnos.queryByExample(alu4);
    while(os.hasNext()){
      alu5=(Alumno)os.next();
      System.out.println(alu5.toString());
    }
    
    ocbdAlumnos.close();
  }    
}
