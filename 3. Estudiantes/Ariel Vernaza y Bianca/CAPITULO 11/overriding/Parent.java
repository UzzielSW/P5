import java.io.IOException;

public class Parent
{
	public void connect() throws IOException
	{
		System.out.println("Inside connect() in Parent");
		throw new IOException();
	}
}