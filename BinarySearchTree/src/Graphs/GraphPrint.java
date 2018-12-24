/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package Graphs;

import java.util.LinkedList;

/**
 * @author Ashish Barthwal
 * @version $Id: GraphPrint.java, v 0.1 2018-12-02 7:34 PM Ashish Barthwal $$
 */
public class GraphPrint {

    static class Graph
    {
        int V;
        LinkedList<Integer> adjListArray[];

        // constructor
        Graph(int V)
        {
            this.V = V;

            // define the size of array as
            // number of vertices
            adjListArray = new LinkedList[V];

            // Create a new list for each vertex
            // such that adjacent nodes can be stored
            for(int i = 0; i < V ; i++){
                adjListArray[i] = new LinkedList<>();
            }
        }
    }

    // Adds an edge to an undirected graph
    static void addEdge(Graph graph, int src, int dest)
    {
        // Add an edge from src to dest.
        graph.adjListArray[src].add(dest);

        // Since graph is undirected, add an edge from dest
        // to src also
        graph.adjListArray[dest].add(src);
    }

    // A utility function to print the adjacency list
    // representation of graph
    static void printGraph(Graph graph)
    {
        for(int v = 0; v < graph.V; v++)
        {
            System.out.println("Adjacency list of vertex "+ v);
            System.out.print("head");
            for(Integer pCrawl: graph.adjListArray[v]){
                System.out.print(" -> "+pCrawl);
            }
            System.out.println("\n");
        }
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        // create the graph given in above figure
        int V = 5;
        Graph graph = new Graph(V);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);

        // print the adjacency list representation of
        // the above graph
        printGraph(graph);
    }
}