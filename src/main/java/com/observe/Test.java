package com.observe;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in 
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        Shop shop = new Shop();
        HuaweiBuyer huaweiBuyer = new HuaweiBuyer("华为粉",shop);
        AppleBuyer appleBuyer = new AppleBuyer("果粉",shop);
        shop.register(huaweiBuyer);
        shop.register(appleBuyer);

        shop.setProduct("华为");
        shop.setProduct("苹果");

    }
}
