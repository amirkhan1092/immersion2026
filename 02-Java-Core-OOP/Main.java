
class Main {

    public static void main(String[] args) {
        System.out.println("Original main");
        
        main(10);
        main("Java");
        // main(new String []{"Abc", "CBA"}); // after adding this i am getting error 
    }

    public static void main(int x) {
        System.out.println("Integer main: " + x);
    }

    public static void main(String s) {
        System.out.println("String main: " + s);
    }
}