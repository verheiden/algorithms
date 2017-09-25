package com.example;
/*
**by Jung Verheiden, add numbers in two linked list and return the sum
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
            ListNode ans = addTwoNumbers(two, five);

            while(ans != null )
            {
                System.out.print((char) ans.val );
                ans = ans.next;
            }
            System.out.println(" ");
        }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ans = null;
        ListNode next = null;
        int num;
        while(l1 != null && l2 != null )
        {
            num = l1.val + l2.val + carry;
            if ( num >= 10)
            {
                carry = 1;
                num %= 10;
            }
            else
            {
                carry = 0;
            }
            ListNode newNum = new ListNode(num + '0');
            if ( ans == null )
            {
                ans = newNum;
            }
            else
            {
                next.next = newNum;
            }
            next = newNum;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode next1 = null;
        if ( l1 != null )
        {
            next1 = l1;
        }
        else if ( l2 != null )
        {
            next1 = l2;
        }
        while(next1 != null || carry != 0  )
        {
            if ( next1 != null )
                num = carry + next1.val ;
            else
            {
                num = carry;
            }

            if ( num >= 10 ) {
                num %= 10;
                carry = 1;
            }
            else
                carry = 0;
            ListNode newNum = new ListNode(next, num + '0');
            next = newNum;
            if ( next1 != null )
                next1 = next1.next;
        }
        return ans;
    }
}
