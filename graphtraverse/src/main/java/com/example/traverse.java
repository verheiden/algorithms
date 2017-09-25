package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
/* Depth first search, Breath first Search, find a quickest path between two vertexes
   by Jung Verheiden */
public class traverse {

    public static void main(String[]  args){
        
        Graph graph = createNewGraph();
        Node[] nodes = graph.getNode();

      System.out.println("Depth First Search graphs");
        traverse(nodes[0]);
        System.out.println("\n\n Breath First Search graphs");
        refresh(graph);
        bfs(nodes[0]);
        System.out.println("\n\n Depth First Search with stack");
        refresh(graph);
        dfsStack(graph.getNode()[0]);
        refresh(graph);
        List<String> sPath ;
        if ( (sPath = findShortestPath(nodes[0],nodes[7] )) != null )
        {
            System.out.println("\n Shortest path from: " + nodes[0].getVertex() +
                " to: " + nodes[7].getVertex());
            for( String r : sPath ){
                System.out.print( r + "- ");
            }
        }

   }
    public static void dfsStack(Node root)
    {
         if ( root == null )
             return;
         Stack<Node> s = new Stack<Node>();
         Node p;
         boolean notVisitedFound;
         s.push(root);
         while(!s.empty() )
         {
             p = s.peek();
             notVisitedFound = false;
             for ( Node n : p.getChild() ){
                 if ( n.state == State.Unvisited )
                 {
                     n.state = State.Visited;
                     s.push(n);
                     notVisitedFound = true;
                 }
             }
             if ( notVisitedFound == false  )
                 s.pop();
         }
    }
    public static List<String> findShortestPath(Node source, Node dest)
    {
        Queue<Node> q = new LinkedList<Node>();
        List<String> path = new ArrayList<String>();

        source.state = State.Visited;
        q.add(source);
        while( !q.isEmpty()){
            Node p= q.remove();
            path.add(p.getVertex());
            for(Node c: p.getChild())
            {
                if ( c.state == State.Unvisited )
                {
                    c.state = State.Visited;
                    if ( dest.getVertex() == c.getVertex() )
                    {
                        path.add(c.getVertex());
                        return path;
                    }
                    else
                        q.add(c);
                }
            }
        }
        return null;
    }
    public static Graph createNewGraph()
    {
        Graph g = new Graph(8);
        Node[] temp = new Node[8];

        temp[0] = new Node("A", 4);
        temp[1] = new Node("B", 4);
        temp[2] = new Node("C",2);
        temp[3] = new Node("D", 1);
        temp[4] = new Node("E", 1);
        temp[5] = new Node("F", 1);
        temp[6] = new Node("G", 3 );
        temp[7] = new Node("H", 2);

        temp[0].addChildNode(temp[1]);
        temp[0].addChildNode(temp[2]);
        temp[0].addChildNode(temp[3]);
        temp[0].addChildNode(temp[6]);

        temp[1].addChildNode(temp[0]);
        temp[1].addChildNode(temp[4]);
        temp[1].addChildNode(temp[5]);
        temp[1].addChildNode(temp[7]);

        temp[2].addChildNode(temp[0]);
        temp[2].addChildNode(temp[7]);
        temp[3].addChildNode(temp[0]);
        temp[4].addChildNode(temp[1]);
        temp[5].addChildNode(temp[1]);

        temp[6].addChildNode(temp[2]);
        temp[6].addChildNode(temp[3]);
        temp[6].addChildNode(temp[4]);

        temp[7].addChildNode(temp[2]);
        temp[7].addChildNode(temp[1]);

        for (int i = 0; i <= 7; i++)
        {
            g.addNode(temp[i]);
        }
        return g;
    }
    private static void refresh(Graph g)
    {
        for(Node r: g.getNode())
        {
            r.state = State.Unvisited;
        }
    }
    public static void traverse(Node root)
    {
        if ( root == null )
            return;
        System.out.println(root.getVertex() + "\t");
        root.state = State.Visited;
        for( Node r : root.getChild() ){
            if ( r.state == State.Unvisited ){
                traverse(r);
            }
        }
    }

    public static void bfs(Node root)
    {
         Queue<Node> q = new LinkedList<Node>();

         if ( root == null )
             return;
         q.add(root);
         root.state = State.Visited;
         while(!q.isEmpty())
         {
             Node n = q.remove();
             System.out.println( n.getVertex());
             for(Node r: n.getChild() ){
                 if ( r.state == State.Unvisited )
                 {
                     r.state = State.Visited;
                     q.add(r);
                 }
             }
         }
    }
    public static void dfs(Node root)
    {
        if ( root == null )
            return;
        Stack<Node> st = new Stack<>();
        boolean newFound = false;
        Node p;
        st.push(root);
        while(!st.isEmpty()){
            p = st.peek();
            newFound = false;
            for( Node ch: p.getChild())
            {
                if ( ch.state == State.Unvisited )
                {
                    newFound = true;
                    st.push(ch);
                    ch.state = State.Visited;
                }
            }
            if ( newFound == false)
                st.pop();
        }
    }

    public static void bfs1(Node root)
    {
        if ( root == null )
            return;

        Queue<Node> q = new LinkedList<>();
        root.state = State.Visited;
        q.add(root);

        while( !q.isEmpty())
        {
            Node pa = q.remove();
            for( Node ch : pa.getChild())
            {
                if ( ch.state == State.Unvisited)
                {
                    ch.state = State.Visited;
                    q.add(ch);
                }
            }
        }
    }
    public static List<String> shorestPath(Node source, Node dest){
        List<String> paths = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        source.state = State.Visited;
        q.add(source);
        while(!q.isEmpty())
        {
            Node current = q.remove();
            paths.add(current.getVertex());
            for( Node ch : current.getChild()){
                if ( ch.state == State.Unvisited )
                {

                    ch.state = State.Visited;
                    if ( dest.getVertex() == ch.getVertex())
                    {
                        paths.add(dest.getVertex());
                        return paths;
                    }
                    else
                        q.add(ch);
                }
            }
        }
    }
}
