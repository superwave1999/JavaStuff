
package agendacontactosfinalrelacional;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
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
    
    private ObjectContainer con;
    private String bdName;

    public AgendaBD(String bdName) {
        this.con = ODBConnection(bdName);
        this.bdName = bdName;
    }
    
    public ObjectContainer ODBConnection(String bdName) {
        ObjectContainer con = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),bdName+".db4o");
        return con;
    }
    
    public static void printSQLException(SQLException ex) {
        
        
        
        
    }
    
    public void ODBClose() {
            con.close();
    }
    
    public void DBCreate () {
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
    
    //Has space remover
    public void ODBModify (String nameOld, String numOld, String nameNew, String numNew) {
        //Igual que el select hasta el if
        Query query = con.query();
        query.constrain(Contacto.class);
        query.descend("nombre").orderAscending().constrain(nameOld);
        
        ObjectSet result = query.execute();
        if (result.isEmpty()) {
            System.out.println("Vacio");
        } else {
            Contacto contac = (Contacto) result.next();
            
            contac.setNombre(nameNew);
            contac.setNumero(numNew);
            con.store(contac);
            
        }
        
        

    }
    
    public void ODBStore (String nombre, String numero) {
        Contacto contacIn = new Contacto (nombre, numero);
        con.store(con);
    }
    
    public void DBDeleteAll () {
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
    
    public void ODBDeleteElement (String name, String num) {
        //Igual que el select hasta el if
        Query query = con.query();
        query.constrain(Contacto.class);
        query.descend("nombre").orderAscending().constrain(name);
        
        ObjectSet result = query.execute();
        if (result.isEmpty()) {
            System.out.println("Vacio");
        } else {
            Contacto contac = (Contacto) result.next();
            con.delete(contac);
            
        }
        
        
    }
    
    public void ODBShowAll () {
        Query query = con.query();
        query.constrain(Contacto.class);
        query.descend("nombre").orderAscending();
        ObjectSet result = query.execute();
        while (result.hasNext()) {
            System.out.println(result.next().toString());
        }
        
    }
    
    
    //Has space remover
    public Contacto ODBShowSingle (String intro) throws SQLException {
        Query query = con.query();
        query.constrain(Contacto.class);
        query.descend("nombre").orderAscending().constrain(intro);
        
        ObjectSet result = query.execute();
        if (result.isEmpty()) {
            System.out.println("Vacio");

            return null;
            
        } else {
            Contacto contac = (Contacto) result.next();
            System.out.println(contac.toString());
            
            return contac;
        }
        
        
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
            
            ODBStore(primerIn,secondIn);
            
        } else if (Utils.esTelefono(Utils.quitarEspacios(primerIn))) {
            System.out.println("Dame el nombre");
            secondIn=input.nextLine();
            while (!Utils.esNombre(secondIn)) {
                System.out.println("Dame el nombre bien dao");
                secondIn=input.nextLine();
            }
            
            ODBStore(secondIn,primerIn);
            
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

        ODBModify(nameOld,numOld,nameNew,numNew);
        
        System.out.println("Contacto nuevo:");
        ODBShowSingle(nameNew);
        
    }
    
    public void operateBorra(Contacto contac) throws SQLException {
        String nameDel=contac.getNombre();
        String numDel=contac.getNumero();
        
        ODBDeleteElement(nameDel,numDel);
        
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
