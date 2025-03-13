import java.io.File;
import java.util.TimerTask;
import javax.sound.sampled.*;

public class PhoneRinger extends TimerTask {
	int counter;

	public PhoneRinger() {
		counter = 0;
	}

	public void run() {
		counter++;
		System.out.println("Ring " + counter);
		AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("sword.wav"));
		Clip clip = AudioSystem.getClip();
		clip.open(audioIn);
		clip.start();
	}

	public int getRingCount() {
		return counter;
	}
}
