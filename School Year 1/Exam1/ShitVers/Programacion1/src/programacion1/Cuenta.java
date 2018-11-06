
package programacion1;

public class Cuenta {
    
    private String nombre;
    private String password;
    private int cuenta;
    private double saldo;
    private double tipoInteres;
    
    public Cuenta () {
        
    }
    
    public Cuenta (String nom,String pass, int cue, double sal, double tip) {
        this.nombre=nom;
        this.password=pass;
        this.cuenta=cue;
        this.saldo=sal;
        this.tipoInteres=tip;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCuenta() {
        return cuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTipoInteres() {
        return tipoInteres;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    public String visualiza() {
        return "nombre=" + nombre + ", cuenta=" + cuenta + ", saldo=" + saldo + ", tipoInteres=" + tipoInteres;
    }
    
    public boolean ingreso(double cantidad) {
        boolean correcto;

        if (cantidad>0) {
            saldo=saldo+cantidad;
            correcto=true;
        } else {
            System.out.println("Introduce un valor positivo");
            correcto=false;
        }
        return correcto;
    }
    
    public boolean reintegro(double cantidad) {
        boolean correcto;

        if (cantidad<=0 || saldo<cantidad) {
            System.out.println("Valor incorrecto");
            correcto=false;
        } else {
            saldo=saldo-cantidad;
            correcto=true;
        }
        return correcto;
    }
    
    //Unused
    
    public boolean transferencia (Cuenta cuentaTrans, double cantTrans) {
        this.reintegro(cantTrans);
        cuentaTrans.ingreso(cantTrans);

        return true;
        
    }
}
