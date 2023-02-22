package com.github.papayankey.p01_basics.thread_methods;

class ThreadJoinSample extends Thread {
    @Override
    public void run() {
        System.out.println("[id: " + getId() + ", name: " + getName() + "]");
    }
}

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main starts");

        ThreadJoinSample t = new ThreadJoinSample();
        t.start();

        // blocks main until t is finished
        t.join();

        System.out.println("main ends");
    }
}
