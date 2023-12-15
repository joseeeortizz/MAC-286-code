package com.mac286.arrays;

public class genericVector<T> {

    private T[] A;
    private int size = 0;

    public genericVector() {
        A = (T[])new Object[10];
        size = 0;
    }

    public genericVector(int capacity) {
        A = (T[]) new Object[capacity];
        size = 0;
    }
    //getter for size
    public int size() {
        return size;
    }
    public int capacity() {
        return A.length;
    }
    public boolean isEmpty() {
        if(size == 0)
            return true;
        return false;
    }
    //add method that adds an element to the back
    public void add(T e) {
        if(size >= A.length) {
            resize();
        }
        A[size] = e;
        size++;
    }

    public T removeBack() {
        if(this.isEmpty()) {
            System.out.println("Vector is empty");
            return null;
        }

        //save the last element
        T save = A[size - 1];
        //decrease the size
        size--;
        //return the saved element
        return save;
    }

    public T removeFront() {
        if(this.isEmpty()) {
            System.out.println("Vector is empty");
            return null;
        }
        //save the first element
        T save = A[0];
        //bring down all element by one
        for(int i = 0; i <size-1; i++) {
            A[i] = A[i+1];
        }
        //decrease the size
        size--;
        //return the saved element
        return save;
    }

    public T remove(int index) {
        if(this.isEmpty()) {
            System.out.println("Vector is empty");
            return null;
        }
        if(index < 0 || index >= size) {
            System.out.println("Invalid index");
            return null;
        }
        //save A[index]
        T save = A[index];
        //bring all elements starting at index down by one
        for(int i = index; i <size-1; i++) {
            A[i] = A[i+1];
        }
        //decrease size
        size--;
        //returned the saved
        return save;
    }
    public T elementAt(int ind) {
        if(this.isEmpty() || ind < 0 || ind >= size)
            return null;
        return A[ind];

    }
    public void add(int index, T e) {
        if(size >= A.length) {
            resize();
        }
        if(index < 0 || index > size) {
            System.out.println("Invalid index");
            return;
        }

        //push up by one all elements starting at size-1 DOWN to index
        for(int i = size; i > index; i--) {
            A[i] = A[i-1];
        }
        //add e at index
        A[index]  = e;
        //increase the size
        size++;
    }
    //HW
    private void resize() {
        //create a bigger array, say capacity of the old one + 10 name it temp
        T[] temp = (T[])new Object[A.length + 10];
        //copy the all the old array into the new one.
        for(int i =0; i < size; i++) {
            temp[i] = A[i];
        }
        //update old Array to new one
        A = temp;
    }
    public String toString() {
        if(this.isEmpty())
            return "[]";
        String st = "[";
        for(int i = 0; i < size-1; i++) {
            st += A[i].toString() + ", ";
        }
        st += A[size-1] + "]";
        return st;
    }

}