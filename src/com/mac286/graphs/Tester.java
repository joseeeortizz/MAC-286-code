package com.mac286.graphs;

public class Tester {
    public static void main(String[] args) {
        //create a Graph
        Graph GR = new Graph();

        GR.addEdge("A", "B");
        GR.addEdge("A", "C");
        GR.addEdge("A", "E");
        GR.addEdge("B", "C");
        GR.addEdge("B", "A");
        GR.addEdge("C", "D");
        GR.addEdge("E", "F");
        GR.addEdge("E", "H");
        GR.addEdge("F", "G");
        GR.addEdge("H", "G");
        System.out.println("GR: \n" + GR.toString());
        System.out.println("Visited starting at A: " + GR.DFS("B"));
        System.out.println("Visited starting at F: " + GR.BFS("F"));
        System.out.println("Minimum spanning tree starting at A: " + GR.MinST("A"));
    }

}