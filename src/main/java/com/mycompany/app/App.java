package com.mycompany.app;

public class App {
    public static void main(String[] args) {
        String[] radixArray = { "bcdef", "dbaqc", "abcde", "omadd", "bbbbb" };

        radixSort(radixArray, 26, 5);

        for (int i = 0; i < radixArray.length; i++) {
            System.out.println(radixArray[i]);
        }
    }

    private static void radixSort(String[] input, int radix, int width) {
        // NOTE: we want to start from the right of the input value
        // and go to the left. Our method for getting the decimal had
        // us getting the index differently so we had our loop indexer
        // incrementing. For letters, we can just use the width-1 to get
        // the char for the specified position
        for (int i = width-1; i >= 0; i--) {
            radixSingleSort(input, i, radix);
        }
    }

    private static void radixSingleSort(String[] input, int position, int radix) {

        int numItems = input.length;

        // array of length 26 for counting letters
        int[] countArray = new int[radix];

        // count the letters
        for (String value: input) {
            countArray[getLetterIndex(position, value)]++;
        }
        // adjust count
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }
        // copy values into temp array
        String[] temp = new String[numItems];
        for (int tempIndex = numItems-1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getLetterIndex(position, input[tempIndex])]] =
                input[tempIndex];
        }
        // copy back from temp array into input array
        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }
    }

    private static int getLetterIndex(int position, String str) {
        // char is just a numeric value behind the scenes
        // a is 97 (A is 65) in ASCII, so whatever letter
        // we need we can get by subtracting 'a'
        return str.charAt(position) - 'a';
    }
}