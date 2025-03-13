import java.io.*;

public class cp12 extends Thread{
 public static void main(String[] args)throws Exception{

  System.out.println("Enter the N'th value: ");
  DataInputStream input=new DataInputStream(System.in);

  int n=Integer.parseInt(input.readLine());
  int data[]=new int[n]; 	
	for(int i=0;i<n;i++){
			input=new DataInputStream(System.in);
		 data[i]=Integer.parseInt(input.readLine());}

System.out.println("\nEnter the Number you wants to search: ");
	input=new DataInputStream(System.in);
	int v=Integer.parseInt(input.readLine());

 quicksort quick=new quicksort(data,n-1);
           quick.start();

/* System.out.println("Enter given values are: ");
	for(int i=0;i<n;i++)
	System.out.print("\t"+data[i]);
*/


  System.out.println();
  System.out.println("______________________________________________");
  System.out.println("Binary and linear search using MultiThreading");
  System.out.println("______________________________________________");
  System.out.println();
  Linear l=new Linear(data,v);
  Binary b=new Binary(v,data,n);

  l.start(); b.start();

 }
}
