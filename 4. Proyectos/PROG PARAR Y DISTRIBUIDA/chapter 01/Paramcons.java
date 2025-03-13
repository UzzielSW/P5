//Paramcons.java
class A{
	A(int a){ // this is parameter constructor
		String a1="Hellow";
		System.out.println(a1+a);
	}
}
class B{ //  this is a main class
	public static void main(String BDP[]){
       A a=new A(10); // constructor passing value
	}
}
