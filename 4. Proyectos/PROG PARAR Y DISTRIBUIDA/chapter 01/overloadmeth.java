//overloadmeth.java
class A{
	void display(){  // overloading method
		String a1="Hellow1"; 
		}  
	void display(int a){ // overloading method
		String a1="Hellow";
		System.out.println(a1+a);}
	void display(int a, int b){ // overloading method
		String a1="Hellow";
		System.out.println(a1+a+b);
	} 
}
class B{ // this is a main class
	public static void main(String BDP[]){
		A a=new A();
		a.display();a.display(10);a.display(1,1);//calling overloading methods
	}
}	
