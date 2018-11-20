package my.java.app;

public class App {
    public static void main(String[] args) {

        System.out.println(maxSumSubarray(new int[] { -2, 3, 2, 1, -1, 4 }));

    }

    private static int maxSumSubarray(int[] arr) {
        int max = 0, curMax = 0;

        for (int i = 0, cur = 0; i < arr.length; i++) {
            cur = Math.max(arr[i], arr[i] + curMax);
            if (cur > curMax) {
                curMax = cur;
                if (curMax > max) {
                    max = curMax;
                }
            }
        }

        return max;
    }
}