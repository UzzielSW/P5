OVERVIEW

NOTE:  This program uses the animator created in Program 7.5  You must
make sure that this animator is in your CLASSPATH.  If you are on windows, 
and have not already done so, run the UseAnimator.bat script found in the
base directory for this distribution once each time you start a DOS shell.

This program shows a simple, and incorrect, attempt to cordinate the Balls
in the animation for Program 8.1  The problem is that a sleep is being called
in a synchronized block in the Ball's thread.  Since the GUI thread must also
obtain this lock, effectively the GUI thread is hung.

TO COMPILE: javac ConcurrentBall.java

To RUN: java ConcurrentBall

 