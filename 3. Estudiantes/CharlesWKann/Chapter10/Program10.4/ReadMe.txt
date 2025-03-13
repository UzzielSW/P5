OVERVIEW

NOTE:  This program uses the animator created in Program 7.5  You must
make sure that this animator is in your CLASSPATH.  If you are on windows, 
and have not already done so, run the UseAnimator.bat script found in the
base directory for this distribution once each time you start a DOS shell.

This program shows object reuse with classification.

TO COMPILE: javac ConcurrentBall.java

            Note that ConcurrentBall uses the class MoveController, which
            is thus compiled.  The MoveController in this directory is used,
            even though there is one in the directory for the animator package,
            because these examples are showing different ways to implement it.

To RUN: java ConcurrentBall
 