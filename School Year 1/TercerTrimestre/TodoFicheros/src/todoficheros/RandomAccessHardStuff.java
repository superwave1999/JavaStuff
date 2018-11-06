/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoficheros;

/**
 *
 * @author super
 */
public class RandomAccessHardStuff {
    
    //Low priority
    public static void insert(){
        System.out.println("teclee nombre ");
        String nom=sc.nextLine();
        System.out.println("teclee telefono");
        int tel=sc.nextInt();sc.nextLine();
       try{
        raf.seek(numRegs*tamReg);
        raf.writeUTF(nom);
        raf.writeInt(tel);
        numRegs++;
       }catch(Exception ex){
           System.out.println("error: "+ex.toString());
       }
    }
    public static void selectall (){
        String nom;
        int tel;
       try{
           for(int i=0; i<numRegs;i++){
        raf.seek(i*tamReg);
        nom=raf.readUTF();
        tel=raf.readInt();
               System.out.println(nom+"\t"+tel);
           }
       }catch(Exception ex){
           System.out.println("error: "+ex.toString());
       }
    }
    public static void update(){
        String nom;int tel,ntel;
        System.out.println("teclee numero identificador");
        int nide=sc.nextInt();sc.nextLine();
       try{
        raf.seek(nide*tamReg);
        nom=raf.readUTF();
        tel=raf.readInt();
           System.out.println(nom+"\t"+tel);
           System.out.println("teclee nuevo telefono");
           ntel=sc.nextInt();sc.nextLine();
           raf.seek(nide*tamReg);
           raf.writeUTF(nom);
           raf.writeInt(ntel);
       }catch(Exception ex){
           System.out.println("error: "+ex.toString());
       }
    }
    public static void delete(){
        String nom;int tel,ntel;char res;
        System.out.println("teclee numero identificador");
        int nide=sc.nextInt();sc.nextLine();
       try{
        raf.seek(nide*tamReg);
        nom=raf.readUTF();
        tel=raf.readInt();
           System.out.println(nom+"\t"+tel);
           System.out.println("borrar s/n?:");
           res=sc.nextLine().charAt(0);
           if(res=='s'||res=='S'){
           raf.seek(nide*tamReg);
           raf.writeUTF(nom);
           raf.writeInt(0);
           }
       }catch(Exception ex){
           System.out.println("error: "+ex.toString());
       }
    }
}

