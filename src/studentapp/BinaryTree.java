/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapp;

import java.util.ArrayList;

/**
 *
 * @author xhu
 * 
 * @student William Wang
 * @id 18017970
 */
public class BinaryTree<E, F extends Comparable> {
    public Node<E, F> root; // root node
    public int number_of_nodes; // number of nodes in the tree
    public Node<E, F>[] nodeList; // array to store all the nodes in the tree

    public BinaryTree() {
        // initialise the tree
        this.root = null;
        this.number_of_nodes = 0;
        this.nodeList = null;
    }

    public BinaryTree(Node<E, F> newNode) {
        // initialise the tree with the node
        this.root = newNode;
    }

    public BinaryTree(E element, F key) {
        // create a new node with element and key, then initialise the tree with the
        // node
        this.root = new Node<E, F>(element, key);
    }

    public void addElement(E element, F key) {
        Node<E, F> newNode = new Node<E, F>(element, key); // create a new node
        addNode(this.root, newNode); // call the addNode method to add the node to the tree
    }

    public void addNode(Node<E, F> currentRoot, Node<E, F> newNode) {
        // use iteration to add node.
        if (currentRoot == null) {
            this.root = newNode; // if the root is null, then the node will be the root
        } else {
            /*
             * if the root is not null, then compare the root with the node,
             * if the root is smaller than the node, then go to the left node,
             * if the root is bigger than the node, then go to the right node.
             * then check the next layer, util the direction is null,
             * then add the node to the null position.
             * 
             */

            if (currentRoot.compareTo(newNode) < 0) {
                if (currentRoot.left == null) {
                    currentRoot.left = newNode;
                    this.number_of_nodes++; // increase the number of nodes
                } else {
                    addNode(currentRoot.left, newNode); // update the root to the left node, then check next layer
                }
            } else {
                if (currentRoot.right == null) {
                    currentRoot.right = newNode;
                    this.number_of_nodes++;
                } else {
                    addNode(currentRoot.right, newNode); // update the root to the right node, then check next layer
                }
            }
        }
    }

    public void traversal(Node<E, F> root) {
        // in order traversal
        if (root != null) {
            traversal(root.left); // traversal the left node
            System.out.println(root.element); // print the element
            traversal(root.right); // traversal the right node
        }
    }

    public Node<E, F>[] toSortedList() {
        this.nodeList = new Node[this.number_of_nodes]; // create a new array to store the nodes
        toSortedList(root); // call the toSortedList method to store the nodes
        return this.nodeList; // return the array
    }

    private void toSortedList(Node<E, F> root) {
        // in order traversal
        if (root != null) {
            toSortedList(root.right); // traversal the right node
            this.nodeList[this.number_of_nodes--] = root; // add the node to the array
            this.number_of_nodes--; // decrease the number of nodes
            toSortedList(root.left); // traversal the left node
        }
    }

    public E searchElement(F key) {

        // create a new node with the key
        Node<E, F> targetNode = new Node<E, F>();
        targetNode.key = key;

        Node<E, F> resultNode = searchNode(this.root, targetNode); // call the searchNode method to find the node

        if (resultNode != null) { 
            return resultNode.element;  // if the node is found, then return the element of resultNode
        }
        return null; // if the node is not found, then return null
    }

    public Node<E, F> searchNode(Node<E, F> currentRoot, Node<E, F> node) {

        /*
         * same logic as the addNode method,
         * 
         * if the key is smaller than the node.key, then go to the left node
         * if the key is bigger than the node.key, then go to the right node
         * then check the next layer, util the direction is equal to the node.key,
         * return the founded node.
         * or return null if the node is not found.
         * 
         */


        if (currentRoot != null) {
            if (currentRoot.compareTo(node) == 0) { // if the root is the node, then return the root
                return currentRoot;
            } else if (currentRoot.compareTo(node) < 0) { // if the root is smaller than the node, then go to the left node
                return searchNode(currentRoot.left, node);
            } else { // if the root is bigger than the node, then go to the right node
                return searchNode(currentRoot.right, node);
            }
        }

        return null;
    }

    public void reverseOrder() {
        reverseOrder(this.root); // call the recursion method
    }

    private void reverseOrder(Node<E, F> root) {

        /*
         * reach the end of the tree,
         * then swap the left and right nodes from the bottom to the top
         * 
         */

        if (root == null) { // in the end of the tree, stop the recursion
            return;
        }

        reverseOrder(root.left); // recursion the left tree
        reverseOrder(root.right); // recursion the right tree

        // swap the left and right nodes.
        Node<E, F> temp = root.left; // store the left node
        root.left = root.right; // right to left
        root.right = temp; // left to right


        /*
         * the time complexity of this method is O(n),
         * because it will go through all the nodes in the tree.
         * n is the number of nodes in the tree.
         * 
         */

    }

}
