class MyException extends Exception{
	String details;
	MyException(String a){
		details=a; 
	}
	public String toString() {
		return "MyException["+details+"]"; 
		}
}
class A{
	static void display() throws MyException{
		throw new MyException("Error");
		}
	public static void main(String BDP[]) {
		try{
			display();
		}catch(MyException e) { 
			System.out.println("caught "+ e); 
		}
	}
}	
