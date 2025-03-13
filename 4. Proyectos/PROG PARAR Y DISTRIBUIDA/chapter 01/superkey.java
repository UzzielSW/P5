//superkey.java
class A{
	String a="Hellow1";
	A(String s){
		System.out.println(s);
	}
	void display(){
		System.out.println("Hellow3");
	}
}
class B extends A{
	B(){
		super("Hellow2");
		super.display();
		System.out.println(super.a);
	 }
}
class C{
	public static void main(String BDP[]){
		B b=new B();
	} 
}	
