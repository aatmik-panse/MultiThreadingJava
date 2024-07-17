package MultiThreading;

public class JoinThread {
    public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(()->{
        for (int i = 0; i < 10; i++) {
            System.out.println("this is TH 1 "+ i);
        }
    });
    Thread t2 = new Thread(()->{
        for (int i = 0; i < 10; i++) {
            System.out.println("This is Thread 2 " + i);
        }
    });
    System.out.println("Before starting t1 and t2");
    t1.start();
    t2.start();
    t1.join();
    t2.join();
        System.out.println("After starting t1 and t2");
    }
}

/*
At first the JVM starts the main thread
 -The priority of the main thread is highest.
 SO the main thread will be executed first.
    -The main thread creates two threads t1 and t2.
    -The main thread starts the t1 and t2 threads.
    -The main thread will print "This is main thread". and thread will terminate.
    and then t1 and t2 threads will continue their execution.
 But what if I want to
 start t1 and t2 threads first and then the main thread?
    -We can use the join() method.
    the join() method is used to pause the current thread execution until the specified thread is dead.
    The jvm will start the t1 and t2 threads first and then the main thread.
    -The main thread will wait until t1 and t2 threads are dead.
*/

/*
Daemon and User Threads

*/