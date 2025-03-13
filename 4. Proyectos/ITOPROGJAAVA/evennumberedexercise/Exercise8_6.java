// Exercise8_6.java: Perform a deep copy
public class Exercise8_6 {
  public static void main(String[] args) {
    Tiger tiger = new Tiger();
    Chicken chicken = new Chicken();
    Apple apple = new Apple();
    Orange orange = new Orange();

    showObject(tiger);
    showObject(chicken);
    showObject(apple);
    showObject(orange);
  }

  public static void showObject(Object object) {
    System.out.println(object);
    if (object instanceof Eatable) {
      ((Eatable)object).howToEat();
    }
  }
}

interface Eatable {
  public void howToEat();
}

class Animal {
  public String toString() {
    return "Animal";
  }
}

class Tiger extends Animal {
  public String toString() {
    return "Tiger";
  }
}

class Chicken extends Animal implements Eatable {
  public void howToEat() {
    System.out.println("Eat a chicken?");
  }

  public String toString() {
    return "Chicken";
  }
}

class Elephant extends Animal {
  public String toString() {
    return "Elephant";
  }
}

class Fruit implements Eatable {
  public void howToEat() {
    System.out.println("Eat a fruit?");
  }
}

class Apple extends Fruit {
}

class Orange extends Fruit {
}