package com.example;

/* get the minimum number of a stack of numbers by Jung Verheiden */
public class minstack {

    static public void main(String[] args){
        minstack st = new minstack();
        st.push(19);
        st.push(-10);
        st.push(9);
        st.push(-11);
        System.out.println(st.getMin());
        st.push(8);
        System.out.println(st.getMin());
        st.push(7);
        System.out.println(st.getMin());
        st.push(-12);
        System.out.println(st.getMin());
        st.pop();
        System.out.println(st.getMin());
        st.pop();
        st.push(-29);
        System.out.println(st.getMin());
        st.pop();
        System.out.println(st.getMin());
        st.pop();
        System.out.println(st.getMin());
        st.pop();
        System.out.println(st.getMin());
        System.out.println(st.getMin());
     }
    Node first = null;
    long minEle ;
    public void push1(int x){
        if ( first == null )
        {
            first = new Node(x, null);
            minEle = x;
        }
        else
        {
            if ( x < minEle )
            {
                first = new Node(2*x - minEle , first);
                minEle = x;
            }
            else
                first = new Node(x, first);
        }
    }

    public void push(int x)
    {

        if ( first  == null )
        {
            minEle = x;
            first = new Node(x, null);
            return;
        }

        if ( minEle > x )
        {
            first = new Node((2*x -minEle ), first );
            minEle = x;
        }
        else
        {
            first = new Node(x, first);
        }
    }

    public void pop() {
        if ( first == null )
            return;

        if ( first.data < minEle )
        {
            minEle = 2*minEle -first.data ;
        }
        first = first.next;
    }

    public int top() {
        if ( first == null )
            return -1;
        return((int)first.data) ;
    }
   int getMin()
   {
       if ( first == null )
           return -1;
       return (int) minEle;
   }
   public class Node {
        long data;
        Node next;
        public Node(long d, Node n)
        {
            data = ( long )d;
            next = n;
        }
   }
}
