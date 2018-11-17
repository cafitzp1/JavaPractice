package my.java.app;

public class App {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        int[] array2a = {4, 5, 6, 7, 8, 1, 2, 3};
        System.out.println(isRotation(array1, array2a));
        // isRotation(array1, array2a) should return false.
        int[] array2b = {4, 5, 6, 7, 1, 2, 3};
        System.out.println(isRotation(array1, array2b));
        // isRotation(array1, array2b) should return true.
        int[] array2c = {4, 5, 6, 9, 1, 2, 3};
        System.out.println(isRotation(array1, array2c));
        // isRotation(array1, array2c) should return false.
        int[] array2d = {4, 6, 5, 7, 1, 2, 3};
        System.out.println(isRotation(array1, array2d));
        // isRotation(array1, array2d) should return false.
        int[] array2e = {4, 5, 6, 7, 0, 2, 3};
        System.out.println(isRotation(array1, array2e));
        // isRotation(array1, array2e) should return false.
        int[] array2f = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(isRotation(array1, array2f));
        // isRotation(array1, array2f) should return true.
    }

    // Implement your solution below.
    public static Boolean isRotation(int[] array1, int[] array2) {

        if (array1.length != array2.length)
            return false;

        int matches = 0;

        for (int i = 0, j = 0, k = 0; i < array1.length && k < array2.length; j++) {
            j %= array1.length;
            if (array1[i] != array2[j]) {
                matches = 0;
                k++;
            } else {
                k = 0;
                i++;
                matches++;
            }
        }

        return matches == array1.length ? true : false;
    }
}