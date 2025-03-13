public class Puesto{
	
	private int numero;
	private boolean estado;
	private String cliente;
	
	public Puesto(int n) {
	numero = n;
	}
	
	public Puesto(String c ){
		cliente = c;
		estado = true;
	}
	
	public void setName(String c){
		estado = true;
		cliente = c;
		System.out.println(" nombre del cliente cambiado ");
	}
	
	public void setNumber( int n){
		numero = n;
	}
	
	public void display(){
		System.out.print(" el puesto # " + numero + "esta " + verificaPuesto() );
		if(cliente != null)
			System.out.println(" el puesto lo reservo el cliente: " + cliente);
	}
	
	public String verificaPuesto(){
		if ( estado == true )
			return ("ocupado");
		else return ("desocupado");
	}
	public int getNumber(){ return numero; }
	public String getName(){ return cliente; }
	
}
