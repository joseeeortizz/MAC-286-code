package com.mac286.LinkedQueue;

import com.mac286.linkedlists.Node;

/*
 * Implement the queue by adding to the back and removing from the
 * front.
 */

public class lQueue<T> {
    private Node<T> Head, Tail;
    private int size;

    //default constructor
    public lQueue() {
        Head = Tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    //add to the back
    public void add(T e) {
        //create a new node with e
        Node<T> N = new Node<T>(e);
        size++;
        //set next of the last to N
        if (Tail != null)
            Tail.setNext(N);
        //set Tail to N
        Tail = N;
        if (Head == null)
            Head = N;
    }

    public T remove() {
        if (this.isEmpty())
            return null;
        //save front
        T save = Head.getData();
        size--;
        Head = Head.next();
        if (size == 0)
            Head = Tail = null;
        return save;
    }

    public T peek() {
        if (this.isEmpty())
            return null;
        return Head.getData();
    }

    public String toString() {
        if (this.isEmpty())
            return "[]";
        String st = "[";
        Node<T> temp = Head;
        while (temp.next() != null) {
            st += temp.toString() + ", ";
            temp = temp.next();
        }

        st += Tail.toString() + "]";
        return st;
    }
}