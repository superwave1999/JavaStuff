/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdandres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author super
 */
public class DBIO {
    
    public static Connection createConnection(String dbName) throws SQLException {
        Connection con=null;
        
        String controlador="com.mysql.jdbc.Driver";
        Class.forName(controlador).newInstance();
        con=DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/"+dbName,"root","coder554");
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
    
    public static void createTable() {
        
        
    }
    
    
    
    
    
}
