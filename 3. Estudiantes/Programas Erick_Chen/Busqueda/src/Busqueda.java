import javax.swing.*;
import java.util.Random;
public class Busqueda {
	 static int n=0,x=0;
    public static void main(String[] args){
       int resp=0;
    	try{
          UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        }catch(Exception e){}
        do{
          // inicializa(n,x);
        try{
	
      	   try{
      	      n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Tamaño del Arreglo: "));
      	      valida(n);
              int vec[]=new int[n];
              Random generador=new Random();
              for(int i=0;i<n;i++){
        	 vec[i]=generador.nextInt(99)+1;
            }
            do{
              x=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Numero: "));
              //valida(x);
            }while(x<=0);
              ParalelSearch2 busca=new ParalelSearch2(x,vec,20,5);
              busca.BusquedaParalela();
              resp= JOptionPane.showConfirmDialog(null,"Desea Continuar: confirme?","YES_NO_OPTION", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
	   }catch(NumberFormatException e){JOptionPane.showMessageDialog(null,"Tiene que ingresar un Valor Entero");}	     
	}catch(Busca t){} 
       }while(resp==0);
      }
    public static void valida(int n)throws Busca{
    	if(n<=0){
    		throw new Busca(n);
    	}
    }
   /* public static void inicializa(int n,int x){
    	n=0;
    	x=0;
    }*/
}
 class Busca extends Exception{
   	private int n;
   	  Busca(int n){
   	  this.n=n;
   	  JOptionPane.showMessageDialog(null,"Ingrese Valores Mayores a 0");	
        }
    }
  
/*Usando LinkedList 2 hilos buscando en una lista de izquierda a derecha*/