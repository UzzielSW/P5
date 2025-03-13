public class Problem511 {
    public static void swap(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void bubbleSort(int array[]) {
        boolean swapMade = false;
        for (int i = 0; i < (array.length-1); i++) {
            swapMade = false;
            for (int j = (i+1); j < array.length; j++) {
                if (array[i] > array[j]) {
                    swapMade = true;
                    swap(array, i, j);
                }
            }
            if (!swapMade)
                break;
        }
    }

    public static void main(String args[]) {
        int array[] = {5, 8, 1, 4, 9, 6, 2, 3, 7};
        bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
