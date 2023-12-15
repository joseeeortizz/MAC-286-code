package com.mac286.iQueue;

import com.mac286.LinkedQueue.lQueue;
import com.mac286.ourList.ourList;

public class iQueueTester {

    public static void main(String[] args) {
        iQueue<String> Q = new ourList<String>();
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
        System.out.println("Queue: " + Q);

    }

}