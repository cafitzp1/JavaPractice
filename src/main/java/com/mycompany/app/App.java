package com.mycompany.app;

public class App 
{
    public static void main( String[] args )
    {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        // element in first index is in the sorted partition
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {

            // save value of element we are going to insert so it doesn't get overwritten
            int newElement = intArray[firstUnsortedIndex];
            int i;

            // traverse sorted partition and look for correct position to insert element
            // keep looking until we hit the front of the array and or we find an element
            // less than or equal to the element we are trying to insert
            for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
                intArray[i] = intArray[i - 1];
            }

            // when we drop out of the loop, we want to insert our element
            intArray[i] = newElement;
        }

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
}