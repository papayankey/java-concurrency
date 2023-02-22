package com.github.papayankey.p01_basics.creating_threads;

class RunnableSample implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("[id: " + t.getId() + ", name: " + t.getName() + "]");
    }
}

public class UsingRunnable {
    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnableSample());
        Thread t2 = new Thread(new RunnableSample());
        Thread t3 = new Thread(new RunnableSample());

        t1.start();
        t2.start();
        t3.start();
    }
}
