    
package examen2trej1;

import java.util.ArrayList;

public class Examen2TREj1 {

    public static void main(String[] args) {
        
        Alumno aSave;
        float[] notas;
        notas=new float[]{1,2,3,4};
        Alumno a1= new Alumno ("Ana",notas,false);
        notas=new float[]{2,5,6,7};
        Alumno a2= new Alumno ("Belen",notas,false);
        notas=new float[]{5,6,7,8};
        Alumno a3= new Alumno ("Carlos",notas,false);
        notas=new float[]{6,7,8,9};
        Alumno a4= new Alumno ("Delia",notas,false);
        
        ArrayList<Alumno> clase=new ArrayList<>();
        
        clase.add(a1);
        clase.add(a2);
        clase.add(a3);
        clase.add(a4);
        
        System.out.println("Leo fichero y lo guardo en el arraylist");
            aSave = Serializacion.leerDeFichero();
                if (aSave!=null) {
                    clase.add(aSave);
                }
        System.out.println("Muestro el arraylist");
            mostrarArrayList(clase);
        System.out.println("Actualizar arraylist");
            actualizarArrayList(clase);
        System.out.println("Muestro arraylist (actualizado)");
            mostrarArrayList(clase);
        
    }
    
    public static boolean compruebaSuspenso(float[] notas){
        int contar = 0;
        for(int i=0;i<notas.length; i++){
            if(notas[i]<5){
                contar++;
            }
        }
        return contar != 0;
    }

    private static void mostrarArrayList(ArrayList<Alumno> clase) {
        for (int i=0; i<clase.size(); i++) {
            System.out.print(clase.get(i).toString()+"\n");
        }
    }

    private static void actualizarArrayList(ArrayList<Alumno> clase) {
        for (int i=0; i<clase.size(); i++) {
            boolean estaSuspenso = compruebaSuspenso(clase.get(i).getNotas());
            clase.get(i).setPromociona(!estaSuspenso);
        }
    }
    
}
