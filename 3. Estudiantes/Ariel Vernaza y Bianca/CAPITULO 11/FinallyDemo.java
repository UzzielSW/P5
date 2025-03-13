import java.io.FileNotFoundException;

public class FinallyDemo
{
	public static void main(String [] args)
	{
		System.out.println("Instantiating a MyFileUtilities3 object...");
		MyFileUtilities3 util = new MyFileUtilities3(args[0]);

		System.out.println("Invoking readOneByte() method...");

		try
		{
			byte b = util.readOneByte();
			System.out.println(b);
		}catch(FileNotFoundException e)
		{
			System.out.println("Could not find " + args[0]);
			e.printStackTrace();
		}
		System.out.println("End of main");
	}
}