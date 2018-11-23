package my.java.app;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        for (int num : plusOne(new int[] {1, 2, 3})) {
            System.out.print(num);
        }

    }

    public static int[] plusOne(int[] digits) {
        if (digits.length == 0 || digits==null)
            return null;
        
        int[] temp = new int[digits.length];
        System.arraycopy(digits, 0, temp, 0, digits.length);
        
        // check the whole number
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i] != 9) {
                // travel back up to the end
                digits[i] += 1;
                for (int j = i + 1; j < digits.length; j++) {
                    digits[j] = 0;
                }
                break;
            }
        }
        
        if (Arrays.equals(digits, temp)) {
            digits = new int[temp.length+1];
            digits[0] = 1;
            for (int i = 1; i < digits.length; i++) {
                digits[i] = 0;
            }
        }
        
        return digits;
    }
}