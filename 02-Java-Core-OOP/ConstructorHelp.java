class student{
    student(){
        System.out.println("Object Created");
    }
    student(String name){
        System.out.println("Object Created");
        System.out.println("Name "+ name);
    }
}



public class ConstructorHelp {
    public static void main(String[] args) {
        student s1 = new student("Ravi");
    }
    
}
