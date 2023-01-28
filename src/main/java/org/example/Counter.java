package org.example;

class Count {
    private int count;
    void increment() {
        count++;
    }
    public int getCount(){
        return count;
    }
}

public class Counter implements Runnable {

    private int counter;
    private int counter1;
    private int counter2;


    public void run() {
        for (int i = 1; i <= 20000; i++) {
            increment();
        }
        for (int i = 1; i <= 20000; i++) {
            increment1();
        }
        for (int i = 1; i <= 20000; i++) {
            increment2();
        }
    }

    //    instance synchronized method
    private void increment() {
        counter++;
    }

    private synchronized void increment1() {
        System.out.println(Thread.currentThread().getName());
        counter1++;
    }

//    static synchronized method

    private synchronized void increment4() {
        System.out.println(Thread.currentThread().getName());
        synchronized (Counter.class){
            counter2++;
        }
    }

//    block level synchronization
    private void increment2() {
        System.out.println(Thread.currentThread().getName());
        synchronized (this){
            counter2++;
        }
    }
    public int getCounter() {
        return counter;
    }

    public int getCounter1() {
        return counter1;
    }

    public int getCounter2() {
        return counter2;
    }


}
