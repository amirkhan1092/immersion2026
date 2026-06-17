public class Test {
    
    int x = 10;
    static void show() {
        System.out.println(this.x); // Error
    }
}
