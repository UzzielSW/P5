 //modify.java
 class  A {
    private void display1(){ // accessed only inside the class
    	System.out.println("Private method");
    }
   protected void display2(){
    	System.out.println("Protected method");
    }
    public void display3(){
    	display1(); // calling private method
    	display2();// calling protected method
     	System.out.println("Public method");
    }
   }
 class B extends A{
  public static void  main(String args[]) {
	B b=new B();
	b.display2(); // only
	b.display3();
  }
}
