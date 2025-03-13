import customer.service.PhoneHandler;

public class FieldDemo
{
	public static void main(String [] args)
	{
		int call = 1;

		switch(call)
		{
			case PhoneHandler.LOCAL :
				System.out.println("Dial 9");
				break;
			case PhoneHandler.LONG_DISTANCE :
				System.out.println("Dial 8");
				break;
			case PhoneHandler.COLLECT :
				System.out.println("Dial 0");
				break;
		}
	}
}
