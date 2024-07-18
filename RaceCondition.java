package MultiThreading;

public class RaceCondition {
    public static int count = 0;
    public static void main(String[] args) {
        Thread one = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        });
        Thread two = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        });
        one.start();
        two.start();
        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}

/*
Lets see what is happening here:
1. We have a static variable count.
2. We have two threads one and two.
3. Both threads are incrementing the count variable by 1 for 10000 times.
4. We are starting both threads.
5. We are joining both threads.
6. We are printing the count variable.
7. The expected output is 20000.
8. But the output is not 20000.
9. The output is different every time we run the program.
10. This is because of race condition
Race Condition is a situation in which two or more threads or processes are reading or writing some shared data,
and the final result depends on the timing of how the threads
are scheduled.

Here is what is happening:
1. The count variable is shared between both threads.
2. The count variable is initially 0.
3. Thread one reads the count variable and increments it by 1.
4. Thread two reads the count variable and increments it by 1.
.

1.load
2.increment
3.store

The above three steps are not atomic.
This means that the above three steps are not executed in one go.
There is a chance that the thread one reads the count variable and increments it by 1.
But before it stores the incremented value, the thread two reads the count variable and increments it by 1.
And then the thread one stores the incremented value.
SO the count variable is incremented by 1 instead of 2.
This is called
the lost update .

*/