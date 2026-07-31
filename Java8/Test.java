package Java8;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
       List<Student> list = new ArrayList<>();
       list.add(new Student(13, "Akash"));
       list.add(new Student(15, "Rakesh"));
       list.add(new Student(10, "Sohan"));
       list.add(new Student(20, "Nitin"));
       
    //    for(Student s : list){
    //         if(s.marks > 15)
    //         System.out.println(s.name);
    //    }  
    // 1. Names of the students having marks > 15  
    list.stream().filter(e->e.marks > 15).forEach(System.out::println);



    

    // list.forEach(Math::max);

    // 1. Names of the students having marks > 15 
    // sort the list by names 
    // convert all names in uppercase 
    // starting 2 elements i want to display 
}
}

class Student{
    int marks; 
    String name;

    Student(int marks, String name){
        this.marks = marks;
        this.name = name;
    }
}
