import java.util.concurrent.*;

class ZooManager2 {
    public void perform(CyclicBarrier c1,CyclicBarrier c2) {
        try {
            removeLion();
            c1.await(); // join all zoo managers
            cleanCage();
            c2.await(); // join all zoo managers
            addLion();
        } catch (BrokenBarrierException | InterruptedException e) {
            // ignore exception
        }

    }

    private void removeLion() {
        System.out.printf("%d: removing lion from cage%n", Thread.currentThread().getId());
    }

    private void cleanCage() {
        System.out.println(Thread.currentThread().getId() + ": cleaning the cage");
    }

    private void addLion() {
        System.out.println(Thread.currentThread().getId() + ": adding lion into cage");
    }
}

public class CyclicBarrierSample {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
        ZooManager2 zooManager = new ZooManager2();
        CyclicBarrier c1 = new CyclicBarrier(4);
        CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println("cage cleaned!"));

        try {
            for (int i = 0; i < 4; i++) {
                fixedThreadPool.submit(() -> zooManager.perform(c1, c2));
            }
        } finally {
            fixedThreadPool.shutdown();
        }
    }


//    public static void main(String[] args) throws InterruptedException {
//        Thread z1 = new Thread(new ZooManager());
//        Thread z2 = new Thread(new ZooManager());
//        Thread z3 = new Thread(new ZooManager());
//        Thread z4 = new Thread(new ZooManager());
//
//        z1.start();
//        z2.start();
//        z3.start();
//        z4.start();
//
//        z1.join();
//        z2.join();
//        z3.join();
//        z4.join();
//
//        System.out.println("main ends");
//    }
}
