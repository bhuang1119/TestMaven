package com.observe;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in 
 * @Modified By:
 */
public class AppleBuyer extends Buyer {

    public AppleBuyer(String name, Shop shop) {
        super(name, shop);
    }

    @Override
    protected void notifyBuyer() {
        String product = shop.getProduct();
        if (product.contains("苹果")) {
            System.out.println(name + "购买" + product);
        }
    }
}
