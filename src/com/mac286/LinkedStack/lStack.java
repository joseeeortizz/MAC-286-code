package com.mac286.LinkedStack;

import com.mac286.linkedlists.Node;

/*
 * Implement the queue by adding to the front and removing from the front
 *
 */

public class lStack<T> {
    private Node<T> Head, Tail;
    private int size;

    //default constructor
    public lStack() {
        Head = Tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    //push adds to the front
    public void push(T e) {
        //create a Node to store e
        Node<T> N = new Node<T>(e);

        //increase size
        size++;
        //Always modify the newly created node first.
        N.setNext(Head);
        Head = N;
        if (Tail == null) {
            //The list was empty, update tail as well
            Tail = N;
        }
    }

    //remove from front
    public T pop() {
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