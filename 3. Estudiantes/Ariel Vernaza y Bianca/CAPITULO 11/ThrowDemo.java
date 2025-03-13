import java.io.*;

public class ThrowDemo
{
	public static void main(String [] args)
	{
		System.out.println("Inside main");
		if(args.length == 0)
		{
			throw new ArrayIndexOutOfBoundsException(5);
		}

		try
		{
			method1(args[0]);
		}catch(IOException e)
		{
			System.out.println("Sorry, but an exception occurred");
			return;
		}
		System.out.println("End of main");
	}

	public static void method1(String fileName) throws IOException
	{
		System.out.println("Inside method1");
		try
		{
			method2(fileName);
		}catch(IOException e)
		{
			System.out.println("Something went wrong!");
			e.printStackTrace();
			throw e;
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