/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingconobjetos;

/**
 *
 * @author alberto
 */
public class ParkingConObjetos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       int op = 0; 
       
       Parking pGranada = new Parking("Granada",0.03, 10, 0.0);
       TarjetaParking tarjeta = null;
       double precioPagado = 0.0;
       
       do {
           System.out.println(pGranada);
           op = pGranada.menu();
           
           switch (op){
               case 1:
                   tarjeta =  pGranada.entraVehiculo();
                   break;
               case 2:
                   precioPagado = pGranada.saleVehiculo(tarjeta);
                   pGranada.setCaja(pGranada.getCaja() + precioPagado);
                   break;
               case 3:
                   System.out.println("Programa terminado normalmente");
                   break;
               default:
                   System.out.println("Opcion erronea");
                   break;
           }
           
       } while (op == 3);
       
       
    }
    
}
