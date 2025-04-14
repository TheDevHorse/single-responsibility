package com.thedevhorse.strategy;

public class ToysDiscount implements Discount {

    @Override
    public double calculateDiscount(Product product) {
        return product.basePrice() * 0.10;
    }
}
