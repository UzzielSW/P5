OVERVIEW

This program is a second step towards creating a generic animator.
In this program, a control frame is added to control the speed of
execution of the animator.  Note that sleeping is now done in an 
animator thread so that there is never an undue delay in the GUI thread.

TO COMPILE: javac MoveObject.java

            Note that MoveObject is a main program that uses the
            animator.  It is not part of the animator.  All other
            files in this directory represent part of the animator.
            When the using program is compiled, all the other parts
            of the animator are compiled, so compiling the MoveObject.java
            files will compile all the other files in this directory.

TO RUN: java MoveObject

 