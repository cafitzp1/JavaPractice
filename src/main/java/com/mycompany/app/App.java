package com.mycompany.app;

public class App {
    public static void main(String[] args) {
        int[] radixArray = { 4725, 4586, 1330, 8792, 1594, 5729 };

        radixSort(radixArray, 10, 4);

        for (int i = 0; i < radixArray.length; i++) {
            System.out.println(radixArray[i]);
        }
    }

    private static void radixSort(int[] input, int radix, int width) {
        for (int i = 0; i < width; i++) {
            // call for each position in our values (the radix, so 4 loops)
            radixSingleSort(input, i, radix);
        }
    }

    private static void radixSingleSort(int[] input, int position, int radix) {

        // store amount of items we are sorting
        int numItems = input.length;

        // create temp array to hold our count values
        int[] countArray = new int[radix];

        // count number of values that have a specific digit in the 
        // specified position
        for (int value: input) {
            countArray[getDigit(position, value, radix)]++;
        }
        // adjust count array to countain number of values with that
        // digit or less than that digit for this position
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }
        // copy values into temporary array, right to left to preserver
        // duplicate values (must be a stable sort)
        int[] temp = new int[numItems];
        for (int tempIndex = numItems-1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] =
                input[tempIndex];
        }
        // copy back from temporary array into input array
        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }
    }

    private static int getDigit(int position, int value, int radix) {
        // divides the number by 10^position, modded by the radix
        // in the end, we get the remainder which will be the digit
        return value / (int)Math.pow(radix, position) % radix;
    }
}
