# Concurrency in Java

### Part 1 (Thread Concepts)

+ Creating threads
    - Thread class
    - Runnable
    - ExecutorService
    - Callable
+ Thread methods
    - Thread.getId()
    - Thread.getName()
    - Thread.setName()
    - Thread.currentThread()
    - Thread.sleep() / TimeUnit
    - Thread.interrupt() / Thread.interrupted() / isInterrupted()
    - Thread.join()
    - Thread.setPriority() / Thread.getPriority()
    - Thread.setDaemon() / Thread.isDaemon()
    - Thread.getState() / Thread.isAlive() -> Thread's Life Cycle
+ Catching Exception
    - try-catch (caught)
    - Thread.UncaughtExceptionHandler (uncaught)

### Part 2 (Thread Safety)

Thread safety is the process to make our program safe to use in a multithreaded
environment. There are different ways through which we can make our program thread safe:

- Reentrant Lock
- Synchronization (synchronized keyword / block)
- Volatile
- Atomic Wrapper
- Thread-safe collection
- Thread-local

NB:

- A thread is the smallest unit of execution in a process.
- A process might have state associated which is shared among all the threads
- Each thread in turn might have some state private to itself

#### Important Terminologies / Concepts

##### Race Condition

- Race condition occurs in a multithreaded environment when more than one thread tries to access
  shared resource (modify or write) at the same time

##### Critical Section

- A code block that has a shared resource and may lead to race conditions

#### Reentrant Lock

#### Synchronized

- Is used to create synchronized code, and internally it uses locks on Objects or Classes to make
  sure only one thread is executing the synchronized code.

+ To keep in mind
    - It works only in the same JVM
    - Synchronized keyword cannot be used for constructors and variables
    - Object maintained in constant pool are not ideal for monitor lock

+ How to use synchronized keyword
    - Make a complete method synchronized (instance or static)
    - Create a synchronized block (resource for lock must be provided)

```java
// Synchronized instance method
class Foo {
    public synchronized void doSomething() {
    }
}
```

```java
// Synchronized static method
class Foo {
    public static synchronized void doSomething() {
    }
}
```

```java
// Synchronized block (similar to synchronized instance)
class Foo {
    public void doSomething() {
        synchronized (this) {
            System.out.println();
        }
    }
}
```

```java
// Synchronized block (equivalent to synchronized static method)
class Foo {
    public void doSomething() {
        synchronized (Foo.class) {
            System.out.println();
        }
    }
}
```

```java
// Synchronized block (equivalent to synchronized static method)
class Foo {
    private final Object lock = new Object();

    public void doSomething() {
        synchronized (lock) {
            System.out.println();
        }
    }
}
```
