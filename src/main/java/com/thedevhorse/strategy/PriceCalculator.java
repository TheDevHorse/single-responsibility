package com.thedevhorse.strategy;

public class PriceCalculator {

    private final DiscountStrategy discountStrategy;

    public PriceCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateFinalPrice(Product product) {
        return discountStrategy.calculateDiscount(product);
    }
}
