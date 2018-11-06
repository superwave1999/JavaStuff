/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendacontactosconbddirectamente;

/**
 *
 * @author alberto
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author alberto
 */
public class AgendaContactos{

   
    private  Connection conexion;
    private  String nomBD;

    
    
    public AgendaContactos(String nomBD) throws SQLException {
        this.conexion = conexionBD(nomBD);
        this.nomBD = nomBD;
    }
    
    public static Connection conexionBD(String BDNombre) {
        
        Connection con=null;
        try{
              System.out.println("conectando ...");
              String controlador="com.mysql.jdbc.Driver";
              Class.forName(controlador).newInstance();
              con=DriverManager.getConnection
                  ("jdbc:mysql://localhost:3306/" + BDNombre,"root","root1234");
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
    
    public void cerrar(){
         try{
               conexion.close();
            }
            catch(SQLException err){
                System.out.println("Error al desconectar " + nomBD);
                
            }
    }
    
    
    public Contacto busca(String cad) throws SQLException{ //Busca por nombre o telefono
        
        Statement stmt=null;
        String telefono;
        String nombre;
  
        String query="select * from " + nomBD +".agenda" +
               " where (telefono = " +  "'" + cad.toUpperCase() + "'" + " or " + "nombre = " + "'" 
                                           +  cad.toUpperCase() + "'" + ")";
        
          try{
              stmt=conexion.createStatement();
              ResultSet rs=stmt.executeQuery(query);
              while (rs.next()){
                  telefono=rs.getString("telefono");
                  nombre=rs.getString("nombre");
                  return new Contacto(nombre, telefono);

              }
          }catch (SQLException e){
              printSQLException(e);
              return null;
          }finally{
              stmt.close();
          }
                return null;
    }
    
    public void lista() throws SQLException{
        Statement stmt=null;
        String telefono;
        String nombre;
        
        String query="select * from " + nomBD +".agenda";
        
        try{
              stmt=conexion.createStatement();
              ResultSet rs=stmt.executeQuery(query);
              while (rs.next()){
                  telefono=rs.getString("telefono");
                  nombre=rs.getString("nombre");
                  System.out.println("Nombre:" + nombre + ", Telefono:" + telefono);

              }
          }catch (SQLException e){
              printSQLException(e);
              
          }finally{
              stmt.close();
          }            
    }
        
    
    
    public String  leeContacto(){
            Scanner entrada = new Scanner(System.in);
            String cad;
           
            System.out.println("Dame nombre o telefono del contacto [intro = terminar]:");
            cad = entrada.nextLine();
                       
            return cad;
    }
    
    public void modifica(Contacto con, boolean esUnTelef){
            String cad;
            Contacto conBus;
            Scanner entrada = new Scanner(System.in);
            if (esUnTelef){
                modificaPorNombre(con);
            } else{
                modificaPorTelefono(con);
            }    
    }
     
    public void modificaPorNombre(Contacto con){
        
        String cad;
        Contacto conBus;
        Scanner entrada = new Scanner(System.in);
        boolean continuar;
        Statement stmt=null;
        String telefono = con.getTelefono();
        String nombre="";
        String createString;
        
        do{
            continuar = true;
            System.out.println("Nuevo nombre[Intro = Sin cambios]:");
            cad = entrada.nextLine();
            cad = cad.toUpperCase();
            if (cad.length() >0){
                if (!Contacto.esNombre(cad)){
                   System.out.println("Nombre invalido");
                } else{
                    continuar = false;
                }
            } else{
                continuar = false;
            }
        } while (continuar);

        try{
                if (cad.length() != 0){

                        if (busca(cad) != null){
                        System.out.println("Error, ya existe el nombre");
                    } else{
                         createString="update " + nomBD + ".agenda set nombre="+"'"+cad+"'" + 
                         " where (telefono = " + "'"+telefono+"'" +")";       
                          stmt=conexion.createStatement();
                          stmt.executeUpdate(createString);
   
  
                            
                    }

                }
        }
        catch(SQLException e){
            printSQLException(e);
        }
    }
    
    public void modificaPorTelefono(Contacto con){
        
        String cad;
        Scanner entrada = new Scanner(System.in);
        boolean continuar;
        Statement stmt=null;
        String telefono="";
        String nombre = con.getNombre();
        String createString;
        
        do{
            continuar = true;
            System.out.println("Nuevo telefono[Intro = Sin cambios]:");
            cad = entrada.nextLine();
                    
            if (cad.length() >0){
                if (!Contacto.esTelefono(cad)){
                   System.out.println("Telefono invalido");
                } else {
                    continuar = false;
                }
            } else{
                continuar = false;
            }
        } while (continuar);

        try{
            if (cad.length() != 0){
                if (busca(cad) != null){
                    System.out.println("Error, ya existe el nombre");
                } else{
                      createString="update " + nomBD + ".agenda set telefono="+"'"+cad+"'" + 
                         " where (nombre = " + "'"+nombre+"'" +")";       
                          stmt=conexion.createStatement();
                          stmt.executeUpdate(createString);
   
                }
            }
        }
        catch(SQLException e){
            printSQLException(e);
        }
        
    }
    
    
     
     public void baja(Contacto con) throws SQLException{
            char res;
            Scanner entrada = new Scanner(System.in);
            Statement stmt=null;
            String tel = con.getTelefono();
            System.out.println("¿Confirma la baja (s/n)?");
            res = entrada.nextLine().charAt(0); 
            if (res == 's' || res == 'S'){
                 String createString="delete from " + nomBD + ".agenda" +
                                     " where (telefono = " + tel +")";
              
              
              
              try{
                  stmt=conexion.createStatement();
                  stmt.executeUpdate(createString);
              }catch (SQLException e){
                  printSQLException(e);
              }finally{
                  stmt.close();
              }
                System.out.println("Contacto borrado");
            }
    }
     
    public boolean alta(String cad) throws SQLException{
            
            if (Contacto.esTelefono(cad)){
                System.out.println("Alta con telefono:" + cad);
                return altaPorTelefono(cad);
            }
            else if (Contacto.esNombre(cad)){
                System.out.println("Alta con nombre:" + cad);
                return altaPorNombre(cad);
            } else {
                System.out.println("Error, no es nombre, ni telefono");
                return false;
            }
    }


    public boolean altaPorTelefono(String cadTelefono) throws SQLException{
        Scanner entrada = new Scanner(System.in);
        boolean continuar;
        String cadAux;
        Statement stmt=null;
        String createString;
        
        do{
            continuar = true;
            System.out.println("Nombre:");
            cadAux= entrada.nextLine(); //Lee un nombre o intro
            cadAux = cadAux.toUpperCase();
            if (cadAux.length() != 0){
                if (!Contacto.esNombre(cadAux)){
                    System.out.println("Error, nombre incorrecto");
                } else{
                    
                    try{
                     if (busca(cadAux) != null){
                        System.out.println("Error, ya existe el contacto");
                     } else{
                          createString = "insert into " + nomBD+ ".agenda values ("
                          +"'"+cadTelefono+"'"+","
                          +"'"+cadAux+"'"+")";
                          stmt=conexion.createStatement();
                          stmt.executeUpdate(createString);
                          continuar = false;
                     }
                    } catch (SQLException e){
                        printSQLException(e);
                        return false;
                    }finally{
                        if (stmt != null){
                            stmt.close();
                        }
                    } 
                    
                }
             } else{
                continuar = false;
            }
        } while(continuar);
        
        return true;
    }
    
    
    
    public boolean altaPorNombre(String cadNombre) throws SQLException{
        Scanner entrada = new Scanner(System.in);
        boolean continuar;
        String cadAux;
        Statement stmt=null;
        String createString;
        
        do{
            continuar = true;
            System.out.println("Telefono:");
            cadAux= entrada.nextLine(); //Lee un telefono o intro
            if (cadAux.length() != 0){
                if (!Contacto.esTelefono(cadAux)){
                    System.out.println("Error, telefono incorrecto");
                } else{
                     try{
                     if (busca(cadAux) != null){
                        System.out.println("Error, ya existe el contacto");
                     } else{
                          createString = "insert into " + nomBD+ ".agenda values ("
                          +"'"+cadAux+"'"+","
                          +"'"+cadNombre.toUpperCase()+"'"+")";
                          stmt=conexion.createStatement();
                          stmt.executeUpdate(createString);
                          continuar = false;
                     }
                    } catch (SQLException e){
                        printSQLException(e);
                        return false;
                    }finally{
                        if (stmt != null){
                            stmt.close();
                        }
                    } 
                }
             } else{
                continuar = false;
            }
        } while(continuar);
    
            return true;
    }
   
     
    public boolean operar() throws SQLException{
            Scanner entrada = new Scanner(System.in);
            String cad, lin;
            Contacto con;
            char opcion;
            boolean continuar;
            
          
            cad = leeContacto();
            if (cad.length() == 0){
                return false;
            }
           
            boolean esUnTelefono = Contacto.esTelefono(cad);

            con = busca(cad);
            if (con != null){
                System.out.println(con);
                do {
                    continuar = true;
                    System.out.println("[M]:modificar   [B]:baja   [intro]:salir");

                    lin = entrada.nextLine();
                    if (lin.length() == 0){
                        continuar = false;
                    } else {
                            opcion = lin.charAt(0);
                            switch (opcion){
                                case 'm':
                                case 'M':   
                                            modifica(con, esUnTelefono);
                                            continuar = false;
                                            break;

                                case 'b':   
                                case 'B':            
                                            baja(con);
                                            continuar = false;
                                            break;

                                default:
                                            System.out.println("Opción incorrecta");

                            }
                    }
                } while (continuar);

                }
                else {  // Es un contacto que no existe   
                    alta(cad);
                }
            
            return true;
    }  
}

   

