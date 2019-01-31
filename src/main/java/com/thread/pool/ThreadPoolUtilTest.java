package com.thread.pool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static org.junit.Assert.*;

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

        for (int i = 0; i < 30; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    System.out.println(finalI + " 前：" + Thread.currentThread());
                    Thread.sleep(5000);
                    System.out.println(finalI + " 后：" + Thread.currentThread());
                    System.out.println(finalI + " 线程池信息：" + executorService.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Test
    public void testThreadPool2(){

    }

    public static void main(String[] args) {
        for(int i=0;i<30;i++){
            ThreadPoolUtil.getThreadPool().execute(new Task(i));
        }
    }
}