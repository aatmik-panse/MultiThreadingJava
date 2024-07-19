package MultiThreading;

public class LockWithCustomObjects {
    private static int count1 = 0;
    private static int count2 = 0;
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
        count1++;
    }
    public static synchronized void increment2(){
        count2++;
    }

}

/*
In this code when the increment1() method is called by t1 thread, the t2 thread cannot call the increment2() method
because the increment1() method is synchronized. So the t2 thread has to wait until the t1 thread completes its execution.
 */