/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqrag;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author Tarde
 */
public class mainRag {

   static int numRegs;
   static int tamReg=80;
   static RandomAccessFile raf;
   static Scanner sc=new Scanner(System.in);
   
    public static void main(String[] args) {
        try{
        File file=new File("miRaf.dat");
        raf=new RandomAccessFile(file,"rw");
        numRegs=(int)Math.ceil((double)
                (raf.length()/(double)tamReg));
            System.out.println("numRegs:" +numRegs);
            //ficheroraf.insert();
            ficheroraf.selectall();
            ficheroraf.update();
            ficheroraf.selectall();
            ficheroraf.delete();
            ficheroraf.selectall();
            
        }catch(Exception ex){
            System.out.println("error: "+ex.toString());
        }
    }
    
}
