package Paquete277;
import java.io.*;
public class Leer {
static InputStreamReader isr = new InputStreamReader(System.in);
static BufferedReader flujoE = new BufferedReader(isr);
//leer un caracter
public static char datoChar(){
char c='\0';
try{
 c=(char)flujoE.read();
}catch(IOException e){
 System.err.println("Error: " + e.getMessage());
}
return c;
}
//cadenas
public static String datoString(){
String sdato = null;
try{
 sdato = flujoE.readLine();
 }catch(IOException e){
 System.err.println("Error: " + e.getMessage());
}
return sdato;
}
// enteros cortos
public static short datoShort(){
try{
 return Short.parseShort(datoString());
}catch(NumberFormatException e){
 return Short.MIN_VALUE;
}
}
// enteros
public static int datoInt(){
try{
 return Integer.parseInt(datoString());
}catch(NumberFormatException e){
 return 0;
}
}



// enteros largos
public static long datoLong(){
try{
 return Long.parseLong(datoString());
}catch(NumberFormatException e){
 return Long.MIN_VALUE;
}
}
//flotantes
public static float datoFloat(){
try{
 Float f = new Float(datoString());
 return f.floatValue();
}catch(NumberFormatException e){
 return Float.NaN;
}
}
//doble flotante o flotante largo
public static double datoDouble(){
try{
 Double d = new Double(datoString());
 return d.doubleValue();
}catch(NumberFormatException e){
 return Double.NaN;
}
}
}
