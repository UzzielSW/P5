//overload.java
class A{
	A(){ // this is an empty constructor
	 	 String a1="Hellow1"; 
	 }
	A(int a){ // this is one paramenter constructor
		String a1="Hellow";
		System.out.println(a1+a);
	}
	A(int a, int b){ // this is two praramter constructor
		String a1="Hellow";
		System.out.println(a1+a+b);
	}
}
class B{ // this is a main class
	public static void main(String BDP[]){
		A a1=new A();
		A a2=new A(10); // constructor passing value
		A a3=new A(1,1); // constructor passing value
	}
}
