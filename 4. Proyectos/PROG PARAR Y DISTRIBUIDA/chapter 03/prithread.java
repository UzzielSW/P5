class A implements Runnable{
String name; int pri; long wait;
Thread t;
A(String name1, int pri1, long wait1){
	t=new Thread (this,name1);
	System.out.println(name1 + " is created");
	t.start();
	t.setPriority(pri1);
	name=name1;
	pri=pri1;
	wait=wait1;
}
public void run(){
	try{
		for(int i=5;i>0;i--){
			System.out.println(name +" : "+ i + " with the priority " + pri);
			Thread.sleep(wait);}
		}catch(InterruptedException e)
		{System.out.println(name + " thread interrupted");}
		System.out.println("Exit " + name + " Thread");}}
class B{
public static void main(String BDP[]) throws Exception{
	new A("one",10,200);
	new A("two",1,100);
	new A("three",5,300); 
	} 
}
