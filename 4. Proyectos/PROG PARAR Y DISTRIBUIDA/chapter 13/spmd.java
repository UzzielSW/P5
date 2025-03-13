class SPMD implements Runnable{ // thread implemented using Runnable
	Thread t;
	String name;
	int a,b,sum;
	SPMD(String str, int val1,int val2){
		t=new Thread (this,str); // creation of thread with different names
		name=str;
		a=val1;
		b=val2;
		t.start();	
	}
	public void run(){  // running a thread
		try{	 
			sum=a+b; // single stream
			System.out.println("the sum is "+ sum + " produced by " + name +" thread");
			t.sleep(200); // this is needed only if you running this program on single processor			
		}catch(Exception e){}
	}
	public static void main(String BDP[]){
		SPMD b1=new SPMD("task1",1,1);  // value 1 ( passes 1,1 to task1)
		SPMD b2=new SPMD("task2",5,5); // value 2 ( passes 5,5 to task12
		SPMD b3=new SPMD("task3",10,10); // value 3 ( passes 10,10 to task3)
		SPMD b4=new SPMD("task4",1,5); // value 4 ( passes 1,5 to task4)
	}
}
