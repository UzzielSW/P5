class p17a implements Runnable {
Thread t; 
String name;
p17a(String name1){
	name=name1;
	t=new Thread (this, name);
	System.out.println(name + " : " + t);
	t.start();}
void call(){
	try{
		for(int i=5;i>0;i--){
			System.out.println(name + ":" + i);
			Thread.sleep(500);}	
	}catch(InterruptedException e)
 		{System.out.println(name + ":  thread interrupted");}
		 System.out.println("Exit "+ name + " Thread");}
public void run(){
	synchronized(this){ // statement
	   call();  }}
}
class B{
public static void main(String BDP[]){
	new p17a("one"); 
	new p17a("two"); 
	new p17a("three"); 
	new p17a("four");
   }
}
