import java.io.*;
class p5{
	public static void main(String BDP[]) throws IOException{
		FileWriter f=new FileWriter("java.txt");
		f.write("hello");
		f.close();
	}
}
