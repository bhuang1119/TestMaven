package com.Proxy.jdk;

import com.Proxy.jdk.UserService;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in 
 * @Modified By:
 */
public class UserServiceImpl implements UserService {

    /**
     *
     * @param item
     */
    @Override
    public void buy(String item) {
        System.out.println("buy:" + item);
    }
}
