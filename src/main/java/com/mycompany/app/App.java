package com.mycompany.app;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class App {
    public static void main(String[] args) {
        // int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
        int[] intArray = { 54, 46, 83, 66, 95, 92, 43 };

        bucketSort(intArray);
        // insertionSort(intArray);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void bucketSort(int[] input) {
        List<Integer>[] buckets = new List[10];

        // create array list at each bucket
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        // scatter values, hash, put into appropriate bucket
        for (int i = 0; i < input.length; i++) {
            buckets[hash(input[i])].add(input[i]);
        }

        // sort each bucket
        System.out.println("Length: " + buckets.length);
        for (List<Integer> bucket : buckets) {
            // using JDK sort
            // Collections.sort(bucket);

            // using my generic insertion sort
            // insertionSort(bucket);

            // using my generic merge sort
            mergeSort(bucket, 0, bucket.size());
        }

        // traverse and copy sorted values from each list
        int j = 0;
        // traverse buckets array
        for (int i = 0; i < buckets.length; i++) {
            // traverse array list at buckets[i]
            for (int value : buckets[i]) {
                // copy into input array
                input[j++] = value;
            }
        }
    }

    private static int hash(int value) {
        // ex: (54 / 10 = 5) % 10 = 5
        return value / (int) 10 % 10;
    }

    public static <T extends Comparable<T>> void insertionSort(List<T> list) {

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < list.size(); firstUnsortedIndex++) {

            T newElement = list.get(firstUnsortedIndex);
            int i;
            for (i = firstUnsortedIndex; i > 0 && list.get(i - 1).compareTo(newElement) == 1; i--) {
                list.set(i, list.get(i - 1));
            }

            list.set(i, newElement);
        }
    }

    public static void mergeSort(List<Integer> list, int start, int end) {
        if (end - start < 2)
            return;

        int mid = (start + end) / 2;

        mergeSort(list, start, mid);
        mergeSort(list, mid, end);
        merge(list, start, mid, end);
    }

    public static void merge(List<Integer> list, int start, int mid, int end) {

        Integer[] input = list.toArray(new Integer[list.size()]);

        if (list.get(mid - 1).compareTo(list.get(mid)) < 1)
            return;

        int i = start, j = mid, index = 0;

        Integer[] temp = new Integer[end - start];

        while (i < mid && j < end) {
            temp[index++] = list.get(i).compareTo(list.get(j)) < 1 ? list.get(i++) : list.get(j++);
        }

        System.arraycopy(input, i, input, start + index, mid - i);
        System.arraycopy(temp, 0, input, start, index);

        list.clear();
        list.addAll(Arrays.asList(input));
    }

    // arraylist 'list' to array 'input'
    // Integer[] input = list.toArray(new Integer[list.size()]);

    // array 'input' to arraylist 'list'
    // list = new ArrayList<Integer>(Arrays.asList(input));

    // generic array instantiation
    // @SuppressWarnings("unchecked")
    // T[] newArray = (T[]) new Object[newSize];
}