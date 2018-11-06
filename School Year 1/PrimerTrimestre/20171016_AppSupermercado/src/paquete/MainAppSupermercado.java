package paquete;

import java.util.Scanner;

public class MainAppSupermercado {
    /*static double total1 = 0, total2 = 0, total3 = 0, total4 = 0, total5 = 0, TOTAL = 0;  //Total de cada producto
    static int U1 = 0, U2 = 0, U3 = 0, U4 = 0, U5 = 0; //Unidades de cada producto
    static int E1 = 100, E2 = 50, E3 =30, E4 = 50, E5 = 1000;  //Existencias
    static boolean cantidad_correcta = false;
    static int unidades = 0;*/
    
    public static void mostrarTicket(int E1, int E2, int E3, int E4, int E5){
        System.out.println("ARTICULOS\tPVP\tEXISTENCIAS");
            System.out.println("1.Espaguettis\t1.0€\t"+E1);
            System.out.println("2.Tomate Frito\t0.5€\t"+E2);
            System.out.println("3.Huevos\t1.5€\t"+E3);
            System.out.println("4.Patatas\t1.2€\t"+E4);
            System.out.println("5.Yogurt\t0.3€\t"+E5);
            System.out.println("===================================");
            System.out.println("");
    }
    
    /*public static void setProducto(double precio, int unidadeds, int existencias,
                boolean cantidad_correcta, double total, int UT, Scanner sc){
            do{
                System.out.print("Introduzca la cantidad que quiere comprar: ");
                unidades = sc.nextInt();
                System.out.println("");

                if((existencias >= unidades && unidades > 0) || existencias == 0)
                    cantidad_correcta = true;
                else
                    System.out.println("Cantidad incorrecta, introduzca otra.");
                }while(!cantidad_correcta);

                if(E1 != 0){
                    cantidad_correcta = false;
                    total = total + unidades*precio;
                    UT = unidades + UT;
                    if(existencias - UT < 0)
                        existencias = 0;
                    else
                        existencias = existencias - UT;
                }
    }*/
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int producto;
        double  precio = 0;
        double total1 = 0, total2 = 0, total3 = 0, total4 = 0, total5 = 0, TOTAL = 0;  //Total de cada producto
        int U1 = 0, U2 = 0, U3 = 0, U4 = 0, U5 = 0; //Unidades de cada producto
        int E1 = 100, E2 = 50, E3 =30, E4 = 50, E5 = 1000;  //Existencias
        boolean cantidad_correcta = false;
        int unidades = 0;
        
