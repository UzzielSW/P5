//errfinal.java
class A{
	final void display1(){  
		String a1="Hellow";
	}
	static void display2(){  
		String a1="Hellow";
 	}
}
class B extends A{
	void display1(){  // error will come
		super.display1();
		System.out.println("world"); 
	}
	void display2(){  // error will come
		super.display2();
		System.out.println("world"); 
	}
	public static void main(String BDP[]){
		B a=new B();
		a.display();   
	}
}
