package my.java.app;

import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        // NOTE: The following input values are used for testing your solution.

        // mostFrequent(array1) should return 1.
        int[] array1 = {1, 3, 1, 3, 2, 1};
        // mostFrequent(array2) should return 3.
        int[] array2 = {3, 3, 1, 3, 2, 1};
        // mostFrequent(array3) should return null.
        int[] array3 = {};
        // mostFrequent(array4) should return 0.
        int[] array4 = {0};
        // mostFrequent(array5) should return -1.
        int[] array5 = {0, -1, 10, 10, -1, 10, -1, -1, -1, 1};
        
        // System.out.println(mostFreqent(array1));       
        System.out.println(mostFreqent(array2));       
        // System.out.println(mostFreqent(array3));       
        // System.out.println(mostFreqent(array4));       
        // System.out.println(mostFreqent(array5));       
    }

    // Implement your solution below.
    public static Integer mostFreqent(int[] givenArray) {
        Integer maxItem = null;
        int maxCount = -1;
        
        if (givenArray.length == 0 || givenArray == null) {
            return maxItem;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < givenArray.length; i++) {

            int value = givenArray[i];
            if (!map.containsKey(value)) {
                map.put(value, 1);
            } else {
                map.replace(value, map.get(value)+1);
            }

            if (map.get(value) > maxCount) {
                maxCount = map.get(value);
                maxItem = value;
            }
        }
        
        return maxItem;
    }
}
