
package programacion2;

public class Gordos {
        
    String nombre;
    float peso;
    float altura;
 
    float calcularIMC() {
        return (float) (peso/Math.pow(altura, 2));
    }
    
    float calculoPesoAdecuado() {
        return 0;
    }
 
    String clasificaIMC() {
        float imc;
        String classe;
        imc = calcularIMC();
 
        if (imc < 18.5)
            classe = "Peso bajo";
        else
        if (imc < 25)
            classe = "Peso normal";
        else
        if (imc < 30)
            classe = "Sobrepeso";
        else
        if (imc < 40)
            classe = "Obesidad";
        else
            classe = "Bola grasa";
 
            return classe;
    }
    
    
}