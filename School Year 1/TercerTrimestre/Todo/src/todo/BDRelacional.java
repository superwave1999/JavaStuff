/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author super
 */
public class BDRelacional {
    
    private Connection con;
    private String bdName;
    
    public Connection DBConnection(String bdName) {
        Connection con=null;
        try {
            String controller="com.mysql.jdbc.Driver";
            Class.forName(controller).newInstance();
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+bdName,"root","root1234");
            
        } catch (Exception e) {
            System.out.println("Error de conexion");
            e.printStackTrace();
        }
        return con;
    }
    
    public static void printSQLException(SQLException ex) {
        
        
        
        
    }
    
    public void DBClose() {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Error de ciere de BD");
            e.printStackTrace();
        }
        
    }
    
    public void DBcreate () throws SQLException {
        String query="create table if not exists "+bdName+".agenda ("+
                "nombre varchar (30),"+
                "numero varchar (9),"+
                "CONSTRAINT PK_Agenda PRIMARY KEY (nombre,numero));";
        
        Statement stmt=null;
        
        try {
            stmt=con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error de creacion de tabla");
            e.printStackTrace();
            
        } finally {
            stmt.close();
        }
        
        

    }
    
    public void DBmodify (String setPart, String wherePart) throws SQLException {
        String query="update "+bdName+".agenda set "+setPart+" where "+wherePart+";";
        
        Statement stmt=null;
        
        try {
            stmt=con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error de modificacion de tabla");
            e.printStackTrace();   
        } finally {
            stmt.close();
        }

    }
    
    public void DBModifyRS () {
        
        
    }
    
    public void DBInsert (String nombre, String numero) throws SQLException {
        String query = "insert into "+bdName+".agenda values("+nombre+","+numero+");";
        
        Statement stmt=null;
        
        try {
            stmt=con.createStatement();
            stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error de insercion de datos");
            e.printStackTrace();
        } finally {
            stmt.close();
        }

    }
    
    public void DBDeleteAll () throws SQLException {
        String query = "drop table "+bdName+".agenda;";
        
        Statement stmt=null;
        
        try {
            stmt=con.createStatement();
            stmt.executeUpdate(query);
            
        } catch (SQLException e) {
            System.out.println("Error de borrado de tabla");
            e.printStackTrace();
        } finally {
            stmt.close();
        }
        
        
        
        
    }
    
    public void DBDeleteElement (String wherePart) throws SQLException {
        String query = "delete * from "+bdName+".agenda where "+wherePart+";";
        
        Statement stmt=null;
        try {
            stmt=con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error de borrado de elemento");
            e.printStackTrace();
        } finally {
            stmt.close();
        }
        
        
    }
    
    public void DBSelectAll () throws SQLException {
        String query = "select * from "+bdName+".agenda;";
        
        Statement stmt=null;
        try {
            stmt=con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            
            while (result.next()) {
                String nombre = result.getString("nombre");
                String numero = result.getString("numero");
                
                System.out.println(nombre+" "+numero);
            }
            
        } catch (SQLException e) {
            System.out.println("Error de visualizacion de tabla");
            e.printStackTrace();
        } finally {
            stmt.close();
        }
        
    }
    
}
