
package agendacontactosfinalrelacional;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class AgendaBD {
    
    private Connection con;
    private String bdName;

    public AgendaBD(String bdName) throws SQLException {
        this.con = DBConnection(bdName);
        this.bdName = bdName;
    }
    
    public Connection DBConnection(String bdName) {
        Connection con=null;
        try {
            String controlador="com.mysql.jdbc.Driver";
            Class.forName(controlador).newInstance();
            con=DriverManager.getConnection
                  ("jdbc:mysql://localhost:3306/" + bdName,"root","root1234");
            
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
    
    public void DBCreate () throws SQLException {
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
    
    public void DBModify (String setPart, String wherePart) throws SQLException {
        
        //Unused
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
    
    
    //Has space remover
    public void DBModifyRS (String nameOld, String numOld, String nameNew, String numNew) throws SQLException {
        
        String query="select * from "+bdName+".agenda where (nombre='"+toUpperCase(nameOld)+"' or numero='"+numOld+"');";
        
        Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet result=stmt.executeQuery(query);
        
        while (result.next()) {
            result.updateString("nombre", toUpperCase(nameNew));
            result.updateRow();
            
            result.updateString("numero", Utils.quitarEspacios(numNew));
            result.updateRow();
            
        }

    }
    
    public void DBInsert (String nombre, String numero) throws SQLException {
        String query = "insert into "+bdName+".agenda values('"+toUpperCase(nombre)+"','"+Utils.quitarEspacios(numero)+"');";
        
        Statement stmt=null;
        
        try {
            stmt=con.createStatement();
            stmt.executeUpdate(query);
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
    
    public void DBDeleteElement (String name, String num) throws SQLException {
        String query = "delete from "+bdName+".agenda where (nombre='"+toUpperCase(name)+"' or numero='"+num+"');";
        
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
    
    
    //Has space remover
    public Contacto DBSelectSingle (String intro) throws SQLException {
        String query = "select * from "+bdName+".agenda where (nombre='"+toUpperCase(intro)+"' or numero='"+Utils.quitarEspacios(intro)+"');";
        Contacto contac=null;
        Statement stmt=null;
        try {
            stmt=con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            
            while (result.next()) {
                String nombre = result.getString("nombre");
                String numero = result.getString("numero");
                
                System.out.println(nombre+" "+numero);
                contac = new Contacto(nombre,numero);
            }
            
        } catch (SQLException e) {
            System.out.println("Error de visualizacion de tabla");
            e.printStackTrace();
        } finally {
            stmt.close();
        }
        
        return contac;
        
    }
    
    public ArrayList<Contacto> DBSelectLike (String intro) throws SQLException {
        ArrayList<Contacto> cList = new ArrayList<>();
        
        String query = "select * from "+bdName+".agenda where (nombre LIKE '"+toUpperCase(intro)+"%' or numero LIKE '"+Utils.quitarEspacios(intro)+"%');";
        Contacto contac=null;
        Statement stmt=null;
        try {
            stmt=con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            
            while (result.next()) {
                String nombre = result.getString("nombre");
                String numero = result.getString("numero");
                
                contac = new Contacto(nombre,numero);
                cList.add(contac);
            }
            
        } catch (SQLException e) {
            System.out.println("Error de visualizacion de tabla");
            e.printStackTrace();
        } finally {
            stmt.close();
        }
        
        for (int i=0; i<cList.size(); i++) {
            System.out.println("["+(i+1)+"] "+cList.get(i).getNombre()+" "+cList.get(i).getNumero());
        }
        
        return cList;
        
    }
    
    public static void operateMenu() {
        System.out.println("1.Modificar contacto");
        System.out.println("2.Borrar contacto");
        System.out.println("3.Borrar todos contactos");
        System.out.println("Otro. Salir");
    }
    
    public boolean operate() throws SQLException {
        Scanner input = new Scanner (System.in);
        String primerIn, operation;
        Contacto contac;
        
        DBCreate();
        
        contac=operateBusca();
        
        if (contac!=null) {
            System.out.println("Contacto existe");
            operateMenu();
            operation=input.nextLine();
            
            switch (operation) {
                case "1":
                    operateModifica(contac);
                break;
                case "2":
                    operateBorra(contac);
                break;
                case "3":
                    operateBorraAll();
                break;
                default:
                    return false;
            }
            
            
            return true;
            
        } else {
            System.out.println("Contacto no encontrado, añadiendo");
            operateAdd();
            
        }

        return true;
    }
    
    public Contacto operateBusca() throws SQLException {
        Scanner input = new Scanner(System.in);
        String busqueda, selecName, selecNum;
        int contacIndex;
        ArrayList<Contacto> cList;
        Contacto contac=null;
        
        System.out.println("Dame tu prefijo o nombre o numero completo");
        busqueda=input.nextLine();
        
        cList=DBSelectLike(busqueda);
        
        
        if (cList.size()>1) {
            
            System.out.println("Dame el [indice] del contacto a operar");
            contacIndex=parseInt(input.nextLine());
            contacIndex=contacIndex-1;

            while (contacIndex<0 || contacIndex>cList.size()) {
                System.out.println("Dame el [indice] del contacto CORRECTO a operar");
                contacIndex=parseInt(input.nextLine());
                contacIndex=contacIndex-1;

            }

            selecName=cList.get(contacIndex).getNombre();
            selecNum=cList.get(contacIndex).getNumero();
            
            contac = new Contacto(selecName,selecNum);
            
            return contac;
            
        } else if (cList.isEmpty()) {
            
            return null;
            
            
        } else {
            selecName=cList.get(0).getNombre();
            selecNum=cList.get(0).getNumero();
            
            contac = new Contacto(selecName,selecNum);
            
            return contac;
        }
        

    }
    
    public void operateAdd() throws SQLException {
        Scanner input = new Scanner(System.in);
        String primerIn,secondIn;
        
        System.out.println("Dame un nombre o numero");
        primerIn=input.nextLine();
        
        if (Utils.esNombre(primerIn)) {
            System.out.println("Dame el telefono");
            secondIn=input.nextLine();
            while (!Utils.esTelefono(secondIn)) {
                System.out.println("Dame el telefono bien dao");
                secondIn=input.nextLine();
            }
            
            DBInsert(primerIn,secondIn);
            
        } else if (Utils.esTelefono(Utils.quitarEspacios(primerIn))) {
            System.out.println("Dame el nombre");
            secondIn=input.nextLine();
            while (!Utils.esNombre(secondIn)) {
                System.out.println("Dame el nombre bien dao");
                secondIn=input.nextLine();
            }
            
            DBInsert(secondIn,primerIn);
            
        }

    }
    
    public void operateModifica(Contacto contac) throws SQLException {
        Scanner input=new Scanner (System.in);
        String nameOld=contac.getNombre();
        String numOld=contac.getNumero();
        String nameNew;
        String numNew;
        
        System.out.println("Dame el nombre nuevo | Vacio deja igual");
        nameNew=input.nextLine();
        if (nameNew.length()==0) {
            nameNew=nameOld;
        } else {
            while (!Utils.esNombre(nameNew)) {
                System.out.println("Dame el nombre nuevo bien dao");
                nameNew=input.nextLine();
            }
        }
        
        System.out.println("Dame el numero nuevo | Vacio deja igual");
        numNew=input.nextLine();
        if (numNew.length()==0) {
            numNew=numOld;
        } else {
            while (!Utils.esTelefono(numNew)) {
                System.out.println("Dame el numero nuevo bien dao");
                numNew=input.nextLine();
            }

        }

        DBModifyRS(nameOld,numOld,nameNew,numNew);
        
        System.out.println("Contacto nuevo:");
        DBSelectSingle(nameNew);
        
    }
    
    public void operateBorra(Contacto contac) throws SQLException {
        String nameDel=contac.getNombre();
        String numDel=contac.getNumero();
        
        DBDeleteElement(nameDel,numDel);
        
    }
    
    public void operateBorraAll(){
        try {
            DBDeleteAll();
            DBCreate();
        } catch (SQLException ex) {
            System.out.println("Error de borado");
        }
        
    }
    
}
