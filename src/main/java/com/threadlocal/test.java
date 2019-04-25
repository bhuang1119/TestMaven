package com.threadlocal;

/**
 * @Author: huangbin
 * @Description: 线程变量测试类
 * @Date: Created in 2019/02/27
 * @Modified By:
 */
public class test {

    public static void main(String[] args) {
        ThreadLocalHolder.set("thread");
        System.out.println(ThreadLocalHolder.get());
//        Thread;
    }

}
