package com.mac286.BinarySearchTree;

public class Node<T> {
    private int key;
    private T mData;
    private Node<T> left, right;

    //default constructor
    public Node() {
        key = 0;
        mData = null;
        left = right = null;
    }
    public Node(int k, T d) {
        key = k;
        mData = d;
        left = right = null;
    }
    public Node(int k, T d, Node l, Node r) {
        key = k;
        mData = d;
        left = l;
        right = r;
    }
    public String toString() {
        return key+": " + mData.toString();
    }
    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }
    public T getmData() {
        return mData;
    }
    public void setmData(T mData) {
        this.mData = mData;
    }
    public Node<T> getLeft() {
        return left;
    }
    public void setLeft(Node<T> left) {
        this.left = left;
    }
    public Node<T> getRight() {
        return right;
    }
    public void setRight(Node<T> right) {
        this.right = right;
    }


}