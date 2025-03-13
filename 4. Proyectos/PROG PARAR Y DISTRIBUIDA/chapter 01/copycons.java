//copycons.java
class A{
	A(String a){ // this is a copy constructor
		System.out.println(a);
	}
}
class B{// this is a main class
	public static void main(String BDP[]){
        A a=new A("Hellow"); // constructor passing value
	}
}
