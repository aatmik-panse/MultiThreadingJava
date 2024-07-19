package MultiThreading;

public class LockWithCustomObjects {
    private static int count1 = 0;
    private static int count2 = 0;
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                increment1();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                increment2();
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Count1: "+count1);
        System.out.println("Count2: "+count2);

    }
    public static synchronized void increment1(){
        synchronized (lock1){
        count1++;
        }
    }
    public static synchronized void increment2(){
        synchronized (lock2){
        count2++;
        }
    }

}

/*
In this code when the increment1() method is called by t1 thread, the t2 thread cannot call the increment2() method
because the increment1() method is synchronized. So the t2 thread has to wait until the t1 thread completes its execution.
 */

/*
So to solve this issue we can use custom objects as locks.
We can create two objects lock1 and lock2 and use them as locks in the increment1() and increment2() methods.
With synchronized(lock1) and synchronized(lock2) we can lock the increment1() and increment2() methods.
synchronized block is used to lock an object for any shared resource.
When a thread invokes a synchronized method, it automatically acquires the lock for that object and releases it when the thread completes its task.
 */