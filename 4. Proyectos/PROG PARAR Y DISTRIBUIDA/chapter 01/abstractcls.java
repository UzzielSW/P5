//abstractcls.java
abstract class A{
	abstract void show(); // declaring abstract method
	void display(){ //implemented normal method
		System.out.println("Hello"); 
	}
}
class B extends A{
	void show(){ //implemented abstract method
		System.out.println("World");  }
}
class C{
	public static void main(String BDP[]){
		B b=new B(); //creating object for subclass
		b.display();// calling super class method
		b.show();  // calling super class abstract method
	} 
}	
