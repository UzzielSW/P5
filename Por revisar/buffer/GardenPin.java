// j.n.magee 11/11/96
//package concurrency.garden;
/* @author: Jeff Magee
 * Modificado por Prof. Álvaro Pino N.
 * Fecha: 11/09/2021
*/
import java.awt.*;
//import java.applet.*;
import java.awt.event.*;
//import concurrency.display.*;

public class GardenPin extends Frame {
/* Agregado por Prof. Álvaro Pino N. */
	 
	private static final long serialVersionUID = 1L;

    Button goButton;
    Turnstile west;
    Turnstile east;
    Counter counter;
    NumberCanvas counterD;
    NumberCanvas westD;
    NumberCanvas eastD;
    Checkbox fixit;
    public final static int MAX = 20;


    public GardenPin(String name) {
        super(name);
        // Set up Button and Checkbox
        Panel p0= new Panel();
        p0.add(goButton = new Button(" Go "));
        goButton.setFont(new Font("Helvetica",Font.BOLD,24));
        Panel p1= new Panel();
        p1.setLayout(new BorderLayout());
        p1.add("Center",p0);
        p1.add("East",fixit = new Checkbox("Fix It"));
        // Set up Display
        Panel p2 = new Panel();
        counterD = new NumberCanvas("Counter");
        westD   = new NumberCanvas("West",Color.green);
        eastD   = new NumberCanvas("East",Color.green);
        
        
        //counterD.resize(150,100);
        counterD.setSize(150,100);
        
        //westD.resize(100,100);
        westD.setSize(100,100);
        
        //eastD.reSize(100,100);
        eastD.setSize(100,100);
        
        p2.add(westD);
        p2.add(counterD);
        p2.add(eastD);
        // Arrange Applet display
        setLayout(new BorderLayout());
        add("Center",p2);
        add("South",p1);
         /* agregado para cerrar la ventana */
     
    this.addWindowListener( new WindowAdapter() 
	{
		public void windowClosing(WindowEvent e)
		{ 
			System.exit(0);
		}
	});
        
        this.setTitle("Garden");
	this.setSize(600,300);
	this.setResizable(false);
	this.setLocationRelativeTo(null);
  //  this.show();
	this.setVisible(true);
    }

    private void go() {
        if (!fixit.getState())
            counter = new Counter(counterD);
        else
            counter = new SynchronizedCounter(counterD);
        west= new Turnstile(westD,counter);
        east= new Turnstile(eastD,counter);
        west.start();
        east.start();
    }

    public boolean handleEvent(Event event) {
        if (event.id != event.ACTION_EVENT) {
            return super.handleEvent(event);
        } else if(event.target==goButton) {
            if (west==null && east==null)
                     go();
            else if (!west.isAlive() && !east.isAlive())
                     go();
            return true;
        } else
            return super.handleEvent(event);
    }

}

class Counter {

    int value=0;
    NumberCanvas display;

    Counter(NumberCanvas n) {
        display=n;
        display.setvalue(value);
    }

    void increment() {
        int temp = value;   //read[v]
        Simulate.HWinterrupt();
        value=temp+1;       //write[v+1]
        display.setvalue(value);
    }
}

class SynchronizedCounter extends Counter {

  SynchronizedCounter(NumberCanvas n)
     {super(n);}

   synchronized void increment() {
        super.increment();
   }
}


class Turnstile extends Thread {
  NumberCanvas display;
  Counter people;

  Turnstile(NumberCanvas n,Counter c)
    { display = n; people = c; }

  public void run() {
    try{
      display.setvalue(0);
      for (int i=1;i<=Garden.MAX;i++){
        Thread.sleep(500); //0.5 second
        display.setvalue(i);
        people.increment();
      }
    } catch (InterruptedException e) {}
  }
}

class Simulate {
    public static void HWinterrupt() {
        if (Math.random()<0.5)
           try{Thread.sleep(200);} catch(InterruptedException e){};
            //used instead of Thread.yield() to ensure portability
    }
    
    public static void main(String [] args)
{
	 GardenPin frame = new GardenPin("Garden Pin");
//	frame.lanza();
	
}
}
