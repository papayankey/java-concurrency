# Thread Life Cycle

![](C:\Users\benneth.yankey\Desktop\Workspace\java\concurrency-lessons\src\main\resources\thread_life_cycle.png)

## NEW

- A newly created thread using `new` that has not yet started the execution
- Thread is not alive and its state is internal

## ACTIVE

- When thread invokes `start()`
- Thread moves from new to active state (`runnable` and `running`)

    - ### RUNNABLE

        - Thread state is changed to this when `start()` is called
        - Thread scheduler takes over and controls the thread
        - Thread is run right away or kept in runnable pool before running,
          implementation of thread scheduler by the OS

    - ### RUNNING

        - Thread state is changed from runnable to running and vice versa
        - Thread gets CPU
        - Thread is run by thread scheduler

## BLOCKED

- Waiting to acquire a lock to enter or re-enter a synchronized block or method

## WAITING

- Waiting for some other thread to perform a particular action with or without time limit
- Without time limit by invoking any of `wait()`, `join()` and `park()`.
- With time limit by invoking any of `sleep(time)`, `join(time)`, `parkNanos()` and `parkUnit()`

## TERMINATED

- When a thread has finished its job
- Abnormal termination: it occurs when some unusual event such as an unhandled exception