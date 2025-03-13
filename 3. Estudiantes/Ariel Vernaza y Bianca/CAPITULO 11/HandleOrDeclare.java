import java.io.*;

public class HandleOrDeclare
{
	public static void main(String [] args)
	{
		System.out.println("Inside main");
		method1(args[0]);
	}

	public static void method1(String fileName)
	{
		System.out.println("Inside method1");
		try
		{
			method2(fileName);
		}catch(IOException e)
		{
			System.out.println("Something went wrong!");
			e.printStackTrace();
		}
		System.out.println("Leaving method1");
	}

	public static void method2(String fileName) throws IOException
	{
		System.out.println("Inside method2");
		NotSoLazy util = new NotSoLazy(fileName);
		System.out.println(util.readOneByte());
		System.out.println("Leaving method2");
	}
}