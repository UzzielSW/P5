class A{
	public static void main(String BDP[]) {
		try{
			int a1=BDP.length;
			int a=42/a1;
			System.out.println(a);
			try{
				int b[]={1};
				b[10]=20;
			}catch(ArrayIndexOutOfBoundsException ai){
				System.out.println("Array size is low"); 
			}
		}catch(ArithmeticException ae){
				System.out.println("Can't divide by zero"); 
		}
	} 
}
