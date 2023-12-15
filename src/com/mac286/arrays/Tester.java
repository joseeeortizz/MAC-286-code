package com.mac286.arrays;

import java.util.Vector;

public class Tester {

    public static void main(String[] args) {
        //create an object ourVector
        ourVector V = new ourVector(5);
        V.add(-2);
        V.add(-3);
        V.add(-5);
        V.add(-7);
        System.out.println("V: " + V.toString());
        V.add(-9);
        System.out.println("V: capacity " + V.capacity());
        System.out.println("V: " + V.toString());
        V.add(-11);
        System.out.println("V: capacity " + V.capacity());
        System.out.println("V: " + V.toString());
        System.out.println("removing " + V.removeFront());
        System.out.println("V: " + V.toString());
        int r = V.removeBack();
        System.out.println("removing " + r);
        System.out.println("V: " + V.toString());
        System.out.println("removing " + V.remove(1));
        System.out.println("V: " + V.toString());
        V.add(0, -13);
        System.out.println("V: " + V.toString());
        V.add(2, -15);
        System.out.println("V: " + V.toString());
        V.add(4, -17);
        System.out.println("V: " + V.toString());

        genericVector<Double> V1 = new genericVector<Double>(5);
        V1.add(-2.0);
        V1.add(-3.0);
        V1.add(-5.1);
        V1.add(-7.3);
        System.out.println("V1: " + V1.toString());
        System.out.println("The element at index 3 is: " + V1.elementAt(3));

        Vector<String> V2 = new Vector<String>(5);
        V2.add("-2.0");
        V2.add("hi");
        V2.add("there");
        V2.add("nothing");
        System.out.println("V2: " + V2.toString());
    }

}