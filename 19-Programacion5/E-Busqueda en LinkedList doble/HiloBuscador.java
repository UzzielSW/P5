import java.util.LinkedList;

class HiloBuscador extends Thread {
	
LinkedList datos;
public int dato_buscado;
public Object inicio;

public HiloBuscador(int dato, LinkedList datos,Object ini){ 
    dato_buscado = dato; 
    this.datos = datos;
    inicio=ini;
}
public void run(){ 

int i;
    
if(inicio==(Object)datos.getFirst())
 {
  
  for(i=0;i<datos.size();i++)
   {
    if (datos.get(i)==(Object)dato_buscado)
     {
     System.out.println("==> Principio:"+dato_buscado+" Encontrado en "+i);
     return;
    }else{
        System.out.println("P"+datos.get(i));
    }
  }
  }else{
     for(i=datos.size()-1;i>0;i--){  
         if (datos.get(i)==(Object)dato_buscado) {
       System.out.println("==> Final:"+dato_buscado+" Encontrado en "+i);
      return;
    }else{
        System.out.println("F"+datos.get(i));
    }
    }
  }
 }
}