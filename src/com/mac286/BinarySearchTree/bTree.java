package com.mac286.BinarySearchTree;

public class bTree<T> {
    //reference to the root
    private Node<T> root;
    private int size = 0;

    public bTree() {
        root = null;
        size = 0;
    }

    public void insert(int k, T d) {
        //create a new node
        Node<T> N = new Node(k, d);
        //Test if tree is empty then set root to node and set size to 1
        if (root == null) {
            root = N;
            size = 1;
            return;
        }
        //create a temporary reference temp set to root
        Node<T> temp = root;
        //forever do the following:
        while (true) {
            //if k < the key at temp
            if (k < temp.getKey()) {
                //if there is left at temp go to left (temp = temp.left)
                if (temp.getLeft() != null) {
                    temp = temp.getLeft();
                    continue;
                } else {
                    //if there is no left. Connect node N to th left of temp, increase size and return
                    temp.setLeft(N);
                    size++;
                    return;
                }
            } else {
                //else (k > temp key)

                //if there is right at temp go to right (temp = temp.right)
                if (temp.getRight() != null) {
                    temp = temp.getRight();
                    continue;
                } else {
                    //else (if there is no right). Connect node N to the right of temp,
                    //increase size and return
                    temp.setRight(N);
                    size++;
                    return;
                }
            }
        }

    }

    public void inOrderTraversal() {
        inOrder(this.root);
        System.out.println("");
    }

    private void inOrder(Node n) {
        if (n == null)
            return;
        //explore the left subtree
        inOrder(n.getLeft());
        //visit the node
        System.out.print("  " + n.toString());
        //explore the right subtree
        inOrder(n.getRight());
    }

    public void PreOrderTraversal() {
        PreOrder(this.root);
        System.out.println("");
    }

    private void PreOrder(Node n) {
        if (n == null)
            return;
        //visit the node
        System.out.print("  " + n.toString());
        //explore the left
        PreOrder(n.getLeft());
        //explore the right subtree
        PreOrder(n.getRight());
    }

    public void PostOrderTraversal() {
        PostOrder(this.root);
        System.out.println("");
    }

    private void PostOrder(Node n) {
        if (n == null)
            return;

        //explore the left
        PostOrder(n.getLeft());
        //explore the right subtree
        PostOrder(n.getRight());
        //visit the node
        System.out.print("  " + n.toString());
    }

    /*Design a method that returns the data of the smallest key
     *
     */
    public T smallest() {
        Node<T> temp = root;
        while (temp.getLeft() != null)
            temp = temp.getLeft();
        //temp refers to the smallest key
        return temp.getmData();
    }

    /*Design a method that returns the data of the largest key
     *
     */
    public T largest() {
        Node<T> temp = root;
        while (temp.getRight() != null)
            temp = temp.getRight();
        //temp refers to the smallest key
        return temp.getmData();
    }

