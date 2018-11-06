package Paquete236;
import java.sql.*;
import paqueteMisClases.*;
public class Main236 {
    public static void main(String[] args) {
      Connection con = null;
      int opcion;
      String BDNombre="bdtest";
      try{
        con=CBaseDatos.conexionBD(BDNombre);
      }catch(SQLException e){
        CBaseDatos.printSQLException(e);
      }
      do{
         System.out.println("1 crear tabla equipo   ");
         System.out.println("2 crear tabla jugadores");
         System.out.println("3 fin                  ");
         System.out.print("teclee opcion            ");
         opcion=Leer.datoInt();
         switch(opcion){
             case 1: try{
                         CBaseDatos.createEQUIPO(con, BDNombre);
                      }catch(SQLException e){
                         CBaseDatos.printSQLException(e);
                      }
                      break;
             case 2: try{
                         CBaseDatos.createJUGADORES(con, BDNombre);
                     }catch(SQLException e){
                          CBaseDatos.printSQLException(e);
                     }
                     break;
         }
      }while (opcion !=3);
   }
}
