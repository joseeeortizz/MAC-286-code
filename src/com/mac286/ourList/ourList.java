package com.mac286.ourList;

import com.mac286.linkedlists.Node;

public class ourList<T> {
    private Node<T> Head;
    private Node<T> Tail;
    private int size;

    //constructor
    public ourList() {
        Head = Tail = null;
        size = 0;
    }

    //getter for size
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    //add front adds the element to the front of the list
    public void addFront(T e) {
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

    public void addBack(T e) {
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

    //remove front
    public T removeFront() {
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

    //remove front
    public T removeBack() {
        if (this.isEmpty())
            return null;
        //save the last
        T save = Tail.getData();

        if (size == 1) {
            Head = Tail = null;
            size = 0;
            return save;
        }
        //move to the one before the tail
		/*Node<T> temp = Head;
		//loop size -2 times
		for(int i = 0; i < size -2; i++)
			temp = temp.next();
			*/
        /*You can move to the last using a while loop like this.
         *
         */
        Node<T> temp = Head;
        while (temp.next().next() != null)
            temp = temp.next();

        //temp refers to the node before the last
        size--;
        temp.setNext(null);
        Tail = temp;
        return save;
    }

    //elementAt(int ind) returns the element at index ind
    public T elementAt(int ind) {
        if (this.isEmpty() || ind < 0 || ind > size - 1)
            return null;
        //create a temporary reference to go through the list
        Node<T> temp = Head;
        for (int i = 0; i < ind; i++)
            temp = temp.next();
        //At the end of the loop temp should refer to the node at index ind
        return temp.getData();
    }

    //add at specific index adds e at index ind. first is index 0 and last
    //is index size - 1
    public void add(int ind, T e) {
        if (ind < 0 || ind > size) {
            throw new IndexOutOfBoundsException();
        }
        //deal with index0 separately
        if (ind == 0) {
            this.addFront(e);
            return;
        }
        if (ind == size) {
            this.addBack(e);
            return;
        }
        //Add at index 2   2-->4 -->6 -->9
        ///               2-->4-->20-->6-->9
        //1- create a node with e as data
        Node<T> N = new Node<T>(e);
        //2- Go to node at index ind-1 call it temp
        Node<T> temp = Head;
        for (int i = 0; i < ind - 1; i++)
            temp = temp.next();
        //3- change links of new node. Set next of new Node to temp.next()
        N.setNext(temp.next());
        //4- set temp.next to new node
        temp.setNext(N);

        size++;
    }

    //remove at specific index
    public T remove(int ind) {
        if (this.isEmpty() || ind < 0 || ind > size - 1)
            return null;
        if (ind == 0)
            return this.removeFront();
        if (ind == size - 1)
            return this.removeBack();
        //go to index ind-1
        Node<T> temp = Head;
        for (int i = 0; i < ind - 1; i++)
            temp = temp.next();
        //save the data to return
        T save = temp.next().getData();
        //temp refers to the node before the one we want to remove
        temp.setNext(temp.next().next());
        size--;
        return save;
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