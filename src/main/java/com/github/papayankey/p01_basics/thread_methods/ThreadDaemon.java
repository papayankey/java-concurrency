package com.github.papayankey.p01_basics.thread_methods;


import java.util.concurrent.TimeUnit;

/*
 * - There are two main types of threads: Normal(User) and Daemon
 * - Normal threads have higher priority than Daemon thread
 * - Normal threads always run till completion once started
 * - Daemon threads are terminated when no normal thread is active
 * - Since Daemon threads terminates abruptly, they are not recommended for I/O tasks
 * - Daemon thread throws IllegalThreadStateException if an attempt to call `setDaemon` while thread is running
 */
class DaemonSample extends Thread {
    @Override
    public void run() {
        System.out.println("id: " + getId() + " daemon thread started");
        for (int i = 0; i < 1_000_000_000L; i++) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException ignore) {
            }
        }
        System.out.println("id: " + getId() + " daemon thread completed");
    }
}

public class ThreadDaemon {
    public static void main(String[] args) {
        System.out.println("main starts");

        DaemonSample t = new DaemonSample();
        t.setDaemon(true);
        t.start();

        System.out.println("id: " + t.getId() + ", is daemon: " + t.isDaemon());
        System.out.println("main ends");
    }
}

