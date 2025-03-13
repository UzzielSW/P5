public class Radio
{
	public int volume;		//0 -10
	public float tuning;	//current station tuned in
	public char band;		//'A' for AM or 'F' for FM

	public Radio()
	{
	}

	public Radio(float t)
	{
		tuning = t;
	}

	public void turnOn(int v, float t, char b)
	{
		System.out.println("Turning on the radio");
		setVolume(v);
		setBand(b);
		tuning = t;
	}

	public void setVolume(int volume)
	{
		//make sure the input is valid (between 0 and 10)
		System.out.println("Setting the volume to " + volume);
		if(volume >= 0 && volume <= 10)
		{
			this.volume = volume;
		}
		else
		{
			this.volume = 0;
		}

		//Let's see what happens here
		volume = -5;
	}

	public void setBand(char b)
	{
		System.out.println("Setting the band to " + b);
		//make sure the input is valid ('A' or 'F')
		if(b == 'A' || b == 'F')
		{
			band = b;
		}
		else
		{
			band = 'F';
		}
	}

	public void turnUp()
	{
		System.out.println("Turning the volume up");
		if(volume < 10)
		{
			volume += 1;	//increase volume by 1
		}
	}

	public void turnDown()
	{
		System.out.println("Turning the volume down");
		if(volume > 0)
		{
			volume -= 1;	//decrease volume by 1
		}
	}

	public float getTuning()
	{
		System.out.println("Inside getTuning");
		return tuning;
	}

	public void changeBand()
	{
		System.out.println("Switching bands");
		if(band == 'A')
		{
			band = 'F';
		}
		else
		{
			band = 'A';
		}
	}
}