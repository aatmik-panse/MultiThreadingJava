package MultiThreading;

public class runnable {
    public static void main(String[] args) {
        Thread t1 = new Thread(new runnable().new Print1());
        Thread t2 = new Thread(new runnable().new Print2());
        t1.start();
        t2.start();

    }
    class Print1 implements Runnable{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                System.out.println("this is TH 1 "+ i);
            }
        }
    }
    class Print2 implements Runnable{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                System.out.println("This is Thread 2 " + i);
            }
        }
    }
}

// This is a simple example of how to create a thread using the Runnable interface.
// This is a multithreaded program, it will print the output of print1() and print2() simultaneously.

/*
 * Difference between Concurrent and Parallel Programming
 * Concurrent Programming: Concurrent programming is a form of programming in which multiple computations are executed
 * during overlapping time periods—concurrently—instead of sequentially (one completing before the next starts).
 *
 * Parallel Programming: Parallel programming is a type of computation in which many calculations or processes are carried
 * out simultaneously. Large problems can often be divided into smaller ones, which can then be solved at the same time.
 *
 */

