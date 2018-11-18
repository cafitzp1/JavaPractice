package com.mycompany.app;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println(recursiveFactorial(3));
        System.out.println(iterativeFactorial(3));
        System.out.println(fibonacci(7));
    }

    private static int recursiveFactorial (int num) {

        if (num == 1)
            return 1;

        return num * recursiveFactorial(num - 1);
    }

    private static int iterativeFactorial (int num) {

        if (num == 0)
            return 1;

        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }

        return factorial;
    }

    private static int fibonacci(int n) {
        if (n <= 2)
            return 1;

        return fibonacci(n-2) + fibonacci(n-1);
    }
}
