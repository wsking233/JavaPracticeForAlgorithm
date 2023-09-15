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
 * 
 */
public class Student {
    
    public String name;
    public Float score;
    public String comment;

    public Student() {
        this.name = null;
        this.score = null;
        this.comment = null;
    }

    public Student(Float score, String name, String comment) {
        this.name = name;
        this.score = score;
        this.comment = comment;
    }
    
    public String toString()
    {
        return "Name: "+name + "\nScore: " + score + "\nComments: " + comment;
    }
}
