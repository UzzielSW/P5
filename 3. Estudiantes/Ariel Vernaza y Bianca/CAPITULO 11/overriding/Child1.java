import java.net.SocketException;

public class Child1 extends Parent
{
	public void connect() throws SocketException
	{
		System.out.println("Inside connect() in Child1");
		throw new SocketException();
	}
}