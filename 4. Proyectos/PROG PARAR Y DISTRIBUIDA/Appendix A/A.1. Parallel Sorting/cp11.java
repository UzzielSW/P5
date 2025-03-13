import java.io.*;
public class cp11 extends Thread{
public static void main(String[] args)throws Exception{

  System.out.println("Enter the N'th value: ");
  DataInputStream input=new DataInputStream(System.in);

  int n=Integer.parseInt(input.readLine());
  int data[]=new int[n];
	for(int i=0;i<n;i++){
		input=new DataInputStream(System.in);
		 data[i]=Integer.parseInt(input.readLine());}

System.out.println("Enter given values are: ");
	for(int i=0;i<n;i++)
	System.out.print("\t"+data[i]);

  System.out.println();
  System.out.println("_________________________________________");
  System.out.println("Bubblesort and Quicksort MultiThreading");
  System.out.println("_________________________________________");
  System.out.println();
  bubblesort bubble=new bubblesort(data,n-1);
  quicksort quick=new quicksort(data,n-1);
  bubble.start(); quick.start(); }}

