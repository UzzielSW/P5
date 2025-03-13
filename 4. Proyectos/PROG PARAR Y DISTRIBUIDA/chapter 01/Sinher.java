//Single.java
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
class C{
	public static void main(String BDP[]){
		B b=new B();
		b.show();
		b.display(); 
	}
}	
