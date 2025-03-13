import java.io.*;

public class MyFileUtilities
{
	private String fileName;

	public MyFileUtilities(String name)
	{
		fileName = name;
	}

	public byte readOneByte()
	{
		FileInputStream file = null;

		try
		{
			System.out.println("Opening file for reading...");
			file = new FileInputStream(fileName);
		}catch(FileNotFoundException f)
		{
			System.out.println("** Could not find " + fileName + " **");
			f.printStackTrace();
			return -1;
		}

		System.out.println("Just opened file: " + fileName);

		byte x = -1;
		try
		{
			System.out.println("Reading one byte from file...");
			x = (byte) file.read();
		}catch(IOException i)
		{
			System.out.println("** Error reading one byte **");
			i.printStackTrace();
			return -1;
		}

		System.out.println("Just read " + x);
		return x;
	}
}