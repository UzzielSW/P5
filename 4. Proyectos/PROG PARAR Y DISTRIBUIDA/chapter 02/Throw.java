class A{
	static void display(){
		try {
			throw new NullPointerException("Hello");
		}catch(NullPointerException e){ 
			System.out.println("caught inside");
			throw e; 
		}
}
	public static void main(String BDP[]){
		try {
			display();
		}catch(NullPointerException ee) { 
			System.out.println("Recaught"+ ee); 
		}
	}
}	
