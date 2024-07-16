package MultiThreading;

public class seq {
    public static void main(String[] args) {
        print1();
        print2();
    }
    static void print1(){
        for (int i = 0; i < 10; i++) {
            System.out.println("this is t1 "+ i);
        }
    }
    static void print2(){
        for (int i = 0; i <15; i++) {
            System.out.println("This is thread 2 " + i);
        }
    }
}
// This is a sequential program, it will print the output of print1() first and then print2().