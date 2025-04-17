package com.thedevhorse.strategy;

public class BooksDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculateDiscount(Product product) {
        return product.basePrice() * 0.20;
    }
}
