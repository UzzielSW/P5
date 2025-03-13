OVERVIEW

NOTE:  This program uses the animator created in Program 7.5  You must
make sure that this animator is in your CLASSPATH.  If you are on windows, 
and have not already done so, run the UseAnimator.bat script found in the
base directory for this distribution once each time you start a DOS shell.

This program shows a correct solution for the coordination problem in Program 8.2.
In this program the creation of the Path and the wait are put in the synchronized
block, removing the race condition from Program 8.4.

TO COMPILE: javac ConcurrentBall.java

To RUN: java ConcurrentBall

 