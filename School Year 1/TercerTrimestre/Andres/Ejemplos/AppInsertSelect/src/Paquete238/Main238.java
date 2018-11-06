package Paquete238;
import java.sql.*;
import paqueteMisClases.*;
public class Main238 {
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
         System.out.println("1 cargar datos en tabla equipo      ");
         System.out.println("2 cargar datos en tabla jugadores   ");
         System.out.println("3 recuperar datos de tabla equipo   ");
         System.out.println("4 recuperar datos de tabla jugadores");
         System.out.println("5 fin                               ");
         System.out.print("teclee opcion                         ");
         opcion=Leer.datoInt();
         switch(opcion){
             case 1: try{
                         CBaseDatos.cargaEQUIPO(con, BDNombre);
                      }catch(SQLException e){
                         CBaseDatos.printSQLException(e);
                      }
                      break;
             case 2: try{
                         CBaseDatos.cargaJUGADORES(con, BDNombre);
                     }catch(SQLException e){
                          CBaseDatos.printSQLException(e);
                     }
                     break;
             case 3: try{
                         CBaseDatos.verEQUIPO(con, BDNombre);
                     }catch(SQLException e){
                          CBaseDatos.printSQLException(e);
                     }
                     break;
             case 4: try{
                         CBaseDatos.verJUGADORES(con, BDNombre);
                     }catch(SQLException e){
                          CBaseDatos.printSQLException(e);
                     }
                     break;
         }
      }while (opcion !=5);
   }
}
