package studentapp;

public class methodTest {

    public static void main(String[] args) {

        Student student1 = new Student(70.0f, "Cindy", "Good");
        Student student2 = new Student(90.0f, "Jimmy", "Good");
        Student student3 = new Student(100.0f, "David", "Good");
        Student student4 = new Student(60.0f, "Banana", "Good");
        Student student5 = new Student(80.0f, "Tom", "Good");
        Student student6 = new Student(85.0f, "Alice", "Keep going!");

        BinaryTree treeScore = new BinaryTree();
        BinaryTree treeName = new BinaryTree();

        StudentManager studentManager = new StudentManager();

        // add student to the tree
        // add in order of score
        treeScore.addElement(student1, student1.score);
        treeScore.addElement(student2, student2.score);
        treeScore.addElement(student3, student3.score);
        treeScore.addElement(student4, student4.score);
        treeScore.addElement(student5, student5.score);
        treeScore.addElement(student6, student6.score);

        // add in order of name
        treeName.addElement(student1, student1.name);
        treeName.addElement(student2, student2.name);
        treeName.addElement(student3, student3.name);
        treeName.addElement(student4, student4.name);
        treeName.addElement(student5, student5.name);
        treeName.addElement(student6, student6.name);

        // print the tree
        // System.out.println("Print the Score tree:");
        // treeScore.traversal(treeScore.root);
        // System.out.println("===========================================");
        // System.out.println("Print the Name tree:");
        // treeName.traversal(treeName.root);

        // search the student by name
        // System.out.println("===========================================");
        // System.out.println("Search the student by name:");
        // Student result = (Student) treeName.searchElement("Tom");
        // System.out.println(result);
        // Student result2 = (Student) treeName.searchElement("Alice");
        // System.out.println(result2);

        // search the student by score
        // System.out.println("===========================================");
        // System.out.println("Search the student by score:");
        // Student result3 = (Student) treeScore.searchElement(60.0f);
        // System.out.println(result3);
        // Student result4 = (Student) treeScore.searchElement(100.0f);
        // System.out.println(result4);

        // get the sorted list
        // System.out.println("===========================================");
        // System.out.println("Get the sorted list by score:");
        // Node[] list = treeScore.toSortedList();
        // for(int i = 0; i < list.length; i++){
        // System.out.println(list[i].element);
        // }
        // System.out.println("===========================================");
        // System.out.println("Get the sorted list by name:");
        // Node[] list2 = treeName.toSortedList();
        // for(int i = 0; i < list2.length; i++){
        // System.out.println(list2[i].element);
        // }

        // System.out.println("===========================================");
        // System.out.println("sort the order by score:");
        // treeScore.traversal(treeScore.root);
        // System.out.println("===========================================");
        // System.out.println("sort the order by name:");
        // treeName.traversal(treeName.root);

        // // reverse the order
        // System.out.println("===========================================");
        // System.out.println("Reverse the order by score:");
        // treeScore.reverseOrder();
        // treeScore.traversal(treeScore.root);
        // System.out.println("===========================================");
        // System.out.println("Reverse the order by name:");
        // treeName.reverseOrder();
        // treeName.traversal(treeName.root);

        // add student to the student manager
        studentManager.addStudent(70.0f, "Cindy", "Good");
        studentManager.addStudent(36.0f, "Jimmy", "Good");
        studentManager.addStudent(100.0f, "David", "Good");
        studentManager.addStudent(60.0f, "Banana", "Good");
        studentManager.addStudent(80.0f, "Tom", "Good");
        studentManager.addStudent(85.0f, "Alice", "Keep going!");

        // find student by name
        System.out.println("===========================================");
        System.out.println("Find student by name:");
        Student result5 = studentManager.findStudent("Tom");
        System.out.println(result5);
        System.out.println("find student by score:");
        Student result6 = studentManager.findStudent(85.0f);
        System.out.println(result6);

        studentManager.reverseOrder();  // reverse the order

        System.out.println("===========================================");
        System.out.println("Find student by name after reverse:");
        Student result7 = studentManager.findStudent("Tom");
        System.out.println(result7);
        System.out.println("find student by score after reverse:");
        Student result8 = studentManager.findStudent(85.0f);
        System.out.println(result8);

        
        // //get the sorted list
        // System.out.println("===========================================");
        // System.out.println("Get the sorted list by score:");
        // Student[] list3 = studentManager.getSortedStudentList(0.0f);
        // for(int i = 0; i < list3.length; i++){
        // System.out.println(list3[i]);
        // }
        // System.out.println("===========================================");
        // System.out.println("Get the sorted list by name:");
        // Student[] list4 = studentManager.getSortedStudentList(new String());
        // for(int i = 0; i < list4.length; i++){
        // System.out.println(list4[i]);
        // }

        // reverse the order
        // System.out.println("===========================================");
        // System.out.println("Reverse the order by score:");
        // Student[] list5 = studentManager.getSortedStudentList(0.0f);
        // for(int i = 0; i < list5.length; i++){
        // System.out.println(list5[i]);
        // }
        // System.out.println("===========================================");
        // System.out.println("Reverse the order by name:");
        // Student[] list6 = studentManager.getSortedStudentList(new String());
        // for(int i = 0; i < list6.length; i++){
        // System.out.println(list6[i]);
        // }

        // System.out.println("===========================================");

        // studentManager.bTreeName.traversal(studentManager.bTreeName.root);
        // System.out.println("===========================================");

        // studentManager.bTreeScore.traversal(studentManager.bTreeScore.root);

        // find student by name after reverse

    }

}
