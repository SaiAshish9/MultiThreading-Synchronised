package org.example;

public class SyncDemo {

    public static void main(String[] args) throws InterruptedException {
        final Count c = new Count();
        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<=1000;i++){
                    c.increment();
                }
            }
        });
        t1.start();
        t1.join();
        System.out.println(c.getCount());
    }

}
