package Paquete248;
import java.sql.*;
import paqueteMisClases.Leer;
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

















public static void createEQUIPO(Connection con, String BDNombre) throws SQLException{
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
      System.out.printf("%50s","tabla equipos creada\n");
  }catch (SQLException e){
      printSQLException(e);
  }finally{
      stmt.close();
  }
}
public static void createJUGADORES(Connection con, String BDNombre) throws SQLException{
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
      System.out.printf("%50s","tabla jugadores creada\n");      
  }catch (SQLException e){
      printSQLException(e);
  }finally{
      stmt.close();
  }
}
public static void insertaEquipoInsert
              (Connection con, String BDNombre) throws SQLException{
              CBaseDatos.createEQUIPO(con, BDNombre);
  System.out.print("teclee identidad equipo numero  ");
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
public static void insertaJugadorInsert
              (Connection con, String BDNombre) throws SQLException{
              CBaseDatos.createJUGADORES(con, BDNombre);
  System.out.print("teclee identidad jugador numero   ");
  int player_id=Leer.datoInt();
  System.out.print("teclee identidad del equipo       ");
  int team_id=Leer.datoInt();
  System.out.print("teclee nombre del jugador         ");
  String nombre=Leer.datoString();
  System.out.print("teclee dorsal del jugador         ");
  int dorsal=Leer.datoInt();
  System.out.print("teclee edad del jugador           ");
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
public static void selectEquipoResultSet(Connection con, String BDNombre)
        throws SQLException{
  CBaseDatos.createEQUIPO(con, BDNombre);  
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
          //System.out.println(team_id+eq_nombre+estadio+poblacion+provincia+cod_postal);
          System.out.printf("%8s %20s %20s %12s %12s %5s","team_id",
                "eq_nombre","estadio","poblacion","provincia","cod_postal"+"\n");
          System.out.printf("%8d %20s %20s %12s %12s %5s",team_id,
                 eq_nombre,estadio,poblacion,provincia,cod_postal);
          System.out.println();
          System.out.println("*************************************"
                  + "**************************************************");
      }
  }catch (SQLException e){
      printSQLException(e);
  }finally{
      stmt.close();
  }
}
public static void selectJugadorSelect(Connection con, String BDNombre)
        throws SQLException{
  CBaseDatos.createJUGADORES(con, BDNombre);  
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
          System.out.printf("%10s %8s %20s %8s %8s","player_id",
                  "team_id","nombre","dorsal","edad"+"\n");
          System.out.printf("%10d %8d %20s %8d %7d",player_id,
                   team_id,nombre,dorsal,edad);
          System.out.println();
          System.out.println("***********************************************************");
      }
  }catch (SQLException e){
      printSQLException(e);
  }finally{
      stmt.close();
  }
}
public static void actualizaEquipoUpdate(Connection con, String BDNombre)
              throws SQLException{
  CBaseDatos.createEQUIPO(con, BDNombre);  
  Statement stmt=null;
  System.out.print("teclee identidad equipo         ");
  int team_id=Leer.datoInt();
  String query="select * from "+BDNombre+".equipo where team_id="+team_id;
  try{
      stmt=con.createStatement();
      //stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
      ResultSet rs=stmt.executeQuery(query);
      while(rs.next()){
         String eq_nombre=rs.getString("eq_nombre");
         String estadio=rs.getString("estadio");
         String poblacion=rs.getString("poblacion");
         String provincia=rs.getString("provincia");
         String cod_postal=rs.getString("cod_postal");
         System.out.printf("%5d %20s %20s %12s %12s %5s",team_id,eq_nombre,estadio,poblacion,provincia,cod_postal);
         System.out.println();
         System.out.println("**************************************************************************************");

         System.out.print("teclee nombre de equipo         ");
         String n_eq_nombre=Leer.datoString();
         if (n_eq_nombre.length()!=0){
          stmt.executeUpdate("update "+BDNombre+".equipo set eq_nombre="+"'"+n_eq_nombre+"'"+"where team_id="+team_id);
         }
         System.out.print("teclee estadio del equipo       ");
         String n_estadio=Leer.datoString();
         if (n_estadio.length()!=0){
          stmt.executeUpdate("update "+BDNombre+".equipo set estadio="+"'"+n_estadio+"'"+"where team_id="+team_id);
         }
         System.out.print("teclee poblacion del equipo     ");
         String n_poblacion=Leer.datoString();
         if (n_poblacion.length()!=0){
          stmt.executeUpdate("update "+BDNombre+".equipo set poblacion="+"'"+n_poblacion+"'"+"where team_id="+team_id);
         }
         System.out.print("teclee provincia del equipo     ");
         String n_provincia=Leer.datoString();
         if (n_provincia.length()!=0){
          stmt.executeUpdate("update "+BDNombre+".equipo set provincia="+"'"+n_provincia+"'"+"where team_id="+team_id);
         }
         System.out.print("teclee codigo postal del equipo ");
         String n_cod_postal=Leer.datoString();
         if (n_cod_postal.length()!=0){
          stmt.executeUpdate("update "+BDNombre+".equipo set cod_postal="+"'"+n_cod_postal+"'"+"where team_id="+team_id);
         }
      }  
  }catch (SQLException e){
      printSQLException(e);
  }finally{
      stmt.close();
  }
}
public static void actualizaJugadorResultSet(Connection con, String BDNombre)
              throws SQLException{
  CBaseDatos.createJUGADORES(con, BDNombre);  
  Statement stmt=null;
  System.out.print("teclee identidad jugador         ");
  int player_id=Leer.datoInt();
  String query="select * from "+BDNombre+".jugadores where player_id="+player_id;
  try{
      stmt=con.createStatement();
      stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
      ResultSet rs=stmt.executeQuery(query);
      while (rs.next()){
        int team_id=rs.getInt("team_id");
        String nombre=rs.getString("nombre");
        int dorsal=rs.getInt("dorsal");
        int edad=rs.getInt("edad");
        System.out.printf("%5d %5d %10s %2d %2d",player_id,team_id,nombre,dorsal,edad);
        System.out.println();
        System.out.println("********************************************************");
        
        System.out.print("teclee equipo del jugador         ");
        int n_team_id=Leer.datoInt();
        if (n_team_id!=0){
            rs.updateInt("team_id", n_team_id);
            rs.updateRow(); //rs.deleteRow(); para borrar
        }
        System.out.print("teclee nombre del jugador         ");
        String n_nombre=Leer.datoString();
        if (n_nombre.length()!=0){
            rs.updateString("nombre", n_nombre);
            rs.updateRow(); 
        }
        System.out.print("teclee dorsal del jugador       ");
        int n_dorsal=Leer.datoInt();
        if (n_dorsal!=0){
            rs.updateInt("dorsal", n_dorsal);
            rs.updateRow(); 
        }
        System.out.print("teclee edad del jugador     ");
        int n_edad=Leer.datoInt();
        if (n_edad!=0){
            rs.updateInt("edad", n_edad);
            rs.updateRow(); 
        }
      }
  }catch (SQLException e){
      printSQLException(e);
  }finally{
      stmt.close();
  }
}
public static void insertaEquipoResultSet(Connection con, String BDNombre)
        throws SQLException{
  CBaseDatos.createEQUIPO(con, BDNombre);  
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
  Statement stmt=null;
  try{
      stmt=con.createStatement();
      stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
      ResultSet rs=stmt.executeQuery("select * from "+BDNombre+".equipo");
      rs.moveToInsertRow();
      rs.updateInt("team_id", team_id);
      rs.updateString("eq_nombre", eq_nombre);
      rs.updateString("estadio", estadio);
      rs.updateString("poblacion", poblacion);
      rs.updateString("provincia", provincia);
      rs.updateString("cod_postal",cod_postal);
      rs.insertRow();
      rs.beforeFirst();
  }catch (SQLException e){
      printSQLException(e);
  }finally{
      stmt.close();
  }
}
public static void insertaJugadorResultSet(Connection con, String BDNombre)
        throws SQLException{
  CBaseDatos.createJUGADORES(con, BDNombre);  
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
  Statement stmt=null;
  try{
      stmt=con.createStatement();
      stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
      ResultSet rs=stmt.executeQuery("select * from "+BDNombre+".jugadores");
      rs.moveToInsertRow();
      rs.updateInt("player_id", player_id);
      rs.updateInt("team_id", team_id);
      rs.updateString("nombre", nombre);
      rs.updateInt("dorsal", dorsal);
      rs.updateInt("edad", edad);
      rs.insertRow();
      rs.beforeFirst();
  }catch (SQLException e){
      printSQLException(e);
  }finally{
      stmt.close();
  }
}
public static void borrarEquipoResultSet(Connection con, String BDNombre)
        throws SQLException{
  CBaseDatos.createEQUIPO(con, BDNombre);  
  Statement stmt=null;
  System.out.print("teclee identidad equipo         ");
  int team_id=Leer.datoInt();
  String query="select * from "+BDNombre+".equipo where team_id="+team_id;
  try{
      stmt=con.createStatement();
      stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
      ResultSet rs=stmt.executeQuery(query);
      if (rs.next()){
        String eq_nombre=rs.getString("eq_nombre");
        String estadio=rs.getString("estadio");
        String poblacion=rs.getString("poblacion");
        String provincia=rs.getString("provincia");
        String cod_postal=rs.getString("cod_postal");
        System.out.printf("%5d %20s %20s %12s %12s %5s",team_id,eq_nombre,estadio,poblacion,provincia,cod_postal);
        System.out.println();
        System.out.println("**************************************************************************************");

        System.out.print("borrar s/n ");
        char res=Leer.datoChar();
        Leer.datoString(); //limpiar buffer
        if (res=='s' || res=='S'){
          rs.deleteRow();
        }
      }
  }catch (SQLException e){
      printSQLException(e);
  }finally{
      stmt.close();
  }
}
public static void borrarJugadorResultSet(Connection con, String BDNombre)
        throws SQLException{
  CBaseDatos.createJUGADORES(con, BDNombre);  
  Statement stmt=null;
  System.out.print("teclee identidad jugador         ");
  int player_id=Leer.datoInt();
  String query="select * from "+BDNombre+".jugadores where player_id="+player_id;
  try{
      stmt=con.createStatement();
      stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
      ResultSet rs=stmt.executeQuery(query);
      while (rs.next()){
        int team_id=rs.getInt("team_id");
        String nombre=rs.getString("nombre");
        int dorsal=rs.getInt("dorsal");
        int edad=rs.getInt("edad");
        System.out.printf("%5d %5d %10s %2d %2d",player_id,team_id,nombre,dorsal,edad);
        System.out.println();
        System.out.println("********************************************************");

        System.out.print("borrar s/n ");
        char res=Leer.datoChar();
        Leer.datoString(); //limpiar buffer
        if (res=='s' || res=='S'){
          rs.deleteRow();
        }
      }
  }catch (SQLException e){
      printSQLException(e);
  }finally{
      stmt.close();
  }
}
}
