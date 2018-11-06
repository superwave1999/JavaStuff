/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgendaSerial;

/**
 *
 * @author alberto
 */
public class AplicacionAgenda {
    public static void main(String[] args){
        AgendaContactos agenda = new AgendaContactos();
        String ruta="archivo.con"; 
        
        if (agenda.existe(ruta)) {
            agenda.loadAgenda(ruta); 
        }
        
        do{       
                System.out.println(agenda);
        } while (agenda.operar());
        
        agenda.saveAgenda(ruta);

    }
}
