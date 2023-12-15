package com.mac286.hashtables;

import java.util.ArrayList;
import java.util.Iterator;

public class ChainHashtable <K, V>{
    private class Node<K, V>{
        private K  key;
        private V mData;
        public K getKey() {
            return key;
        }
        public void setKey(K key) {
            this.key = key;
        }
        public V getmData() {
            return mData;
        }
        public void setmData(V mData) {
            this.mData = mData;
        }
        public Node() {
            key 	= null;
            mData	= null;
        }
        public Node(K k, V v) {
            key 	= k;
            mData	= v;
        }
        public String toString() {
            return key + "=" + mData;
        }
    }

    ArrayList<Node<K, V>>[] H;
    private int size;
    private float loadFactor = 0.75f;
    public ChainHashtable() {
        H = new ArrayList[100];
        //each arraylist needs to be created as empty
        for(int i =0; i < H.length; i++) {
            H[i] = new ArrayList<Node<K, V>>();
        }
        size = 0;
        loadFactor = 0.75f;
    }
    public ChainHashtable(int c) {
        H = new ArrayList[c];
        for(int i =0; i < H.length; i++) {
            H[i] = new ArrayList<Node<K, V>>();
        }
        size = 0;
        loadFactor = 0.75f;
    }
    public ChainHashtable(int c, float l) {
        H = new ArrayList[c];
        for(int i =0; i < H.length; i++) {
            H[i] = new ArrayList<Node<K, V>>();
        }
        size = 0;
        loadFactor = l;
    }
    public boolean isEmpty() {
        return (size == 0);
    }
    public int hashFunction(K k) {
        return
                Math.abs((k.hashCode()%H.length));
    }

    public void put(K k, V v) {
        //create a node with k and v
        Node<K, V> n = new Node<K, V>(k, v);
        //where are you going to add this node
        int index = hashFunction(k);
        //insert n in the arrayllist at index index
        H[index].add(n);
        size++;
    }
    public V get(K k) {
        if(this.isEmpty())
            return null;
        int index = hashFunction(k);
        if(H[index].isEmpty())
            return null;
        for(int i = 0; i < H[index].size(); i++) {
            if(H[index].get(i).getKey().equals(k)) {
                return H[index].get(i).getmData();
            }
        }
        return null;
    }
    public V delete(K k) {
        if(this.isEmpty())
            return null;
        int index = hashFunction(k);
        if(H[index].isEmpty())
            return null;
		/*
		for(int i = 0; i < H[index].size(); i++) {
			if(H[index].get(i).getKey().equals(k)) {
				V save = H[index].get(i).getmData();
				//Delete the node at index i
				H[index].remove(i);
				size--;
				return save;
			}
		}*/
        Iterator<Node<K, V>> it = H[index].iterator();
        while(it.hasNext()) {
            Node<K, V> n = it.next();
            if(n.getKey().equals(k)) {
                V save = n.getmData();
                H[index].remove(n);
                size--;
                return save;
            }
        }
        return null;

    }
    public String toString() {
        if(this.isEmpty())
            return "{}";
        String st = "{";
        for(int i = 0; i<H.length; i++) {
            if(!H[i].isEmpty()) {
                st += H[i].toString() + ", ";
            }
        }
        st += "}";
        return st;
    }
}