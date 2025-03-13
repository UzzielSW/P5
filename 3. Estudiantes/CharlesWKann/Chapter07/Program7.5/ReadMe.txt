OVERVIEW

This program is a third step towards creating a generic animator.
The animator implements the Java Event Model, which forces some
naming changes and also fixes a race condition that might cause
dead lock.  This is the animator that will be used through the
rest of the text.

TO COMPILE: javac MoveObject.java

            Note that MoveObject is a main program that uses the
            animator.  It is not part of the animator.  All other
            files in this directory represent part of the animator.
            When the using program is compiled, all the other parts
            of the animator are compiled, so compiling the MoveObject.java
            files will compile all the other files in this directory.

TO RUN: java MoveObject

 