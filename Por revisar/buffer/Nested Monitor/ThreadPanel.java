//@author: j.n.magee 11/11/96
//package concurrency.display;
/*
@author  j.n.magee 14/11/96
*/
//package concurrency.buffer;

/*
 * ThreadPanel.java
 *@author  j.n.magee 20/04/98
*
* Modificado por Prof. �lvaro Pino N.
 * Fecha: 19/09/2021
*/
import java.awt.*;
import java.applet.*;

/********************************************************/

public class ThreadPanel extends Panel {
	private static final long serialVersionUID = 1L;
    Button run;
    Button pause;
    Scrollbar bar_;
    DisplayThread thread_;
    GraphicCanvas canvas_;
    boolean hasSlider;
    boolean suspended;
     public ThreadPanel(String title, Color c) {
        this(title,c,false);
    }

    public ThreadPanel(String title, Color c, boolean hasSlider) {
        super();
        this.hasSlider=hasSlider;
        // Set up Buttons
        this.setFont(new Font("Helvetica",Font.BOLD,14));
        Panel p = new Panel();
        p.add(run=new Button("Run"));
        p.add(pause=new Button("Pause"));
        setLayout(new BorderLayout());
        add("South",p);
        canvas_ = new GraphicCanvas(title,c);
        add("North",canvas_);
        bar_ = new Scrollbar(Scrollbar.HORIZONTAL, 30, 10, 2, 58);
        if (hasSlider) add("Center",bar_);
    }

    public static boolean rotate() throws InterruptedException {
        return DisplayThread.rotate();
    }

    public static void rotate(int degrees) throws InterruptedException {
        for(int i=0;i<degrees;i+=6)
            DisplayThread.rotate();
    }

    public static void setSegmentColor(Color c) {
        DisplayThread.setSegmentColor(c);
    }

    public void start(Runnable r) {
        thread_ = new DisplayThread(canvas_,r,100,hasSlider?bar_.getValue():0,true);
        thread_.start();
    }

    public Thread start(Runnable r, boolean suspended) {
        thread_ = new DisplayThread(canvas_,r,100,hasSlider?bar_.getValue():0,suspended);
        thread_.start();
        return thread_;
    }

    public void stop() {
       // thread_.interrupt();
        suspended = true;
        //thread_.stop();  //required for Java 1.0
    }

//public boolean processEvent(AWTEvent event){
    public boolean handleEvent(Event event) {
       if(event.target==run && event.id == event.ACTION_EVENT) {
            thread_.activate();
            return true;
       } else if(event.target==pause && event.id == event.ACTION_EVENT) {
            thread_.passivate();
            return true;
       } else if(event.target==bar_) {
            thread_.setSplit(bar_.getValue());
            return true;
       } else
            return super.handleEvent(event);
            //return super.processEvent(event);
    }
}

/********************************************************/

class DisplayThread extends Thread {

    GraphicCanvas display_;
    boolean suspended = true;
    int angle_=0;
    int segStart_=9999;
    int segEnd_=9999;
    int rate_;
    final static int step = 6;
    int barValue_;
    Color segColor_=Color.cyan;

    Runnable target_;

    DisplayThread(GraphicCanvas g, Runnable target, int rate, int split, boolean susp) {
        display_ = g;
        target_=target;
        rate_=rate;
        setSplit(split);
        suspended= susp;
        if (suspended)
            display_.setColor(Color.red);
        else
            display_.setColor(Color.green);
    }

    synchronized void mysuspend() throws InterruptedException{
        while (suspended) wait();
    }

    void passivate() {
        if (!suspended) {
            suspended = true;
            display_.setColor(Color.red);
           }
    }

    void activate() {
        if (suspended) {
            suspended = false;
            display_.setColor(Color.green);
            synchronized(this) {notify();}
        }
    }

    static boolean rotate() throws InterruptedException {
        DisplayThread d = (DisplayThread)Thread.currentThread();
        synchronized(d) {
            d.mysuspend();
            d.angle_=(d.angle_+step)%360;
            d.display_.setAngle(d.angle_);
            Thread.sleep(d.rate_);
            return (d.angle_>=d.segStart_ && d.angle_<=d.segEnd_);
        }
    }

