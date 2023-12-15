package com.mac286.arrays;

import java.util.Scanner;
import java.util.Vector;

/*
 * An array is a collection of variables of the same type.
 * Those variables are accessed using indices
 * If your array is A, then the first variable A[0], A[1] the second  and so on.
 * To define/declare an array: TYPE[] arrayName = new TYPE[SIZE];
 *
 *Using this declaration, you are declaring an array of SIZE elements of
 *type TYPE
 * Example: Declare an array of 10 strings
 * String[] names = new String[10];
 * Assign "mouloud" to second element
 * names[1] = "mouloud";
 */

public class arrays {

    //create a main where you do the following:
	/*
	public static void main(String[] args) {
		/*Create an array of 10 integers
		final int SIZE = 10;
		int[] numbers = new int[SIZE];

		//have a loop to read each integer from the user
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < SIZE; i++) {
			System.out.print("numbers["  + i + "] = ");
			numbers[i] = sc.nextInt();
		}
		//design a loop to compute the average of all elements in the array
		//sum
		int sum = 0;
		for(int i =0; i< SIZE; i++) {
			sum += numbers[i];
		}
		double average = (double)sum/SIZE;
		//display the result
		System.out.println("Average is: " + average);


		//Vector is a class that implements an array an provides huge flexibility
		//to add elements, remove, find etc...
		//To define a vector
		//Vector<TYPE> nameofVector = new Vector<TYPE>();
		//TYPE has to be a class, you cannot use primitive types
		//like int, double, char ...
		//to use integers we use the wrapper class Integer
		Integer a = 3;
		a = a.parseInt("456");
		System.out.println("a: " + a);
		//example of Vector
		Vector<Integer> V = new Vector<Integer> ();
		System.out.println("V: " + V.toString());
		//When you add elements to a vector
		V.add(-4);
		V.add(-6);
		System.out.println("V: " + V.toString());
		V.add(-10);
		System.out.println("V: " + V.toString());
		V.add(0, -15); //adds -15 at index 0, the front
		System.out.println("V: " + V.toString());
		V.add(2, -20); //adds -20 at index 2, the front
		System.out.println("V: " + V.toString());
		V.add(V.size(), -30); //adds -30 at the back
		System.out.println("V: " + V.toString());
		//V.add(8, -40); // Thisis going to trigger an exception, you can only add at
		//0 to size, anything below or above will trigger an exception.
		//to remove elements from the Vector
		//Whatever is removed is returned by the remove
		System.out.println("removing the front " + V.remove(0));
		System.out.println("V: " + V.toString());
		System.out.println("removing the element at index 3 " + V.remove(3));
		System.out.println("V: " + V.toString());
		//You can only remove index 0 to size-1
		System.out.println("removing the element at index 3 " + V.remove(V.size()));
		System.out.println("V: " + V.toString());

	}
*/

}