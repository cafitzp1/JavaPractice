package com.mycompany.app;

// 1, 2, 3, 4
// 1, 4, 8, 12
// 1, 5, 13, 25

public class App 
{
    public static void main( String[] args )
    {
        System.out.println(shapeArea(2));
    }

    private static int shapeArea(int n) {

        if (n==1) return 1;

        return (shapeArea(n-1)) + (n-1)*4;
    }
}
