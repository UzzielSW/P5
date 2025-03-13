import java.util.Timer;

import javax.print.SimpleDoc;

public class TimerDemo
{
	public static void main(String [] args)
	{
		//se programa una tarea que se ejecuta indefinidamente cada cierto tiempo.
		//en este caso se crea un Object sin referencia y se ejecuta la tarea de mostrar el garbage collerctor.
		Timer timer = new Timer();
		GCTask task = new GCTask();
		//tarea, delay, periodo
		timer.schedule(task, 5000, 5000);

		int counter = 1;
		while(true)
		{
			new SimpleObject("Object" + counter++);

			try
			{
				Thread.sleep(500);
			}catch(InterruptedException e)
			{}
		}
	}
}
