
package ClasesYObjetos;

import JOptionPane;

public class HiloDeposita extends Thread{
    BaseCuentas base;
    double deposito;
    int id;
    
    public HiloDeposita(BaseCuentas base ,double deposito,int id){
    this.id=id;
    this.base=base;
    this.deposito=deposito;
    }
    @Override
    public void run(){
         System.out.println("hilo creado");
         int x=base.getIndice(id);
         
        synchronized(base.arregloCuentas.get(x)){
            System.out.println("haciendo deposito");
         base.arregloCuentas.get(x).deposito(deposito);
        }
          System.out.println("saldo"+base.arregloCuentas.get(x).getSaldo()); 
       
       
    }
    public BaseCuentas getBase (){
    return base;
    }
  

    
}
