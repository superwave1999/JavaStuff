
package agendacontactosfinalrelacional;

import java.sql.SQLException;


public class AgendaContactosFinalRelacional {

    public static void main(String[] args) {
        
        String bdName = "bdagenda";
        
        try {
            AgendaBD agenda = new AgendaBD(bdName);
            agenda.DBCreate();
            do {        
                agenda.DBSelectAll();
            } while (agenda.operate());
            agenda.DBClose();
        } catch (SQLException ex) {
            AgendaBD.printSQLException(ex);
        }
                
    }
    
}
