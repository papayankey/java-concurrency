package com.github.papayankey.p01_basics.thread_methods;

class ThreadNameIdSample extends Thread {
    @Override
    public void run() {
        System.out.println("Name: " + getName());
        System.out.println("Id: " + getId());

        setName("Id_Name_Thread");
        System.out.println("==============");

        System.out.println("Name: " + getName());
        System.out.println("Id: " + getId());
    }
}

//class ThreadNameIdSample implements Runnable {
//   @Override
//   public void run() {
//      Thread t = Thread.currentThread();
//      System.out.println("Name: " + t.getName());
//      System.out.println("Id: " + t.getId());
//
//      t.setName("Id_Name_Thread");
//      System.out.println("==============");
//
//      System.out.println("Name: " + t.getName());
//      System.out.println("Id: " + t.getId());
//   }
//}

public class ThreadNameAndId {
    public static void main(String[] args) {
        ThreadNameIdSample t = new ThreadNameIdSample();
        t.start();


//      Thread t = new Thread(new ThreadNameIdSample());
//      t.setName("Id_and_Name_Thread");
//      t.start();
    }
}
