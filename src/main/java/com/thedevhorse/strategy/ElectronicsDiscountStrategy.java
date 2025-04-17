package com.thedevhorse.strategy;

public class ElectronicsDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculateDiscount(Product product) {
        return product.basePrice() * 0.15;
    }
}
