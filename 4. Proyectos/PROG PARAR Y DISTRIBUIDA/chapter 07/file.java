import java.io.*;
class A{
	public static void main(String BDP[]){
			File f=new File("file.java");
			System.out.println(f.getName());
			System.out.println(f.canRead());
			System.out.println(f.canWrite());
			System.out.println(f.getAbsolutePath());
			System.out.println(f.getParent());
			System.out.println(f.isDirectory());
			System.out.println(f.isFile());
			System.out.println(f.length());
 	        System.out.println();
	 }
 }
