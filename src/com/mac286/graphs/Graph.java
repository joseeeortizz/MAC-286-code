package com.mac286.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {

    private int size = 0;
    private Map<String, ArrayList<String>> G;

    public Graph() {
        size = 0;
        G = new Hashtable<String, ArrayList<String>>();
    }

    public void addEdge(String src, String dst) {
        //get the adjacency list of the src
        ArrayList<String> L = G.get(src);
        if(L == null) {
            //this is the first time we discovering src. Create an adjacency list for it and increase the size of
            //the number of vertices
            L = new ArrayList<String>();
            L.add(dst);
            //add the list tot he map
            G.put(src, L);
            size++;
        }else {
            //the src has been already discovered
            if(L.contains(dst)) {
                //we are trying to add dst twice, don't do it
                System.out.println("Trying to add " + dst + " twice!!!");
                return;
            }
            //else (no need for else here) add dst to the list
            L.add(dst);
        }
        //check if we have already discovered the dst.
        L = G.get(dst);
        if(L == null) {
            //this is the first time we discover dst, create an adjacency list and add it
            L = new ArrayList<String>();
            L.add(src);
            //add it to the map
            G.put(dst, L);
            size++;
        } else { //it's already discovered
            //check if src is already in the adjacency list of dst, if not add it
            if(!L.contains(src)) {
                L.add(src);
            }
        }
    }

    //HW
    //DFS returns the string of vertices visited using DFS algorithm starting at src
    public String DFS(String src) {
        //create a list of visited nodes, then turn it into string to return it
        ArrayList<String> visited = new ArrayList<String>();
        Stack<String> S = new Stack<String>();
        //push src into the stack
        S.push(src);
        while(!S.isEmpty()) {
            //pop from the stack
            String temp = S.pop();
            if(!visited.contains(temp)) {
                //add it to the visited
                visited.add(temp);
                //add all non visited neighbors of temp to the stack
                ArrayList<String> adj = G.get(temp);
                for(int i = 0; i < adj.size(); i++) {
                    if(!visited.contains(adj.get(i))) {
                        //push it to the stack
                        S.push(adj.get(i));
                    }
                }
            }
        }

        return visited.toString();
    }

    //BFS returns the string of vertices visited using BFS algorithm starting at src
    public String BFS(String src) {
        //create a list of visited nodes, then turn it into string to return it
        ArrayList<String> visited = new ArrayList<String>();
        Queue<String> Q = new LinkedList<String>();
        //visit src and add it to the queue
        visited.add(src);
        Q.add(src);
        while(!Q.isEmpty()) {
            String temp = Q.remove();
            ArrayList<String> adj = G.get(temp);
            for(int i = 0; i < adj.size(); i++) {
                if(!visited.contains(adj.get(i))) {
                    //visit it
                    visited.add(adj.get(i));
                    //add it to the queue
                    Q.add(adj.get(i));
                }
            }
        }
        return visited.toString();
    }

    public String MinST(String src) {
        String st = "";
        //create a list of visited, use a set
        Set<String> Visited = new HashSet<String>();
        //create a stack of vertices
        Stack<String> S = new Stack<String>();
        //push the src into the stack
        Visited.add(src);
        S.push(src);
        while(!S.isEmpty()) {
            //as long as the stack is not empty
            //pop from the stack
            String current = S.peek();
            //find an unvisited node adjacent to current.
            String v = null;
            ArrayList<String> adj = G.get(current);
            Iterator<String> it = adj.iterator();
            while(it.hasNext()) {
                String t = it.next();
                if(!Visited.contains(t)) {
                    v = t;
                    break; //get out of the loop
                }
            }
            if(v == null) {
                //no adjacent node to current is unvisited
                S.pop();
            }else {
                Visited.add(v);
                S.push(v);
                st += "("+ current + ", " + v + ")  ";
            }
        }
        return st;
    }
    public String toString() {
        String st = "";
        Set<String> S = G.keySet();
        System.out.println("Keys: " + S.toString());
        if (S.isEmpty())
            return "{}";
        //go through eash key and add the list of neighbors to the string
        Iterator<String> it = S.iterator();
        while(it.hasNext()) {
            String k = it.next();
            st += k + ": "  + G.get(k).toString() + "\n";
        }
        return st;
    }

}