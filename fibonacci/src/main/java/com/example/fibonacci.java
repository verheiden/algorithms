package com.example;

import java.util.Scanner;
/* solve fibonacci recursively and iteratively by Jung Verheiden */
public class fibonacci {
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);

        System.out.println("Type in the N'th Fibonacci ");

        int n = reader.nextInt();

        System.out.println("Fibonacci using Recursion");
        for (int i = 0; i <= n; i++) {
            System.out.println(i + " : " + fiboRecur(i));
        }
        System.out.println("Fibonacci using Loop");
        for (int i = 0; i <= n; i++) {
            System.out.println(i + " : " + fiboIteration(i));
        }

    }

    static int fiboIteration(int n)
    {
        int fib0 = 0;
        int fib1 = 1;
        int fibonacci = fib0 + fib1;

        if (n <= 1)
            return n;

        for (int i = 2; i <= n; i++) {
            fibonacci = fib0 + fib1;
            fib0 = fib1;
            fib1 = fibonacci;
        }
        return fibonacci;
    }

    static long fiboRecur(int n)
    {
        if (n <= 1)
            return n;
        return (fiboRecur(n - 2) + fiboRecur(n - 1));
    }
}