public class Child3 extends Parent
{
	public void connect() throws Exception
	{
		System.out.println("Inside connect() in Child3");
		throw new Exception();
	}
}