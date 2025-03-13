// PrimeNumber.java: Print first 50 prime numbers
public class PrimeNumber {
  /** Main method */
  public static void main(String[] args) {
    final int NUM_OF_PRIMES = 50;
    int count = 1; // Count the number of prime numbers
    int number = 2; // A number to be tested for primeness
    boolean isPrime = true;  // Is the current number is prime?

    System.out.println("The first 50 prime numbers are \n");

    // Repeatedly test if a new number is prime
    while (count <= NUM_OF_PRIMES) {
      // Assume the number is prime
      isPrime = true;

      // Set isPrime to false, if the number is not prime
      for (int divisor = 2; divisor <= number / 2; divisor++) {
        //If true, the number is not prime
        if (number % divisor == 0) { 
          isPrime = false;
          break;  // Exit the for loop
        }
      }

      // Print the prime number and increase the count
      if (isPrime) {
        if (count % 10 == 0) {
          // Print the number and advance to the new line
          System.out.println(number);
        }          
        else
          System.out.print(number + " ");

        count++;  // Increase the count
      }

      // Check if the next number is prime
      number++;
    }
  }
}