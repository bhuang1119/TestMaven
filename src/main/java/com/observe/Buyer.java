package com.observe;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in 
 * @Modified By:
 */
public abstract class Buyer {
    protected String name;
    protected Shop shop;

    protected abstract void notifyBuyer();

    public Buyer(String name, Shop shop) {
        this.name = name;
        this.shop = shop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
