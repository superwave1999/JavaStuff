
package arraylist_contacto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccesoBD {
    
    public static Connection conectaBD () {
        String nombreBD="bdagenda";
        String driver="com.mysql.jdbc.Driver";
        String jdbc="jdbc:mysql://localhost:3306/"+nombreBD;
        String user="root";
        String pass="root1234";
        
        Connection con=null;
        try {
            Class.forName(driver).newInstance();
            con=DriverManager.getConnection(jdbc,user,pass);
        } catch (Exception e) {
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
    
    public static void createTable (String tableName) {
        String tablas = "create table "+tableName+" ( nombre varchar (30), numero int not null, PRIMARY KEY (numero));";
        updateBD(tablas);

    }
    
    public static void updateBD (String updateString) {
        try {
            Statement stmt=null;
            
            stmt=conectaBD().createStatement();
            stmt.executeUpdate(updateString);
            
            stmt.close();
        } catch (SQLException ex) {
            printSQLException(ex);
        }
    }
    
    public static void queryBD (String queryString) {
        try {
            Statement stmt=null;
            
            stmt=conectaBD().createStatement();
            
            ResultSet rs = stmt.executeQuery(queryString);
            while (rs.next()) {
                int numero=rs.getInt("numero");
                String nombre=rs.getString("nombre");
                
                System.out.println(numero+" "+nombre);
            }
            
            stmt.close();
        } catch (SQLException ex) {
            printSQLException(ex);
        }
    }
    
    public static void closeBD(){
        
        try {
            conectaBD().close();
        } catch (SQLException ex) {
            
        }
        
    }
 
}
