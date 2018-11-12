package com.mycompany.app;

import java.util.HashMap;

public class App {
    public static void main(String[] args) {

        int[] intArray = { 2, 7, 11, 14 };
        int target = 9;

        int[] output = twoSum(intArray, target);

        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }
}