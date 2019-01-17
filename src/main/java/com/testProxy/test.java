package com.testProxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Proxy;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in
 * @Modified By:
 */
public class test {

    public static void main(String[] args) {
        Say say = new Say();
        ProxyClass proxyClass = new ProxyClass(say);
        ProxyInterface proxyInterface = (ProxyInterface) Proxy.newProxyInstance(Say.class.getClassLoader(), Say.class.getInterfaces(), proxyClass);
        proxyInterface.say();

        Listen listen = new Listen();
        ProxyClass proxyClass1 = new ProxyClass(listen);
        ProxyInterface proxyInterface1 = (ProxyInterface) Proxy.newProxyInstance(Listen.class.getClassLoader(),Listen.class.getInterfaces(),proxyClass1);
        proxyInterface1.say();
    }

}
