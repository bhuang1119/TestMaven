package com.testProxy;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in
 * @Modified By:
 */
public class Say implements ProxyInterface {
    @Override
    public void say() {
        System.out.println("Hello World!");
    }
}
