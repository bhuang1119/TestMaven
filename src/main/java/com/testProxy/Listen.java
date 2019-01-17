package com.testProxy;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in
 * @Modified By:
 */
public class Listen implements ProxyInterface{
    @Override
    public void say() {
        System.out.println("Hello 2 World!");
    }
}
