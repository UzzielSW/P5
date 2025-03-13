class A{
	void display(){  // overloading function
		String a1="Hellow1"; 
	}  
	void display(int a){ // overloading function
		String a1="Hellow";
		System.out.println(a1+a);
	}
	void display(int a, int b){ // overloading function
		String a1="Hellow";
		System.out.println(a1+a+b);
	}
}
class share1{
	public static void main(String BDP[]){
		A a=new A(); // the following display methods will utilize same memory during the execution
		a.display();
		a.display(10);
		a.display(1,1);
	}
}
