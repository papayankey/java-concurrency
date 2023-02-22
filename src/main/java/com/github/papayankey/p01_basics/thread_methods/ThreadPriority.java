package com.github.papayankey.p01_basics.thread_methods;


class ThreadPrioritySample extends Thread {
    @Override
    public void run() {
        System.out.println("name: " + getName() + ", Priority: " + getPriority());
    }
}

public class ThreadPriority {
    public static void main(String[] args) {
        ThreadPrioritySample t1 = new ThreadPrioritySample();
        ThreadPrioritySample t2 = new ThreadPrioritySample();

        t1.setName("t1");
        t2.setName("t2");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
    }
}

/*
 * MIN_PRIORITY = 0
 * MAX_PRIORITY = 10
 * NORMAL_PRIORITY = 5
 *
 * - IllegalArgumentException - throws when priority value is out of range MIN_PRIORITY and MAX_PRIORITY
 * - SecurityException - throws if current thread cannot modify its priority
 */
