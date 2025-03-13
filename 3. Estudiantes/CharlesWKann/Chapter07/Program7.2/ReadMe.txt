OVERVIEW

This animator points out why the animator from program 7.1 is
flawed in calling sleep in the paint method.  A simple speed 
control is added, but the whole program locks up when the 
speed control slows down the animation.  This is due to the
fact that the program is sleeping in the GUI thread.

TO COMPILE: javac SimpleAnimator.java

            Note that compiling NumberTest will also compile the 
            files for the Path.java and StraightLinePath.java files.

TO RUN: java SimpleAnimator

 