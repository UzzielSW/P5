class A implements Runnable{
	String name;
	Thread t;
	A(String name1){
		t=new Thread (this,name1);
		name=name1;
		System.out.println(name +" thread:"+ t);
		t.start();
	}
	public void run(){
		try{
			for(int i=5;i>0;i--){
			System.out.println(name + " thread:"+ i);
			Thread.sleep(500);}
		}catch(InterruptedException e){
			System.out.println(name + " thread interrupted");
		}
		System.out.println("Exit " + name + " Thread");
	}
}
class B{
	public static void main(String BDP[]){
		new A("one");
		new A("two");
		new A("three");
		try{
		for(int i=5;i>0;i--){
			System.out.println("Main thread:"+ i);
			Thread.sleep(1000);}
		}catch(InterruptedException ie){
			System.out.println("Main Thread interrupted");
		}
		System.out.println("Exit Main Thread");
	}
}
