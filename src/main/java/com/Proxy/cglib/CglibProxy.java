package com.Proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
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


    /**
     * 被代理的目标对象
     */
    private Object targetObject;

    /**
     *
     * @param targetObject 目标对象
     * @return 代理对象
     */
    public Object createProxyInstance(Object targetObject) {
        this.targetObject = targetObject;
        //Enhancer用于生成代理对象
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(this.targetObject.getClass());
        //设置回调对象为本身
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     *
     * @param o 代理对象的实例
     * @param method 代理实例调用父类方法的
     * @param objects 传入到代理实例上方法参数值的对象数组
     * @param methodProxy 调用父类的方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before..." + methodProxy.getSuperName());
        System.out.println(method.getName());
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("after..." + methodProxy.getSuperName());
        return object;
    }
}
