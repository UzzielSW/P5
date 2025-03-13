import java.util.Stack;
import java.util.EmptyStackException;
public class Timing {
                                                               
    public static void main(String args[]) {
        Stack myStack = new Stack();

        long startTime = System.currentTimeMillis();
        try { 
            for (int i = 0; i < 1000000; i++) {
                myStack.push(new Object());
                if ( ! myStack.empty())
                    myStack.pop();
            }
        } catch(EmptyStackException e) {
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time = " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            myStack.push(new Object());
            try{
                myStack.pop();
            } catch (EmptyStackException e) {
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time = " + (endTime - startTime));
    }
    
}
