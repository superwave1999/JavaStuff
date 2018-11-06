package Paquete236;
import java.sql.*;
public class CBaseDatos {
public static Connection conexionBD(String BDNombre) throws SQLException{
    Connection con=null;
    try{
          System.out.println("conectando ...");
          String controlador="com.mysql.jdbc.Driver";
          Class.forName(controlador).newInstance();
          con=DriverManager.getConnection
              ("jdbc:mysql://localhost:3306/bdtest","root","root1234");
          System.out.println("connection succeed!");
    }catch (Exception e){
          e.printStackTrace();
    }
    return con;
}
public static void printSQLException(SQLException ex){
    ex.printStackTrace(System.err);
    System.err.println("SQLState: "+ex.getSQLState());
    System.err.println("Error Code: "+ex.getErrorCode());
    System.err.println("Message: "+ex.getMessage());
    Throwable t=ex.getCause();
    while (t!=null){
        System.out.println("Cause: "+t);
        t=t.getCause();
    }
}




















public static void createEQUIPO(Connection con, String BDNombre)
                   throws SQLException{
  String createString="create table if not exists "+BDNombre+".equipo "+
          "(team_id integer not null,"+
          "eq_nombre varchar(40) not null,"+
          "estadio varchar(40) not null,"+
          "poblacion varchar(20) not null,"+
          "provincia varchar(20) not null,"+
          "cod_postal char(5),"+
          "primary key (team_id)) Engine=InnoDB";
  Statement stmt=null;
  try{
      stmt=con.createStatement();
      stmt.executeUpdate(createString);
      System.out.println("tabla equipos creada");
  }catch (SQLException e){
      printSQLException(e);
  }finally{
      stmt.close();
  }
}
public static void createJUGADORES(Connection con, String BDNombre) 
                   throws SQLException{
  String createString="create table if not exists "+BDNombre+".jugadores "+
          "(player_id integer not null,"+
          "team_id integer not null,"+
          "nombre varchar(40) not null,"+
          "dorsal integer not null,"+
          "edad integer not null,"+
          "primary key (player_id),"+
          "foreign key (team_id) references equipo (team_id)"+
          "on delete restrict on update cascade) Engine=InnoDB";
  Statement stmt=null;
  try{
      stmt=con.createStatement();
      stmt.executeUpdate(createString);
      System.out.println("tabla jugadores creada");
  }catch (SQLException e){
      printSQLException(e);
  }finally{
      stmt.close();
  }
}
}
