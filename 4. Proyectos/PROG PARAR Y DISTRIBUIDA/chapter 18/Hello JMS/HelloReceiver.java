// The Hello World Receiver Program: HelloReceiver.java
import javax.jms.*;
public class HelloReceiver {
public static void main(String[] args) throws Exception
{
try {
// JMS setup work.
// Get a connection factory for the point-to-point style
// i.e. a queue connection factory.
QueueConnectionFactory myConnectionFactory =
new com.sun.messaging.QueueConnectionFactory();
// Use myConnectionFactory to get a queue connection
QueueConnection myConnection =
myConnectionFactory.createQueueConnection();
// Use myConnection to create a queue session
QueueSession mySession =
myConnection.createQueueSession(false,1);
// Use mySession to get the queue
Queue myQueue = mySession.createQueue("HelloWorldQueue");
// Use mySession to create a receiver
QueueReceiver myReceiver = mySession.createReceiver(myQueue);
// Start the connection
myConnection.start();
// Wait for the Hello World message
// Use the receiver and wait forever until the
// message arrives
TextMessage m = (TextMessage)myReceiver.receive();
// Display the message
System.out.println("Received the message: " + m.getText());
// Done.
// Need to clean up
mySession.close();
myConnection.close();
}
catch( Exception e ) {
e.printStackTrace();
}
}
}
