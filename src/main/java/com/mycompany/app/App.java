package com.mycompany.app;

public class App {
    public static void main(String[] args) {
        int[] intArray = { 2, 5, 9, 8, 2, 8, 7, 10, 4, 3 };

        countingSort(intArray, 1, 10);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    private static void countingSort(int[] input, int min, int max) {

        int[] countArray = new int[(max - min) + 1];

        // count each element of the array
        for (int i = 0; i < input.length; i++) {
            countArray[input[i] - min]++;
        }

        // put the elements back
        int j = 0;
        for (int i = min; i <= max; i++) {
            // while there is a number in this index of the count array
            while (countArray[i - min] > 0) {
                // write to the input array
                input[j++] = i;
                // decrement count of this number in the countArray
                countArray[i - min]--;
            }
        }
    }
}