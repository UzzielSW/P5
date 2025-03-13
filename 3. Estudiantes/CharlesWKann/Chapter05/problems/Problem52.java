interface ExampleInterface {
    public void method1();
}

class Class1 implements ExampleInterface {
    public void method1() {}
    public void method2() {}
}

class Class2 {
    public void method1() {}
    public void method2() {}
}

public class Problem52 {
    public static void main(String args[]) {
        Class1 c1 = new Class1();
        Class2 c2 = new Class2();
        Object o1;
        ExampleInterface ei1;
        ExampleInterface ei2 = new ExampleInterface();

        o1 = c1;
        o1.method1();
        ei1 = c1;
        ei1 = o1;
        ei1 = (ExampleInterface) o1;
        ei1.method1();

        o1 = c2;
        o1.method1();
        ei1 = c2;
        ei1 = o1;
        ei1 = (ExampleInterface) o1;
        ei1.method1();
    }
}

