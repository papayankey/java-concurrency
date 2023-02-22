package com.github.papayankey.p01_basics.thread_methods;

class ThreadUncaughtExceptionSample extends Thread {
    @Override
    public void run() {
        String message = String.format("Exception occurred in thread; [id:%d name:%s]", getId(), getName());
        throw new RuntimeException(message);
    }
}

//class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
//    @Override
//    public void uncaughtException(Thread t, Throwable e) {
//        System.out.println("UncaughtExceptionHandler: " + e.getMessage());
//    }
//}


//class ExceptionHandlerFactory implements ThreadFactory {
//    @Override
//    public Thread newThread(Runnable r) {
//        Thread t = new Thread(r);
//        t.setUncaughtExceptionHandler(new UncaughtExceptionHandler());
//        return t;
//    }
//}

public class ThreadUncaughtException {
    // Unhandled thread exception
    public static void main(String[] args) {
        ThreadUncaughtExceptionSample t1 = new ThreadUncaughtExceptionSample();
        t1.start();
    }

    // Handled thread exception
//    public static void main(String[] args) {
//        ThreadUncaughtExceptionSample t1 = new ThreadUncaughtExceptionSample();
//        t1.setUncaughtExceptionHandler(new UncaughtExceptionHandler());
//        t1.start();
//    }

    // Handled thread exception using lambda expression
//    public static void main(String[] args) {
//        ThreadUncaughtExceptionSample t1 = new ThreadUncaughtExceptionSample();
//
//        t1.setUncaughtExceptionHandler((Thread t, Throwable e) -> {
//            System.out.println("Using lambda expression");
//            System.out.println(e.getMessage());
//        });
//
//        t1.start();
//    }

    // Handled thread exception using executor service
//    public static void main(String[] args) {
//        ExecutorService e = Executors.newFixedThreadPool(1, new ExceptionHandlerFactory());
//
//        e.execute(() -> {
//            Thread t = Thread.currentThread();
//            String message = String.format("Exception occurred in thread; [id:%d name:%s]", t.getId(), t.getName());
//            throw new RuntimeException(message);
//        });
//
//        e.shutdown();
//    }
}
