package com.mac286.linkedlists;

public class nodeTester {

    public static void main(String[] args) {
        //create a node N1 to store Strings
        Node<String> N1 = new Node<String>();
        //assign the string "Spring" to it
        N1.setData("Spring");
        //display the node N1
        System.out.println("N1: " + N1.toString());
        //create a node N2 with "summer" as data.
        Node<String> N2 = new Node<String>("Summer");
        //Display the node N2
        System.out.println("N2: " + N2);
        //Create a node N3 with data "Fall" and next as N2
        Node<String> N3 = new Node<String>("Fall", N2);
        //Display N3
        System.out.println("N3: " + N3);
        //link N1 to N3 (N1 next should be N3)
        N1.setNext(N3);
        //display N1
        System.out.println("N2 reference is: " + N2);
        //How can you access N2, from N1? Show N2 data using only N1 reference
        System.out.println("N2 from N1 is: " + N1.next().next());
        //Create a Node N4 with data "Winter".
        Node<String> N4 = new Node<String>("Winter");
        //Add N4 between N3 and N2, if the only reference you know is N1.
        //Always change the newly created node before messing up with your chain
        N4.setNext(N2);
        //set next of N3 to N4 using N1 (N1.next() is same as N3, use it)
        (N1.next()).setNext(N4);
        //show N1, then N1.next(), then N1.next().next() then N1.next().next().next()
        System.out.println("N1: " + N1);
        System.out.println("N3: " + N1.next());
        System.out.println("N4: " + N1.next().next());
        System.out.println("N2: " + N1.next().next().next());
        System.out.println("This should not work!: " + N1.next().next().next().next());
        //Remove N3 from the chain using only N1 reference, no N2, N3 or N4 anywhere
        //N1 next should be set to N4, that would be enough
        N1.setNext(N1.next().next());
        System.out.println("N1: " + N1);
        System.out.println("Should be N4: " + N1.next());
        System.out.println("Should be N2: " + N1.next().next());
        System.out.println("Should be null: " + N1.next().next().next());
    }

}