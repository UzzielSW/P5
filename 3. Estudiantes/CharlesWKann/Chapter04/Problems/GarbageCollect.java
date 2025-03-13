class LinkedLetter {
    char letter;
    LinkedLetter nextLetter;

    public LinkedLetter(char letter, LinkedLetter nextLetter) {
        this.letter = letter;
        this.nextLetter = nextLetter;
    }

    public LinkedLetter(char letter) {
        this.letter = letter;
        this.nextLetter = null;
    }
}

public class GarbageCollect {
    public static void main(String args[]) {
        LinkedLetter A, B;
        {
            LinkedLetter C, D, E;
            B = new LinkedLetter('B');
            E = new LinkedLetter('E', B);
            C = new LinkedLetter('C', E);
            D = new LinkedLetter('E');
            A = new LinkedLetter('A', D);
        }                               // Point 1 
        B = new LinkedLetter('B');      // Point 2
    }                                   // Point 3
}

