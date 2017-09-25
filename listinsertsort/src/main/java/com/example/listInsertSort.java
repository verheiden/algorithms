package com.example;
/* Jung Verheiden's solution to the insert sorting of ListNode array */
public class listInsertSort {
    public static void main(String[] args){

        listInsertSort obj = new listInsertSort();
        ListNode a = obj.testList();

        while(a != null )
        {
            System.out.print( " " + a.val );
            a = a.next;
        }
    }
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x)
            {val = x; next = null;}
    }
    ListNode testList()
    {
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(66);
        ListNode c = new ListNode(68);
        ListNode d = new ListNode(42);
        ListNode e = new ListNode(73);
        ListNode f = new ListNode(25);
        ListNode g = new ListNode(84);
        ListNode h = new ListNode(63);
        ListNode i = new ListNode(72);
        ListNode j = new ListNode(20);
        ListNode k = new ListNode(77);
        ListNode l = new ListNode(38);
        ListNode m = new ListNode(8);
        ListNode n = new ListNode(99);
        ListNode o = new ListNode(92);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e; e.next = f; f.next = g;
        g.next = h; h.next = i; i.next = j;
        j.next = k; k.next = l; l.next = m;
        m.next = n; n.next =o;
        return insertionSortList(a);
    }
    public ListNode insertionSortList(ListNode a) {
        ListNode previous = null;
        ListNode dummyHead  = new ListNode(0);
        dummyHead.next = a;
        if (( a == null ) || a.next  == null  )
            return a;

        recv( dummyHead, a );
        return( dummyHead.next);
    }

    void recv( ListNode prev, ListNode node)
    {
        if ( node  == null  )
            return;
        recv(node, node.next);
        ListNode start = node.next;
        ListNode previous = prev;
        boolean change = false;
        while( ( start != null ) && ( node.val > start.val ) )
        {
            previous = start;
            start = start.next;
            change = true;
        }

        if ( change  ){
            if ( start == null )
                append(prev, previous, node);
            else
                insert(prev, previous, start, node);
        }
    }
    void append(ListNode prev, ListNode previous, ListNode node)
    {
        prev.next = node.next;
        previous.next = node;
        node.next = null;
    }
    void insert(ListNode prev, ListNode before, ListNode nextNode, ListNode node)
    {
        prev.next = node.next;
        before.next = node;
        node.next = nextNode;
    }
}
