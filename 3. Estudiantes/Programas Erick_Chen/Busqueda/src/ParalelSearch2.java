import java.awt.*;
import javax.swing.*;
public class ParalelSearch2{
    public int x,array[],n,nhilos,i,j;
    public static int hi=0;
    public int indice=-1; 
    Thread hilos[];
    TextArea area;
   public  ParalelSearch2(int num,int v[],int valor,int numhilos){
        x=num;
        array=v;
        n=valor;
        nhilos=numhilos;
        hilos=new Thread[numhilos];
    }
    public void BusquedaParalela(){
    	int k=n/nhilos;
    	for(i=0,j=1;i<nhilos;i++){
    		     hilos[hi]=new Thread(new Buscador(i*k,j++*k));
                 hilos[hi].start();
                 hi++;
    		}
    	for(int i=0;i<hilos.length;i++){
    	       try{
    	        hilos[i].join();
    	        }catch(InterruptedException e){
    	        	e.printStackTrace();
    	        }
    	 }   	
       DesplegarElemento();
   }
    public void DesplegarElemento(){
    	area=new TextArea();
    	area.setFont(new java.awt.Font("Comic Sans MS",0,15));
    	area.append("Arreglo de Numeros\n\n");
    	for(int i=0;i<20;i++){
    		area.append(" "+array[i]+" ");
    	}
      if (indice>=0){
      	area.append("\nNumero "+array[indice]+"\nEsta en el indice ["+indice+"]");
       }else {
       	area.append("\n\nEl Numero "+x+" No se Encuentra en el Array");
       }
       JOptionPane.showMessageDialog(null,area);
     }  
     	
 public  class Buscador implements Runnable{
 	int i,j;
 	public Buscador(int x,int y){
 		i=x;
 		j=y;
 	}
    	public void run(){
    		for(int k=i; k<j; k++){
    			if(array[k]==x){
    				indice=k;
    			    break;
    			}
    		}
    	   return;
    	}
    }  
}

