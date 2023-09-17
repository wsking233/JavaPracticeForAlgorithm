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
public class StudentManager<E, F extends Comparable> {

    public BinaryTree<Student, Float> bTreeScore;
    public BinaryTree<Student, String> bTreeName;

    public StudentManager() {
        this.bTreeScore = new BinaryTree<Student, Float>();
        this.bTreeName = new BinaryTree<Student, String>();
    }

    public void addStudent(float score, String name, String comments) {
        Student student = new Student(score, name, comments);
        addToTree(student, (F) student.score);
        addToTree(student, (F) student.name);
    }

    public void addToTree(Student student, F key) {
        if (key instanceof Float) {
            bTreeScore.addElement(student, (Float) key);
        } else if (key instanceof String) {
            bTreeName.addElement(student, (String) key);
        }
    }

    public Student findStudent(F key) {
        Student studentFound = null;
        if(key instanceof Float){

            studentFound =(Student) bTreeScore.searchElement((Float)key);            
            
        }else if (key instanceof String){
              studentFound = (Student) bTreeName.searchElement((String)key);
        }

        return studentFound;
    }

    public Student[] getSortedStudentList(F key) {
       
        //get node list from the tree
        Node[] list = null;
        if(key instanceof Float){
            list = bTreeScore.toSortedList();
        }else if(key instanceof String){
            list = bTreeName.toSortedList();
        }
        
        //convert the node list to student list
        Student[] studentList = new Student[list.length];
        for(int i = 0; i < list.length; i++){
            studentList[i] = (Student)list[i].element;
        }

        //return the student list
        if(studentList.length == 0){
            // System.out.println("No student found");
            return null;
        }else{
            return studentList;
        }
    }

    public void reverseOrder() {
        bTreeScore.reverseOrder();
        bTreeName.reverseOrder();
    }

}
