//minher.java
class A{
	void display(){ 
		System.out.println("Hello");
	} 
}
class B extends A{
	void show(){ 
		System.out.println("Hellow");
	} 
}
class C extends B{ 
	void Print(){ 
	System.out.println("Hellow….");
	} 
}
class D{
	public static void main(String BDP[]){
		C c=new C();
		c.display();
		c.show();
		c.Print();
	}
}
