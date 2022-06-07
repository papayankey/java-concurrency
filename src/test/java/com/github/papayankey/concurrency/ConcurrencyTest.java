package com.github.papayankey.concurrency;

import org.junit.jupiter.api.Test;

public class ConcurrencyTest {

    @Test
    void createThreadUsingRunnable() {
        System.out.println("Main starts");

        // create thread
        class HelloRunnable implements Runnable {
            @Override
            public void run() {
                System.out.println("Hello from runnable");
            }
        }

        // execute thread
        HelloRunnable helloRunnable = new HelloRunnable();
        Thread thread = new Thread(helloRunnable);

        thread.start();

        System.out.println("Main ends");
    }

    @Test
    void createThreadUsingThreadClass() {
        System.out.println("main starts");

        class HelloThread extends Thread {
            @Override
            public void run() {
                System.out.println("Hello from thread");
            }
        }

        HelloThread helloThread = new HelloThread();
        helloThread.start();

        System.out.println("main ends");
    }

    @Test
    void pauseThreadExecution() {
        System.out.println("main starts");

        class MessageThread implements Runnable {

            @Override
            public void run() {
                String[] messages = {
                        "Monkey likes banana",
                        "kids like to play"
                };

                for (String message : messages) {
                    System.out.println(message);

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        Thread thread = new Thread(new MessageThread());
        thread.start();

        try {
            Thread.sleep(3000); // blocked until 3s
            System.out.println("main ends");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void interruptThread() {
        System.out.println("main starts");

        class MessageThread implements Runnable {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("I have been interrupted");
                        return;
                    }
                }
            }
        }

        Thread messageThread = new Thread(new MessageThread());
        messageThread.start();

        try {
            Thread.sleep(3000); // blocked until 3s
            messageThread.interrupt(); // main does not wait for thread to respond

            System.out.println("main ends");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void interruptThread2() {
        System.out.println("main starts");

        class MessageThread implements Runnable {
//            boolean interrupted = false;

            @Override
            public void run() {

                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(i);

                        if (Thread.interrupted()) {
                            throw new InterruptedException();
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }

//                for (int i = 0; i < 10; i++) {
//                    System.out.println(i);
//
////                    try {
////                        throw new InterruptedException("I have been interrupted");
////                    } catch (InterruptedException e) {
////                        System.out.println(e.getMessage());
////                        return;
////                    }
//                }
            }
        }

        Thread messageThread = new Thread(new MessageThread());
        messageThread.start();

        try {
            Thread.sleep(3000); // blocked until 3s
            messageThread.interrupt(); // main does not wait for thread to respond

            System.out.println("main ends");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void waitForThreadUsingJoin() throws InterruptedException {
        System.out.println("main starts");

        class MessageThread implements Runnable {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        Thread messageThread = new Thread(new MessageThread()); // NEW
        messageThread.start();// RUNNABLE

        messageThread.join(); // blocking main to finish execution

        System.out.println("main ends");
    }
}
