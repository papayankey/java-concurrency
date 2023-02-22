package com.github.papayankey.p01_basics.thread_methods;

import java.util.concurrent.TimeUnit;

class ThreadSleepSample extends Thread {
    @Override
    public void run() {
        System.out.println(getId() + ": sleeping started");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // ignore for now
        }
        System.out.println(getId() + ": sleeping completed");
    }
}

//class ThreadSleepSample extends Thread {
//    @Override
//    public void run() {
//        System.out.println("Thread id: " + getId() + " has started sleeping");
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            // ignore for now
//        }
//        System.out.println("Thread id: " + getId() + " has completed sleeping");
//    }
//}

public class ThreadSleeping {
    public static void main(String[] args) {
        System.out.println("main starts");

        ThreadSleepSample t = new ThreadSleepSample();
        t.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // ignore for now
        }

        System.out.println("main ends");
    }
}
