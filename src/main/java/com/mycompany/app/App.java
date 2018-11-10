package com.mycompany.app;

public class App 
{
    public static void main( String[] args )
    {
        int[] intArray = new int[] {20, 35, -15, 7, 55, 1, -22 };

        for (int lastUnsortedIndex = intArray.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    swap(intArray, i, i + 1);
                }
            }
        }

        for (int i = 0; i<intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        // nothing to swap, two elements are the same
        if (i == j) return;

        // swap the elements
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
