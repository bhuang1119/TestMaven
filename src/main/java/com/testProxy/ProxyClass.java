package com.testProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in
 * @Modified By:
 */
public class ProxyClass implements InvocationHandler {

    private Object proxyObject;

    public ProxyClass(Object proxyObject) {
        this.proxyObject = proxyObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("动态代理类开始。。。");

        method.invoke(proxyObject, args);

        System.out.println("动态代理类结束。。。");
        return null;
    }
}
