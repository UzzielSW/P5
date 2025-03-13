// Using break to exit from nested loops
//BreakLabel.java
class BreakLabel {
public static void main(String args[]) {
	outer: 
		for(int i=0; i<3; i++) {
			System.out.print("Value " + i + ": ");
			for(int j=0; j<100; j++) {
				if(j == 10) break outer; // exit both loops
					System.out.print(j + " ");
			}
				System.out.println("This will not print");
		}
   }
}
