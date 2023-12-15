package com.mac286.BinarySearchTree;

public class bTreeTester {

    public static void main(String[] args) {
        //create a tree
        bTree<String> T = new bTree<String>();
        T.insert(25, "dfgdfg");
        T.insert(35, "df");
        T.insert(30, "dfg");
        T.insert(28, "dffg");
        T.insert(32, "dfg");
        T.insert(37, "dfrhg");
        T.insert(17, "dfrqfg");
        T.insert(19, "drthfg");
        T.insert(10, "dlulfg");
        T.insert(14, "d;i;fg");
        T.insert(5, "dfo;;");
        T.inOrderTraversal();
        T.PreOrderTraversal();
        T.PostOrderTraversal();
        System.out.println("smallest is: " + T.smallest());
        System.out.println("largest is: " + T.largest());
        System.out.println("deleting 17: " + T.delete(17));
        T.inOrderTraversal();
        T.PreOrderTraversal();
        System.out.println("deleting 32: " + T.delete(32));
        T.inOrderTraversal();
        T.PreOrderTraversal();
        System.out.println("deleting the root 25: " + T.delete(25));
        T.inOrderTraversal();
        T.PreOrderTraversal();
        T.insert(47, "dhgdffo;;");
        T.insert(40, "dheeeefo;;");
        T.insert(43, "dsssssffo;;");
        T.inOrderTraversal();
        T.PreOrderTraversal();
        System.out.println("deleting 37 no left: " + T.delete(37));
        T.inOrderTraversal();
        T.PreOrderTraversal();


    }

}