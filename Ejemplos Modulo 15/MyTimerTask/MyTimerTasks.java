
/**
 * @(#)MyTimerTasks.java
 *
 *
 * @author 
 * @version 1.00 2021/10/12
 */

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Creates a new instance of <code>MyTimerTasks</code>.
 */

public class MyTimerTasks extends TimerTask {

    @Override
    public void run() {
        System.out.println("Timer task started at:" + new Date());
        completeTask();
        System.out.println("Timer task finished at:" + new Date());
    }

    private void completeTask() {
        try {
            // assuming it takes 20 secs to complete the task
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * javadoc -sourcepath src -classpath lib -d apidocs \
     * -docletpath umldoclet-2.x.jar -doclet nl.talsmasoftware.umldoclet.UMLDoclet \
     * com.foobar*
     *
     */
    public static void main(String args[]) {
        TimerTask timerTask = new MyTimerTasks();
        // running timer task as daemon thread
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 10000);
        System.out.println("TimerTask started");
        // cancel after sometime
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        System.out.println("TimerTask cancelled");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
