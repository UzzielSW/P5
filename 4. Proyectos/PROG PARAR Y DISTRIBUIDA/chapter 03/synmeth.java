class p16 implements Runnable{
Thread t; 
String name;
p16(String name1){
	name=name1;
	t=new Thread (this, name);
	System.out.println(name + " : " + t);
	t.start();}
synchronized public void run(){
	try{
		for(int i=5;i>0;i--){
			System.out.println(name + ":" + i);
			Thread.sleep(500);}
		}catch(InterruptedException e) {System.out.println(name + ":  thread interrupted");}
	System.out.println("Exit "+ name + " Thread");
	} 
}
class B{
public static void main(String BDP[]){
	new p16("one"); 
	new p16("two"); 
	new p16("three"); 
	new p16("four");
	}
}
