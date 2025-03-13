class B{
	B(){    // constructor overloading
		String a1="Hellow1"; 
	}
	B(int a){  // // constructor overloading
		String a1="Hellow"; System.out.println(a1+a);
	}
	B(int a, int b){ // constructor overloading
		String a1="Hellow"; System.out.println(a1+a+b);
	} 
}
class share2{
	public static void main(String BDP[]){
	// the following constructors will utilize same memory during the execution
		B a1=new B();
		B a2=new B(10);
	    B a3=new B(1,1);
	}
}
