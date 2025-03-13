// CalendarPanel.java: Display calendar for a month
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.util.*;
import java.text.*;

public class CalendarPanel extends JPanel {
  private int month;
  private int year;

  // The header label
  private JLabel jlblHeader = new JLabel(" ", JLabel.CENTER);

  // Labels to display day names and days
  private JLabel[] jlblDay = new JLabel[49];

  // MyCalendar instance
  private MyCalendar calendar = new MyCalendar();

  /** Default constructor */
  public CalendarPanel() {
    // Panel jpDays to hold day names and days
    JPanel jpDays = new JPanel();
    jpDays.setLayout(new GridLayout(7, 1));
    for (int i = 0; i < 49; i++) {
      jpDays.add(jlblDay[i] = new JLabel());
      jlblDay[i].setBorder(new LineBorder(Color.black, 1));
      jlblDay[i].setHorizontalAlignment(JLabel.RIGHT);
      jlblDay[i].setVerticalAlignment(JLabel.TOP);
    }

    // Place header and calendar body in the panel
    this.setLayout(new BorderLayout());
    this.add(jlblHeader, BorderLayout.NORTH);
    this.add(jpDays, BorderLayout.CENTER);

    // Set current month, and year
    calendar = new MyCalendar();
    month = calendar.get(Calendar.MONTH) + 1;
    year = calendar.get(Calendar.YEAR);

    // Show calendar
    showHeader();
    showDayNames();
    showDays();
  }

  /** Update the header based on locale */
  private void showHeader() {
    SimpleDateFormat sdf = 
      new SimpleDateFormat("MMMM yyyy", getLocale());
    String header = sdf.format(calendar.getTime());
    jlblHeader.setText(header);
  }

  /** Update the day names based on locale */
  private void showDayNames() {
    DateFormatSymbols dfs = new DateFormatSymbols(getLocale());
    String dayNames[] = dfs.getWeekdays();

    // Set calendar days
    for (int i = 0; i < 7; i++) {
      jlblDay[i].setText(dayNames[i + 1]);
      jlblDay[i].setHorizontalAlignment(JLabel.CENTER);
    }
  }

  /** Display days */
  public void showDays() {
    // Set the calendar to the first day of the
    // specified month and year
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, month-1);
    calendar.set(Calendar.DATE, 1);

    // Get the day of the first day in a month
    int startingDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK);

    // Fill the calendar with the days before this month
    MyCalendar cloneCalendar = (MyCalendar)calendar.clone();
    cloneCalendar.add(Calendar.DATE, -1);

    for (int i = 0; i < startingDayOfMonth - 1; i++) {
      jlblDay[i + 7].setForeground(Color.yellow);
      jlblDay[i + 7].setText(cloneCalendar.daysInMonth() - 
        startingDayOfMonth + 2 + i + "");
    }

    // Display days of this month
    for (int i = 1; i <= calendar.daysInMonth(); i++) {
      jlblDay[i - 2 + startingDayOfMonth + 7].
        setForeground(Color.black);
      jlblDay[i - 2 + startingDayOfMonth + 7].setText(i + "");
    }

    // Fill the calendar with the days after this month
    int j = 1;
    for (int i = calendar.daysInMonth() - 1 + startingDayOfMonth + 7;
      i < 49; i++) {
      jlblDay[i].setForeground(Color.yellow);
      jlblDay[i].setText(j++ + "");
    }

    showHeader();
  }

  /** Return month */
  public int getMonth() {
    return month;
  }

  /** Set a new month */
  public void setMonth(int newMonth) {
    month = newMonth;
    showDays();
  }

  /** Return year */
  public int getYear() {
    return year;
  }

  /** Set a new year */
  public void setYear(int newYear) {
    year = newYear;
    showDays();
  }

  /** Set a new locale */
  public void changeLocale(Locale newLocale) {
    setLocale(newLocale);
    showHeader();
    showDayNames();
  }
}