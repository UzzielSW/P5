class MPSD implements Runnable{
	Thread t;
	String name;
	int a,b,sum;
	MPSD (String str, int val1,int val2){
		t=new Thread (this,str);
		name=str;
		a=val1;
		b=val2;
		 t.start();	}
	public void run(){
		try{	 
			if(name.equals("add")){
				sum=a+b;  // program 1
				System.out.println("the sum is "+ sum + " produced by " + name +" thread");			
				t.sleep(200);  // this is needed only if you running this program on single processor
			}
			if(name.equals("sub")){
				sum=a-b; // program 2
				System.out.println("the sum is "+ sum + " produced by " + name +" thread");
				t.sleep(200); // this is needed only if you running this program on single processor	
			}
			if(name.equals("mul")){
				sum=a*b;  // program 3
				System.out.println("the sum is "+ sum + " produced by " + name +" thread");
				t.sleep(200); // this is needed only if you running this program on single processor	
			}
			if(name.equals("div")){
				sum=a/b;  // program 4
				System.out.println("the sum is "+ sum + " produced by " + name +" thread");
				t.sleep(200); // this is needed only if you running this program on single processor	
			}
			}catch(Exception e){}	
	}
	public static void main(String BDP[]){
		// Same Values for all add, sub, mul, div tasks	
		MPSD b1=new MPSD ("add",5,5);
		MPSD b2=new MPSD ("sub",5,5);
		MPSD b3=new MPSD ("mul",5,5);
		MPSD b4=new MPSD ("div",5,5);   
	}
}
