public class OverdraftException extends Exception implements java.io.Serializable {
  private double deficit;
  private String message;

  public OverdraftException(String message, double deficit) {
    this.deficit = deficit;
    this.message = message;
  }

  // * Metodo para retornar deficit del balance*/
  public double getDeficit() {
    return deficit;
  }

  // * Metodo para informar sobre el deficit*/
  public String getMessage() {
    return message;
  }
}
