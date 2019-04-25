package com.Proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in 
 * @Modified By:
 */
public class JDKProxy implements InvocationHandler {

    private Object target;

    /**
     *
     * @param object 被代理对象（目标类）
     * @return 代理对象（代理类）
     */
    public Object createProxyInstance(Object object) {
        target = object;

        /**
         * 参数1：类加载器，一般采用和目标类相同的类加载器
         * 参数2：代理类实现的接口，和目标类使用相同的接口
         * 参数3：回调对象，当代理对象的方法被调用时，会调用该对象的invoke方法
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


    /**
     *
     * @param proxy 目标对象的代理类实例
     * @param method 代理类实例上调用接口方法的Method实例
     * @param args 传入到代理类实例的方法参数值的对象数组
     * @return 方法返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理开始。。。");
        Object object = method.invoke(target, args);
        System.out.println("代理结束。。。");
        return object;
    }
}
