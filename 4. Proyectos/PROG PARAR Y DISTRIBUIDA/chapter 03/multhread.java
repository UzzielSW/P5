class A implements Runnable{
String name;
Thread t;
A(String name){
	t=new Thread (this,name);
	System.out.println("child thread:"+ t);
	t.start();}
public void run(){
	try{
		for(int i=5;i>0;i--){
			System.out.println("child thread:"+ i);
			Thread.sleep(500);}
	}catch(InterruptedException e)
	{System.out.println("child thread interrupted");}
	System.out.println("Exit child Thread");}}
class B{
public static void main(String BDP[]){
	new A("one");
	new A("two");
	new A("three");
	try{
		for(int i=5;i>0;i--){
			System.out.println("Main thread:"+ i);
			Thread.sleep(1000);}
	}catch(InterruptedException ie)
	 {System.out.println("Main Thread interrupted");}
	System.out.println("Exit Main Thread");
	} 
}
