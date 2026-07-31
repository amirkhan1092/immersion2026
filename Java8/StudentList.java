package Java8;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();

        list.add(new Student(10, "Raju"));
        list.add(new Student(23, "Krishna"));
        list.add(new Student(13, "Samad"));
        list.add(new Student(14, "Rakesh"));

        // display name only marks > 15

        // for(Student s: list){
        //     if(s.marks > 15){
        //         System.out.println(s.name);
        //     }
        // }

        list.stream().filter(s->s.marks>15).forEach(s->System.out.println(s.name));

        // System.out.println(list);

        
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