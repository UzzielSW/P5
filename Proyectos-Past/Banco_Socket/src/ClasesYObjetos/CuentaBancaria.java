
package ClasesYObjetos;

import JOptionPane;

/**
 *  Esta Clase representa al tipo de dato que simula una cuenta Bancaria, con los atributos
 *  que guardaran los datos del usuario y metodos correspondiente a una cuenta bancaria
 * @author Victor
 * @version 2019
 */
public class CuentaBancaria {
    /**Nombre del Cliente o propieratio de la cuenta. */
    private String nombre;
    /**Numero unico de 4 digitos de la cuenta. */
    private int cuentaId;
    /**Saldo del dinero que existe en la cuenta, de tipo flotante. */
    private double saldo;
    /**Tipo de Cuenta del usuario. */
    private String tipoCuenta;
    /**Contrasena Alfanumerica. */
    private String claveAlfaNum;
    /**Fecha de Creacion de la cuenta. */
    private String fechaInicio;
    /**Fecha de cierre de la cuenta. */
    private String fechaCierre;
    /**Metodo Constructor que para poder instanciar un Objeto de este tipo debe mandar el valor
     6  de sus  atributos. */
    public CuentaBancaria(String nombre, int cuentaId, double saldo, String tipoCuenta, String claveAlfaNum, String fechaInicio) {
        this.nombre = nombre;
        this.cuentaId = cuentaId;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
        this.claveAlfaNum = claveAlfaNum;
        this.fechaInicio = fechaInicio;
        
    }

    public CuentaBancaria() {
    }
    
       
    
     /**Metodo que deposita a la cuenta bancaria, aumentado el valor de el atributo saldo. 
      @param cantidad valor flotante que se le sumara al saldo. */
    public   void  deposito (double cantidad){
        this.saldo=saldo +cantidad;
    }
    
     /**Metodo retiro que que restara un monto indicado al saldo de la cuenta. 
      @param cantidad cantidad que debera ser menor al saldo para poder ser retirada */
    public  void retiro (double cantidad){
    if (cantidad<saldo){
     this.saldo=saldo-cantidad;
     }else {
        JOptionPane.showMessageDialog(null,"La cantidad que usted a ingresado es mayor al valor de su saldo");
      }
    
    
    
    
    }

    public String getNombre() {
        return nombre;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public String getClaveAlfaNum() {
        return claveAlfaNum;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaCierre() {
        return fechaCierre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public void setClaveAlfaNum(String claveAlfaNum) {
        this.claveAlfaNum = claveAlfaNum;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
    
    
    
  
    
}
