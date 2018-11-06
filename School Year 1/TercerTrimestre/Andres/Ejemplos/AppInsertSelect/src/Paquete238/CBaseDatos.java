package Paquete238;
import java.sql.*;
import paqueteMisClases.*;
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
  String createString="create table "+BDNombre+".equipo "+
          "(team_id integer not null,"+
          "eq_nombre varchar(40) not null,"+
          "estadio varchar(40) not null,"+
          "poblacion varchar(20) not null,"+
          "provincia varchar(20) not null,"+
          "cod_postal char(5),"+
          "primary key (team_id))";
  Statement stmt=null;
  try{
      stmt=con.createStatement();
      stmt.executeUpdate(createString);
  }catch (SQLException e){
      printSQLException(e);
  }finally{
      stmt.close();
  }
}
public static void createJUGADORES(Connection con, String BDNombre) 
                   throws SQLException{
  String createString="create table "+BDNombre+".jugadores "+
          "(player_id integer not null,"+
          "team_id integer not null,"+
          "nombre varchar(40) not null,"+
          "dorsal integer not null,"+
          "edad integer not null,"+
          "primary key (player_id),"+
          "foreign key (team_id) references equipo (team_id))";
  Statement stmt=null;
  try{
      stmt=con.createStatement();
      stmt.executeUpdate(createString);
  }catch (SQLException e){
      printSQLException(e);
  }finally{
      stmt.close();
  }
}








public static void cargaEQUIPO(Connection con, String BDNombre) 
                   throws SQLException{
  System.out.print("teclee identidad equipo         ");
  int team_id=Leer.datoInt();
  System.out.print("teclee nombre de equipo         ");
  String eq_nombre=Leer.datoString();
  System.out.print("teclee estadio del equipo       ");
  String estadio=Leer.datoString();
  System.out.print("teclee poblacion del equipo     ");
  String poblacion=Leer.datoString();
  System.out.print("teclee provincia del equipo     ");
  String provincia=Leer.datoString();
  System.out.print("teclee codigo postal del equipo ");
  String cod_postal=Leer.datoString();
  String createString="insert into "+BDNombre+".equipo values ("
          +team_id+","
          +"'"+eq_nombre+"'"+","
          +"'"+estadio+"'"+","
          +"'"+poblacion+"'"+","
          +"'"+provincia+"'"+","
          +"'"+cod_postal+"'"+")";
  Statement stmt=null;
  try{
      stmt=con.createStatement();
      stmt.executeUpdate(createString);
  }catch (SQLException e){
      printSQLException(e);
  }finally{
      stmt.close();
  }
}

















public static void cargaJUGADORES(Connection con, String BDNombre) 
                   throws SQLException{
  System.out.print("teclee identidad jugador    ");
  int player_id=Leer.datoInt();
  System.out.print("teclee identidad del equipo ");
  int team_id=Leer.datoInt();
  System.out.print("teclee nombre del jugador   ");
  String nombre=Leer.datoString();
  System.out.print("teclee dorsal del jugador   ");
  int dorsal=Leer.datoInt();
  System.out.print("teclee edad del jugador     ");
  int edad=Leer.datoInt();
  String createString="insert into "+BDNombre+".jugadores values ("
          +player_id+","
          +team_id+","
          +"'"+nombre+"'"+","
          +dorsal+","
          +edad+")";
  Statement stmt=null;
  try{
      stmt=con.createStatement();
      stmt.executeUpdate(createString);
  }catch (SQLException e){
      printSQLException(e);
  }finally{
      stmt.close();
  }
}




















public static void verEQUIPO(Connection con, String BDNombre) 
                   throws SQLException{
  Statement stmt=null;
  String query="select * from "+BDNombre+".equipo";
  try{
      stmt=con.createStatement();
      ResultSet rs=stmt.executeQuery(query);
      while (rs.next()){
          int team_id=rs.getInt("team_id");
          String eq_nombre=rs.getString("eq_nombre");
          String estadio=rs.getString("estadio");
          String poblacion=rs.getString("poblacion");
          String provincia=rs.getString("provincia");
          String cod_postal=rs.getString("cod_postal");
          /*System.out.println
               (team_id+eq_nombre+estadio+poblacion+provincia+cod_postal);*/
          System.out.printf("%5d %20s %20s %12s %12s %5s",
             team_id,eq_nombre,estadio,poblacion,provincia,cod_postal);
          System.out.println();
          System.out.println
             ("*********************************************************");
      }
  }catch (SQLException e){
      printSQLException(e);
  }finally{
      stmt.close();
  }
}






















public static void verJUGADORES(Connection con, String BDNombre) 
                   throws SQLException{
  Statement stmt=null;
  String query="select * from "+BDNombre+".jugadores";
  try{
      stmt=con.createStatement();
      ResultSet rs=stmt.executeQuery(query);
      while (rs.next()){
          int player_id=rs.getInt(1);
          int team_id=rs.getInt(2);
          String nombre=rs.getString(3);
          int dorsal=rs.getInt(4);
          int edad=rs.getInt(5);
          /*/System.out.println
          (player_id+"\t"+team_id+"\t"+nombre+"\t"+dorsal+"\t"+edad);*/
          System.out.printf
             ("%5d %5d %10s %2d %2d",player_id,team_id,nombre,dorsal,edad);
          System.out.println();
          System.out.println
             ("********************************************************");
      }
  }catch (SQLException e){
      printSQLException(e);
  }finally{
      stmt.close();
  }
}
}
