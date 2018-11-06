
package agendacontactosfinalrelacional;

import java.sql.SQLException;


public class AgendaContactosFinalRelacional {

    public static void main(String[] args) {
        
        String bdName = "bdagenda";
        
        try {
            AgendaBD agenda = new AgendaBD(bdName);
            agenda.DBCreate();
            do {        
                agenda.ODBShowAll();
            } while (agenda.operate());
            agenda.ODBClose();
        } catch (SQLException ex) {
            AgendaBD.printSQLException(ex);
        }
                
    }
    
}