    //HW
    //Find the reference of the node with smallest key on the right of node N
    private Node<T> smallestOnRight(Node<T> N) {
        Node<T> temp = N;
        if (temp.getRight() != null) {
            //go to the right once
            temp = temp.getRight();
        } else {
            return null;
        }
        //keep going to the left as long as there is left
        while (temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        return temp;

    }

    //Find the reference of the node with largest key on the left of node N
    private Node<T> largestOnLeft(Node<T> N) {
        Node<T> temp = N;
        if (temp.getLeft() != null) {
            //go to the right once
            temp = temp.getLeft();
        } else {
            return null;
        }
        //keep going to the left as long as there is left
        while (temp.getRight() != null) {
            temp = temp.getRight();
        }
        return temp;
    }

    private Node<T> parent(Node<T> N) {
        Node<T> temp = root;
        while (temp != null) {
            if (N.getKey() < temp.getKey()) {
                //check on the left to see if left is same as N
                if (temp.getLeft() != null && temp.getLeft().getKey() == N.getKey()) {
                    //temp is the parent return it.
                    return temp;
                }
                //explore the left
                temp = temp.getLeft();
            } else {
                //check on the right to see if right is same as N
                if (temp.getRight() != null && temp.getRight().getKey() == N.getKey()) {
                    //temp is the parent return it.
                    return temp;
                }
                //explore the right
                temp = temp.getRight();
            }
        }
        return temp;
    }

    private Node<T> find(int k) {
        Node<T> temp = root;
        while (temp != null) {
            if (temp.getKey() == k) {
                return temp;
            }
            //need to go to the left or right
            if (k < temp.getKey()) {
                //go to the left
                temp = temp.getLeft();
            } else {
                //gp to the right
                temp = temp.getRight();
            }
        }
        return temp;
    }

    public T delete(int k) {
        Node<T> nodeToDelete = find(k);
        if (nodeToDelete == null) {
            System.out.println("there is no key " + k + " in the tree");
            return null;
        }

        //save data to return
        T save = nodeToDelete.getmData();
        //if node to delete is root and thre is only one
        if (nodeToDelete == root && size == 1) {
            root = null;
            size = 0;
            return save;
        }
        //if node is a leaf prune it
        if (nodeToDelete.getLeft() == null && nodeToDelete.getRight() == null) {
            //go to the parent
            Node<T> parentDelete = parent(nodeToDelete);
            if (parentDelete == null) {
                System.out.println("This should not happen, there is no parent!!");
                return null;
            }
            //if node is connected to the parent through left, prune the left, else prune the right
            if (parentDelete.getLeft().getKey() == k) {
                //nodeTodelete is connected through the left
                parentDelete.setLeft(null);
                size--;
                return save;
            } else {
                //the node is connected through the right
                parentDelete.setRight(null);
                size--;
                return save;
            }
        } else {
            if (nodeToDelete.getLeft() != null) {
                //there is a left so replace it with the largest on the left
                //find the replacement
                Node<T> replacement = largestOnLeft(nodeToDelete);
                if (replacement == null) {
                    System.out.println("We have a problem!! replacement is null");
                    return null;
                }
                Node<T> parentReplacement = parent(replacement);
                if (parentReplacement == null) {
                    System.out.println("We have a problem!! parent replacement is null");
                    return null;
                }
                //copy replacement to nodeToDelete
                nodeToDelete.setKey(replacement.getKey());
                nodeToDelete.setmData(replacement.getmData());
                //set the link through which replacement is connected to its parent
                //to left of replacement
                if (parentReplacement.getRight() != null &&
                        parentReplacement.getRight().getKey() == replacement.getKey()) {
                    //replacement is connected to its parent through the right
                    parentReplacement.setRight(replacement.getLeft());
                } else {
                    //it has to be connected through the left
                    parentReplacement.setLeft(replacement.getLeft());
                }
                size--;
                return save;
            } else {
                //replace it with the smallest on the right
                //find the replacement
                Node<T> replacement = smallestOnRight(nodeToDelete);
                if (replacement == null) {
                    System.out.println("We have a problem!! replacement is null smallest on right");
                    return null;
                }
                Node<T> parentReplacement = parent(replacement);
                if (parentReplacement == null) {
                    System.out.println("We have a problem!! parent replacement is null smallest on right");
                    return null;
                }
                //copy replacement to nodeToDelete
                nodeToDelete.setKey(replacement.getKey());
                nodeToDelete.setmData(replacement.getmData());
                //set the link through which replacement is connected to its parent
                //to right of replacement
                if (parentReplacement.getRight() != null &&
                        parentReplacement.getRight().getKey() == replacement.getKey()) {
                    //replacement is connected to its parent through the right
                    parentReplacement.setRight(replacement.getRight());
                } else {
                    //it has to be connected through the left
                    parentReplacement.setLeft(replacement.getRight());
                }
                size--;
                return save;
            }
        }
    }

}