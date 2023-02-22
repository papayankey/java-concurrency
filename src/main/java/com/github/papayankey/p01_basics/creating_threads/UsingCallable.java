package com.github.papayankey.p01_basics.creating_threads;

import java.util.concurrent.*;

class CallableSample implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread t = Thread.currentThread();
        t.setName("Callable Thread");
        return t.getName();
    }
}

public class UsingCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> future = executor.submit(new CallableSample());
        executor.shutdown();

        String result = future.get(); // blocks main until resolved
        System.out.println("Retrieved: " + result);

        System.out.println("main ends");
    }
}
