/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapp;

/**
 *
 * @author xhu
 */
public class StudentManager<E,F  extends Comparable> {

    public BinaryTree<Student, Float> bTreeScore;
    public BinaryTree<Student, String> bTreeName;
    
    public void addStudent(float score, String name, String comments)
    {

    }
    
    public void addToTree(Student student, F key)
    {
     
    }
    
    public Student findStudent(E key)
    {
        return null;
    }
    
    public Student[] getSortedStudentList(E key)
    {
        return null;
    }
    
    public void reverseOrder()
    {
    
    }
    
}
