class A{
	public static void main(String BDP[]) {
		try{
			int a1=0;
			int a=42/a1;
			System.out.println(a);
			int b[]=new int[1];
			b[10]=20;
		}catch(ArithmeticException ae){
			System.out.println("Can't divide by zero"); 
		}
		catch(ArrayIndexOutOfBoundsException ai) {
			System.out.println("Array size is low"); 
		}
	} 
}

