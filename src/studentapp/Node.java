/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapp;

/**
 *
 * @author xhu
 * 
 * @student William Wang
 * @id 18017970
 */
public class Node <E, F extends Comparable> implements Comparable <Node>{

    public E element;   //E type will only be student class in this case
    public F key;      
    public Node<E, F> left;
    public Node<E, F> right;

    public Node() {
        this.element = null;
        this.key = null;
        this.left = null;
        this.right = null;
    }

    public Node(E element, F key) {
        this.element = element;
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public Node(E element, F key, Node<E, F> left, Node<E, F> right) {
        this.element = element;
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public int compareTo(Node t){

        if(this.key == null){
            if(t.key == null){
                return 0;
            }else{
                return -1;
            }
        }
        return this.key.compareTo(t.key);
    }


}

// @Override
// public int compareTo(Node t) {
//     if (this.key.compareTo(t.key) == 0) {
//         //return 0; if equal
//         return 0;
//     } else if (this.key.compareTo(t.key) > 0) {
//         //return 1; if this > t
//         return 1;
//     } else {
//         //return -1; if this < t
//         return -1;
//     }
// }