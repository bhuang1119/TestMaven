package com.thread.pool;

import java.util.concurrent.*;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in 
 * @Modified By:
 */
public class ThreadPoolUtil {

    private static final int CORE_POOL_SIZE = 10;

    private static final int MAX_POOL_SIZE = 20;

    private static final int QUEUE_SIZE = 15;

    private static final int KEEP_ALIVE_TIME = 1;

    private static final TimeUnit TIME_UNIT = TimeUnit.HOURS;

    //    private static ArrayBlockingQueue QUEUE = new ArrayBlockingQueue(QUEUE_SIZE);

//    private static LinkedBlockingQueue QUEUE = new LinkedBlockingQueue(QUEUE_SIZE);

//    private static LinkedBlockingQueue QUEUE = new LinkedBlockingQueue();

//    private static LinkedBlockingDeque QUEUE = new LinkedBlockingDeque(QUEUE_SIZE);

    private static PriorityBlockingQueue QUEUE = new PriorityBlockingQueue(QUEUE_SIZE);

    public static ExecutorService threadPoolExecutorService = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE,
            KEEP_ALIVE_TIME, TIME_UNIT, QUEUE);

    public static ExecutorService getThreadPool() {
        return threadPoolExecutorService;
    }
}
