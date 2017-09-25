package com.example;

/* Jung Verheiden's solution to adding digits in two ListNode list */
public class addTwoListNodes {
    public static void main(String[] args)
    {
        addTwoListNodes obj = new addTwoListNodes();
        ListNode ans = obj.testAdd();
        while(ans != null)
        {
            System.out.print(" " + ans.val + " ");
            ans = ans.next;
        }
    }
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x)
        {val = x; next = null;}
    }
    ListNode testAdd(){
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(9);
        a.next = b;
        b.next= c;
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(0);
        ListNode f = new ListNode(9);
        d.next = e; e.next = f;
        return(addTwoNumbers(a,d));
    }
    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        ListNode aStart = a;
        ListNode bStart = b;
        ListNode cStart = null;
        ListNode ans = null;
        ListNode ansBegin = null;
        boolean carry = false;
        while( (aStart != null ) && ( bStart != null))
        {
            int num1 = aStart.val + bStart.val;
            if ( carry )
            {
                num1 += 1;
            }
            carry = false;
            if ( num1 >= 10 )
            {
                carry = true;
                num1 %= 10;
            }
            if ( ans == null )
            {
                ans = new ListNode(num1);
                ansBegin = ans;
            }
            else
            {
                ans.next = new ListNode(num1);
                ans = ans.next;
            }

            aStart = aStart.next;
            bStart = bStart.next;
        }
        if ( bStart != null )
        {
            cStart = bStart;
        }
        else if ( aStart != null )
        {
            cStart = aStart;
        }

        while(cStart!= null)
        {
            int num = cStart.val;
            if (carry)
                num += 1;
            if ( num >= 10 )
            {
                carry = true;
                num %= 10;
            }
            else
                carry = false;
            cStart = cStart.next;
            if ( num == 0 )
            {
                if (( cStart != null ) ||  ( carry == true ))
                {
                    ans.next = new ListNode(num);
                    ans = ans.next;
                }
            }
            else
            {
                ans.next = new ListNode(num);
                ans = ans.next;
            }
        }
        if ( carry )
        {
            ans.next = new ListNode(1);
        }
        return ansBegin;
    }
}
