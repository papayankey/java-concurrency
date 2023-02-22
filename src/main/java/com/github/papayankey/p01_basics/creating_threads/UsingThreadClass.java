package com.github.papayankey.p01_basics.creating_threads;

class ThreadSample extends Thread {
    @Override
    public void run() {
        System.out.println("[id: " + getId() + ", name: " + getName() + "]");
    }
}

public class UsingThreadClass {
    public static void main(String[] args) {
        ThreadSample t1 = new ThreadSample();
        ThreadSample t2 = new ThreadSample();
        ThreadSample t3 = new ThreadSample();

        t1.start();
        t2.start();
        t3.start();
    }
}
