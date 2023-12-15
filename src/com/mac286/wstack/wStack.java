package com.mac286.wstack;

import com.mac286.arrays.genericVector;

public class wStack<T> {
    private genericVector<T> S;

    public wStack() {
        //create an object genericVector
        S = new genericVector<T>();
    }

    public int size() {
        return S.size();
    }

    public boolean isEmpty() {
        return S.isEmpty();
    }

    public void push(T e) {
        S.add(e);
    }

    public T pop() {
        return S.removeBack();
    }

    public T peek() {
        return S.elementAt(S.size() - 1);
    }

    public String toString() {
        return S.toString();
    }

}