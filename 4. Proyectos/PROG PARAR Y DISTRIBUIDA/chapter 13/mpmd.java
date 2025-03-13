class MPMD implements Runnable{
	Thread t;
	String name;
	int a,b,sum;
	MPMD(String str, int val1,int val2){
		t=new Thread (this,str);
		name=str;
		a=val1;
		b=val2;
		t.start();	
	}
	public void run(){
	   try{	
	   	if(name.equals("add")){
			sum=a+b;  // program 1
			System.out.println("the sum is "+ sum + " produced by " + name +" thread");
			t.sleep(200); // this is needed only if you running this program on single processor	
		}
	    if(name.equals("sub")){
			sum=a-b; // program 2
			System.out.println("the sum is "+ sum + " produced by " + name +" thread");
			t.sleep(200); // this is needed only if you running this program on single processor	
		}
		if(name.equals("mul")){
		sum=a*b; // program 3
		System.out.println("the sum is "+ sum + " produced by " + name +" thread");
		t.sleep(200); // this is needed only if you running this program on single processor	
		}
		if(name.equals("div")){
		sum=a/b; // program 4
		System.out.println("the sum is "+ sum + " produced by " + name +" thread");
		t.sleep(200); // this is needed only if you running this program on single processor	
		}
		 }catch(Exception e){}	
}
	public static void main(String BDP[]){
		MPMD b1=new MPMD("add",5,5);      // value 1
		MPMD b2=new MPMD("sub",50,25);  // value 2
		MPMD b3=new MPMD("mul",10,10); // value 3
		MPMD b4=new MPMD("div",100,5);  // value 4  
	}
}
