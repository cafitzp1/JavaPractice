package com.mycompany.app;

public class App {
    public static void main(String[] args) {

        System.out.println(reverseNumber(-123));
    }

    private static int reverseNumber(int num) {

        int rev = 0;
        while (num != 0) {
            int pop = num % 10;
            num /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}