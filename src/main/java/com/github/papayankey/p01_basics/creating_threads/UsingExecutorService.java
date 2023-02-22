package com.github.papayankey.p01_basics.creating_threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SampleRunnable implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("[id: " + t.getId() + ", name: " + t.getName() + "]");
    }
}

public class UsingExecutorService {
    public static void main(String[] args) {
        // Executors.newCachedThreadPool :-
        // creates as many threads it needs during execution of program and stops
        // creating as it recycles or reuses old ones
        ExecutorService e1 = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            e1.execute(new SampleRunnable());
        }
        e1.shutdown();

        // Executors.newFixedThreadPool :-
        // creates fixed number of threads upfront
        ExecutorService e2 = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 3; i++) {
            e2.execute(new SampleRunnable());
        }
        e2.shutdown();

        // Using SingleThreadPool :- create a pool of a single thread
        // Leverages a queue to guarantee sequential execution of tasks.
        ExecutorService e3 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            e3.execute(new SampleRunnable());
        }
        e3.shutdown();
    }
}
