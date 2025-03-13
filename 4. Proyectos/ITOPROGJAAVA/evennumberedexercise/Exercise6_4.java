// Exercise6_4.java: Create a Stock class
public class Exercise6_4 {
  public static void main(String[] args) {
    Stock stock = new Stock("SUNW", "Sun MicroSystems Inc.");
    stock.setPreviousClosingPrice(100);

    // Set current price
    stock.setCurrentPrice(100 + 10*Math.random());

    // Display stock info
    System.out.println("Previous Closing Price: " +
      stock.getPreviousClosingPrice());
    System.out.println("Current Price: " +
      stock.getCurrentPrice());
    System.out.println("Price Change: " +
      stock.changePercent());
  }
}

class Stock {
  private String symbol;
  private String name;
  private double previousClosingPrice;
  private double currentPrice;

  public Stock() {
  }

  public Stock(String symbol, String name) {
    this.symbol = symbol;
    this.name = name;
  }

  public String getSymbol() {
    return symbol;
  }

  public String getName() {
    return name;
  }

  public double getPreviousClosingPrice() {
    return previousClosingPrice;
  }

  public double getCurrentPrice() {
    return currentPrice;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPreviousClosingPrice(double price) {
    this.previousClosingPrice = price;
  }

  public void setCurrentPrice(double price) {
    this.currentPrice = price;
  }

  public double changePercent() {
    return (currentPrice - previousClosingPrice)/
      previousClosingPrice;
  }
}