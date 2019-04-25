package com.thread.pool;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicStampedReference;


/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in 
 * @Modified By:
 */
public class ThreadPoolUtilTest {

    ThreadPoolExecutor executorService = (ThreadPoolExecutor) ThreadPoolUtil.getThreadPool();

    @Test
    public void testThreadPool() {

        for (int i = 1; i <= 40; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    System.out.println(finalI + " 前：" + Thread.currentThread());
                    Thread.sleep(1000);
                    System.out.println(finalI + " 后：" + Thread.currentThread());
                    System.out.println(finalI + " 线程池信息：" + executorService.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        }
//        System.out.println(" 线程池信息后：" + executorService.toString());

    }

    @Test
    public void testThreadPool2() {
        final int COUNT_BITS = Integer.SIZE - 3;
        final int RUNNING = -1 << COUNT_BITS;
        System.out.println(RUNNING);
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<Integer>(100,0);
//        atomicStampedReference.compareAndSet();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            ThreadPoolUtil.getThreadPool().execute(new Task(i));
        }
    }
}