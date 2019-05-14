package com.example;
/* Jung Verheiden's Linked List array Merge sort algorithm */


public class LinkedListSort {
    class ListNode {
        int value;
        ListNode next;
        public  ListNode(int a){
            value = a;
            next = null;
        }
    }
    public static void main(String[] args){

        LinkedListSort obj = new LinkedListSort();
        ListNode a = obj.testSort();

        while(a != null )
        {
            System.out.print( " " + a.value );
            a = a.next;
        }
    }
    ListNode testSort(){
        ListNode a = new ListNode(10);
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

    ListNode sortList(ListNode list){
        if ( list == null || list.next == null )
            return list;

        ListNode faster = list.next;
        ListNode slower = list;

        while( faster != null )
        {
            faster = faster.next;
            if ( faster != null )
            {
                faster = faster.next;
                slower = slower.next;
            }

        }
        ListNode left =  list;
        ListNode right = slower.next;
        slower.next = null;
        ListNode leftSorted = sortList(left);
        ListNode rightSorted = sortList(right);
        ListNode head = merge(leftSorted, rightSorted);
        return head;
    }

    ListNode merge(ListNode a, ListNode b){
        ListNode head = null;
        ListNode tail = null;
        ListNode left = a;
        ListNode right = b;
        while(left != null && right != null )
        {
            if ( left.value < right.value  )
            {
                if ( head == null ) {
                    head = left;
                }
                if ( tail != null )
                    tail.next = left;
                tail = left;
                left = left.next;

            }
            else
            {
                if ( head ==null )
                    head = right;
                if ( tail != null )
                    tail.next = right;
                tail = right;
                right = right.next;

            }
            tail.next = null;
        }
        if ( left != null )
            tail.next = left;
        else if ( right != null )
            tail.next = right;
        return( head);
    }
}
