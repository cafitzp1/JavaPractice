package com.mycompany.app;

public class App {
    public static void main(String[] args) {

        int input = 123345;
        int output = closestPalindrome(input);

        System.out.println(output);
    }

    private static int closestPalindrome(int input) {

        if (input <= 10)
            return -1;
            
        for (int i = input; i > 0; i--) {

            int tempInput = i;
            int revInput = 0;

            while (tempInput != 0) {
                revInput = revInput * 10 + tempInput % 10;
                tempInput = tempInput/10;
            }

            if (i == revInput)
                return i;
        }

        return -1;
    }
}