    static void setSegmentColor(Color c) {
        DisplayThread d = (DisplayThread)Thread.currentThread();
        synchronized(d) {
            d.segColor_=c;
            d.display_.setSegment(d.segStart_,d.segEnd_,d.segColor_);
        }
    }


    synchronized void setSplit(int i) {
        barValue_ = i;
        segStart_=(60-i)*3;
        segEnd_ = segStart_+i*6;
        display_.setSegment(segStart_,segEnd_,segColor_);
    }

    public void run() {
        try {
          mysuspend();
          target_.run();
          display_.setColor(Color.white);
          display_.setAngle(0);
        } catch (InterruptedException e){}
     }
 }


/********************************************************/

class GraphicCanvas extends Canvas {
		private static final long serialVersionUID = 1L;
    int angle_ = 0;
    String title_;
    Color arcColor_ = Color.blue;
    int segStart_ = 9999;
    int segEnd_ = 9999;
    Color segColor_ = Color.yellow;

    Font f1 = new Font("Times",Font.ITALIC+Font.BOLD,24);

    final static int Cx = 30;
    final static int Cy = 45;

    GraphicCanvas(String title, Color c) {
        super();
        title_=title;
        setSize(150,150);
        arcColor_=c;
  	}

    public void setColor(Color c){
        setBackground(c);
        repaint();
    }

    public void setAngle(int a){
        angle_ = a;
        repaint();
    }

    public void setSegment(int start, int end, Color c) {
        segStart_ = start;
        segEnd_ = end;
        segColor_ = c;
    }

    public void paint(Graphics g){
        update(g);
    }

    Image offscreen;
    Dimension offscreensize;
    Graphics offgraphics;

    public synchronized void update(Graphics g){
        Dimension d = getSize();
	    if ((offscreen == null) || (d.width != offscreensize.width)
	                            || (d.height != offscreensize.height)) {
	        offscreen = createImage(d.width, d.height);
	        offscreensize = d;
	        offgraphics = offscreen.getGraphics();
	        offgraphics.setFont(getFont());
	    }

	    offgraphics.setColor(getBackground());
	    offgraphics.fillRect(0, 0, d.width, d.height);

             // Display the title
         offgraphics.setColor(Color.black);
         offgraphics.setFont(f1);
         FontMetrics fm = offgraphics.getFontMetrics();
         int w = fm.stringWidth(title_);
         int h = fm.getHeight();
         int x = (getSize().width - w)/2;
         int y = h;
         offgraphics.drawString(title_, x, y);
         offgraphics.drawLine(x,y+3,x+w,y+3);
         // Display the arc
         if (angle_>0) {
             if (angle_<segStart_ || segStart_==segEnd_) {
                offgraphics.setColor(arcColor_);
                offgraphics.fillArc(Cx,Cy,90,90,0,angle_);
             } else if ( angle_>=segStart_ && angle_<segEnd_) {
                offgraphics.setColor(arcColor_);
                offgraphics.fillArc(Cx,Cy,90,90,0,segStart_);
                if (angle_-segStart_>0) {
                    offgraphics.setColor(segColor_);
                    offgraphics.fillArc(Cx,Cy,90,90,segStart_,angle_-segStart_);
                }
             } else  {
                offgraphics.setColor(arcColor_);
                offgraphics.fillArc(Cx,Cy,90,90,0,segStart_);
                offgraphics.setColor(segColor_);
                offgraphics.fillArc(Cx,Cy,90,90,segStart_,segEnd_-segStart_);
                if (angle_-segEnd_>0){
                    offgraphics.setColor(arcColor_);
                    offgraphics.fillArc(Cx,Cy,90,90,segEnd_,angle_-segEnd_);
                }
             }
         }
         g.drawImage(offscreen, 0, 0, null);
    }
}

/****************************************************************************/