package com.example;

/*
** By Jung Verheiden, algorithm to rotate a linked list by a given number of nodes.
*/
public class ListRotate {
    public static void main(String[] args)
    {
        ListRotate obj = new ListRotate();
        ListNode ans = obj.test();
        while(ans != null)
        {
            System.out.print(" " + ans.val + " ");
            ans = ans.next;
        }
    }
    ListNode test(){
        ListNode a = new ListNode(9);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next= c;
        ListNode d = new ListNode(11);
        ListNode e = new ListNode(0);
        ListNode f = new ListNode(7);
        c.next = d; d.next = e; e.next = f;
        return(rotateRight(a,3));
    }
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x)
        {val = x; next = null;}
    }
    public ListNode rotateRight(ListNode a, int b) {
        if ( b <= 0 )
            return a;

        int size = 0;
        ListNode last = a;
        ListNode node = a;

        while(node!=null){
            size++;
            last = node;
            node = node.next;
        }

        b = b%size;
        if ( b == 0 )
            return a;
        int  k = size - b ;
        node = a;
        ListNode previous = a;
        for( int i = 1; i <= k; i++)
        {
            previous = node;
            node = node.next;
        }
        last.next = a;
        previous.next = null;
        return node;
    }
}
