
public class ArrayInitDemo {

    public static void main(String[] args) {
        int[] odds = {1, 3, 5, 7, 9};
        System.out.println("odds.length = " + odds.length);
        
        for (int i = 0; i < odds.length; i++) {
            System.out.println("odds[" + i + "] = " + odds[i]);
        }

        String[] daysOfWeek = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        System.out.println("\ndaysOfWeek.length = " + daysOfWeek.length);

        for (int i = 0; i < daysOfWeek.length; i++) {
            System.out.println("daysOfWeek[" + i + "] = " + daysOfWeek[i]);
        }

        Employee[] employees = {
        	new Employee("M. Mouse", "Main St. USA", 1),
            new Employee("D. Duck", "Lake Buena Vista", 2),
            new Employee("W. Pooh", "100 Acre St.", 3)
        };

        System.out.println("\nemployees.length = " + employees.length);
        for (int i = 0; i < employees.length; i++) {
            employees[i].mailCheck();
        }
    }
}
