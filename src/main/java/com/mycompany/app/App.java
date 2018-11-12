package com.mycompany.app;

public class App {
    public static void main(String[] args) {

        System.out.println(reverseNumber(523));
    }

    private static int reverseNumber(int num) {

        int revNum = 0;
        while (num > 0) {
            revNum = revNum * 10 + num % 10;
            num /= 10;
        }

        return revNum;
    }
}