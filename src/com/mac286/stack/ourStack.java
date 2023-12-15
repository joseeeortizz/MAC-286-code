package com.mac286.stack;

/*A stack is very common data structure that allows to add and remove objects.
 * A stack exposes the following interface:
 *  int size(); returns the size of the stack
 *  boolean isEmpty(); return true if empty and false othewise
 *  void push(T e)' adds e to the top of the stack
 *  T pop(); removes the top and returns it
 *  T peek(); returns the top of the stack without removing it
 *
 *
 */
public class ourStack<T> {

    //reference to an array of Ts
    private T[] S;
    private int size;

    //Default constructor create an array of 10
    @SuppressWarnings("unchecked")
    public ourStack() {
        S = (T[]) new Object[10];
        size = 0;
    }

    //getter for size
    public int size() {
        return size;
    }

    //isEmpty
    public boolean isEmpty() {
        return (size == 0);
    }

    //push method if full resize, use the same resize method as the one on ourVector
    public void push(T e) {
        if (size >= S.length) {
            resize();
        }
        S[size] = e;
        size++;
    }

    //pop remove top and return it, if empty return null.
    public T pop() {
        if (this.isEmpty())
            return null;
        T save = S[size - 1];
        size--;
        return save;
    }

    //peek return the top without removing it.
    public T peek() {
        if (this.isEmpty())
            return null;
        return S[size - 1];
    }

    private void resize() {
        //create a bigger array, say capacity of the old one + 10 name it temp
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[S.length + 10];
        //copy the all the old array into the new one.
        for (int i = 0; i < size; i++) {
            temp[i] = S[i];
        }
        //update old Array to new one
        S = temp;
    }

    public String toString() {
        if (this.isEmpty())
            return "[]";
        String st = "[";
        for (int i = 0; i < size - 1; i++) {
            st += S[i].toString() + ", ";
        }
        st += S[size - 1] + "]";
        return st;
    }
}