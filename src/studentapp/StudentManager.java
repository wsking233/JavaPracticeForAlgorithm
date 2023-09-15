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
public class StudentManager<E,F extends Comparable> {

    public BinaryTree<Student, Float> bTreeScore;
    public BinaryTree<Student, String> bTreeName;

    public StudentManager() {
        this.bTreeScore = new BinaryTree<Student, Float>();
        this.bTreeName = new BinaryTree<Student, String>();
    }

    public void addStudent(float score, String name, String comments)
    {
        Student student = new Student(score, name, comments);
        addToTree(student, score);
        addToTree(student, name);
    }
    
    public void addToTree(Student student, F key)
    {
        if(key instanceof Float)
        {
            bTreeScore.addElement(student, (Float)key);
        }
        else if(key instanceof String)
        {
            bTreeName.addElement(student, (String)key);
        }
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
