public class quicksort extends Thread{
 private int[] data;
 private int n;

 public quicksort(int[] data, int n){
	 this.data=data;
	 this.n=n;   }

 void qsort(){
System.out.println("\n\nSorting data of quick Sorting: ");
		for(int i=0;i<=n;i++)
			System.out.print("\t"+data[i]); }

 public void run(){
	 try{
	int r; int s; int temp=0;
	 int n2=n;
	 int tukar=0;
	 boolean done;
	 while(n2>1){
		 n2=(int)(n2/2);
		 do{
			 done=true;
				 for(s=0;s<=n-n2;s++){
					 r=s+n2;
					 if(data[s]>data[r]){
						 temp=data[r];
						 data[r]=data[s];
							 data[s]=temp;
							 tukar++;
							 if(tukar%10==0){
							 System.out.print("Q ");
							 try{
								 sleep(500);
							 }catch (Exception e){};
							 }
							 done=false;
						 } }
			 } while (done==false);		 }

		 System.out.println();
		 System.out.println("\n\n*** Thread QUICKSORT ["+tukar+"] done ***");
		 System.out.println();
boolean b=false;
	if(b=isAlive()) qsort();

	 } catch(Exception e){};
 } }

