import java.io.*;

public class MyFileUtilities3
{
	private String fileName;

	public MyFileUtilities3(String name)
	{
		fileName = name;
	}

	public byte readOneByte() throws FileNotFoundException
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
			System.out.println("Could not find " + fileName);
			throw f;
		}catch(IOException i)
		{
			System.out.println("Error reading one byte");
			i.printStackTrace();
			return -1;
		}finally
		{
			System.out.println("** Inside finally block **");
			try
			{
				if(file != null)
				{
					file.close();
				}
			}catch(IOException e)
			{}
		}

		System.out.println("Just read " + x);
		return x;
	}
}