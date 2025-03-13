package customer.service;

public interface PhoneHandler
{
	public static final int LOCAL = 0;
	public static final int LONG_DISTANCE = 1;
	public static final int COLLECT = 2;

	public void answer();
	public boolean forward(int extension);
	public void takeMessage(String message, String recipient);
}
