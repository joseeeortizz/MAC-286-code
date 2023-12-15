package com.mac286.arrays;

/*
 * Design a class ourVector that mimics Vector class in java.
 * You class must have the following:
 * - A reference to an array of integers (for now just integers, later we will use generic)
 * - integer size that keeps track of the number if elements in the array.
 * - accessor/getter for size
 * - Default constructor that creates an array of 10 integers (size = 0)
 	public outVector() { .....}
 * - A constructor that accepts an initial size
 	public outVector(int s) { .....}
  - boolean isEmpty() returns true if the array is empty and false if not
  - int elementAt(int ind)  return the elements at index ind, if index ind is not valid
  throw an exception OR display a message invalid index if not familiar with exceptions
  - void add(int e)  adds e to the end of the array (adds to index size)
  - String toString() returns the ontent of the array as a string between brackets [-1, -3, -6]

  //If you do up to this point and test it, you are great!
   *
   * Later
   * - void add(int ind, int e)  adds e to index ind, if ind not valid throw an exception
   * - int remove(int i) removes and returns the element at index i, if i is invalid
   * throw an exception. OR display a message invalid index if not familiar with exceptions
   * - Write a main tester where you test your class
 */
public class ourVector {
    private int[] A;
    private int size = 0;

    public ourVector() {
        A = new int[10];
        size = 0;
    }

    public ourVector(int capacity) {
        A = new int[capacity];
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
        if (size == 0)
            return true;
        return false;
    }

    //add method that adds an element to the back
    public void add(int e) {
        if (size >= A.length) {
            resize();
        }
        A[size] = e;
        size++;
    }

    public int removeBack() {
        if (this.isEmpty()) {
            System.out.println("Vector is empty");
            return -1;
        }

        //save the last element
        int save = A[size - 1];
        //decrease the size
        size--;
        //return the saved element
        return save;
    }

    public int removeFront() {
        if (this.isEmpty()) {
            System.out.println("Vector is empty");
            return -1;
        }
        //save the first element
        int save = A[0];
        //bring down all element by one
        for (int i = 0; i < size - 1; i++) {
            A[i] = A[i + 1];
        }
        //decrease the size
        size--;
        //return the saved element
        return save;
    }

    public int remove(int index) {
        if (this.isEmpty()) {
            System.out.println("Vector is empty");
            return -1;
        }
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return -1;
        }
        //save A[index]
        int save = A[index];
        //bring all elements starting at index down by one
        for (int i = index; i < size - 1; i++) {
            A[i] = A[i + 1];
        }
        //decrease size
        size--;
        //returned the saved
        return save;
    }

    public void add(int index, int e) {
        if (size >= A.length) {
            resize();
        }
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
            return;
        }

        //push up by one all elements starting at size-1 DOWN to index
        for (int i = size; i > index; i--) {
            A[i] = A[i - 1];
        }
        //add e at index
        A[index] = e;
        //increase the size
        size++;
    }

    //HW
    private void resize() {
        //create a bigger array, say capacity of the old one + 10 name it temp
        int[] temp = new int[A.length + 10];
        //copy the all the old array into the new one.
        for (int i = 0; i < size; i++) {
            temp[i] = A[i];
        }
        //update old Array to new one
        A = temp;
    }

    public String toString() {
        if (this.isEmpty())
            return "[]";
        String st = "[";
        for (int i = 0; i < size - 1; i++) {
            st += A[i] + ", ";
        }
        st += A[size - 1] + "]";
        return st;
    }
}