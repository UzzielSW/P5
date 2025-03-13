// ClockAppletWithAudio.java: Display a running clock on the applet
// with audio
import java.applet.*;

public class ClockAppletWithAudio extends CurrentTimeApplet {
  // Declare audio files
  protected AudioClip[] hourAudio = new AudioClip[12];
  protected AudioClip minuteAudio;
  protected AudioClip amAudio;
  protected AudioClip pmAudio;

  // Declare a clock
  ClockWithAudio clock;

  /** Initialize the applet */
  public void init() {
    super.init();

    // Create audio clips for pronouncing hours
    for (int i = 0; i < 12; i++)
      hourAudio[i] = getAudioClip(getCodeBase(),
        "timeaudio/hour" + i + ".au");

    // Create audio clips for pronouncing am and pm
    amAudio = getAudioClip(getCodeBase(), "timeaudio/am.au");
    pmAudio = getAudioClip(getCodeBase(), "timeaudio/pm.au");
  }

  /** Override the plugClock method defined in
     CurrentTimeApplet and plug a new kind of clock to
     CurrentTimeApplet
    */
  public void plugClock() {
    getContentPane().add(clock =
      new ClockWithAudio(locale, timeZone, this));
  }

  /** Announce the current time at every minute */
  public void announceTime(int s, int m, int h) {
    if (s == 0) {
      // Announce hour
      hourAudio[h % 12].play();

      // Load the minute file
      minuteAudio = getAudioClip(getCodeBase(),
        "timeaudio/minute" + m + ".au");

      // Time delay to allow hourAudio play to finish
      try {
        Thread.sleep(1500);
      }
      catch(InterruptedException ex) {
      }

      // Announce minute
      minuteAudio.play();

      // Time delay to allow minuteAudio play to finish
      try {
        Thread.sleep(1500);
      }
      catch(InterruptedException ex) {
      }

      // Announce am or pm
      if (h < 12)
        amAudio.play();
      else
        pmAudio.play();
    }
  }

  /** Implement Applet's start method to resume the thread */
  public void start() {
    clock.resume();
  }

  /** Implement Applet's stop method to suspend the thread */
  public void stop() {
    clock.suspend();
  }
}