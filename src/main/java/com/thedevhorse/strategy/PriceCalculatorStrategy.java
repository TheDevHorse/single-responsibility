package com.thedevhorse.strategy;

public class PriceCalculatorStrategy {

    private final Discount discount;

    public PriceCalculatorStrategy(Discount discount) {
        this.discount = discount;
    }

    public double calculateFinalPrice(Product product) {
        return discount.calculateDiscount(product);
    }
}
