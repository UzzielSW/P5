
public class Linear extends Thread {
 int[] data;
 int n;

public Linear(int[] data,int n){
 this.data=data;
 this.n=n;
 }
public void run(){

        int size = data.length;
	for( int i=0;i<size;i++)
		if(n==data[i]){ 
			i=i+1;
		   System.out.println("\n\nLinear Search: The element found at "+i+"'th location of array");	 
		   break;}
      }

}



		