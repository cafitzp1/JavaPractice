package com.mycompany.app;

public class App 
{
    public static void main( String[] args )
    {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        recursiveInsertionSort(intArray, 0, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    private static void recursiveInsertionSort(int[] intArray, int start, int end) {

        // return if start crosses end
        if(start + 1 >= end)
            return;

        // we do not have to check the first value as this is in the sorted 
        // partition already
        int firstUnsortedIndex = start + 1; 
        int newElement = intArray[firstUnsortedIndex];
        int i;

        for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
            intArray[i] = intArray[i - 1];
        }

        intArray[i] = newElement;

        recursiveInsertionSort(intArray, firstUnsortedIndex, end);
    }
}