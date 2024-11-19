public class Message implements java.io.Serializable {

  public String name;
  public String text;

  public Message(String name, String text) {
    this.name = name;
    this.text = text;
  }
}