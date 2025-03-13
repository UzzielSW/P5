
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
	
	public void llenaTanque() throws Desbordamiento{
	if(this.arriba.abierta)	
		if((volumen+2.00)>this.capacidad){
			double c=(volumen+2.00)-capacidad;
			double d=2.00-c;
			volumen+=c;
			throw new Desbordamiento(d);}
		else
			volumen+=2.00;
	}
	public void llenaTanque(double a) throws Desbordamiento{
		if(this.arriba.abierta)	
			if((volumen+a)>this.capacidad){
				double c=(volumen+a)-capacidad;
				double d=a-c;
				volumen+=c;
				throw new Desbordamiento(d);}
			else
				volumen+=a;
		}
	
	public void vaciaTanque() throws SubDesbordamiento{
	if(this.abajo.abierta)
		if((volumen-2.00)<0){
			double c= (this.volumen-2.00)*-1;
			double d=2.00-c;
			volumen-=c;
			throw new SubDesbordamiento(c);
			}
		else
			volumen-=2.00;
	}
	
	public void vaciaTanque(double a) throws SubDesbordamiento{
		if(this.abajo.abierta)
			if((volumen-a)<0){
				double c= (this.volumen-a)*-1;
				double d=a-c;
				volumen-=c;
				throw new SubDesbordamiento(c);
				}
			else
				volumen-=a;
		}

}