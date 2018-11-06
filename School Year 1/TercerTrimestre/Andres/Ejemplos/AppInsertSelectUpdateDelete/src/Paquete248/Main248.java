package Paquete248;
import java.sql.*;
import paqueteMisClases.*;
public class Main248 {
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
         System.out.println("1 insertar.....insert   ");
         System.out.println("2 seleccionar..select   ");
         System.out.println("3 actualizar...update   ");
         System.out.println("4 borrar.......resultset");
         System.out.println("5 finalizar.............");
         System.out.print("teclee opcion..............");
         String nombreTabla;
         opcion=Leer.datoInt();
         switch(opcion){
             case 1: System.out.print("teclee nombre tabla equipo/jugador ");
                     nombreTabla=Leer.datoString();
                     if(nombreTabla.compareToIgnoreCase("equipo")==0){
                       try{
                         CBaseDatos.insertaEquipoInsert(con, BDNombre);
                       }catch(SQLException e){
                         CBaseDatos.printSQLException(e);
                       }
                       break;
                     }else if(nombreTabla.compareToIgnoreCase("jugador")==0){  
                       try{
                         CBaseDatos.insertaJugadorResultSet(con, BDNombre);
                       }catch(SQLException e){
                          CBaseDatos.printSQLException(e);
                       }
                       break;
                     }else{
                       System.out.println("no existe tabla "+nombreTabla);
                       break;
                     }  
             case 2: System.out.print("teclee nombre tabla equipo/jugador ");
                     nombreTabla=Leer.datoString();
                     if(nombreTabla.compareToIgnoreCase("equipo")==0){
                       try{
                         CBaseDatos.selectEquipoResultSet(con, BDNombre);
                       }catch(SQLException e){
                         CBaseDatos.printSQLException(e);
                       }
                       break;
                     }else if(nombreTabla.compareToIgnoreCase("jugador")==0){
                       try{
                         CBaseDatos.selectJugadorSelect(con, BDNombre);
                       }catch(SQLException e){
                          CBaseDatos.printSQLException(e);
                       }
                       break;
                     }else{
                       System.out.println("no existe tabla "+nombreTabla);
                       break;
                     } 
             case 3: System.out.print("teclee nombre tabla equipo/jugador ");
                     nombreTabla=Leer.datoString();
                     if(nombreTabla.compareToIgnoreCase("equipo")==0){
                       try{
                         CBaseDatos.actualizaEquipoUpdate(con, BDNombre);
                       }catch(SQLException e){
                         CBaseDatos.printSQLException(e);
                       }
                       break;
                     }else if(nombreTabla.compareToIgnoreCase("jugador")==0){  
                       try{
                         CBaseDatos.actualizaJugadorResultSet(con, BDNombre);
                       }catch(SQLException e){
                          CBaseDatos.printSQLException(e);
                       }
                       break;
                     }else{
                       System.out.println("no existe tabla "+nombreTabla);
                       break;
                     }    
             case 4: System.out.print("teclee nombre tabla equipo/jugador ");
                     nombreTabla=Leer.datoString();
                     if(nombreTabla.compareToIgnoreCase("equipo")==0){
                       try{
                         CBaseDatos.borrarEquipoResultSet(con, BDNombre);
                       }catch(SQLException e){
                         CBaseDatos.printSQLException(e);
                       }
                       break;
                     }else if(nombreTabla.compareToIgnoreCase("jugador")==0){  
                       try{
                         CBaseDatos.borrarJugadorResultSet(con, BDNombre);
                       }catch(SQLException e){
                          CBaseDatos.printSQLException(e);
                       }
                       break;
                     }else{
                       System.out.println("no existe tabla "+nombreTabla);
                       break;
                     }    
         }
      }while (opcion !=5);
   }
}
