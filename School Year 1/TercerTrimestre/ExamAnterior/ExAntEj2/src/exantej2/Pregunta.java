/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exantej2;

/**
 *
 * @author super
 */
public class Pregunta {

    String pregunta;
    String respuesta1;
    String respuesta2;
    String respuesta3;
    String respuesta4;
    String solucion;
    
    public Pregunta() {
        
        
    }
    
    public Pregunta(String p, String r1, String r2, String r3, String r4, String s) {
        pregunta=p;
        respuesta1=r1;
        respuesta2=r2;
        respuesta3=r3;
        respuesta4=r4;
        solucion=s;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public String getRespuesta3() {
        return respuesta3;
    }

    public void setRespuesta3(String respuesta3) {
        this.respuesta3 = respuesta3;
    }

    public String getRespuesta4() {
        return respuesta4;
    }

    public void setRespuesta4(String respuesta4) {
        this.respuesta4 = respuesta4;
    }

    //Part of
    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }
    
    //Part of
    @Override
    public String toString() {
        return "Pregunta{" + "pregunta=" + pregunta + ", respuesta1=" + respuesta1 + ", respuesta2=" + respuesta2 + ", respuesta3=" + respuesta3 + ", respuesta4=" + '}';
    }
    
    

}
