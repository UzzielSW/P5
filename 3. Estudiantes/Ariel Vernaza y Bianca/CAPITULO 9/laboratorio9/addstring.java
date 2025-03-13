public class AddString
{
	public static void main(String [] args)
	{
		StringSorter sorter = new StringSorter();
		sorter.addString("hello");
		sorter.addString("world");
		sorter.addString("applet");
		sorter.addString("Servlet");
		sorter.addString("servlet");
		sorter.addString("java");
		sorter.addString("javac");
		sorter.addString("Java");

		sorter.printList();
	}
}