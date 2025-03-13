
public class TanqueAgua{
	public Llaver arriba;
	public Llaver abajo;	
	public double capacidad;
	public double volumen;

	public TanqueAgua(double capacidad,double volumen){
		this.arriba=new Llaver();
		this.abajo=new Llaver();
		this.capacidad=capacidad;
		this.volumen=volumen;
	}
	
	public void llenaTanque(double a) throws Desbordamiento{
		if(this.arriba.abierta)	
			if((this.volumen+a)>this.capacidad){
				double c=(this.volumen+a)-this.capacidad;
				double d=a-c;				
				  volumen+=d;				
				throw new Desbordamiento(c);}
			else
				volumen+=a;
		}
	
	
	public void vaciaTanque(double a) throws SubDesbordamiento{
		if(this.abajo.abierta)
			if((volumen-a)<0){
				double c= (this.volumen-a)*-1;
				double d=a-c;
				volumen-=d;
				throw new SubDesbordamiento(c);
				}
			else
				volumen-=a;
		}

}