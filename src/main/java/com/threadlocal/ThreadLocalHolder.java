package com.threadlocal;

/**
 * @Author: huangbin
 * @Description: 线程变量载体
 * @Date: Created in 2019/02/27
 * @Modified By:
 */
public class ThreadLocalHolder {

    /**
     * 线程变量实例
     */
    public static ThreadLocal<String> threadLocal = new ThreadLocal<String>();


    /**
     * 获取线程变量
     * @return
     */
    public static String get() {
        return threadLocal.get();
    }

    /**
     * 设置线程变量
     * @param str
     */
    public static void set(String str) {
        threadLocal.set(str);
    }

    /**
     * 清除线程变量
     */
    public static void clear() {
        threadLocal.remove();
    }
}
