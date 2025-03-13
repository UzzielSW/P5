import java.io.*;

public class MyFileUtilities2
{
	private String fileName;

	public MyFileUtilities2(String name)
	{
		fileName = name;
	}

	public byte readOneByte()
	{
		FileInputStream file = null;
		byte x = -1;

		try
		{
			System.out.println("Opening file for reading...");
			file = new FileInputStream(fileName);
			System.out.println("Just opened file: " + fileName);
			System.out.println("Reading one byte from file...");
			x = (byte) file.read();

		}catch(FileNotFoundException f)
		{
			System.out.println("** Could not find " + fileName + " **");
			f.printStackTrace();
			return -1;
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