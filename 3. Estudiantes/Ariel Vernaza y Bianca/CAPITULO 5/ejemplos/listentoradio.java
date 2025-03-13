public class ListenToRadio
{
	public static void main(String [] args)
	{
		System.out.println("Creating a radio...");
		Radio radio = new Radio();

		System.out.println("...and turning it on...");
		float initialStation = Float.parseFloat(args[0]);
		int initialVolume = 5;
		radio.turnOn(initialVolume, initialStation, 'F');

		System.out.println("The tuning is " + radio.getTuning());

		int x = 7;
		radio.setVolume(x);
		System.out.println("x = " + x);

		radio.turnUp();
		radio.turnUp();
		radio.changeBand();

		System.out.println("The volume is now " + radio.volume + ", the band is "
					+ radio.band + ", and the tuning is " + radio.tuning);
	}
}