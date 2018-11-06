
package exantej1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Articulos {
    
    private Connection con;
    private String bdNombre;
    
    Articulos () {
        
    }
    
    Articulos (String bdNombre) {
        this.con=bdConnect(bdNombre);
        this.bdNombre=bdNombre;
        
    }
    
    public static Connection bdConnect (String bdNombre) {
        Connection con = null;
        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver).newInstance();
            
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/" + bdNombre,"root","root1234");
            
        } catch (Exception e) {
            System.out.println("Error en la conexión");
        }
        
        return con;
    }
    
    public void bdClose() throws SQLException {
        con.close();
    }
    
    public boolean createTable() throws SQLException {
        Statement stmt = null;
        String query = "create table if not exists "+bdNombre+".articulos ("
                + "codigo integer AUTO_INCREMENT not null PRIMARY KEY,"
                + "nombre varchar(30) not null,"
                + "pvp integer not null,"
                + "existencias integer not null,"
                + "existencias_min integer not null,"
                + "CONSTRAINT CHK_1 CHECK (existencias>=0),"
                + "CONSTRAINT CHK_2 CHECK (existencias_min>=0),"
                + "CONSTRAINT CHK_3 CHECK (pvp>=0)"
                + ");";
        
        try {
            stmt = con.createStatement();

            stmt.executeUpdate(query);

        } catch (SQLException ex) {
            System.out.println("Error de createTable()");
            System.out.println("Comprueba CONSTRAINTS y tabla repetida");
            return false;
        } finally {
            stmt.close();
            
        }

        return true;
            
    }
    
    public boolean insertData(String nom, int pvp, int e, int e_min) throws SQLException {
        
        if (insertDataCheck(nom,pvp,e,e_min)==false) {
            return false;
        }
        
        Statement stmt = null;
        String query = "insert into "+bdNombre+".articulos (nombre, pvp, existencias, existencias_min) values ("
                + "'"+nom+"',"+pvp+","+e+","+e_min+");";
        
        try {
            stmt = con.createStatement();

            stmt.executeUpdate(query);

        } catch (SQLException ex) {
            System.out.println("Error de insertData()");
            System.out.println("Comprueba CONSTRAINTS");
            return false;
        } finally {
            stmt.close();
            
        }

        return true;
        
        
    }
    
    public boolean insertDataCheck(String nom,int pvp,int e, int e_min){
        
        boolean status=true;
        
        if (nom.length()<0) {
            System.out.println("No has insertado nombre");
            status=false;
        }
        
        if (nom.length()>30) {
            System.out.println("Demasiado largo para BD");
            status=false;
        }
        
        if (pvp<0 || e<0 || e_min<0) {
            System.out.println("Precio, exist y ex_min no debe ser negativo");
            status=false;
        }
        
        return status;
        
    }
    
    public boolean displayData() throws SQLException {
        Statement stmt=null;
        String nombre;
        int cod,pvp,exist,e_min;
        String query = "select * from "+bdNombre+".articulos;";
        
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                cod = rs.getInt("codigo");
                nombre = rs.getString("nombre");
                pvp = rs.getInt("pvp");
                exist = rs.getInt("existencias");
                e_min = rs.getInt("existencias_min");
                
                System.out.println(cod+" "+nombre+" "+pvp+" "+exist+" "+e_min);
                
            }
        } catch (SQLException ex) {
            System.out.println("Error de displayData()");
            return false;
        } finally {
            stmt.close();
        }
        return true;
    }
    
    public boolean operate() throws SQLException {
        Scanner input = new Scanner(System.in);
        String option;
        
        if (con==null) {
            return false;
        }
        
        createTable();
        
//        for (int i=0; i<5; i++) {
//            
//        }



        
        
        insertData("Toalla",5,3,2);
        insertData("Sombrilla",15,5,1);
        insertData("Bocata",4,8,4);
        insertData("Arena",1,3,2);
        insertData("Agua",1,10,2);
        
        insertData("POLLaSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSO",-1,-5,2);
        
        displayData();
        
        System.out.println("Repetir? 1.Si, 2.No");
        option=input.nextLine();
        if ("1".equals(option)) {
            return true;
        } else {
            return false;
        }
        
    }
    
}
