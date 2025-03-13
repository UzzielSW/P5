// Rectangle.java: The Rectangle class that extends GeometricObject
public class Rectangle extends GeometricObject {
  private double width;
  private double height;

  /** Default constructor */
  public Rectangle() {
    this(1.0, 1.0);
  }

  /** Construct a rectangle with width and height */
  public Rectangle(double width, double height) {
    this(width, height, "white", false);
  }

  /** Construct a rectangle with specified width, height, 
     filled, and color */
  public Rectangle(double width, double height,
    String color, boolean filled) {
    super(color, filled);
    this.width = width;
    this.height = height;
  }

  /** Return width */
  public double getWidth() {
    return width;
  }

  /** Set a new width */
  public void setWidth(double width) {
    this.width = width;
  }

  /** Return height */
  public double getHeight() {
    return height;
  }

  /** Set a new height */
  public void setHeight(double height) {
    this.height = height;
  }

  /** Implement the findArea method in GeometricObject */
  public double findArea() {
    return width*height;
  }

  /** Implement the findPerimeter method in GeometricObject */
  public double findPerimeter() {
    return 2*(width + height);
  }

  /** Override the equals method defined in the Object class */
  public boolean equals(Rectangle rectangle) {
    return (width == rectangle.getWidth()) &&
      (height == rectangle.getHeight());
  }

  /** Override the toString method defined in the Object class */
  public String toString() {
    return "[Rectangle] width = " + width + 
      " and height = " + height;
  }
}