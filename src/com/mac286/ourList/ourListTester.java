package com.mac286.ourList;

public class ourListTester {

    public static void main(String[] args) {
        //create a list
        ourList<Integer> L = new ourList<Integer>();
        System.out.println("removing the front: " + L.removeFront());
        System.out.println("L: " + L.toString());
        L.addFront(-1);
        System.out.println("L: " + L.toString());
        System.out.println("removing the front: " + L.removeFront());
        System.out.println("L: " + L.toString());
        L.addFront(-7);
        System.out.println("L: " + L.toString());
        System.out.println("removing the back: " + L.removeBack());
        System.out.println("L: " + L.toString());
        L.addFront(-5);
        L.addFront(-3);
        System.out.println("L: " + L.toString());
        L.addBack(-15);
        L.addBack(-13);
        System.out.println("L: " + L.toString());
        System.out.println("removing the front: " + L.removeFront());
        System.out.println("L: " + L.toString());
        System.out.println("removing the back: " + L.removeBack());
        System.out.println("L: " + L.toString());
        //add to index 0
        L.add(0, -35);
        System.out.println("L: " + L.toString());
        //add -55 at index 2
        L.add(2, -55);
        System.out.println("L: " + L.toString());
        //invalid index
        L.add(4, -75);
        System.out.println("L: " + L.toString());
        System.out.println("removing index 3: " + L.remove(3));
        System.out.println("L: " + L.toString());
    }

}