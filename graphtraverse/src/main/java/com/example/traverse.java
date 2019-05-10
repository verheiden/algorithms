package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import static com.example.State.Unvisited;
import static com.example.State.Visited;

/* Depth first search, Breath first Search, find a quickest path between two vertexes
   by Jung Verheiden */
public class traverse {
    static Graph g;
    static Node root;
    public static void main(String[] args) {
    Node[] nodes;

        nodes = createNewGraph();
        root = nodes[0];

        System.out.println("Depth First Search graphs");
        dfs();
        System.out.println("\n\n Breath First Search graphs");
        bfs();
        List<String> sPath;
        if ((sPath = shortestPath(nodes[0], nodes[7])) != null) {
            System.out.println("\n Shortest path from: " + nodes[0].getVertex() + " to: " + nodes[7].getVertex());
            for (String r : sPath) {
                System.out.print(r + "- ");
            }
        }

    }

    public static Node[] createNewGraph()
    {
        g = new Graph(8);
        Node[] temp = new Node[8];

        temp[0] = new Node("A", 4);
        temp[1] = new Node("B", 4);
        temp[2] = new Node("C", 2);
        temp[3] = new Node("D", 1);
        temp[4] = new Node("E", 1);
        temp[5] = new Node("F", 1);
        temp[6] = new Node("G", 3);
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
        temp[6].addChildNode(temp[0]);

        temp[7].addChildNode(temp[2]);
        temp[7].addChildNode(temp[1]);

        for (int i = 0; i <= 7; i++) {
            g.addNode(temp[i]);
        }
        return g.getNode();
    }


    public static void traverse(Node root)
    {
        if (root == null)
            return;
        System.out.println(root.getVertex() + "\t");
        root.state = Visited;
        for (Node r : root.getChild()) {
            if (r.state == Unvisited) {
                traverse(r);
            }
        }
    }

    public static void bfs()
    {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node parent = q.remove();
            System.out.println(parent.getVertex());
            for (Node c : parent.getChild()) {
                if (c.state == Unvisited) {
                    c.state = Visited;
                    q.add(c);
                }
            }
        }
    }

    public static void dfs()
    {
        g.refresh();
        Stack<Node> s = new Stack<Node>();
        s.push(root);
        while(!s.empty())
        {
            Node parent = s.pop();
            if ( parent.state == Unvisited )
            {
                parent.state = Visited;
                for( Node child : parent.getChild()){
                    if ( child.state == Unvisited ){
                        s.push(child);
                    }
                }
            }
        }
    }


    public static List<String> shortestPath(Node source, Node dest)
    {
        g.refresh();
        Queue<Node> s = new LinkedList<>();
        source.state = State.Visited;
        s.add(source);
        List<String> path = new ArrayList<String>();
        while (!s.isEmpty()) {
            Node node = s.remove();
            path.add(node.getVertex());
            for (Node c : node.getChild()) {
                if (c.state == State.Unvisited) {
                    if (c.getVertex().equals(dest.getVertex())) {
                        path.add(c.getVertex());
                        return path;
                    }
                    c.state = State.Visited;
                    s.add(c);
                }
            }
        }
        return null;
    }
    int longestToSelf(Node root)
    {
        Stack<Node> s = new Stack<Node>();
        s.push(root);
        root.state = State.Visited;
        int maxPath = 0;
        int depth = 0;
        while(!s.isEmpty()){
            Node current = s.peek();
            boolean allVisited= true;
            for ( Node c : current.getChild() )
            {
                if ( c.state != State.Visited ){
                    c.state = State.Visited;
                    s.add(c);
                    allVisited = false;
                }
            }
            if ( allVisited == false )
            {
                depth++;
            }
            else
            {
                maxPath = Math.max(maxPath, depth + 1);
                s.remove(current);
                depth = 0;
            }
        }
        return maxPath;
    }
}
