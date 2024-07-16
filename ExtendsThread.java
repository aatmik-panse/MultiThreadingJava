package MultiThreading;

public class ExtendsThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ExtendsThread().new Print1());
        Thread t2 = new Thread(new ExtendsThread().new Print2());
        Thread t3 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("This is Thread 3 " + i);
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
    class Print1 extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 50; i++) {
                System.out.println("this is TH 1 "+ i);
            }
        }
    }
    class Print2 extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 60; i++) {
                System.out.println("This is Thr 2 " + i);
            }
        }
    }
}

/*
Implementing Runnable VS Extending Thread
1. Implementing Runnable is preferred because Java does not support multiple inheritances.
2. If you extend the Thread class, you cannot extend any other class, but if you implement the Runnable interface,
you can extend another class as well.
3. Implementing Runnable is considered a better object-oriented design practice.
4. Implementing Runnable is more flexible than extending the Thread class.
*/