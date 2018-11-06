package Paquete232;
import java.sql.*;
//en cada proyecto en Libraries
//añadir libreria MySQL JDBC Driver
public class Main232 {
    //variables de la clase
    static Connection con = null;
    static String BDNombre="bdtest";
    public static void main(String[] args) {
      try{
        con=CBaseDatos.conexionBD(BDNombre);
      }catch(SQLException e){
        CBaseDatos.printSQLException(e);
      }
      try{
        CBaseDatos.createEQUIPO(con, BDNombre);
      }catch(SQLException e){
          CBaseDatos.printSQLException(e);
      }
      try{
        CBaseDatos.createJUGADORES(con, BDNombre);
      }catch(SQLException e){
          CBaseDatos.printSQLException(e);
      }
    }
}
