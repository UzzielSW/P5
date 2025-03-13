interface A{ 
	 void display();  
	 void show(); 
}
class B implements A{
	public void display(){  
		System.out.println("Hello"); 
	}
	public void show(){ 
		System.out.println("World"); 
	}
}
class C{
	public static void main(String BDP[]){
		B b=new B();
		b.display();  b.show(); 
	}
}	
