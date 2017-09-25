package com.example;

import java.util.Scanner;

public class newSort {
    static int N;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrays = {7,2000,-3001,222, 3333, -4444, 5555, 6066, 10111, 6, 7, 8, 9};
        newSort(arrays);
        for (int j: arrays )
        {
            System.out.print(j + " ");
        }
        System.out.println("\n");
    }
    static void newSort(int[] numbers)
    {
        N = numbers.length - 1;
       heapify(numbers);

        for (int i = N; i > 0 ; i--)
        {
            swap(numbers, 0, i);
            N -= 1;
            maxheap(numbers, 0);
        }
    }

    static void swap(int[] numbers, int from, int to)
    {
        int tmp = numbers[from];
        numbers[from] = numbers[to];
        numbers[to] = tmp;
    }
    static void heapify(int[] numbers)
    {
        for (int i = N/2; i >= 0; i--)
        {
            maxheap(numbers, i);
        }
    }
    static void maxheap(int[] numbers, int i)
    {
        int left = 2*i;
        int right = left + 1;
        int max = i;
        if ((left <= N) && (numbers[left])> numbers[max])
        {
            max = left;
        }
        if ( (right <= N) && (numbers[right] >numbers[max]))
        {
            max = right;
        }
        if ( i != max )
        {
            swap(numbers, i, max);
            maxheap(numbers, max);
        }
    }
}
