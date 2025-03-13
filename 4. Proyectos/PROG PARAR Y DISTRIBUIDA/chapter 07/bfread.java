import java.io.*;
class p6{
	public static void main(String BDP[]) throws IOException{
		FileInputStream f=new FileInputStream("bfread.java");
		int i;
			while((i=f.read()) != -1){
			char c= (char)i;
			System.out.print(c);
			} 
	}
}
