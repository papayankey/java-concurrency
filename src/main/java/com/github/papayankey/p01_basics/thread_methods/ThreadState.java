package com.github.papayankey.p01_basics.thread_methods;

import java.util.concurrent.TimeUnit;

class ThreadStateSample extends Thread {
    @Override
    public void run() {
        System.out.println("state: " + getState());
        System.out.println("is alive: " + isAlive());

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ignore) {
        }

    }
}


public class ThreadState {
    public static void main(String[] args) {
        ThreadStateSample t = new ThreadStateSample();
        t.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ignore) {
        }

        System.out.println("state: " + t.getState());
        System.out.println("is alive: " + t.isAlive());
    }
}
