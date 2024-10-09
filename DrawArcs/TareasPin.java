
/**
 * @(#)TareasPin.java
 *
 *http://chuwiki.chuidiang.org/index.php?title=Clase_Calendar_de_Java#Fecha.2FHora_actual
 * @author
 * @version 1.00 2021/10/14
 */

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class TareasPin {

    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask tt = new TimerTask() {
            public void run() {
                Calendar cal = Calendar.getInstance();

                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int min = cal.get(Calendar.MINUTE);
                System.out.println(hour+" "+min);
                if (hour == 16 && min == 24) {
                    //   Calendar today = Calendar.getInstance();
// System.out.println("Today is " + today.getTime());
                    Calendar today = Calendar.getInstance();
                    today.add(Calendar.DAY_OF_MONTH, 20);
                    System.out.println("Today plus 20 days : " + today.getTime());

                    today = Calendar.getInstance();
                    today.add(Calendar.DAY_OF_MONTH, -20);
                    System.out.println("Today minus 20 days : " + today.getTime());

                }
            }
        };
        timer.schedule(tt, 1000, 5000);
    }

}
