package com.observe;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in 
 * @Modified By:
 */
public class HuaweiBuyer extends Buyer {

    public HuaweiBuyer(String name, Shop shop) {
        super(name, shop);
    }

    @Override
    protected void notifyBuyer() {
        String product = shop.getProduct();
        if (product.contains("华为")) {
            System.out.println(name + "购买" + product);
        }
    }
}
