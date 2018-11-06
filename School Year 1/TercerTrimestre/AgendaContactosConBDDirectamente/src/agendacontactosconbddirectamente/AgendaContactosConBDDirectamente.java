/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendacontactosconbddirectamente;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Alberto
 */
public class AgendaContactosConBDDirectamente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        String nomBD  = "agendacontactos";
       
        try{
            AgendaContactos agenda = new AgendaContactos(nomBD); 
             do{       
                    agenda.lista();
            } while (agenda.operar());
            
            agenda.cerrar();
        }
        catch (SQLException e){
            AgendaContactos.printSQLException(e);
        }
      
    }
    
}
    