        do{
            mostrarTicket(E1,E2,E3,E4,E5);
            
            System.out.print("Introduzca un producto que desee comprar (de 1 a 5) (-1 para terminar): ");
            producto = sc.nextInt();
            System.out.println("");
            
            if((producto < 1 || producto > 5) && producto != -1)
                System.out.println("Este producto no existe, prueba con otro.");
            else{
                if(producto == 1){
                    //setProducto(1, unidades, E1, cantidad_correcta, total1, U1, sc);    
                    
                        precio = 1;

                        do{
                            System.out.print("Introduzca la cantidad que quiere comprar: ");
                            unidades = sc.nextInt();
                            System.out.println("");

                            if((E1 >= unidades && unidades > 0) || E1 == 0)
                                cantidad_correcta = true;
                            else
                                System.out.println("Cantidad incorrecta, introduzca otra.");
                        }while(!cantidad_correcta);

                        if(E1 != 0){
                            cantidad_correcta = false;
                            total1 = total1 + unidades*precio;
                            U1 = unidades + U1;
                            if(E1 - U1 < 0)
                                E1 = 0;
                            else
                                E1 = E1 - U1;
                        }
                }else if(producto == 2){
                    //setProducto(0.5, unidades, E2, cantidad_correcta, total2, U2, sc);
                    
                        precio = 0.5;

                        do{
                            System.out.print("Introduzca la cantidad que quiere comprar: ");
                            unidades = sc.nextInt();
                            System.out.println("");

                            if((E2 >= unidades && unidades > 0) || E2 == 0)
                                cantidad_correcta = true;
                            else
                                System.out.println("Cantidad incorrecta, introduzca otra.");
                        }while(!cantidad_correcta);

                        if(E2 != 0){
                            cantidad_correcta = false;
                            total2 = total2 + unidades*precio;
                            U2 = unidades + U2;
                            if(E2 - U2 < 0)
                                E2 = 0;
                            else
                                E2 = E2 - U2;
                        }
                        
                }else if(producto == 3){
                    //setProducto(1.5, unidades, E3, cantidad_correcta, total3, U3, sc);
                    
                        precio = 1.5;

                        do{
                            System.out.print("Introduzca la cantidad que quiere comprar: ");
                            unidades = sc.nextInt();
                            System.out.println("");

                            if((E3 >= unidades && unidades > 0) || E3 == 0)
                                cantidad_correcta = true;
                            else
                                System.out.println("Cantidad incorrecta, introduzca otra.");
                        }while(!cantidad_correcta);

                        if(E3 != 0){
                            cantidad_correcta = false;
                            total3 = total3 + unidades*precio;
                            U3 = unidades + U3;
                            if(E3 - U3 < 0)
                                E3 = 0;
                            else
                                E3 = E3 - U3;
                        }
                    
                }else if(producto == 4){
                    //setProducto(1.2, unidades, E4, cantidad_correcta, total4, U4, sc);
                    
                        precio = 1.2;

                        do{
                            System.out.print("Introduzca la cantidad que quiere comprar: ");
                            unidades = sc.nextInt();
                            System.out.println("");

                            if((E4 >= unidades && unidades > 0) || E4 == 0)
                                cantidad_correcta = true;
                            else
                                System.out.println("Cantidad incorrecta, introduzca otra.");
                        }while(!cantidad_correcta);

                        if(E4 != 0){
                            cantidad_correcta = false;
                            total4 = total4 + unidades*precio;
                            U4 = unidades + U4;
                            if(E4 - U4 < 0)
                                E4 = 0;
                            else
                                E4 = E4 - U4;
                        }
                        
                }else if(producto == 5){
                    //setProducto(0.3, unidades, E5, cantidad_correcta, total5, U5, sc);  
                    
                        precio = 0.3;

                        do{
                            System.out.print("Introduzca la cantidad que quiere comprar: ");
                            unidades = sc.nextInt();
                            System.out.println("");

                            if((E5 >= unidades && unidades > 0) || E5 == 0)
                                cantidad_correcta = true;
                            else
                                System.out.println("No quedan existencias, cantidad incorrecta.");
                        }while(!cantidad_correcta);

                        if(E5 != 0){
                            cantidad_correcta = false;
                            total5 = total5 + unidades*precio;
                            U5 = unidades + U5;
                            if(E5 - U5 < 0)
                                E5 = 0;
                            else
                                E5 = E5 - U5;
                        }
                }
            }
        }while(producto != -1);
        
        TOTAL = total1 + total2 + total3 + total4 + total5;
        
        System.out.println("==================================");
        System.out.println("UNDS\tPRODUCTO\tIMPORTE");
        if(total1 > 0)
            System.out.println(U1+"\tEspaguettis\t"+total1);
        if(total2 > 0)
            System.out.println(U2+"\tTomateFrito\t"+total2);
        if(total3 > 0)
            System.out.println(U3+"\tHuevos     \t"+total3);
        if(total4 > 0)
            System.out.println(U4+"\tPatatas    \t"+total4);
        if(total5 > 0)
            System.out.println(U5+"\tYogurt     \t"+total5);
        
        System.out.println("\nTOTAL:  "+TOTAL);
        System.out.println("==================================");
    }
    
}
