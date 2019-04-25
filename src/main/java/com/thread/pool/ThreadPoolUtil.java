package com.thread.pool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

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

    private static LinkedBlockingQueue QUEUE = new LinkedBlockingQueue(QUEUE_SIZE);

    //    private static LinkedBlockingQueue QUEUE = new LinkedBlockingQueue();

    //    private static LinkedBlockingDeque QUEUE = new LinkedBlockingDeque(QUEUE_SIZE);

    //    private static PriorityBlockingQueue QUEUE = new PriorityBlockingQueue(QUEUE_SIZE);

    public static ExecutorService threadPoolExecutorService = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE,
            KEEP_ALIVE_TIME, TIME_UNIT, QUEUE,new MyThreadFactory(),new RejectedHandler());

    public static ExecutorService getThreadPool() {
        return threadPoolExecutorService;
    }

    /**
     * 饱和策略类
     */
    private static class RejectedHandler implements RejectedExecutionHandler {

        /**
         * Method that may be invoked by a {@link ThreadPoolExecutor} when
         * {@link ThreadPoolExecutor#execute execute} cannot accept a
         * task.  This may occur when no more threads or queue slots are
         * available because their bounds would be exceeded, or upon
         * shutdown of the Executor.
         *
         * <p>In the absence of other alternatives, the method may throw
         * an unchecked {@link RejectedExecutionException}, which will be
         * propagated to the caller of {@code execute}.
         *
         * @param r the runnable task requested to be executed
         * @param executor the executor attempting to execute this task
         * @throws RejectedExecutionException if there is no remedy
         */
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                System.out.println("rejectedExecution:"+"    "+r.toString()+"     "+executor.toString());
                executor.getQueue().put(r);
            }catch (Exception e){

            }
        }
    }

    private static class MyThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        private MyThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = "pool-" + poolNumber.getAndIncrement() + "-thread-huangbin-";
        }

        /**
         * Constructs a new {@code Thread}.  Implementations may also initialize
         * priority, name, daemon status, {@code ThreadGroup}, etc.
         *
         * @param r a runnable to be executed by new thread instance
         * @return constructed thread, or {@code null} if the request to
         *         create a thread is rejected
         */
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;        }
    }
}
