package com.mac286.postfix;

import com.mac286.wqueue.wQueue;
import com.mac286.wstack.wStack;

public class Postfix {
    private String expression;
    private wQueue<String> infix;
    private wQueue<String> postfix;

    public Postfix(String exp) {
        expression = exp;
        infix = new wQueue<String>();
        postfix = new wQueue<String>();
    }
    public String getExpression() {
        return expression;
    }
    public void setExpression(String expression) {
        this.expression = expression;
    }
    public wQueue<String> getInfix() {
        return infix;
    }
    public wQueue<String> getPostfix() {
        return postfix;
    }
    public void generateInfix() {
        //example expression"  "(  34.2*3.2 - 3.8)  / (43 * 2.5/34 - 6.1) "
        for(int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) == ')' || expression.charAt(i) == '(' || expression.charAt(i) == '+'
                    || expression.charAt(i) == '-' || expression.charAt(i) == '*' ||
                    expression.charAt(i) == '/' ) {
                infix.add(""+expression.charAt(i));
            }
            if(expression.charAt(i) == ' ')
                continue;
            if(expression.charAt(i) == '.' || Character.isDigit(expression.charAt(i))){
                int count = 1;
                while(i+count < expression.length() && (Character.isDigit(expression.charAt(i+count)) || expression.charAt(i+count) == '.'))
                    count++;
                String operand = expression.substring(i, i+count);
                infix.add(operand);
                i = i + count - 1;
            }
        }
    }
    //returns true if first is higher or equal precedence than second
    private boolean isHigherPrecedence(String first, String second) {
        if(first.equals("*") || first.equals("/") )
            return true;
        if(second.equals("-") || second.equals("+") )
            return true;
        return false;
    }
    public void generatePostFix() {
        /*Rules to generate postfix
         * 1- if '(', push to stack
         * 2- if ')' pop and append to postfix until '('
         * 3- if Operand, append to postfix
         * 4- if operator and top stack is not operator or top stack
         * is operator of lower precedence, then push operator
         * 5- if operator and top stack is operator of higher precedence,
         * pop and append to postfix
         * 6 empty the stack into postfix.
         *
         *
         */
        wStack<String> S = new wStack<String>();
        while(!infix.isEmpty()) {
            if(infix.peek().equals("(")) {
                S.push(infix.remove());
            } else if(infix.peek().equals(")")) {
                while(!S.isEmpty()&&!S.peek().equals("(")) {
                    postfix.add(S.pop());
                }
                if(S.isEmpty()) {
                    System.out.println("Something is wrong with expression!");
                    return;
                } else {
                    //throw out the "("
                    S.pop();
                    //remove the open parenthesis from the queue
                    infix.remove();
                }
            } else if (isOperator(infix.peek())) {
                if(S.isEmpty() || !isOperator(S.peek())) {
                    S.push(infix.remove());
                } else {
                    while(isOperator(S.peek()) && isHigherPrecedence(S.peek(), infix.peek() ))
                        postfix.add(S.pop());
                    //push the operator to the stack
                    S.push(infix.remove());
                }
            } else {
                //this is an operand add it to the postfix
                postfix.add(infix.remove());

            }
        }
        //empty the stack into the postfix
        while(!S.isEmpty()) {
            postfix.add(S.pop());
        }
    }

    private boolean isOperator(String s) {
        if(s.equals("+") || s.equals("-") ||s.equals("*") ||s.equals("/"))
            return true;
        return false;
    }

    public double evaluate() {
        //TODO HW.
        //evaluate the postfix.
        wStack<String> S = new wStack<String>();
        //As long as the postfix queue is not empty

        while(!postfix.isEmpty()) {
            //remove from postfix,
            String temp = postfix.remove();
            //if operand push to stack
            if(!isOperator(temp)) {
                S.push(temp);
            }else {
                //if operator, then pop from stacj two operands, perform the operation

                //pop the second operand
                double second = Double.parseDouble(S.pop());
                //then pop the first operand
                double first = Double.parseDouble(S.pop());
                //perform the operation
                //and push the result back to the stack.
                if(temp.equals("+")) {
                    S.push(""+(first+second));
                } else if(temp.equals("-")) {
                    S.push(""+(first-second));
                } else if(temp.equals("*")) {
                    S.push(""+(first*second));
                } else if(temp.equals("/")) {
                    S.push(""+(first/second));
                } else {
                    System.out.println("Aomething is wrong! Maybe wrong operator");
                }
            }
        }
        //AT THE END THE FINAL RESULT SOULD BE IN THE STACK
        return Double.parseDouble(S.pop());
    }

}