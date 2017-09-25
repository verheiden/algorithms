package com.example;

public class solveMeFirst {
    static public void main(String args[])
    {
        if ( args.length < 2 ) {
            System.out.println("Two integer parameters are not provided");
            System.exit(-1);
        }
        int first = Integer.parseInt(args[0]);
        int second = Integer.parseInt(args[1]);
        int sum = solveMeFirst(first, second);
        System.out.println("Sum is " + sum);

    }

    public static int solveMeFirst(int first, int second)
    {
        return(first+second);
    }
}
