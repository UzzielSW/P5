//@author: j.n.magee 11/11/96
//package concurrency.semaphore;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
//import concurrency.display.*;

/********************************************************/

class MutexLoop implements Runnable {

    Semaphore mutex;

    MutexLoop (Semaphore sema) {mutex=sema;}

    public void run() {
      try {
        while(true)  {
           while(!ThreadPanel.rotate());
            // get mutual exclusion
            mutex.down();
            while(ThreadPanel.rotate()); //critical section
            //release mutual exclusion
            mutex.up();
        }
      } catch(InterruptedException e){}
    }
}

/********************************************************/

public class SemaDemoPin extends Frame {

/* Agregado por Prof. Álvaro Pino N. */
	 
	private static final long serialVersionUID = 1L;
    ThreadPanel thread1;
    ThreadPanel thread2;
    ThreadPanel thread3;
    NumberCanvas semaDisplay;

    public SemaDemoPin(String name){
    	super(name);
        setLayout(new BorderLayout());
        semaDisplay = new NumberCanvas("Mutex");
        add("Center",semaDisplay);
        Panel p = new Panel();
        p.add(thread1=new ThreadPanel("Thread 1",Color.blue,true));
        p.add(thread2=new ThreadPanel("Thread 2",Color.blue,true));
        p.add(thread3=new ThreadPanel("Thread 3",Color.blue,true));
        add("South",p);
        
          /* agregado para cerrar la ventana */
     
    this.addWindowListener( new WindowAdapter() 
	{
		public void windowClosing(WindowEvent e)
		{ 
			System.exit(0);
		}
	});
	
	   Semaphore mutex = new DisplaySemaphore(semaDisplay,1);
        thread1.start(new MutexLoop(mutex));
        thread2.start(new MutexLoop(mutex));
        thread3.start(new MutexLoop(mutex));
	
        
    this.setTitle("SemaDemoPin");
	this.setSize(500,400);
	this.setResizable(false);
	this.setLocationRelativeTo(null);
  //  this.show();
	this.setVisible(true); 
    }

    public void start() {
        Semaphore mutex = new DisplaySemaphore(semaDisplay,1);
        thread1.start(new MutexLoop(mutex));
        thread2.start(new MutexLoop(mutex));
        thread3.start(new MutexLoop(mutex));

    }

    public void stop() {
        thread1.stop();
        thread2.stop();
        thread3.stop();
    }
    
    public static void main(String [] args)
{
	 SemaDemoPin frame = new SemaDemoPin("SemaDemoPin");
//	frame.lanza();
	
}
    
}

