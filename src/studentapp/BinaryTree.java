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
public class BinaryTree <E, F extends Comparable> {
    public Node root;
    public int number_of_nodes;
    public ArrayList<Node> nodeList;
    
    public BinaryTree()
    {   
        //initialise the tree
        this.root = null;
        this.number_of_nodes = 0;
        this.nodeList = new ArrayList<>();
    }
    
    public BinaryTree(Node node)
    {  
        //initialise the tree with the node
        this.root = node;
    }
    
    public BinaryTree(E element, F key)
    {
        //create a new node with element and key, then initialise the tree with the node
        this.root = new Node(element, key);
    }
    
    public void addElement(E element, F key)
    {   
        Node node = new Node(element, key);     //create a new node
        addNode(root, node);    //call the addNode method to add the node to the tree
    }
    
    public void addNode(Node root, Node node)
    {        
        if (root == null) {
            root = node;
        } else {
            if (root.compareTo(node) < 0) {
                if (root.left == null) {
                    root.left = node;
                } else {
                    addNode(root.left, node);
                }
            } else {
                if (root.right == null) {
                    root.right = node;
                } else {
                    addNode(root.right, node);
                }
            }
        }
    }
    
    public void traversal(Node root)
    {

    }
    
    public Node[] toSortedList()
    {
        return null;
    }
    
    private void toSortedList(Node root)
    {

    }
    
    public E searchElement(F key)
    {
        return null;
    }
       
    public Node searchNode(Node root, Node node)
    {
        return null;
    }
    
    public void reverseOrder()
    {

    }
    
    private void reverseOrder(Node root)
    {

    }
    
}
