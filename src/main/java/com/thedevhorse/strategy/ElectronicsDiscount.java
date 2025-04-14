package com.thedevhorse.strategy;

public class ElectronicsDiscount implements Discount {

    @Override
    public double calculateDiscount(Product product) {
        return product.basePrice() * 0.15;
    }
}
