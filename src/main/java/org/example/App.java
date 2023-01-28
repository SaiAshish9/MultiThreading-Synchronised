package org.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        Counter r = new Counter();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
//        t1.start();
//        t1.join();
//        t2.start();
//        t2.join();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
//            Thread class provides the join() method which allows one thread to wait
//            until another thread completes its execution. If t is a Thread object
//            whose thread is currently executing, then t. join() will make sure
//            that t is terminated before the next instruction is executed by the program
        System.out.println(r.getCounter());
        System.out.println(r.getCounter1());
        System.out.println(r.getCounter2());
    }
}
