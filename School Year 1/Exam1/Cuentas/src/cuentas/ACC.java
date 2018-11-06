/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentas;

/**
 *
 * @author CruZ
 */
public class ACC {
    private String nick;
    private String pass;
    private double saldo;
    private double tipoInteres;
    
    ACC() {
        
    }
    ACC(String nick,String pass,double saldo,double tipoInteres) {
        this.nick=nick;
        this.pass=pass;
        this.saldo=saldo;
        this.tipoInteres=tipoInteres;
    }
    
    public void ingreso(double cantidad) {
    if(cantidad>0)
        saldo+=cantidad;
    }
    
    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    public String getNick() {
        return nick;
    }

    public String getPass() {
        return pass;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTipoInteres() {
        return tipoInteres;
    }

   
    
}
