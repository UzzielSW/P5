class myexception extends Exception{
	myexception(int a){	}
	public String toString(){	return " <<< BUBBLESORT : '0' Founded >>> ";	}
}

public class bubblesort extends Thread{
 int[] data;
 int n;
 void  check(int a,int b) throws myexception{	 if (a==0||b==0) throw new myexception(a);	  }

 public bubblesort(int[] data,int n){
 this.data=data;
 this.n=n; }

public void bsort(){
System.out.println("\n\nSorting data of Bubble Sorting: ");
		for(int i=0;i<=n;i++)
			System.out.print("\t"+data[i]);
}

 public void run(){
 int i; int j; int temp; int t=0;
  try{
   for (i=0;i<=n-1;i++){
    for (j=i+1;j<=n;j++){
     check(data[i],data[j]);
     if (data[i]>data[j]){
       temp=data[i];
      data[i]=data[j];
      data[j]=temp;
      t++;
      if(t%10==0){
        System.out.print("B ");
        try{
		sleep(500);
	}catch (InterruptedException e){};
	 }     }    }   }
   System.out.println();
   System.out.println("\n\n*** Thread BUBBLESORT ["+t+"] done ***");
   System.out.println();

boolean b=false;
	if(b=isAlive()) bsort();

  }catch(myexception e){System.out.println(e);}
 } }
