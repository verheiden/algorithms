package com.example;

import java.util.ArrayList;
/* Jung Verheiden's solution to reversing N to M members in an LinkedList array */
public class reverseNtoM
{
   class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x)
      {val = x; next = null;}
   }


   public static void main(String[] args) {


   }
   public ListNode reverseBetween(ListNode a, int m, int n) {
      ListNode node = a;
      ArrayList<Integer> reverseM = new ArrayList<Integer>();
      ArrayList<Integer> reverseN = new ArrayList<Integer>();


      int i = 1;
      int size = ( n - m + 1);
      boolean oddSize = size%2 == 1 ? true: false;
      size  /= 2;
      if ( size == 0 )
         return a;

      while( i < m && node != null )
      {
         i++;
         node = node.next;
      }
      if ( i == m )
      {
         int j = i;
         ListNode kNode = node;
         while( (j >=m   && j < (m+size )) &&( kNode != null ) )
         {
            j++;
            reverseM.add(kNode.val);
            kNode = kNode.next;
         }
         int l = reverseM.size() -1;
         int k;
         if ( oddSize )
         {
            j++;
            kNode = kNode.next;
         }
         while(( j >= (m + size  ) && (j <= n)))
         {
            reverseN.add(kNode.val);
            kNode.val = reverseM.get(l);
            kNode = kNode.next;
            l--;
            j++;
         }
      }
      int k = reverseN.size() - 1;
      while( (k >= 0 ) && (node != null ))
      {
         node.val = reverseN.get(k);
         node = node.next;
         k--;
      }
      return a;
   }
}
