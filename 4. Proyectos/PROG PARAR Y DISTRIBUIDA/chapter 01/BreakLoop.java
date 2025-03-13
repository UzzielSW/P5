// Using break to exit a loop.
//BreekLoop.java
class BreakLoop {
	public static void main(String args[]) {
		for(int i=0; i<100; i++) {
			if(i == 5) break; // terminate loop if i is 5
				System.out.println("i: " + i);
		}
		}
}
