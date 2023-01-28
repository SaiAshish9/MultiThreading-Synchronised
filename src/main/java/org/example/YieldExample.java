package org.example;

public class YieldExample
{
    public static void main(String[] args)
    {
        Thread producer = new Producer();
        Thread consumer = new Consumer();
        producer.setPriority(Thread.MIN_PRIORITY);
        consumer.setPriority(Thread.MAX_PRIORITY);
        producer.start();
        consumer.start();
    }
}

/*
w/o yield
Producer : Produced Item 0
Producer : Produced Item 1
Consumer : Consumed Item 0
Producer : Produced Item 2
Consumer : Consumed Item 1
Consumer : Consumed Item 2

with yield
Consumer : Consumed Item 0
Producer : Produced Item 0
Consumer : Consumed Item 1
Producer : Produced Item 1
Consumer : Consumed Item 2
Producer : Produced Item 2

Yield means currently executing thread gives chance
to the threads that have equal priority in the Thread-pool.
Yield does not guarantee that it will change
the state of the currently executing thread to runnable state immediately.
If a join is called on a thread instance than it can be used
to join the start of a thread's execution to the end of another
thread's execution, such that a thread will not start running until another thread has ended
*/

class Producer extends Thread
{
    public void run()
    {
        for (int i = 0; i < 3; i++)
        {
            System.out.println("Producer : Produced Item " + i);
            Thread.yield();
        }
    }
}

class Consumer extends Thread
{
    public void run()
    {
        for (int i = 0; i < 3; i++)
        {
            System.out.println("Consumer : Consumed Item " + i);
            Thread.yield();
        }
    }
}
