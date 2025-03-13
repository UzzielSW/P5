class DP implements Runnable{
	int sum=0;
	Thread t;
	int aa[]=new int[20];
	String name;
	int beg, end;
	static int ln=0;
	DP(String str, int st,int en){
			t=new Thread (this,str);
			beg=st;
			end=en;
			name=str;
			t.start();
	}
	public void run(){
			try{
				for(int i=beg; i<end;i++) { 
					aa[i]=i; sum=aa[i]; 
					System.out.println("Thread "+name +" "+sum);
					ln=ln+1;
					if(ln==4){ 
						System.out.println("\n");ln=0;
					}
					t.sleep(200);
				}			
		      }catch(Exception e){}	
	}
	public static void main(String BDP[]){
		DP b1=new DP("task1",0,5);  // task 1 (thread 1) will use array element with 0 to 4
		DP b2=new DP("task2",5,10);  // task 2 (thread 2) will use array element with 5 to 9
		DP b3=new DP("task3",10,15);  // task 3 (thread 3) will use array element with 10 to 14
		DP b4=new DP("task4",15,20);  // task 4 (thread 4) will use array element with 15 to 19
	}
}
