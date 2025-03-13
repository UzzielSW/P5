class A{
	public static void main(String BDP[]) {
		try{
			int d=0;
			int a=42/d;
			System.out.println(a);
			}catch(ArithmeticException ae){
			 System.out.println("Can't divide by zero"); 
			}
	} 
}	
