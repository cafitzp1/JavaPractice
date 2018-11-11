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

        // break out when the method is called with a one element array
        // by definition, one element array is sorted
        if (end - start < 2)
            return;

        int mid = (start + end) / 2;

        // handle the left partition sorting
        // when this returns, the entire left side is sorted
        mergeSort(input, start, mid);

        // handle the right partition sorting
        // again, entire right side is sorted when this returns
        mergeSort(input, mid, end);

        // finally, merge left and right sorted partitions
        // NOTE: because of recursion, this merges all sub arrays
        merge(input, start, mid, end);
    }

    private static void merge(int[] input, int start, int mid, int end) {

        // NOTE: at this point, each partition's elements are sorted
        // if the last element of the left side is less than or equal
        // to first element of right partition, we can return
        if (input[mid - 1] <= input[mid])
            return;

        // keep track of where we are in temp array while copying
        int i = start, j = mid, tempIndex = 0;

        // allocate space in temp array to hold all copied values
        int[] temp = new int[end - start];

        // compare current element in left partition with current
        // element in right partition (which we keep track of with i & j)
        while (i < mid && j < end) {
            // write smaller element to the temp array
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        // if there are items remaining in left array, we need to get
        // them into their positions in the input array (overwrite) 
        System.arraycopy(input, i, input, start + tempIndex, mid - i);

        // copy the temp array into the input array
        System.arraycopy(temp, 0, input, start, tempIndex);
    }
}