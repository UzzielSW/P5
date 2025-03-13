OVERVIEW

NOTE:  This program uses the animator created in Program 7.5  You must
make sure that this animator is in your CLASSPATH.  If you are on windows, 
and have not already done so, run the UseAnimator.bat script found in the
base directory for this distribution once each time you start a DOS shell.

This program shows procedural reuse, where the move method is abstracted into
a method.  Note that this does not work if there is more than one object using
the move method, as the move method must then be copied to each object.

TO COMPILE: javac ConcurrentBall.java

To RUN: java ConcurrentBall
 