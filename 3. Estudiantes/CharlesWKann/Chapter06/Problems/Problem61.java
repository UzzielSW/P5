public class Problem61 {
    public static void method1() {
        try {
            int i = 0, j = 7, k;
            k = j / i;
        } catch(Exception e) {
            if (e instanceof ArithmeticException) {
                System.out.println("Arithmetic Exception raised");
                throw e;
            }
        }
    }
}
