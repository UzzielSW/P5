OVERVIEW

This directory has three programs which show the use of interfaces to create
generic tables.  The base program is PrintTable.java, which uses a Printable
interface.  The 3 programs are: 1 - Person.java, which creates a table of Person
objects; 2 - Car.java, which creates a table of Car objects; and 3 - Polymorphism.java,
which creates a tables of mixed objects, both Car and Person.

TO COMPILE: javac Person.java       (for the Person Table)
            javac Car.java          (for the Car Table)
            javac Polymorphism.java (for the mixed object Table)

            Note that compiling the main program will compile the PrintTable.java
            and Printable.java classes automatically if they are not already compiled.

TO RUN: java Person         (for the Person Table)
        java Car            (for the Car Table)
        java Polymorphism   (for the mixed object Table)