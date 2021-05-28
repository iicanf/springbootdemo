package com.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class RunnerThread implements Runnable {
    private int threadNum;


    @Override
    public void run() {
        ReentrantLockDemo demo = new ReentrantLockDemo();
        demo.methodA(threadNum);
    }
}