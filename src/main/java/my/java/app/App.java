package my.java.app;

@SuppressWarnings("unused")

public class App {
    public static void main(String[] args) {

        int[] intArray = { -22, -15, 1, 7, 30, 35, 55};

        System.out.println(recursiveBinarySearch(intArray, -15));
        // should return '1'
        System.out.println(recursiveBinarySearch(intArray, 35));
        // should return '5'
        System.out.println(recursiveBinarySearch(intArray, 8888));
        // should return '-1'
        System.out.println(recursiveBinarySearch(intArray, 1));
        // should return '2'
    }

    private static int linearSearch(int[] input, int value) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == value)
                return i;
        }
        return -1;
    }

    private static int iterativeBinarySearch(int[] input, int value) {
        int start = 0;
        int end = input.length;

        while (start < end) {
            int midpoint = (start + end) / 2;
            // if we land on the item, just return
            if (input[midpoint] == value) {
                return midpoint;
            // we know value must be in the right partition
            } else if (input[midpoint] < value) {
                start = midpoint + 1;
            // we know value must be in the left partition
            } else {
                end = midpoint;
            }
        }
        // if the value isn't in the array
        return -1;
    }

    private static int recursiveBinarySearch(int[] input, int value) {
        return recursiveBinarySearch(input, 0, input.length, value);
    }

    private static int recursiveBinarySearch(int[] input, int start, int end, int value) {
        if (start >= end)
            return -1;

        int midpoint = (start + end) / 2;

        if (input[midpoint] == value)
            return midpoint;

        if (input[midpoint] < value)
            return recursiveBinarySearch(input, midpoint + 1, end, value);
            
        return recursiveBinarySearch(input, start, midpoint, value);
    }
}