package com.mac286.cirQueue;
/*
 * Implement a circular queue
 */
public class cirQueue<T> {
    private T[] Q;
    private int size, last, first;
    public cirQueue() {
        Q = (T[]) new Object[5];
        size = 0;
        last = first = -1;
    }

    public int size() {
        return size;
    }
    public int first() {
        return first;
    }
    public int last() {
        return last;
    }
    public int capacity() {
        return Q.length;
    }
    public boolean isEmpty() {
        return (size == 0);
    }
    public void add(T e) {
        if(size >= Q.length) {
            resize();
        }
        if(this.isEmpty()) {
            last = first = 0;
            Q[0] = e;
            size = 1;
            return;
        }
        last = (last+1)%Q.length;
        Q[last] = e;
        size++;
        //++size is same as increase first size then use it
        //size++ is same as use size then increase it
    }
    private void resize() {
        //create a bigger array, say capacity of the old one + 10 name it temp
        T[] temp = (T[])new Object[Q.length + 10];
        //copy the all the old array into the new one.
        for(int i =0; i < size; i++) {
            temp[i] = Q[(first+i)%Q.length];
        }
        //update old Array to new one
        first = 0;
        last = size - 1;
        Q = temp;
    }
    // A queue removes the front
    public T remove() {
        if(this.isEmpty())
            return null;
        //save the first
        T save = Q[first];
        //bring all item down by one
        size--;
        first = (first + 1)%Q.length;
        return save;
    }
    public T peek() {
        if(this.isEmpty())
            return null;
        return Q[first];
    }
    public String toString() {
        if(this.isEmpty())
            return "[]";
        String st = "[";
        for(int i = 0; i < size-1; i++) {
            st += Q[(first+i)%Q.length].toString() + ", ";
        }
        st += Q[last] + "]";
        return st;
    }
}