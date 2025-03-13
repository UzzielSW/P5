
public class DisplayMessage implements Runnable {
	public String str;

	public DisplayMessage(String n) {
		str = n;
	}

	@Override
	public void run() {
		System.out.println(this.str);
	}

}
