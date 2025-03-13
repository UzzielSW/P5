// Address.java: Encapsulate address information
public class Address {
  private String street;
  private String city;
  private String state;
  private String zip;

  /** Default constructor */
  public Address() {
    this("100 Main", "Savannah", "GA", "31411");
  }

  /** Create address with street, city, state, and zip */
  public Address(String street, String city,
    String state, String zip) {
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
  }

  /** Return street */
  public String getStreet() {
    return street;
  }

  /** Set a new street */
  public void setStreet(String street) {
    this.street = street;
  }

  /** Return city */
  public String getCity() {
    return city;
  }

  /** Set a new city */
  public void setCity(String city) {
    this.city = city;
  }

  /** Return state */
  public String getState() {
    return state;
  }

  /** Set a new state */
  public void setState(String state) {
    this.state = state;
  }

  /** Return zip */
  public String getZip() {
    return zip;
  }

  /** Set a new zip */
  public void setZip(String zip) {
    this.zip = zip;
  }

  /** Get full address */
  public String getFullAddress() {
    return street + '\n' + city + ", " + state + ' ' + zip + '\n';
  }
}