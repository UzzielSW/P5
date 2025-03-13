OVERVIEW

NOTE:  This program uses the animator created in Program 7.5  You must
make sure that this animator is in your CLASSPATH.  If you are on windows, 
and have not already done so, run the UseAnimator.bat script found in the
base directory for this distribution once each time you start a DOS shell.

This program fixes the problem in Program 8.2 by using the timed format
for the wait method to drop the lock and simulate the sleep in the Ball's
thread.  While this technically works, it is a poor solution to the problem.

TO COMPILE: javac ConcurrentBall.java

To RUN: java ConcurrentBall

 