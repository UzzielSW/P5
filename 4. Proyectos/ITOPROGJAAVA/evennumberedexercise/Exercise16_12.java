// Exercise16_12.java: Improve Example 16.2
import java.applet.*;

public class Exercise16_12
  extends ClockAppletWithAudio {
  // Declare a thread for announcing time
  AnnounceTime announceTime = new AnnounceTime();

  /**Initialize the applet*/
  public void init() {
    super.init();
  }

  /**Override this method defined in ClockAppletWithAudio
     to announce the current time at every minute*/
  public void announceTime(int s, int m, int h) {
    // Announce current time
    if (s == 0) {
      announceTime.setHourAudio(hourAudio[h%12]);
      // Load the minute file
      minuteAudio = getAudioClip(getDocumentBase(),
        "timeaudio/minute" + m + ".au");
      announceTime.setHourAudio(minuteAudio);

      if (h < 12)
        announceTime.setAmPm(amAudio);
      else
        announceTime.setAmPm(pmAudio);

     announceTime.start();
    }
  }
}

// Define a thread class for announcing time
class AnnounceTime extends Thread {
  private AudioClip hourAudio, minuteAudio, amPM;

  public void setHourAudio(AudioClip hourAudio) {
    this.hourAudio = hourAudio;
  }

  public void setMinuteAudio(AudioClip minuteAudio) {
    this.minuteAudio = minuteAudio;
  }

  public void setAmPm(AudioClip amPM) {
    this.amPM = amPM;
  }

  public void run() {
    if (hourAudio == null || minuteAudio == null || amPM == null)
      return;

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