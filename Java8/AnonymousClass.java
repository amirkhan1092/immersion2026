package Java8;

public class AnonymousClass {
    public static void main(String[] args) {
        Greetings obj = new Greetings(){
            public void sayHello(){
                System.out.println("Hello Anonymous Class");
            }
        };
        
        obj.sayHello();
    }
}


// class Greet implements Greetings{
//     public void sayHello(){
//         System.out.println("Hello, Programmer");
//     }
// }

