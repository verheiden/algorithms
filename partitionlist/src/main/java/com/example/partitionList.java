package com.example;
/* Solution to partition a linked list into two linked list divided by
 * a given dividing node by Jung Verheiden.
 */
public class partitionList {
    public static void main(String[] args){
        partitionList obj = new partitionList();
        obj.makeObjects();
    }
    void makeObjects()
    {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.add(b);
        b.add(c);
        c.add(d);
        d.add(e);
        ListNode k = partition(a, 1);
        System.out.println("abc");
    }
    public ListNode partition(ListNode a, int b) {

        ListNode first = a;
        int N = 0;
        while(first!= null )
        {
            N++;
            first = first.next;
        }
        first = a;
        ListNode smaller = null;
        ListNode previous = a;
        ListNode firstLarger = null;
        ListNode head = a;
        previous = null;
        while(N--> 0 )
        {
            if ( first.val >  b )
            {
                if ( firstLarger == null )
                {
                    firstLarger = first;
                }
                previous = first;
                first = first.next;
            }
            else
            {
                if ( previous != null )
                    previous.next = first.next;
                if ( smaller == null )
                {
                    smaller = first;
                    head = first;
                }
                else {

                    smaller.next = first;
                    smaller = first;
                }
                ListNode nBegin = first.next;
                if ( firstLarger != null ) {
                    first.next = firstLarger;
                }
                else
                {
                    previous = first;
                }
                first = nBegin;
            }
        }
        return head;
    }
/**
 * Definition for singly-linked list.
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
    void add(ListNode a)
    {
        next = a;
    }
}
}
