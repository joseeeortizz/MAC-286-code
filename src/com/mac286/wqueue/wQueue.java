package com.mac286.wqueue;

import com.mac286.arrays.genericVector;

public class wQueue <T>{
	private genericVector<T> Q;

	public wQueue() {
		//create an object genericVector
		Q = new genericVector<T>();
	}
	public int size() {
		return Q.size();

	}
	public boolean isEmpty() {
		return Q.isEmpty();
	}
	public void add(T e) {
		Q.add(e);
	}
	public T remove() {
		//Q.remove(0); //correct
		return Q.removeFront();
	}
	public T peek() {
		return Q.elementAt(0);
	}
	public String toString() {
		return Q.toString();
	}
}