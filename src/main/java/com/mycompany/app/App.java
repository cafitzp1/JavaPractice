package com.mycompany.app;

public class App {
    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        quickSort(intArray, 0, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    private static void quickSort(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }

        // get pivotIndex to its sorted position, get partition elements on
        // left and right to be less than and greater than the pivotIndex 
        int pivotIndex = partition(input, start, end);

        // do the same thing for the left partition
        quickSort(input, start, pivotIndex);

        // do the same for the right partition
        quickSort(input, pivotIndex + 1, end) ; 
    }

    private static int partition(int[] input, int start, int end) {
        // this is using the first element as the pivot
        int pivot = input[start];
        int i = start;
        int j = end;

        // continue while elements have not crossed eachother
        while (i < j) {

            // NOTE: empty loop body
            // keep decrementing j until we find an element less than the
            // pivot, or until j crosses i
            while (i < j && input[--j] >= pivot);

            // as long as j hasn't crossed i, we've found an element larger
            // than the pivotIndex item
            if (i < j) {
                // move element of position j into i
                input[i] = input[j];
            }

            // NOTE: empty loop again
            while (i < j && input[++i] <= pivot);
            if(i < j) {
                input[j] = input[i];
            }
        }

        // finsihed moving elements smaller to the left and
        // larger to the right
        input[j] = pivot;
        return j;
    }
}
