public class Binary extends Thread {
int v=0,n=0,i=0;
int[] data;

int low =0, high =0;

  /* public static int search (int v, int[] data) {
      return search (v, data, 0, data.length);
   }*/

public Binary(int v,int[] data,int n){
 this.data=data;
 this.n=n;
 this.v=v;
 }

   public int search (int v, int[] data, int n) {
      return search (v, data, 0, n);
   }

   public int search (int v, int[] data, int first, int n)  {
     try{
     
      low = first; high = n;
         int mid=0;
      while (low <= high) {
			mid = (low+high) / 2;
		         if (data[mid] == v) {   return mid; } 
			   else if (data[mid] < v) { 
				     low = mid+1;    } 
		 	   else {
//          		    assert data[mid] > v;
		             high = mid-1;    }
			      Thread.sleep(500);
			      }
			      
      return -1;
   }catch(Exception e) {}

public void run(){
	
      
	i = search (v, data, n);

      if (i==-1) {     System.out.println ("\n\n"+v+" not found");  } 
            else {    i=i+1; System.out.println("\n\nBinary Search: The element found at "+i+"'th location of array");}
    }
}
