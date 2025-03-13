public class CatchDemo2
{
	public static void main(String [] args)
	{
		System.out.println("Instantiating a MyFileUtilities2 object...");
		MyFileUtilities2 util = new MyFileUtilities2(args[0]);

		System.out.println("Invoking readOneByte() method...");
		System.out.println(util.readOneByte());
	}
}