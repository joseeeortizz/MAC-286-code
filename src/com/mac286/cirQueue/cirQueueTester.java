package com.mac286.cirQueue;

import com.mac286.queue.ourQueue;

public class cirQueueTester {

    public static void main(String[] args) {
        //create a stack of strings
        cirQueue<String> Q = new cirQueue<String>();
        //add few strings
        Q.add("apple");
        Q.add("Orange");
        Q.add("pineapple");
        Q.add("watermelon");
        // display the content of the stack
        System.out.println("Queue: " + Q);
        //display the top
        System.out.println("The front is: " + Q.peek());
        System.out.println("Queue: " + Q);
        //remove and element and display it
        String fruit = Q.remove();
        System.out.println("removed : " + fruit);
        //display the stack
        System.out.println("Queue: " + Q);
        //display the top of the stack
        System.out.println("The front is: " + Q.peek());
        Q.add("etert");
        Q.add("ertet");
        System.out.println("Cap: " + Q.capacity() + " Queue: " + Q);
        System.out.println("first: " + Q.first() + "  last: " + Q.last());
        Q.add("ghuwtrutui");
        System.out.println("Cap: " + Q.capacity() + " Queue: " + Q);
        System.out.println("first: " + Q.first() + "  last: " + Q.last());

    }

}