package com.example;

import java.util.Arrays;
/* solutions to insertion sort two linked lists by Jung Verheiden */
public class mergeSort {
    public static void main(String[] args){
        //int[] A = new int[] {1, 5, 9, 10, 15, 20};
        //int[] B = new int[] {2, 3, 8, 13};
        int[] A = new int[] {10};
        int[] B = new int[] {2,3};
mergeSort obj = new mergeSort();
        /*
        int[] C = obj.insertSort(A, B);
        System.out.println("{ ");
        for ( int i : C)
        {
            System.out.print(i);
            System.out.print(' ');
        }
        System.out.print(" }\n"); */

    obj.removeNthFromEnd1();


    }
    class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val =x; next = null;}
    }
    public ListNode removeNthFromEnd1() {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        ListNode head = removeNthFromEnd(a, 1);
        System.out.println("Halleluyha");
        return head;
    }
    public ListNode removeNthFromEnd(ListNode a, int b) {
        ListNode node  = a;
        int length = 0;
        while( node != null )
        {
            node = node.next;
            length++;
        }
        int k = length - b;
        ListNode current;
        if ( k <= 1 )
        {
            return(a.next);
        }
        ListNode previous = null;
        ListNode head  = a;
        current = a;
        for ( int i = 0 ; i <=  (k -1) ; i++)
        {
            previous = current;
            current = current.next;
        }

        previous.next = current.next;
        return head;
    }
   private int[] insertSort(int[] A, int[] B)
   {
       int Asize = A.length;
       int Bsize = B.length;
       int total = Asize + Bsize;
       try {
           A = Arrays.copyOf(A, A.length + B.length);
           int last = Asize - 1;
           int nInserted = 0;
           for (int i = Bsize - 1; i >= 0; i--)
           {
               while ( (last >= 0 ) && ( A[last] > B[i]))
               {
                   if ( last == 0 )
                   {
                       shift(A, 0, total - (i +1),  i+1 );
                       for ( int k = 0; k <= i ; k++)
                           A[k] = B[k];
                       return A;
                   }
                   last--;
               }
               if ( last == 0 )
               {
                   shift(A,1, total-i -2, i+1 );
                   for ( int l = 0; l <= i; l++)
                   {
                       A[l+1]= B[l];
                   }
                   return A;
               }
               int bInserted = Bsize - i;
               shift(A, last, total - i -1 -last, 1);
               A[last+1] = B[i];
           }
       } catch ( Exception e)
       {
           System.out.println("Exception"+ e);
       }
       return A;
   }
   private void shift(int[] A, int start, int nNum, int jump)
   {
       int end = start + nNum -1;
       for ( int i = ( end  ); i >= start; i-- ){
           A[i+jump] = A[i];
       }
   }
}
