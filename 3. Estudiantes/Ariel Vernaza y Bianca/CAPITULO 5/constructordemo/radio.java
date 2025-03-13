public class Radio
{
	public int volume;		//0 -10
	public float tuning;		//current station tuned in
	public char band;		//'A' for AM or 'F' for FM

	public Radio()
	{
		System.out.println("Inside no-argument constructor");
		tuning = 80.0F;
		band = 'F';
		volume = 5;
	}

	public Radio(float t)
	{
		System.out.println("Inside float constructor");
		tuning = t;
		band = 'A';
		volume = 8;
	}

	//the remainder of the class definition...
}
