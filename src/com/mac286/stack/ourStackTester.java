package com.mac286.stack;

public class ourStackTester {

    public static void main(String[] args) {
        //create a stack of strings
        ourStack<String> st = new ourStack<String>();
        //add few strings
        st.push("apple");
        st.push("Orange");
        st.push("pineapple");
        st.push("watermelon");
        // display the content of the stack
        System.out.println("Stack: " + st);
        //display the top
        System.out.println("The top is: " + st.peek());
        System.out.println("Stack: " + st);
        //remove and element and display it
        String fruit = st.pop();
        System.out.println("removed : " + fruit);
        //display the stack
        System.out.println("Stack: " + st);
        //display the top of the stack
        System.out.println("The top is: " + st.peek());
    }

}