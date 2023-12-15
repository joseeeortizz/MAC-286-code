package com.mac286.queue;
/*A queue is a data structure that allows you to store and remove elements. The interface to a queue
 * is the following:
 *
 * - A default constructor
 * - int size() returns the size
 * - boolean isEmpty() returns true if empty and false if not
 * - void add(T e) adds elements e to the back of the queue
 * - T remove() removes the front the the queue an returns it  (FIFO: First In First Out)
 * - T peek() returns the front of the queue without removing it.
 *
 * --Write a tester to test the queue with appropriate data.
 *
 */
public class ourQueue <T>{
	private T[] Q;
	private int size;

	public ourQueue() {
		Q = (T[]) new Object[100];
		size = 0;
	}

	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return (size == 0);
	}
	public void add(T e) {
		if(size >= Q.length) {
			resize();
		}
		Q[size++] = e;

		//++size is same as increase first size then use it
		//size++ is same as use size then increase it
	}
	private void resize() {
		//create a bigger array, say capacity of the old one + 10 name it temp
		T[] temp = (T[])new Object[Q.length + 10];
		//copy the all the old array into the new one.
		for(int i =0; i < size; i++) {
			temp[i] = Q[i];
		}
		//update old Array to new one
		Q = temp;
	}
	// A queue removes the front
	public T remove() {
		if(this.isEmpty())
			return null;
		//save the first
		T save = Q[0];
		//bring all item down by one
		for(int i = 0; i < size -1; i++) {
			Q[i] = Q[i+1];
		}
		size--;
		return save;
	}
	public T peek() {
		if(this.isEmpty())
			return null;
		return Q[0];
	}
	public String toString() {
		if(this.isEmpty())
			return "[]";
		String st = "[";
		for(int i = 0; i < size-1; i++) {
			st += Q[i].toString() + ", ";
		}
		st += Q[size-1] + "]";
		return st;
	}
}