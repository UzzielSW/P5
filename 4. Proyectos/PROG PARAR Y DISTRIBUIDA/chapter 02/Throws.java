class A {
	static void display() throws IllegalAccessException {
		throw new IllegalAccessException("Hello"); 
		}
	public static void main(String BDP[]){
		try{
			display();
		}catch(IllegalAccessException a) {
			System.out.println("Caught"+a);
		}
	} 
}	
