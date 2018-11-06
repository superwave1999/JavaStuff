package proyecto1;
import java.util.Scanner;
public class Proyecto1 {
  public static void main(String[] args){
      
    Scanner sc=new Scanner(System.in);
    
   float altura;
   char sexo;
   String nombre;
   
    System.out.println("Teclee su nombre");
    nombre=sc.nextLine();
//    System.out.println("Me llamo "+nombre+" y mi altura es "+altura);

    System.out.println("Teclee su sexo");
    sexo=sc.nextLine().charAt(0);
    
    System.out.println("Teclee su altura");
    altura=sc.nextFloat();
    sc.nextLine();
//    System.out.println("Me llamo Imanol y mi altura es"+altura);
   
    System.out.println("Me llamo "+nombre+" mido "+altura+" cm, y mi sexo es "+sexo);
  }
}