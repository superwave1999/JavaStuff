/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exantej1;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author super
 */
public class ExAntEj1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String bdNombre = "bdExamen1";
        
        Articulos art = new Articulos(bdNombre);
        try {
            do {
                
            } while (art.operate());
            art.bdClose();
        } catch (SQLException ex) {
            System.out.println("Error de cierre de stmt");
        }
    }
    
}
