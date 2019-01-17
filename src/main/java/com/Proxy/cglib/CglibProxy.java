package com.Proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in 
 * @Modified By:
 */
public class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before..."+methodProxy.getSuperName());
        System.out.println(method.getName());
        methodProxy.invokeSuper(o,objects);
        System.out.println("after..."+methodProxy.getSuperName());
        return null;
    }
}
