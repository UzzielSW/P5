OVERVIEW

This program is a final step towards creating a generic animator.
In this animator a Multicaster is used to clone the drawListeners
vector so that it is only cloned when an object is addded or removed 
from the animation, rather than each time the animator is used.  
This reduces the amount of work needed to be done by the animator
significantly.

TO COMPILE: javac MoveObject.java

            Note that MoveObject is a main program that uses the
            animator.  It is not part of the animator.  All other
            files in this directory represent part of the animator.
            When the using program is compiled, all the other parts
            of the animator are compiled, so compiling the MoveObject.java
            files will compile all the other files in this directory.

TO RUN: java MoveObject

 