package com.example;

import java.util.Scanner;

public class strangeSort {


    static int N;

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter number of Heapsort  elements");
        int n = scanner.nextInt();
        int[] arrays = new int[n];
        int i = 0;

        while ((i++ < n) && scanner.hasNext()) {
            arrays[i] = scanner.nextInt();
        }
        sort(arrays);

        System.out.println("\n These are sorted numbers\n");
        for (int j: arrays )
        {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }
    static void sort(int[] numbers)
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
        int left = 2*1;
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
