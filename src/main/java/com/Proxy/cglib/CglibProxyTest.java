package com.Proxy.cglib;

import com.Proxy.jdk.UserService;
import com.Proxy.jdk.UserServiceImpl;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

import static org.junit.Assert.*;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in 
 * @Modified By:
 */
public class CglibProxyTest {

    @Test
    public void intercept() {
        CglibProxy cglibProxy = new CglibProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(cglibProxy);

        UserService userService = (UserService) enhancer.create();

        userService.buy("bike");

    }
}