import java.awt.*;
import java.awt.event.*;

public class Fibonacci
{
private static boolean stopProgram = false;

public static void main(String argv[]) {

Frame myFrame = new Frame("Calculate  Fibonacci Numbers");

List myList  = new List(4);

myFrame.add(myList, BorderLayout.CENTER);

Button b1 = new Button("Stop Calculation");

b1.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent e) {
System.out.println("· Thread actual: "+Thread.currentThread().getName());
stopProgram = true;
}
} );

Button b2 = new Button("Exit");

b2.addActionListener( new ActionListener() { 
   public void actionPerformed(ActionEvent e ) {
   	System.out.println("· Thread actual: "+Thread.currentThread().getName());
   System.exit(0);
   }
  });
  
  Panel p1 = new Panel();
  
  p1.add(b1);
  p1.add(b2);
  
  myFrame.add(p1, BorderLayout.SOUTH);
  myFrame.setSize(200,300);
  //myFrame.show();
  
  myFrame.setVisible(true);
  
  int  counter = 2;
  
  while( true) {
  if( stopProgram)
    break;
  
    counter += 1;
    
    myList.add("Num =   "  +  "   " +counter + "  " + "   Fib = " + fibonacci(counter));
    
    //myFrame.show();
    myFrame.setVisible(true);
    }
    
    // Note: stopPtrogram cannot change value to true in the above
    // loop. How does the program get to this point
    
    myList.add("Program Done");
    }
    
    public static int fibonacci( int NI )
    {
    if( NI <= 1 ) return 1;
      return fibonacci( NI - 1) + fibonacci(NI - 2);
    }
    
   }
    
