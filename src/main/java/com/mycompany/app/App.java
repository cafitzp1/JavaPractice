package com.mycompany.app;

public class App {
    public static void main(String[] args) {

        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        mergeSort(intArray, 0, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    private static void mergeSort(int[] input, int start, int end) {
        // NOTE: this is the sort step, no modification necessary
        if (end - start < 2)
            return;

        int mid = (start + end) / 2;

        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    private static void merge(int[] input, int start, int mid, int end) {

        // check if items are greater or equal rather than less
        if (input[mid - 1] >= input[mid])
            return;

        int i = start, j = mid, tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            // add items that are greater or equal, not less
            temp[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }
}