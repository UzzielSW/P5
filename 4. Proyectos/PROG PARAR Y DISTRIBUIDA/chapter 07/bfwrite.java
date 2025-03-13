import java.io.*;
class p7{
public static void main(String BDP[]) throws IOException{
	FileOutputStream f=new FileOutputStream("java1.txt");
		String s="Hello";
		byte b[]=s.getBytes();
		f.write(b);
		f.close();
	}
}
