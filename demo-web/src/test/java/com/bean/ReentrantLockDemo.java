package com.bean;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ReentrantLockDemo {
    ReentrantLock lock1 = new ReentrantLock(true);

    public void methodA(int threadNum) {
        log.info("enter methodA,thread:{}", threadNum);
        try {
            lock1.lock();
            log.info("lock methodA, start enter methodB, thread:{}", threadNum);
            methodB(threadNum);
        } catch (Exception e) {

        } finally {
            lock1.unlock();
        }

    }

    public void methodB(int threadNum) {
        log.info("enter methodB, thread:{}", threadNum);
        ReentrantLock lock = new ReentrantLock(true);
        try {
            log.info("before methodB lock ,local lock:{},lock1: {}, thread:{}", lock.isHeldByCurrentThread(), lock1.isHeldByCurrentThread(), threadNum);
            lock.lock();
            log.info("after methodB lock ,local lock:{},lock1: {}, thread:{}", lock.isHeldByCurrentThread(), lock1.isHeldByCurrentThread(), threadNum);
            log.info("lock methodB, thread:{}", threadNum);
        } catch (Exception e) {

        } finally {
            lock.unlock();
            ;
        }

    }
}
