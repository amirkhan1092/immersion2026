package Java8;

@FunctionalInterface
public interface InterfaceClass {
        public void sayHello();
        // public void sayHello2();
        default void sayBye(){
            System.out.println("Bye Execute");
        }
}
