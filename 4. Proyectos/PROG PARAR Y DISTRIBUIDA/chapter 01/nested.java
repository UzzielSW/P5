//nested.java
class A{ // this is an outer class 
		void display(){ 
			System.out.println("Hello");
			new B().display1(); // calling inner class method 
		} 
	class B{ // this is an inner class
		void display1(){
			System.out.println("Hello");
	} 
	}
}
class c{ // this is a main class
	public static void main(String BDP[]){
		A a=new A(); 
		a.display(); // calling outer class method
	} 
}	
