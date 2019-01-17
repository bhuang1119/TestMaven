package com.Proxy.jdk;

import com.Proxy.jdk.MyInvocationHandler;
import com.Proxy.jdk.UserService;
import com.Proxy.jdk.UserServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in 
 * @Modified By:
 */
public class test {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(userService);

        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),userService.getClass().getInterfaces(),myInvocationHandler);

        userServiceProxy.buy("bike");
    }

}
