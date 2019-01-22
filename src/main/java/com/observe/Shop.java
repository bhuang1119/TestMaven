package com.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in 
 * @Modified By:
 */
public class Shop {
    private String product;
    private List<Buyer> buyers;

    public Shop() {
        this.product = "无商品";
        this.buyers = new ArrayList<>();
    }

    public void register(Buyer buyer) {
        buyers.add(buyer);
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
        notifyAllBuyer();
    }

    private void notifyAllBuyer() {
        buyers.stream().forEach(b -> b.notifyBuyer());
    }
}
