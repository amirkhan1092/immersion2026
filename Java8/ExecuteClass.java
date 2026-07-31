package Java8;

public class ExecuteClass implements InterfaceClass{

    public void sayHello(){
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        // ExecuteClass obj = new ExecuteClass();
        // obj.sayHello();
        InterfaceClass obj = new InterfaceClass();
    }

}
