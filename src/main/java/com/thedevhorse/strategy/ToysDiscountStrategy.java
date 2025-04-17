package com.thedevhorse.strategy;

public class ToysDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculateDiscount(Product product) {
        return product.basePrice() * 0.10;
    }
}
