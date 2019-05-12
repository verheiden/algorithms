package com.example;
/*
**by Jung Verheiden, add two numbers in two linked list and return the sum
*  as the linked list.
*/
public class addLinkedList {
   public static void main(String[] args){
       new addLinkedList().test();
   }
   public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; next = null;}
            ListNode(ListNode a, int value){ a.next = this; val = value; next = null;}
            ListNode( int value, ListNode tail ){ this.next = tail; val = value; }
        }
        private void test()
        {
            ListNode two = new ListNode(2);
            ListNode four = new ListNode(two, 4);
            ListNode three = new ListNode(four, 8);
            ListNode five = new ListNode(5);
            ListNode six = new ListNode(five,6);
            ListNode four1 = new ListNode(six, 4);
            ListNode nine = new ListNode(four1, 9);
            ListNode  ans = addTwoNumbers(two, five);

            while(ans != null )
            {
                System.out.print( ans.val );
                ans = ans.next;
            }
            System.out.println(" ");
        }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        int ans = convertToInt(l1) + convertToInt(l2);
        ListNode tail = null;
        while(ans != 0 ){
            int  lastDigit = ans%10;
            ans /= 10;

            ListNode number = new ListNode(lastDigit, tail);
            tail = number;
        }
        return tail;
    }
    int convertToInt(ListNode node)
    {
        int  num1 = 0;

        while(node != null  )
        {
            num1 = node.val + 10*num1;
            node = node.next;
        }
        return num1;
    }
}
