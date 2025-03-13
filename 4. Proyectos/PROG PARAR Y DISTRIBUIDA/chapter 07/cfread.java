import java.io.*;
class p4{
	public static void main(String BDP[]) throws IOException{
		FileReader f=new FileReader("cfread.java");
		BufferedReader br=new BufferedReader(f);
		String s;
		while((s=br.readLine()) != null) 
		System.out.println(s);
	}
}
