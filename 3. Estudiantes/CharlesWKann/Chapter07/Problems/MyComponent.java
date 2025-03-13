import java.awt.*;

public class MyComponent extends Component {
    
    public MyComponent() {
        // Set the event mask to some event, otherwise processEvent
        // is never called.
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
    }

    // contains checks to see if the mouse is in the current component.
    // If it is, the event is sent to the component.  Otherwise the
    // event is not sent to the component.
    public boolean contains(int x, int y) {
        System.out.println("In contains " + x + " " + y);
        //return false;   // If false is returned, the processEvent is
                          // never called.
        return true;      // Tell the container to send events to this
                          // Component.
    }

    // processEvent is called when an event occurs.  This is what
    // causes the Event Source to call all its listeners.
    public void processEvent(AWTEvent e) {
        System.out.println("In Event");
    }

    // paint is always called on a repaint event.  This is where the
    // Component is drawn.
    public void paint(Graphics g) {
        System.out.println("In Paint");
    }

    public static void main(String args[]) {
        MyComponent my_c1 = new MyComponent();


        // Put it all together in a Frame.
        Frame f1 = new Frame();
        f1.add(my_c1);
        f1.setSize(200,200);
        f1.show();
    }
}
