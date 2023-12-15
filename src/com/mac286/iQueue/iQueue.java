package com.mac286.iQueue;

public interface iQueue<T> {
    //in an interface only mthods should be specified no data

    public int size();

    public boolean isEmpty();

    public void add(T e);

    public T remove();

    public T peek();

    public String toString();

}