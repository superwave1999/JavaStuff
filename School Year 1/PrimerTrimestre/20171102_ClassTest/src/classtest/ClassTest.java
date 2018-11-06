
package classtest;

public class ClassTest {
    
    public static void cambiar1 (int x) {
        x++;
        System.out.println("X en metodo vale "+x);
        
    }

    public static void cambiar2 (int[] par) {
        par[0]++;
        System.out.println("par[] en metodo vale "+par[0]);
        
    }
    
    public static void cambiar3 (String[] nombre) {
        nombre[0]="Cristina";
        System.out.println("nombre[] en metodo vale "+nombre[0]);
    }
    
    public static void main(String[] args) {
        
        int x=4;
        
        System.out.println("X en main vale "+x);
        cambiar1(x);
        
        
        int par[]=new int[1];
        par[0]=7;
        
        System.out.println("par[] en main vale "+par[0]);
        cambiar2(par);
        
        
        String nombre[]= new String[1];
        nombre[0]="Marta";
        
        System.out.println("nombre[] en main vale "+nombre[0]);
        cambiar3(nombre);
    }
    
}
