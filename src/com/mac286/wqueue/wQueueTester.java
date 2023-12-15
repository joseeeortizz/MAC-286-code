package com.mac286.wqueue;

import com.mac286.queue.ourQueue;

public class wQueueTester {

    public static void main(String[] args) {
        //create a stack of strings
        wQueue<String> Q = new wQueue<String>();
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

    }

}