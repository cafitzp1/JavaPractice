package my.java.app;

public class App {
    public static void main(String[] args) {

        // --- string implementation ---
        String[] stringArray = new String[] { "cat", "dog", "apple", "tree", "door" };
        insertionSort(stringArray);
        System.out.println("Find: 'dog'");
        for (String str : stringArray)
            System.out.println(str);
        System.out.println("> " + binarySearch(stringArray, "dog"));

        System.out.println("---------------");

        // --- integer implementation ---
        Integer[] intArray = new Integer[] { 5, 7, 14, -56, 32 };
        insertionSort(intArray);
        System.out.println("Find: '32'");
        for (Integer num : intArray)
            System.out.println(num);
        System.out.println("> " + binarySearch(intArray, 32));
    }

    private static <T extends Comparable<T>> void insertionSort(T[] input) {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < input.length; firstUnsortedIndex++) {
            T newElement = input[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i > 0 && input[i - 1].compareTo(newElement) > 0; i--) {
                input[i] = input[i - 1];
            }
            input[i] = newElement;
        }
    }

    private static <T extends Comparable<T>> int binarySearch(T[] input, T value) {
        return binarySearch(input, 0, input.length, value);
    }

    private static <T extends Comparable<T>> int binarySearch(T[] input, int start, int end, T value) {
        if (start >= end)
            return -1;

        int mid = (start + end) / 2;

        if (input[mid].compareTo(value) == 0)
            return mid;

        if (input[mid].compareTo(value) < 0)
            return binarySearch(input, mid + 1, end, value);

        return binarySearch(input, start, mid, value);
    }

    @SuppressWarnings("unused")
    private static int iterativeBinarySearch(int[] input, int value) {

        int start = 0, end = input.length;

        while (start < end) {
            int mid = (start + end) / 2;
            if (input[mid] == value) {
                return mid;
            } else if (input[mid] < value) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return -1;
    }
}