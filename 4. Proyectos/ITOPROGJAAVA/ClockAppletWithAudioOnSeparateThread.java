// ClockAppletWithAudioOnSeparateThread.java: Display a 
// running clock on the applet with audio on a separate thread
import java.applet.*;

public class ClockAppletWithAudioOnSeparateThread
  extends ClockAppletWithAudio {
  // Declare a thread for announcing time
  AnnounceTime announceTime;

  /** Initialize the applet */
  public void init() {
    super.init();
  }

  /** Override this method defined in ClockAppletWithAudio
     to announce the current time at every minute */
  public void announceTime(int s, int m, int h) {
    // Load the minute file
    minuteAudio = getAudioClip(getCodeBase(),
      "timeaudio/minute" + m + ".au");

    // Announce current time
    if (s == 0) {
      if (h < 12)
        announceTime = new AnnounceTime(hourAudio[h % 12],
          minuteAudio, amAudio);
      else
        announceTime = new AnnounceTime(hourAudio[h % 12],
          minuteAudio, pmAudio);

      announceTime.start();
    }
  }
}

// Define a thread class for announcing time
class AnnounceTime extends Thread {
  private AudioClip hourAudio, minuteAudio, amPM;

  /** Get Audio clips */
  public AnnounceTime(AudioClip hourAudio,
                      AudioClip minuteAudio,
                      AudioClip amPM) {
    this.hourAudio = hourAudio;
    this.minuteAudio = minuteAudio;
    this.amPM = amPM;
  }

  public void run() {
    // Announce hour
    hourAudio.play();

    // Time delay to allow hourAudio play to finish
    // before playing the clip
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
    amPM.play();
  }
}