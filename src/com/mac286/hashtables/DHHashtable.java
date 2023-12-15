package com.mac286.hashtables;

public class DHHashtable <K, V>{

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

    Node<K, V>[] H;
    private int size;
    private float loadFactor = 0.75f;
    public DHHashtable() {
        H = new Node[100];
        size = 0;
        loadFactor = 0.75f;
    }
    public DHHashtable(int c) {
        H = new Node[c];
        size = 0;
        loadFactor = 0.75f;
    }
    public DHHashtable(int c, float l) {
        H = new Node[c];
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

    private boolean isPrime(int a) {
        if(a == 2)
            return true;
        for(int i =2; i <= Math.sqrt(a); i++) {
            if(a%i == 0)
                return false;
        }
        return true;
    }
    private int generatePrime(int n) {
        if(n/2<=2)
            return 2;
        int m = n/2;
        while(!isPrime(m))
            m++;
        return (m);
    }
    public void put(K k, V v) {
        if(size == H.length) {
            System.out.println("Hashtable is full");
            return;
        }
        //index is generated using the following formula
        // i = h(k);
        // i + j*d(k); d(k) = (Q - k) mod Q; Q is prime < N;
        //Q = generatePrime(H.lenght)

        int index = hashFunction(k);
        int Q = generatePrime(H.length);
        int d = Q - Math.abs(k.hashCode())%Q;

        //create a node with k and v
        Node<K, V> n = new Node<K, V>(k, v);
        //where are you going to add this node
        if (H[index] == null) {
            //put the node n there
            H[index] = n;
            size++;
            return;
        }
        //if we are here then the index is taken.
        //Use linear probing

        index = (index + d)%H.length;
        int j = 0;
        while(H[index] != null && j < H.length) {
            //advance
            index = (index + d)%H.length;
            j++;
        }
        if(j == H.length) {
            System.out.println("Could not find a spot to insert");
            return;
        }
        //index is free. put n in index
        H[index] = n;
        size++;
    }

    private int find(K k) {
        if(this.isEmpty())
            return -1;

        //index is generated using the following formula
        // i = h(k);
        // i + j*d(k); d(k) = (Q - k) mod Q; Q is prime < N;
        //Q = generatePrime(H.lenght)

        int index = hashFunction(k);
        int Q = generatePrime(H.length);
        int d = Q - Math.abs(k.hashCode())%Q;

        if(H[index]!= null && H[index].getKey().equals(k))
            return index;
        int j = 0;
        index = (index + d)%H.length;
        while(j < size) {
            if(H[index] != null && H[index].getKey().equals(k))
                return index;
            else if(H[index] != null) {
                index = (index+ d)%H.length;
                j++;
            }else {
                index = (index+ d)%H.length;
            }
        }
        //it's not there
        return -1;

    }

    public V get(K k) {
        if(this.isEmpty())
            return null;
        int ind = find(k);
        if(ind < 0)
            return null;
        return H[ind].getmData();
    }

    public V delete(K k) {
        if(this.isEmpty())
            return null;
        int ind = find(k);
        if(ind < 0)
            return null;
        V save = H[ind].getmData();
        H[ind] = null;
        size--;
        return save;
    }
    public String toString() {
        if(this.isEmpty())
            return "{}";
        String st = "";
        int count = 0;
        for(int i = 0; i < H.length; i++) {
            if(H[i] !=null) {
                count++;
                if(count < size)
                    st += H[i].toString() +", ";
                else {
                    st += H[i].toString() +"}";
                    return st;
                }
            }
        }
        return st;
    }
}