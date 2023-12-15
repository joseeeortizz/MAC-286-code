package com.mac286.hashtables;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class hashtableTester {
    public static void main(String[] args) {
        //to create a map you need to use one of the implementing classes
        //of a map  for instance hashmap or hashtable
		/*LPHashtable<String, String> H = new LPHashtable<String, String>(5);
		H.DoubleHashPut("Dog", "An animal of the canine species; annoys all the neighbohood when the owner is not there!");
		H.DoubleHashPut("Cat", "Animal of the Felin species, playful and can be very violent");
		H.DoubleHashPut("Turtle", "Animal reptile, can live up to 300 years; moves slowly");
		H.DoubleHashPut("Corse", "Animal reptile, can live up to 300 years; moves slowly");
		H.DoubleHashPut("Cor", "Animal reptile, can live up to 300 years; moves slowly");
		System.out.println("H: " + H);
		System.out.println("The value at key Dog is: " + H.DHget("Dog"));
		System.out.println("The value at key dog is: " + H.DHget("dog"));//null
		System.out.println("Deleting Turtle: " + H.DHdelete("Turtle"));
		System.out.println("H: " + H);
		*/
        ChainHashtable<Integer, String> H = new ChainHashtable<Integer, String>(13);
        H.put(18,  "fgh");
        H.put(41,  "fhgjgh");
        H.put(22,  "fvadgh");
        H.put(44,  "dgdgq");
        H.put(59,  "dfdfgh");
        H.put(32,  "fvbngh");
        H.put(31,  "fgghnadgh");
        H.put(73,  "fgcbdfbvh");
        System.out.println("H: " + H);
        System.out.println("value at 31: " + H.get(31));
        System.out.println("removing 44: " + H.delete(44) );
        System.out.println("H: " + H);
        System.out.println("removing 44: " + H.delete(44) );
        System.out.println("H: " + H);

    }

}