package com.example;


/**
 * Created by jung on 1/18/16.
 */
public class Graph {
    private int count;
    private Node[] vertices;
    Node root;
    int max;

    public Graph(int size)
    {
        vertices = new Node[size];
        count = 0;
        max = size;
    }

    public void addNode(Node n)
    {
        if ( count < max )
        {
            vertices[count] = n;
            count++;
        }
        else
        {
            System.out.println("Graph is full");
        }
    }

    public  Node[] getNode()
    {
        return vertices;
    }
    public void refresh()
    {
        for ( int i = 0; i < count; i++)
        {
            vertices[i].state = State.Unvisited;
        }
    }
}
