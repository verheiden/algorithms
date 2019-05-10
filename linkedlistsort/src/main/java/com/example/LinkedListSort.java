package com.example;
/* Jung Verheiden's Linked List array Merge sort algorithm */
public class LinkedListSort {
    public static void main(String[] args){

        LinkedListSort obj = new LinkedListSort();
        ListNode a = obj.testSort();

        while(a != null )
        {
            System.out.print( " " + a.val );
            a = a.next;
        }
    }
    ListNode testSort(){
        ListNode a = new ListNode(9);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next= c;
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(0);
        ListNode f = new ListNode(9);
        c.next = d; d.next = e; e.next = f;
        return(sortList(a));
    }
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x)
        {val = x; next = null;}
    }
    public ListNode sortList(ListNode a) {
        ListNode faster;
        ListNode slower = a;
        ListNode first = a;

        if ( a == null || a.next == null  )
            return a;
        faster = a.next;
        while( faster!= null  )
        {
            faster = faster.next;
            if ( faster != null ) {
                faster = faster.next;
                slower = slower.next;
            }
        }

        ListNode right  = slower.next;
        slower.next  = null;
        first = sortList(first);
        right = sortList(right);
        return(merge(first, right ));
    }

    ListNode merge(ListNode left, ListNode right)
    {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while( left != null && right != null )
        {
            if ( left.val <= right.val )
            {
                head.next = left;
                left = left.next;
            }
            else
            {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }
        if ( left != null )
            addNodes(head, left);
        if ( right != null )
            addNodes(head, right);
        return dummy.next;
    }
    void addNodes(ListNode head, ListNode nodes)
    {
        while(nodes != null)
        {
            head.next = nodes;
            nodes = nodes.next;
            head = head.next;
        }
    }
}
