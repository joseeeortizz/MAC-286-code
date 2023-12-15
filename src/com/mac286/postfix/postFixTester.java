package com.mac286.postfix;

public class postFixTester {

    public static void main(String[] args) {
        // Create a postfix object
        Postfix P = new Postfix("( 34.2*3.2 - 3.8)  / (43 * 2.5/34 - 6.1)");
        P.generateInfix();
        System.out.println("infix: " + P.getInfix().toString());
        P.generatePostFix();
        System.out.println("infix: " + P.getPostfix().toString());
        //expeted postfix:  34.2 3.2* 3.8-43 2.5 * 34 / 6.1- /
        System.out.println(P.getExpression() + " = " + P.evaluate());
        //Cannot call evaluate twice because postfix queue has been emptied
        System.out.println(P.getExpression() + " = " + P.evaluate());
    }

}