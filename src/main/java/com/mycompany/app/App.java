package com.mycompany.app;

public class App {

    // should be 1, 5, 13, 25, 41
    public static void main(String[] args)
    {
        System.out.println(shapeArea(4));
    }

    private static int shapeArea(int n)
    {
        if (n == 1)
            return 1;

        return shapeArea(n - 1) + (n - 1) * 4;
    }
}
