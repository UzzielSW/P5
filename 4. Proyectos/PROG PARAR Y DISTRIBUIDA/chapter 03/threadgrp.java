class p18 implements Runnable{
	Thread t; 
	String name;
	ThreadGroup tg;
	p18(String name1){
		name=name1;
		tg=new ThreadGroup ("one");
		t=new Thread (tg,this, name);
		System.out.println(name + " : " + t);
		t.start();
		}
	public void run(){
		try{
			for(int i=5;i>0;i--){
				System.out.println(name + ":" + i);
				Thread.sleep(500);}
		}catch(InterruptedException e) {
			System.out.println(name + ":  thread interrupted");}
		System.out.println("Exit "+ name + " Thread");
		}
	public static void main(String BDP[]) throws Exception{
		new p18("one"); 
		new p18("two"); 
		new p18("three"); 
		new p18("four");
	}
}
