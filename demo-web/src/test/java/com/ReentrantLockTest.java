package com;

import com.bean.RunnerThread;

import java.util.concurrent.*;

public class ReentrantLockTest {

    public static void main(String[] args) {
        BlockingQueue<Runnable> blockingDeque = new LinkedBlockingQueue<>();

        Executors.newCachedThreadPool();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 20, 1, TimeUnit.MINUTES, blockingDeque);
//        poolExecutor.execute();
        for (int i = 0; i < 1; i++) {
            poolExecutor.execute(new RunnerThread(1));
        }
    }

}
