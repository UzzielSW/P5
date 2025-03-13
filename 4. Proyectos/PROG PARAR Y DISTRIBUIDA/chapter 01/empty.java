//empty.java
class A{
	A(){ // this is an empty constructor
		String a="Hellow";
		System.out.println(a);
	}
}
class B{ // this is a main class
	public static void main(String BDP[]){
		A a=new A();// after object is created, constructor automatically called
	}
}
