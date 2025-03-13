OVERVIEW

This program makes the animator from Program 7.5 more generic by seperating
out the Control Frame from the animator.  This should have been done in 
Program 7.5, but would have added unduly to the complexity of the animator at
that point.

It uses a Monitor from Chapter 3 to separate out the control from the animator.
It also uses interfaces, as presented in Chapter 5, to break out the pieces of 
the animator so that the objects are more coherent and less coupled.

TO COMPILE: javac ConcurrentBall.java

            Note:  Compiling ConcurrentBall.java will compile all the other
            animator componenet.  ConcurrentBall.java is not part of the 
            animator, but is a program which uses the animator.

To RUN: java ConcurrentBall.

 