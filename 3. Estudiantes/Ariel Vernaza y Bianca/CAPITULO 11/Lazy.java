import java.io.*;

public class Lazy
{
	private String fileName;

	public Lazy(String name)
	{
		fileName = name;
	}

	public byte readOneByte()
	{
		FileInputStream file = null;
		byte x = -1;

		System.out.println("Opening file for reading...");
		file = new FileInputStream(fileName);
		System.out.println("Just opened file: " + fileName);
		System.out.println("Reading one byte from file...");
		x = (byte) file.read();

		System.out.println("Just read " + x);
		return x;
	}
}