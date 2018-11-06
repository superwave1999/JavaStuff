
package paqexamen2;

import java.util.Scanner;


public class cosas {
    private float peso;
    private float altura;
    private Scanner sc;
    public float imc;
    
    public void pepe(){
        sc=new Scanner(System.in);
        
            System.out.println("ingrese altura");
            altura=sc.nextFloat();
            System.out.println("ingrese peso");
            peso=sc.nextFloat();
            
        imc=peso/(altura*altura);
    
    
        System.out.println("su imc es: "+imc);
            
        
    }
    public void imce(){
        
       if (imc<=18.5)
       System.out.println("peso bajo");
       else if(imc<=25)
           System.out.println("peso normal");
       else if (imc<=30)
            System.out.println("sobrepeso");
       else if(imc<=40)
            System.out.println("obesidad");
       else if(imc>40)
            System.out.println("obesidad morbida");
               
               
    }
    public void perdepeso(){
        float perder;
        float ganar;
        perder=imc-25;
        ganar=25-imc;
        if(imc==25)
            System.out.println("estas en tu peso ideal");
        else if (imc<25)
            System.out.println("tienes que ganar "+ganar);
        else if(imc>25)
            System.out.println("tienes que perder "+perder);
            
        
             
    }
}
