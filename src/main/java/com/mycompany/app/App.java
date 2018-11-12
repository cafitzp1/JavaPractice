package com.mycompany.app;

// time complexity: O(log (m+n))
public class App {
    public static void main(String[] args) {

        int[] nums1 = { 1, 2 };
        int[] nums2 = { -1, 3 };

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // return if either array is empty
        if (nums1 == null || nums1.length == 0)
            return median(nums2);
        else if (nums2 == null || nums2.length == 0)
            return median(nums1);

        // get arrays into 1 array
        int[] input = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, input, 0, nums1.length);
        System.arraycopy(nums2, 0, input, nums1.length, nums2.length);

        // set mid to partition split
        int start = 0, end = input.length, mid = nums1.length;

        // merge the array partitions
        merge(input, start, mid, end);

        return median(input);
    }

    private static void merge(int[] input, int start, int mid, int end) {

        // return if the partitions are sorted
        if (input[mid - 1] <= input[mid])
            return;

        int i = start, 
            j = mid, 
            tempIndex = 0;

        // make a new array for merge sort
        int[] temp = new int[end - start];

        // compare separate partition elements
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        // overwrite input array with temp array
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }

    private static double median(int[] input) {
        int end = input.length, 
            mid = (0 + end) / 2;

        double med = end % 2 == 0 ?
            (input[mid - 1] + input[mid]) / 2.0 :
            input[mid];

        return med;
    }
}