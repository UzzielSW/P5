// Rational.java: Define a rational number and its associated
// operations such as add, subtract, multiply, and divide
// the divide method throws an exception
public class Rational extends Number implements Comparable {
  // Data fields for numerator and denominator
  private long numerator = 0;
  private long denominator = 1;

  /** Default constructor */
  public Rational() {
    this(0, 1);
  }

  /** Construct a rational with specified numerator and denominator */
  public Rational(long numerator, long denominator) {
    long gcd = gcd(numerator, denominator);
    this.numerator = numerator/gcd;
    this.denominator = denominator/gcd;
  }

  /** Find GCD of two numbers */
  private long gcd(long n, long d) {
    long t1 = Math.abs(n);
    long t2 = Math.abs(d);
    long remainder = t1%t2;

    while (remainder != 0) {
      t1 = t2;
      t2 = remainder;
      remainder = t1%t2;
    }

    return t2;
  }

  /** Return numerator */
  public long getNumerator() {
    return numerator;
  }

  /** Return denominator */
  public long getDenominator() {
    return denominator;
  }

  /** Add a rational number to this rational */
  public Rational add(Rational secondRational) {
    long n = numerator*secondRational.getDenominator() +
      denominator*secondRational.getNumerator();
    long d = denominator*secondRational.getDenominator();
    return new Rational(n, d);
  }

  /** Subtract a rational number from this rational */
  public Rational subtract(Rational secondRational) {
    long n = numerator*secondRational.getDenominator()
      - denominator*secondRational.getNumerator();
    long d = denominator*secondRational.getDenominator();
    return new Rational(n, d);
  }

  /** Multiply a rational number to this rational */
  public Rational multiply(Rational secondRational) {
    long n = numerator*secondRational.getNumerator();
    long d = denominator*secondRational.getDenominator();
    return new Rational(n, d);
  }

  /** Divide a rational number from this rational */
  public Rational divide(Rational secondRational)
    throws RuntimeException {
    if (secondRational.getNumerator() == 0)
      throw new RuntimeException("Divisor cannot be zero");

    long n = numerator*secondRational.getDenominator();
    long d = denominator*secondRational.getNumerator();
    return new Rational(n, d);
  }

  /** Override the toString() method */
  public String toString() {
    if (denominator == 1)
      return numerator + "";
    else
      return numerator + "/" + denominator;
  }

  /** Override the equals method */
  public boolean equals(Object parm1) {
    /** @todo: Override this java.lang.Object method */
    if ((this.subtract((Rational)(parm1))).getNumerator() == 0)
      return true;
    else
      return false;
  }

  /** Override the intValue method */
  public int intValue() {
    /** @todo: implement this java.lang.Number abstract method */
    return (int)doubleValue();
  }

  /** Override the floatValue method */
  public float floatValue() {
    /** @todo: implement this java.lang.Number abstract method */
    return (float)doubleValue();
  }

  /** Override the doubleValue method */
  public double doubleValue() {
    /** @todo: implement this java.lang.Number abstract method */
    return numerator*1.0/denominator;
  }

  /** Override the longValue method */
  public long longValue() {
    /** @todo: implement this java.lang.Number abstract method */
    return (long)doubleValue();
  }

  /** Override the compareTo method */
  public int compareTo(Object o) {
    /** @todo: Implement this java.lang.Comparable method */
    if ((this.subtract((Rational)o)).getNumerator() > 0)
      return 1;
    else if ((this.subtract((Rational)o)).getNumerator() < 0)
      return -1;
    else
      return 0;
  }
}