package paquete;

//Contar cuantas quinielas de 10, 11, 12, 13, 14, 15. En una matriz 1000x15. 1000 quinielas

public class MainAppQuiniela { 
    
    public static char generaResultadoPartido(){
        char[] resultado = new char [3];
        char[] resultados = {'1','x','2'};
        
        return resultados[(int)(Math.random()*3)];
    }
    
    public static void generarQuinielas(char[][] quinielas, int fils, int cols){
        for(int i = 0; i < fils; ++i)
            for(int j = 0; j < cols; ++j)
                quinielas[i][j] = generaResultadoPartido();                           
    }
    
    public static void generarSolucion(char[] solucion, int tam){
        for(int i = 0; i < tam; ++i)
                solucion[i] = generaResultadoPartido();                            
    }
    
    public static int acertados(int numero, char[][] quinielas, char[] solucion, int tam){
        int acertados = 0;
        
        for(int i = 0; i < tam; ++i)
            if(quinielas[numero][i] == solucion[i])
                acertados++;
        
        return acertados;
    }
    
    public static void porcentaje(int aciertos, float[] porcentajes){
        int index = aciertos % 10;
        
        porcentajes[index] += 1;
    }
    
    public static void mostrarPorcentajes(float[] porcentajes, int FILS){
        for(int i = 0; i < porcentajes.length; ++i)
            System.out.println("Han habido un " + porcentajes[i]/FILS*100 
                    + "% de quinielas con " + " 1"+i+" aciertos. (" + (int)porcentajes[i] +
                        " quinielas)");      
    }
    
    public static void main(String[] args) {
        int FILS = 20000000; //Numero de quinielas
        int COLS = 15;  //Numero de partidos por quiniela   
        char[][] quinielas = new char[FILS][COLS];
        char[] solucion = new char[COLS];
        float[] porcentajes = new float [6];
        
        generarQuinielas(quinielas,FILS,COLS);
        generarSolucion(solucion,COLS);
        
        for(int i = 0; i < FILS; ++i){
            if(acertados(i,quinielas,solucion,COLS) >= 10){
                System.out.println("La quiniela " + (i+1) + " ha sido premiada con " 
                        + acertados(i,quinielas,solucion,COLS) + " aciertos.");
                porcentaje(acertados(i,quinielas,solucion,COLS), 
                        porcentajes);
            }
        }
        
        System.out.println("");
        System.out.println("====================================================");
        mostrarPorcentajes(porcentajes, FILS);
    }
    
}
