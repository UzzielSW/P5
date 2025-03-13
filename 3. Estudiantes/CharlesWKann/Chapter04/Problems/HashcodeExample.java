import java.util.*;
class Name {
    String firstName;
    String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName  = lastName;
    }

    public boolean equals(Object name) {
        if (! (name instanceof Name))
            return false;
        if (( ((Name) name).firstName.equals(firstName)) &&
            ( ((Name) name).lastName.equals(lastName)))
            return true;
        return false;
    }

    public int hashCode() {
        String buffer = new String(firstName + lastName);
        return buffer.hashCode();
    }
}

class Person {
    Name name;
    int age;
    char sex;
    
    public Person(Name name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String toString() {
        return("Name = " + name.firstName
                         + " " + name.lastName
                         + " age = " + age
                         + " sex = " + sex);
    }

}

public class HashcodeExample {
    public static void main(String argv[]) {
        Hashtable myTable = new Hashtable();

        myTable.put(new Name("Chuck", "Kann"),
            new Person(new Name("Chuck", "Kann"), 42, 'M'));
        Person P = (Person) myTable.get(new Name("Chuck", "Kann"));
        System.out.println(P);
    }
}
