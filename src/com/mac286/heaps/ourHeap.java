package com.mac286.heaps;

public class ourHeap<T extends Comparable<T>> {
    //create a reference to an array of T
    private T[] H;
    private int size = 0;

    //default constructor
    @SuppressWarnings("unchecked")
    public ourHeap() {
        H = (T[]) new Comparable[100];
        size = 0;
    }

    public ourHeap(int c) {
        H = (T[]) new Comparable[c];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    private void Heapify(int ind) {
        if (ind == 0)
            return;
        if (H[ind].compareTo(H[(ind - 1) / 2]) < 0) {
            //swap the child with the parent
            T save = H[ind];
            H[ind] = H[(ind - 1) / 2];
            H[(ind - 1) / 2] = save;
            //heapify but starting at the parent H[(ind-1)/2]
            Heapify((ind - 1) / 2);
        }
        return;
    }

    public void add(T e) {
        //add it to index size then heapify
        H[size] = e;
        size++;
        Heapify(size - 1);
    }

    public T remove() {
        if (this.isEmpty())
            return null;
        //remember the top
        T save = H[0];
        if (size == 1) {
            size = 0;
            return save;
        }
        //we copy the last into index 0;
        H[0] = H[size - 1];
        //delete the last (decrease the size)
        size--;
        ReHeapify(0);
        return save;
    }

    private void ReHeapify(int ind) {
        //check if ind has two children
        //right child is 2*ind+2 it exists if 2*ind+2 < size
        //if there is a rigt then there is a left
        if (2 * ind + 2 < size) {
            //find the smallest of the two children
            int indexSmallest = 2 * ind + 2;
            if (H[2 * ind + 1].compareTo(H[2 * ind + 2]) < 0) {
                indexSmallest = 2 * ind + 1;
            }
            //Compare indexSmallest to its parent ind
            //If th smallest is smaller than ind
            //then swap the smallest with ind
            if (H[indexSmallest].compareTo(H[ind]) < 0) {
                //swap element at indexSmallest with element at ind
                T temp = H[indexSmallest];
                H[indexSmallest] = H[ind];
                H[ind] = temp;
                //keep reheapifiying at indexSmallest
                ReHeapify(indexSmallest);
            } else {
                return;
            }
        } else if (2 * ind + 1 < size) {
            //there is left child compare with it
            //compare ind to left child if larger then swap and
            //return, don't go further.
            if (H[2 * ind + 1].compareTo(H[ind]) < 0) {

                T save = H[2 * ind + 1];
                H[2 * ind + 1] = H[ind];
                H[ind] = save;
                return;
            }
        } else
            //else, no children, just return.
            return;
    }

    public String toString() {
        if (this.isEmpty())
            return "[]";
        String st = "[";
        for (int i = 0; i < size - 1; i++) {
            st += H[i] + ", ";
        }
        st += H[size - 1] + "]";
        return st;
    }
}