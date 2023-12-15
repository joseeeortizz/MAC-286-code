package com.mac286.linkedlists;

public class Node <T> {
    private T mData;
    private Node<T> next;

    //Default constructor
    public Node() {
        mData = null;
        next = null;
    }
    public Node(T d) {
        mData = d;
        next = null;
    }
    public Node(T d, Node n) {
        mData = d;
        next = n;
    }
    //Getters
    public T getData() {
        return mData;
    }
    public Node<T> next(){
        return next;
    }
    //Setters
    public void setData(T d) {
        mData = d;
    }
    public void setNext(Node n) {
        next = n;
    }
    public String toString() {
        return mData.toString();
    }
}