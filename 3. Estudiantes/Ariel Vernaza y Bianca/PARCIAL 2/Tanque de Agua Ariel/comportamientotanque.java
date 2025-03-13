import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ComportamientoTanque{	
	TanqueAgua tanque1,tanque2;
	boolean lleno,vacio;
	
	public ComportamientoTanque(){
		tanque1=new TanqueAgua(20.0,5.0);
		tanque2=new TanqueAgua(10.0,0.0);
		lleno=false;
		vacio=false;
	}
	
	public void llena(double a){	
		this.vacio=false;
		try
		{			
			System.out.println("\n\n+++++++++++++++Nuevo Procedimiento de LLenado del tanque+++++++++++++++++++++");
			System.out.println("El Tanque 1 llave de Arriba");
			this.tanque1.arriba.abre_llave();
			this.tanque1.llenaTanque(a);
			System.out.println("Se han agregado: "+a+" gal. Al tanque 1.\nActualmente hay: "+this.tanque1.volumen+ "gal.");
			System.out.println("Todavia hay capacidad para: "+(this.tanque1.capacidad-this.tanque1.volumen));
			System.out.println("La Tanque 1 llave de Arriba");
			this.tanque1.arriba.cierraLlave();
		 }catch(Desbordamiento u)
		  {
			try
			{
			 System.out.println("El tanque uno tienen actulmente: "+this.tanque1.volumen);			
			 System.out.println("Se ha llenado el Tanque 1");
			 System.out.println("La Tanque 2 llave de Arriba");
			 this.tanque2.arriba.abre_llave();			
		     this.tanque2.llenaTanque(u.galones);
		     System.out.println("Se han agregado: "+u.galones+" gal. Al tanque 2.\nActualmente hay: "+this.tanque2.volumen+ "gal.");
			 System.out.println("Todavia hay capacidad para: "+(this.tanque2.capacidad-this.tanque2.volumen));
		     System.out.println("La Tanque 1 llave de Cerrada");
			 this.tanque1.arriba.cierraLlave();
			 System.out.println("La Tanque 2 llave de Arriba");
			 this.tanque2.arriba.cierraLlave();
			}catch(Desbordamiento e)
			  {
				lleno=e.desbordado;
				System.out.println("Hay demasiada agua en ambos tanque, se debe vaciar");
				System.out.println("El tanque uno tienen actulmente: "+this.tanque1.volumen);
				System.out.println("El tanque dos tienen actulmente: "+this.tanque2.volumen);
				System.out.println("La Tanque 1 llave de Cerrada");
				 this.tanque1.arriba.cierraLlave();
				System.out.println("La Tanque 2 llave de Arriba");
				 this.tanque2.arriba.cierraLlave();
			  }
			
		   }
	}
	
	public void vacia(double a){
		this.lleno=false;
		try
		{
			System.out.println("\n\n+++++++++++++++Nuevo Procedimiento de Vaciado del tanque+++++++++++++++++++++");
			System.out.println("La Tanque 1 llave de Abajo");
			this.tanque1.abajo.abre_llave();
			this.tanque1.vaciaTanque(a);
			System.out.println("Se han quitado: "+a+" gal. Al tanque 1.\nActualmente hay: "+this.tanque1.volumen+ "gal.");
			System.out.println("Todavia se puede quitar: "+this.tanque1.volumen);
			System.out.println("La Tanque 1 llave de Abajo");
			this.tanque1.abajo.cierraLlave();
		 }catch(SubDesbordamiento u)
		  {
			try
			{
			 System.out.println("El tanque uno tienen actulmente: "+this.tanque1.volumen);			
			 System.out.println("Se ha vaciado el Tanque 1, se procede a Usar el agua del tanque 2");
			 System.out.println("La Tanque 2 llave de Abajo");
			 this.tanque2.abajo.abre_llave();			
		     this.tanque2.vaciaTanque(u.galones);
		     System.out.println("Se han quitado: "+u.galones+" gal. Al tanque 2.\nActualmente hay: "+this.tanque2.volumen+ "gal.");
			 System.out.println("Todavia hay capacidad para: "+this.tanque2.volumen);
		     System.out.println("La Tanque 1 lave de Abajo");
			 this.tanque1.abajo.cierraLlave();
			 System.out.println("La Tanque 2 llave de Abajo");
			 this.tanque2.abajo.cierraLlave();
			}catch(SubDesbordamiento e)
			  {
				vacio=e.subdevolv;
				System.out.println("Ya no queda agua en la reserva.");
				System.out.println("El tanque uno tienen actulmente: "+this.tanque1.volumen);
				System.out.println("El tanque dos tienen actulmente: "+this.tanque2.volumen);
				System.out.println("La Tanque 1 lave de Abajo");
				 this.tanque1.abajo.cierraLlave();
				 System.out.println("La Tanque 2 llave de Abajo");
				 this.tanque2.abajo.cierraLlave();
			  }
			
		   }		 
			 
	}
	
	
	public static void main(String arg[]){
	ComportamientoTanque Test=new ComportamientoTanque();
	 Object[] options = { "INTRODUCIR AGUA", "SACAR AGUA","CANCELAR" };
	 while(true){
	 int i=JOptionPane.showOptionDialog(null, "Selecciona una opcion", "IDAAN",JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null, options, options[0]);
		if(i==JOptionPane.YES_OPTION)
		{
			if(Test.lleno)
				 JOptionPane.showMessageDialog(null,"El tanque esta lleno");
			 else{
			 double a=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de agua"));
			 Test.llena(a);
			 }
		}
		else if(i==JOptionPane.NO_OPTION)
		{
			if(Test.vacio)
				JOptionPane.showMessageDialog(null,"Tanque sin agua");
			else{
			double a=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de agua"));
			Test.vacia(a);}
		  }			
		  else
			System.exit(0);
		}	
	}
	
}
