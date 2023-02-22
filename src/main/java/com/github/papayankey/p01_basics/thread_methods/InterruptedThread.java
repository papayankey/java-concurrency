package com.github.papayankey.p01_basics.thread_methods;

import java.util.concurrent.TimeUnit;

class InterruptedThreadSample extends Thread {
    @Override
    public void run() {
        System.out.println("id: " + getId() + " started");
//        for (int i = 0; i < 1000000000L; i++) {
//            System.out.println(i);
//        }
        for (int i = 0; i < 1000000000L; i++) {
            System.out.println(i);

            if (Thread.interrupted()) {
                System.out.println("id: " + getId() + " was interrupted");
                return;
            }
//            if (isInterrupted()) {
//                System.out.println("id: " + getId() + " was interrupted");
//                Thread.interrupted();
//                return;
//            }
        }

        System.out.println("id: " + getId() + " completed");
    }
}

//class InterruptedThreadSample extends Thread {
//    @Override
//    public void run() {
//        System.out.println("id: " + getId() + " started");
//
////        for (int i = 0; i < 1000000000L; i++) {
////            System.out.println(i);
////        }
//
//        for (int i = 0; i < 1000000000L; i++) {
//            System.out.println(i);
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                System.out.println("id: " + getId() + " was interrupted");
//                return;
//            }
//        }
//
//        System.out.println("id: " + getId() + " completed");
//    }
//}

public class InterruptedThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main starts");

        InterruptedThreadSample t = new InterruptedThreadSample();
        t.start();

        TimeUnit.SECONDS.sleep(1);

        t.interrupt(); // non-blocking

        System.out.println("main ends");
    }
}


/*
  NB: A thread can be interrupted if it's in ony of these states
  1. sleep
  2. wait
  3. joi
  4. by interrupted() or isInterrupted() on current thread
 */
